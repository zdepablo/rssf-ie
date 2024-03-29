package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;
import org.apache.uima.util.Logger;

import com.seemla.rssf.Phase;

/**
 * An annotator that uses keywords and regular expressions 
 * to find phase names for competitions 
 * 
 * @author cdepablo
 *
 */
public class PhaseAnnotator extends JCasAnnotator_ImplBase {

	// Some reusable keywords. all should be non capturing groups 
	private static final String PHASE = "(?:Phase|Round)";
	private static final String ORDINAL = "(?:First|Second|Third|Fourth|1st|2nd|3rd|Intermediate|Preliminary)";
	private static final String QUALIFY = "(?:Qualifying|Qualification)";
	
	// A number of names for phases used in different competitions
	
	// Qualifying Phase 1 | First Qualifying Phase 
	private static final String QUALIFYING_PHASE = 
			"(?:" + QUALIFY + "\\s+" + PHASE + "(?:\\s+\\d)?|" + ORDINAL + "\\s+" + QUALIFY + "\\s+" + PHASE +")";
	// Group Phase | Group Phase 1 
	private static final String GROUP_PHASE = "Group\\s+" + PHASE + "(?:\\s+\\d)?";
	
	// First Round | Second Round | Intermediate Round ...
	private static final String FIRST_ROUND = ORDINAL +"\\s+" + PHASE;
	
	private static final String OCTAVES = "1/8(?:-|\\s+)Finals";
	private static final String QUARTER = "Quarter(?:-|\\s+)Finals";
	private static final String SEMIFINAL = "Semi(?:-|\\s+)Finals";
	private static final String FINAL = "Final";
	
	
	// A pattern for different phases
	private static Pattern phasePattern =  Pattern.compile(
			FINAL + "|" + SEMIFINAL + "|" + QUARTER + "|" + OCTAVES + "|" + 
	        FIRST_ROUND + "|"  + QUALIFYING_PHASE + "|" + GROUP_PHASE   	
			); 
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		Logger logger = getContext().getLogger();
		
		String docText = aJCas.getDocumentText();
		
		Matcher matcher = phasePattern.matcher(docText);
		int length = docText.length();
	
		int pos = 0;
		if (matcher.find(pos)) {

			Phase previousAnnotation = new Phase(aJCas);
			previousAnnotation.setBegin(matcher.start());
			previousAnnotation.setName(matcher.group());

			pos = matcher.end();
			
			while (matcher.find(pos)) {
				
				previousAnnotation.setEnd(matcher.start()-1);
				previousAnnotation.addToIndexes();
				logger.log(Level.FINER, "Phase " + previousAnnotation);
				
				Phase annotation = new Phase(aJCas);
				annotation.setBegin(matcher.start());
				annotation.setName(matcher.group());

				previousAnnotation = annotation;
				pos = matcher.end();
			}
			
			previousAnnotation.setEnd(length);
			previousAnnotation.addToIndexes();
			logger.log(Level.FINER, "Phase " + previousAnnotation);
			
		}

	}

}
