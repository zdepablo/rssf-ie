package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;

import com.seemla.rssf.Competition;

/**
 * 
 * An annotator that uses regular expressions and a list of competition names 
 * to detect competitions in the RSSF pages. 
 * 
 * @author cdepablo
 *
 */
public class CompetitionAnnotator extends JCasAnnotator_ImplBase{
	
	// List of competition names - extend to detect additional ones
	// It is a regexp group
	private static final String competition = "(" +
			"Champions' Cup|" +
			"Inter-Cities Fairs Cup|" +
			"UEFA Champions' League|" +
			"UEFA Champions League|" +
			"UEFA Cup|Europa League|" +
			"Super Cup|" +
			"Cup Winners' Cup|" +
			"Inter Cities Fairs Cup Trophy Play-off" +
			")";

	
	// A string to build a pattern for season years: Eg. 2009-2010 or simply 2010
	// It is a regexp group
	private static final String season = "((?:\\d{4}-\\d{2})|\\d{4})";
	
	// Matches competition names like: UEFA Champions League 2009-10
	// First group: competition name 
	// Second group: season year 
	private Pattern competitionPattern = Pattern.compile(competition + "\\s+" + season );
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		String docText = aJCas.getDocumentText();
		
		Matcher matcher = competitionPattern.matcher(docText);
		
		int pos = 0;
		while (matcher.find(pos)) {
			
			Competition annotation = new Competition(aJCas);
			annotation.setBegin(matcher.start());
			annotation.setEnd(matcher.end());
			
			int n = matcher.groupCount();
			
			if (n == 2) {
				annotation.setName(matcher.group(1));
				annotation.setYear(matcher.group(2));				
			} else {
				getContext().getLogger().log(Level.INFO, "Groups found: " + n + " in " + matcher.group() );
			}
			
			
			annotation.addToIndexes();
			
			pos = matcher.end();
		}

	}

}
