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
import com.seemla.rssf.MatchPairResult;
import com.seemla.rssf.MatchPairResult_Type;
import com.seemla.rssf.MatchResult;
import com.seemla.rssf.MatchResult_Type;
import com.seemla.rssf.Phase;
import com.seemla.rssf.QualifyingResult;
import com.seemla.rssf.Result;
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
	 	    
			// A variable to control the order of a phase in a competition, 
			// phases use to appear in sequential order that corresponds to chonological in competitions  
			int phaseOrder = 0;
			
	 	    for (FSIterator iter = jcas.getAnnotationIndex(QualifyingResult.type).iterator(); iter.hasNext();) {
	 	    	
	 	    	QualifyingResult q = (QualifyingResult) iter.next();
	 	    	
	 	    	// Insert competition if does not exist 
	 	    	Competition c = q.getCompetition();
	 	    	Integer competitionId = db.findCompetition(c.getName(), c.getSeason());
	 	    	if (competitionId == null) {
	 	    		db.insertCompetition(c.getName(), c.getSeason(), c.getStart(), sdi.getUri());
	 	    		competitionId = db.findCompetition(c.getName(), c.getSeason());
	 	    		
	 	    		// Starts a competition 
	 	    		phaseOrder = 0;
	 	    	}
	 	    	
	 	    	// Insert phase if does not exist 
	 	    	Phase p = q.getPhase();
	 	    	boolean inserted = db.findPhase(competitionId, p.getName());
	 	    	if (!inserted) {
	 	    		// Increase phase order
	 	    		phaseOrder++;
	 	    		db.insertPhase(competitionId, p.getName(),phaseOrder, sdi.getUri());
	 	    	}
	 	    	
	 	    	
	 	    	Result m = q.getResult();
	 	    	if ( m.getType().getShortName().equals("MatchPairResult")) {
	 	    		insertMatchPairResult((MatchPairResult) m, competitionId, p, sdi.getUri());
	 	    	} else if ( m.getType().getShortName().equals("MatchResult")) {
	 	    		insertMatchResult((MatchResult) m, competitionId, p, sdi.getUri());
	 	    	} else {
	 	    		getLogger().log(Level.FINE, "Result of no processed type");
	 	    	}
	 	    	
	 	    }

		} catch (SQLException e) {

			this.db.close();
						
			throw new ResourceProcessException(e);
		}
		
		
	}

	private void insertMatchPairResult(MatchPairResult m, Integer competitionId, Phase p, String uri) throws SQLException {

		Integer team1Id = findTeamOrInsert(m.getTeam1(), m.getCountry1());
		Integer team2Id = findTeamOrInsert(m.getTeam2(), m.getCountry2());
	    	
		if (team1Id != null && team2Id != null ) {

			db.insertMatchPair(team1Id, team2Id, 
					m.getLeg1_1(), m.getLeg1_2(), m.getLeg2_1(), m.getLeg2_2(), 
					m.getTotal_1(), m.getTotal_2(), 
					competitionId, p.getName(), uri);

		} else {
			if (team1Id == null) 
				getLogger().log(Level.FINE, "team not found: " + m.getTeam1()  + " " +  m.getCountry1() + " at " + uri);
			if (team2Id == null) 
				getLogger().log(Level.FINE, "team not found: " + m.getTeam2()  + " " +  m.getCountry2() + " at " + uri);

		}
	    	

		
	}
	

	private void insertMatchResult(MatchResult m, Integer competitionId, Phase p, String uri) throws SQLException {


		Integer team1Id = findTeamOrInsert(m.getTeam1(), null);
		Integer team2Id = findTeamOrInsert(m.getTeam2(), null);

		if (team1Id != null && team2Id != null ) {

			db.insertMatch(team1Id, team2Id, 
					m.getResult1(), m.getResult2(),  
					m.getMid1(), m.getMid2(), 
					competitionId, p.getName(), uri);

		} else {

			if (team1Id == null) 
				getLogger().log(Level.FINE, "team not found: " + m.getTeam1()  + "(No country)  at " + uri);
			if (team2Id == null) 
				getLogger().log(Level.FINE, "team not found: " + m.getTeam2()  + "(No country) at " + uri);

		}


	}

	
	private Integer findTeamOrInsert(String name, String country) throws SQLException {
	
		Integer teamId = null;
		boolean hasCountry = false;
		
		// Try to find team with country
		if (country != null) {
			teamId = this.db.findTeamByNameAndCountry(name, country);
			hasCountry = true;
		}
		
		// Find team even if country is not the same
		if (teamId == null) 
			teamId = this.db.findTeam(name);
		
		// If the country is not found should be new, then insert whatever we have
		if (teamId == null) {
			db.insertTeam(name,country);
			teamId = db.findTeamByNameAndCountry(name,country);
			if (country != null) hasCountry = true; 
		} 
		
		// If the team has the country valuem but it was nit found before then update
		if (country != null && !hasCountry){
			teamId = db.updateTeam(teamId,country);
		}
		
		
		
		return teamId;
	}
	
	
	@Override
	public void collectionProcessComplete(ProcessTrace arg0) throws ResourceProcessException, IOException {
		this.db.close();
		firstCall = true;
	}
		
	
}
