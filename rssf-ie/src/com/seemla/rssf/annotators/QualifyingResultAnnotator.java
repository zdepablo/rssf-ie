package com.seemla.rssf.annotators;



import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.util.Level;
import org.apache.uima.util.Logger;

import com.seemla.rssf.Competition;
import com.seemla.rssf.Result;
import com.seemla.rssf.Phase;
import com.seemla.rssf.QualifyingResult;

public class QualifyingResultAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		Logger logger = getContext().getLogger(); 
		
		FSIterator matchPairResultIter = aJCas.getAnnotationIndex(Result.type).iterator();		
		while (matchPairResultIter.hasNext()) {
			
			Result matchResult = (Result) matchPairResultIter.next();
			Annotation competition = findParent(aJCas, Competition.type, matchResult);
			Annotation phase = findParent(aJCas, Phase.type, matchResult);
			
			if ((phase != null ) && (competition != null)) {
			
				QualifyingResult qualifyingResult = new QualifyingResult(aJCas);
				qualifyingResult.setBegin(matchResult.getBegin());
				qualifyingResult.setEnd(matchResult.getEnd());
				qualifyingResult.setCompetition((Competition)competition);
				qualifyingResult.setPhase((Phase)phase);
				qualifyingResult.setResult(matchResult);
				qualifyingResult.addToIndexes();
				
				logger.log(Level.FINER, "QualifyingResult " + qualifyingResult); 
			} else {
				logger.log(Level.INFO, "QualifyingResult not enclosed" + matchResult);
			}
			
		}
		
	}

	/**
	 * Test if the parent annotation covers completely the child annotation
	 * 
	 * @param parent
	 * @param child
	 * @return true if is covered, false otherwise
	 */
	private boolean cover(Annotation parent, Annotation child) {
		return (parent.getBegin() <= child.getBegin()) && (parent.getEnd() >= child.getEnd());		
	}
	
	/**
	 * Find a parent annotation of the given type that covers completely the child 
	 * 
	 * @param aJCas
	 * 			the Jcas to search for annotations 
	 * @param type
	 * 			the type of the annotation 
	 * @param child
	 * 			the child annotation to be covered
	 * @return 
	 * 			the parent annotation, null if none is found
	 */
	private Annotation findParent(JCas aJCas, int type,  Annotation child) {
		FSIterator<Annotation> iter = aJCas.getAnnotationIndex(type).iterator();
		
		 while (iter.hasNext()) {
			 
			 Annotation parent = iter.next();
			 if (cover(parent,child)) {
				return parent; 
			 }
			 
		 }
		
		return null;
	}


}
