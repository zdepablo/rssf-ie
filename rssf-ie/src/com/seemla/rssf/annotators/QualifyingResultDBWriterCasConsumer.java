package com.seemla.rssf.annotators;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.Level;
import org.apache.uima.util.ProcessTrace;

import com.seemla.rssf.Competition;
import com.seemla.rssf.MatchResult;
import com.seemla.rssf.Phase;
import com.seemla.rssf.QualifyingResult;
import com.seemla.rssf.db.DatabaseProxy;

/**
 * A simple CAS consumer that creates a Derby database in the file system 
 * and persist results from match from RFFS 
 * 
 * <p>
 * This CAS Consumer takes one parameter:
 * <ul>
 * 	<li><code>OutputDirectory</code> - path to directory which is the "System" 
 * directory for the derby DB</li>
 * </ul>
 * 
 * It deletes all the databases at the system location (!!!), creates a new database
 * and creates a table in the database to hold instances of the ResultMatch annotation. 
 * Adds entries for each ResultMatch annotation in each CAS to the database. 
 * 
 * The processing is set up to handle multiple CASes. The end is indicated by using the 
 * CollectionProcessComplete call. 
 * 
 * Batching of updates to the database is done. The batch size is set to 50. The larger 
 * size takes more Java heap space, but perhaps runs more efficiently.
 * 
 * The URI of the document is included with every record.
 *  
 * @author cdepablo
 *
 */

public class QualifyingResultDBWriterCasConsumer extends CasConsumer_ImplBase {

	/**
	 * Name of configuration parameter that must be set to path of a directory into 
	 * which the Derby Database will be written. 
	 */
	public static final String PARAM_OUTPUTDIR = "OutputDirectory";
		
	private File mOutputDir;
	private boolean firstCall = true;
	private long startTime;
	

	private DatabaseProxy db;
	
	
	@Override
	public void initialize() throws ResourceInitializationException {
		startTime = System.currentTimeMillis();
		System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " initialize() called");
		
		mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
		
		this.db = new DatabaseProxy(mOutputDir);

		
		
	}



	@Override
	public void processCas(CAS aCAS) throws ResourceProcessException {
		System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: ProcessCas called");
		
		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new ResourceProcessException(e);
		}
		
		
		
		
		try {
			if (firstCall) {
				this.db.open();
				this.db.createDatabase();
				firstCall = false;	
			}
			
			
			SourceDocumentInformation sdi = (SourceDocumentInformation) jcas.getAnnotationIndex(SourceDocumentInformation.type).iterator().next();
			
			getLogger().log(Level.INFO, "Processing doc: '" + sdi.getUri() + "'");
	 	    
	 	    for (FSIterator iter = jcas.getAnnotationIndex(QualifyingResult.type).iterator(); iter.hasNext();) {
	 	    	
	 	    	QualifyingResult q = (QualifyingResult) iter.next();
	 	    	
	 	    	// Insert competition if does not exist 
	 	    	Competition c = q.getCompetition();
	 	    	Integer competitionId = db.findCompetition(c.getName(), c.getSeason());
	 	    	if (competitionId == null) {
	 	    		db.insertCompetition(c.getName(), c.getSeason(), c.getStart(), sdi.getUri());
	 	    		competitionId = db.findCompetition(c.getName(), c.getSeason());
	 	    	}
	 	    	
	 	    	// Insert phase if does not exist 
	 	    	Phase p = q.getPhase();
	 	    	boolean inserted = db.findPhase(competitionId, p.getName());
	 	    	if (!inserted) {
	 	    		db.insertPhase(competitionId, p.getName(), sdi.getUri());
	 	    	}
	 	    	
	 	    	MatchResult m = q.getResult();
	 	    	Integer team1Id = db.findTeam(m.getTeam1(), m.getCountry1());
	 	    	if (team1Id == null) {
	 	    		db.insertTeam(m.getTeam1(), m.getCountry1());
	 	    		team1Id = db.findTeam(m.getTeam1(), m.getCountry1());
	 	    	}
	 	    		
	 	    	Integer team2Id = db.findTeam(m.getTeam2(), m.getCountry2());
	 	    	if (team2Id == null) {
	 	    		db.insertTeam(m.getTeam2(), m.getCountry2());
	 	    		team2Id = db.findTeam(m.getTeam2(), m.getCountry2());
	 	    	}
	 	    	
	 	    	db.insertMatchPair(team1Id, team2Id, 
	 	    			m.getLeg1_1(), m.getLeg1_2(), m.getLeg2_1(), m.getLeg2_2(), 
	 	    			m.getTotal_1(), m.getTotal_2(), 
	 	    			competitionId, p.getName(), sdi.getUri());
	 	    	
	 	    }

		} catch (SQLException e) {

			this.db.close();
						
			throw new ResourceProcessException(e);
		}
		
		
	}

	
	
	
	
	@Override
	public void collectionProcessComplete(ProcessTrace arg0) throws ResourceProcessException, IOException {
		this.db.close();
		firstCall = true;
	}
		
	
}
