package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;

import com.seemla.rssf.MatchResult;;

/**
 * An annotator for match results for individual match 
 * as they are given in RSSF 
 * 
 * The format is like: 
 * 
 * Bayern Munich            (0) 1  Rangers                  (0) 0  after extra-time
 * team1 			 mid1 result1  team2 		     mid2 result2  
 * 
 * It is assumed that the first team is the local in the first match. 
 * 
 * @author cdepablo
 *
 */
public class MatchResultAnnotator extends JCasAnnotator_ImplBase {
	 
	
	// A pattern that match the name of a team ( or almos t anything) that contains characters, puntuactions and digits 
	private static final String team = "((?:[\\p{L}&;-]+\\s)*[\\p{L}\\p{P}]+?)";
	
	
	// A pattern to capture singkle match results, a number of digits 
	private static final String singleresult = "(\\d+)";
	

	
 	private static Pattern matchresultPattern1 = Pattern.compile(
 			team + "\\s+" +"(?:\\(" + singleresult + "\\))?" + "\\s+" + singleresult 
 			+ "\\s+" +
 			team + "\\s+" +"(?:\\(" + singleresult + "\\))?" + "\\s+" + singleresult  
 	);



	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		 
		
		String docText = aJCas.getDocumentText();
		
		Matcher matcher = matchresultPattern1.matcher(docText);
		
		int pos = 0;
		while (matcher.find(pos)) {
			
			MatchResult annotation = new MatchResult(aJCas);
			annotation.setBegin(matcher.start());
			annotation.setEnd(matcher.end());
			
			int n = matcher.groupCount();
			
			if (n == 6 ) {
				
				annotation.setTeam1(CleanUtils.cleanTeamname(matcher.group(1)));
				
				try {
					annotation.setMid1(Integer.valueOf(matcher.group(2)));
					annotation.setResult1(Integer.valueOf(matcher.group(3)));
				} catch (NumberFormatException e) {
					getContext().getLogger().log(Level.INFO, "Error casting integer" + matcher.group());
				}
				
				
				annotation.setTeam2(CleanUtils.cleanTeamname(matcher.group(4)));				
				try {
					annotation.setMid2(Integer.valueOf(matcher.group(5)));
					annotation.setResult2(Integer.valueOf(matcher.group(6)));
					
				} catch (NumberFormatException e) {
					getContext().getLogger().log(Level.INFO, "Error casting integer" + matcher.group());
				}
			} else if (n == 4){
				
				annotation.setTeam1(CleanUtils.cleanTeamname(matcher.group(1)));
				annotation.setMid1(-1);
				
				try {
					annotation.setResult1(Integer.valueOf(matcher.group(2)));
					annotation.setMid1(-1);
				} catch (NumberFormatException e) {
					getContext().getLogger().log(Level.INFO, "Error casting integer" + matcher.group());
				}
				
				
				annotation.setTeam2(CleanUtils.cleanTeamname(matcher.group(3)));				
				try {
					annotation.setResult2(Integer.valueOf(matcher.group(4)));
					annotation.setMid2(-1);
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
