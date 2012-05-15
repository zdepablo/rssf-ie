package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.seemla.rssf.MatchResult;

public class MatchResultAnnotator extends JCasAnnotator_ImplBase {
	
	String team = "((?:[\\p{L}\\p{P}\\d]+\\s)*[\\p{L}\\p{P}\\d]+)";
	String country = "(\\b[A-Za-z]{3}\\b)";
	String result = "[\\*]?(\\d+-\\d+)[a-z\\*]?";
		
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
			annotation.setResult(matcher.group());
			annotation.addToIndexes();
			
			pos = matcher.end();
		}

	}

}
