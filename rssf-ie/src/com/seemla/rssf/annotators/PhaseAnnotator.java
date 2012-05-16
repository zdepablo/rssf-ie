package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.seemla.rssf.MatchResult;
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
	private static final String ORDINAL = "(?:First|Second|Third|1st|2nd|3rd|Intermediate|Preliminary)";
	
	// A number of names for phases used in different competitions
	
	// Qualifying Phase 1 | First Qualifying Phase 
	private static final String QUALIFYING_PHASE = 
			"(?:Qualifying\\s+" + PHASE + "\\s+\\d|" + ORDINAL + "\\s+Qualifying\\s+" + PHASE +")";
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
	
		String docText = aJCas.getDocumentText();
		
		Matcher matcher = phasePattern.matcher(docText);
		
		int pos = 0;
		while (matcher.find(pos)) {
			
			Phase annotation = new Phase(aJCas);
			annotation.setBegin(matcher.start());
			annotation.setEnd(matcher.end());
			annotation.addToIndexes();
			
			pos = matcher.end();
		}


	}

}
