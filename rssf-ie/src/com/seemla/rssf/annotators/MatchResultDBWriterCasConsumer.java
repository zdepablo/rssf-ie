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
import org.apache.uima.util.ProcessTrace;

import com.seemla.rssf.Competition;
import com.seemla.rssf.MatchResult;
import com.seemla.rssf.Phase;

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

public class MatchResultDBWriterCasConsumer extends CasConsumer_ImplBase {

	/**
	 * Name of configuration parameter that must be set to path of a directory into 
	 * which the Derby Database will be written. 
	 */
	public static final String PARAM_OUTPUTDIR = "OutputDirectory";
	
	public static final int MAX_URI_LENGTH = 80;
	
	public static final int MAX_TEAM_LENGTH = 50;
	
	private File mOutputDir;
	
	
	private boolean firstCall = true;
	
	private boolean firstEverCall = true;
	
	private long startTime;
	
	private Connection con;
	
	private PreparedStatement stmt;
	
	
	
	@Override
	public void initialize() throws ResourceInitializationException {
		startTime = System.currentTimeMillis();
		System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " initialize() called");
		
		mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
		
		if (!mOutputDir.exists()) {
			mOutputDir.mkdirs();
		}
		
		// make this directory the derby home
		System.setProperty("derby.system.home", mOutputDir.toString());
		System.out.println("Time: " + (System.currentTimeMillis() - startTime) 
				+ " DB Writer: Set derby system home to: '" + mOutputDir.toString() +"'");
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
				firstCall = false;
				System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: First time initialization");

				// Load the embedded derby driver - depends on derby.system.property
				if (firstEverCall) {
					firstEverCall = false;
					System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: Doing first process call ever (even during re-runs) initialization");
					loadDriver();	
				}

				// Create and connect to the database RssfResultsDB
				File db = new File(mOutputDir.toString() + "/RssfResultsDB");
				if (db.exists()) {
					System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: First Time Initialization: Deleting Database");
					deleteDir(db);
					System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: First Time Initialization: Database deleted");
				}

				con = DriverManager.getConnection("jdbc:derby:RssfResultsDB;create=true");
		        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: First Time Initialization: Created the RssfResultsDB and connected to it.");
		        
		        createDatabase();
		        
