package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;

import com.seemla.rssf.MatchResult;

/**
 * An annotator for match results for qualifying rounds 
 * as they are given in RSSF 
 * 
 * The basic format is like: 
 * 
 * Maccabi Tel-Aviv         Isr  Fenerbahçe               Tur   0-1  1-1  1-2
 * Rangers                  Sco  Alania Vladikavkaz       Rus   3-1  7-2 10-3
 * (Team 1)			 (Country 1) (Team 2)          (Country 2)  (score first match) (score second match) (score total)
 * 
 * It is assumed that the first team is the local in the first match. 
 * 
 * @author cdepablo
 *
 */
public class MatchResultAnnotator extends JCasAnnotator_ImplBase {
	 
	
	// A pattern that match the name of a team ( or almos t anything) that contains characters, puntuactions and digits 
	private static final String team = "((?:[\\p{L}\\p{P}\\d]+\\s)*[\\p{L}\\p{P}\\d]+)";
	
	// A pattern that match country abbreviations as are used in RSSF: three characters 
	private static final String country = "(\\b[A-Za-z]{3}\\b)";
	
	// A pattern to capture match results as given in the gualifyinng, a number of digits separated by a dash 
	// Results usually have annotations 
	private static final String result = "[\\*]?(\\d+)-(\\d+)[a-z\\*]?";
		
 	private Pattern resultPattern = Pattern.compile(
 			team + "\\s+" + country + "\\s+" + team + "\\s+" + country + 
 			"\\s+" + result + "\\s+" + result + "\\s+" + result);


	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		 
		
		String docText = aJCas.getDocumentText();
		
		Matcher matcher = resultPattern.matcher(docText);
		
		int pos = 0;
		while (matcher.find(pos)) {
			
			MatchResult annotation = new MatchResult(aJCas);
			annotation.setBegin(matcher.start());
			annotation.setEnd(matcher.end());
			
			int n = matcher.groupCount();
			
			if (n == 10 ) {
				
				annotation.setTeam1(matcher.group(1));
				annotation.setCountry1(matcher.group(2));
				
				annotation.setTeam2(matcher.group(3));
				annotation.setCountry2(matcher.group(4));
				
				try {
					annotation.setLeg1_1(Integer.valueOf(matcher.group(5)));
					annotation.setLeg1_2(Integer.valueOf(matcher.group(6)));
					
					annotation.setLeg2_1(Integer.valueOf(matcher.group(7)));
					annotation.setLeg2_2(Integer.valueOf(matcher.group(8)));
					
					annotation.setTotal_1(Integer.valueOf(matcher.group(9)));
					annotation.setTotal_2(Integer.valueOf(matcher.group(10)));

				} catch (NumberFormatException e) {
					getContext().getLogger().log(Level.INFO, "Error casting integer" + matcher.group());
				}
				
			} else {
				getContext().getLogger().log(Level.INFO, "Groups found: " + n + " in " + matcher.group());
			}
			
			
			
			annotation.addToIndexes();
			
			pos = matcher.end();
		}

	}

}
