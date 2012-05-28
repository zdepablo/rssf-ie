package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;
import org.apache.uima.util.Logger;

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

	
	// A string to build a pattern for season years: Eg. 2009-10, 2009-2010 or simply 2010
	// It is a regexp group
	private static final String season = "((?:\\d{4}(?:-|/)\\d{4})|(?:\\d{4}(?:-|/)\\d{2})|\\d{4})";
	
	// Matches competition names like: UEFA Champions League 2009-10
	// First group: competition name 
	// Second group: season year 
	private static Pattern competitionPattern = Pattern.compile(competition + "\\s+" + season );
	
	// Matches the year start inside a season 
	private static Pattern startPattern = Pattern.compile("\\d{4}");
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		Logger logger = getContext().getLogger();
		
		String docText = aJCas.getDocumentText();
		int length = docText.length();
		
		Matcher matcher = competitionPattern.matcher(docText);
		
		int pos = 0;
		
		// The annotation works more like a zoning 
		// The beginning of an annotation is marked by a match 
		// The end of the annotation is marked by the beginning 
		// of the following match or the end of the document
		if (matcher.find(pos)) {

			Competition previousAnnotation = new Competition(aJCas);
			
			previousAnnotation.setBegin(matcher.start());
			fillCompetition(previousAnnotation, matcher);
			
			pos = matcher.end();

			while (matcher.find(pos)) {			
				
				previousAnnotation.setEnd(matcher.start() -1 );
				previousAnnotation.addToIndexes();
				logger.log(Level.FINER, "Competition " + previousAnnotation);	
				
				Competition annotation = new Competition(aJCas);
				annotation.setBegin(matcher.start());
				fillCompetition(annotation, matcher);	
				
				previousAnnotation = annotation;
				pos = matcher.end();
			}
			
			previousAnnotation.setEnd(length);
			previousAnnotation.addToIndexes();
			logger.log(Level.FINER, "Competition " + previousAnnotation);
		}
		
		

	}

	/**
	 * Helper method to fill a Competition with the information 
	 * of a regular expression match 
	 * 
	 * @param annotation
	 * 			the competition annotation to fill  
	 * @param matcher
	 * 			a matcher that include the text  
	 */
	private void fillCompetition(Competition annotation, Matcher matcher) {
		
		int n = matcher.groupCount();
		
		if (n == 2) {
			annotation.setName(matcher.group(1));
			String season = matcher.group(2);
			annotation.setSeason(season);
			
			// Add a numeric start of the season
			Matcher m = startPattern.matcher(season);
			if (m.find()) {
				try {
				Integer start = Integer.valueOf(m.group());					
				annotation.setStart(start);
				} catch (NumberFormatException e) {
					getContext().getLogger().log(Level.INFO, "exception transforming competition start year: " + season);
				}
			}
		} else {
			getContext().getLogger().log(Level.INFO, "Groups found: " + n + " in " + matcher.group() );
		}

	}
	
}