		        // con.setAutoCommit(false);

			}
			
			saveAnnotations(jcas);
			
			
		} catch (SQLException e) {
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				if (stmt != null) stmt.clearBatch();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			throw new ResourceProcessException(e);
		}
		
		
	}

	
	
	
	
	@Override
	public void collectionProcessComplete(ProcessTrace arg0) throws ResourceProcessException, IOException {
		firstCall = true;
		
		try {			
			con.close();
			
    	    System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: Sucessfully closed the connection - done.");

		} catch (SQLException e) {
		      System.err.println("Unexpected SQL exception");
		      e.printStackTrace();
		}
		
	    try {
	        DriverManager.getConnection("jdbc:derby:RssfResultsDB;shutdown=true");
	      } catch (SQLException e) {
	      }

		
		
		// If we shut down the db - we get a "no suitable driver" SQL exception if rerunning
		try {
			firstEverCall = true;
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException e) {
		}
		
	}


	private void loadDriver() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: Loaded Derby driver Ok");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("No driver found for derby - check class path");
			e.printStackTrace();
		}

		
	}

	
	private void saveAnnotations(JCas jcas) throws SQLException {
		
		SourceDocumentInformation sdi = (SourceDocumentInformation) jcas.getAnnotationIndex(SourceDocumentInformation.type).iterator().next();
		
 	    System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: Processing doc: '" + sdi.getUri() + "'");
 	    
 	    for (FSIterator CompetitionIter = jcas.getAnnotationIndex(Competition.type).iterator(); CompetitionIter.hasNext();) {
 	    	Competition competition = (Competition) CompetitionIter.next();
 	    	
 	    	PreparedStatement stmt = mapCompetition(competition, sdi.getUri());
 	    	stmt.executeUpdate();		
 	    	
 	    }

 	    
 	    for (FSIterator PhaseIter = jcas.getAnnotationIndex(Phase.type).iterator(); PhaseIter.hasNext();) {
 	    	Phase phase = (Phase) PhaseIter.next();
 	    	
 	    	PreparedStatement stmt = mapPhase(phase, sdi.getUri());
 	    	stmt.executeUpdate();		
 	    	
 	    }

 	    
 	   
 	    for (FSIterator MatchResultIter = jcas.getAnnotationIndex(MatchResult.type).iterator(); MatchResultIter.hasNext();) {
 	    	MatchResult matchResult = (MatchResult) MatchResultIter.next();
 	    	
 	    	PreparedStatement stmt = mapMatchResult(matchResult, sdi.getUri());
 	    	stmt.executeUpdate();
 	           
 	    	
 	    }
	}
	
	private PreparedStatement mapCompetition(Competition competition, String origin) throws SQLException {
		
		PreparedStatement stmt = con.prepareStatement("INSERT INTO COMPETITION(name,season,uri) VALUES (?,?,?)");
		
		stmt.setString(1, competition.getName());
		stmt.setString(2, competition.getYear());
		stmt.setString(3, truncate(origin, MAX_URI_LENGTH));
		
		return stmt;
	}

	private PreparedStatement mapPhase(Phase phase, String origin) throws SQLException {
		
		PreparedStatement stmt = con.prepareStatement("INSERT INTO PHASE(name,uri) VALUES (?,?)");
		
		stmt.setString(1, phase.getName());
		stmt.setString(2, truncate(origin, MAX_URI_LENGTH));
		
		return stmt;
	}


	private PreparedStatement mapMatchResult( MatchResult matchResult, String origin) throws SQLException {
		
			PreparedStatement stmt = con.prepareStatement("INSERT INTO MATCH_PAIR VALUES (?,?,?,?,?,?,?)");
		
	    	stmt.setString(1, truncate(matchResult.getTeam1(), MAX_TEAM_LENGTH));
	    	stmt.setString(2, truncate(matchResult.getTeam2(), MAX_TEAM_LENGTH));
	    	stmt.setInt(3, matchResult.getLeg1_1());
	    	stmt.setInt(4, matchResult.getLeg1_2());
	    	stmt.setInt(5, matchResult.getLeg2_1());
	    	stmt.setInt(6, matchResult.getLeg2_2());
	    	stmt.setString(7, truncate(origin, MAX_URI_LENGTH));
	    	
	    	return stmt;
	    	 	
	}
	
	
	
	private void createDatabase() throws SQLException {
		
        Statement sqlStatement = con.createStatement();
        try {
        	sqlStatement.execute("DROP TABLE MATCH_PAIR");
        	sqlStatement.execute("DROP TABLE COMPETITION");
        	sqlStatement.execute("DROP TABLE PHASE");
        	System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: First Time Initialization: Delete table");
        } catch (SQLException e) {
		}
        
        String MATCH_PAIR_CREATE = "CREATE TABLE MATCH_PAIR (" +
        		"team1 varchar(" + MAX_TEAM_LENGTH +")," +
        		"team2 varchar(" + MAX_TEAM_LENGTH +")," +
        		"leg1_1 int," +
        		"leg1_2 int," +
        		"leg2_1 int," +
        		"leg2_2 int," +
        		"uri varchar(" + MAX_URI_LENGTH +")" +
        		")";
        
        sqlStatement.execute(MATCH_PAIR_CREATE);
        
        String COMPETITION_CREATE = "CREATE TABLE COMPETITION (" +
        		"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
        		"name VARCHAR(50), " +
        		"season VARCHAR(10)," +
        		"uri varchar(" + MAX_URI_LENGTH +")," +
        		"CONSTRAINT competition_pk PRIMARY KEY (id)" +
        		")";
        
        sqlStatement.execute(COMPETITION_CREATE);
        
        String PHASE_CREATE = "CREATE TABLE PHASE (" +
        		"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
        		"name VARCHAR(50), " +
        		"uri varchar(" + MAX_URI_LENGTH +")," +
        		"CONSTRAINT phase_pk PRIMARY KEY (id)" +
        		")";
       
        sqlStatement.execute(PHASE_CREATE);
        
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " DB Writer: First Time Initiailization: Created the MATCH_PAIR table");
        sqlStatement.close();

		
	}

	private void deleteDir(File f) {
		if (f.isDirectory()) {
			String[] contents = f.list();
			for (String content : contents) {
				deleteDir(new File(f.toString() + File.separator + content));
			}
		}
	}
	
	  private String truncate(String s, int length) {
		    if (s.length() <= length)
		      return s;
		    return s.substring(0, length);
		  }

	
	
}
