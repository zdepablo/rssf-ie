package com.seemla.rssf.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.seemla.rssf.Competition;

public class DatabaseProxy {

	private static Logger logger = Logger.getLogger(DatabaseProxy.class.toString());
	
	public static final int MAX_URI_LENGTH = 80;
	
	public static final int MAX_COMPETITION_LENGTH = 50;
	public static final int MAX_SEASON_LENGTH = 10;
	public static final int MAX_PHASE_LENGTH = 50;
	
	public static final int MAX_TEAM_LENGTH = 50;
	public static final int MAX_COUNTRY_LENGTH = 50;

	
	private File db;
	private boolean firstCall = true;
	private boolean firstEverCall = true;
	
	private Connection con;
	private Statement stmt;
	
	public DatabaseProxy(File dir) {
		super();
		this.db =  new File(dir.toString() + "/RssfResultsDB");
		
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }

	    System.setProperty("derby.system.home", dir.toString());
	    logger.log(Level.INFO, "Set derby system home to: " +  dir.toString());
		
		if (firstCall) {
			firstCall = false;
			logger.log(Level.INFO, "First time initialization");
			
			if (firstEverCall) {
				firstEverCall = false;
				logger.log(Level.INFO, "Doing first process call ever (even during re-runs) initialization");
				loadDriver();
			}
			
			if (db.exists()) {
				logger.log(Level.INFO, "First Time Initialization: Deleting Database");
				deleteDir(db);
				logger.log(Level.INFO, "First Time Initialization: Database deleted");
			}

		}
		
	}

	/**
	 * Open a connection to the database 
	 * 
	 * @throws SQLException
	 */
	public void open() throws SQLException {
		this.con = DriverManager.getConnection("jdbc:derby:RssfResultsDB;create=true");
		this.stmt = this.con.createStatement();
		logger.log(Level.INFO, "First Time Initialization: Connect to database");
	}
	
	/**
	 * Close all the connections to the database
	 * 
	 */
	public void close() {
		firstCall = true;
		
		try {
			this.stmt.close();
			this.con.close();
			logger.log(Level.INFO,"Sucessfully closed the connection - done.");
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

	
	public void createDatabase() throws SQLException {
		dropTables();
		createTables();
		
	}

	private void dropTables() throws SQLException{
		
//		if (this.con == null)
//			this.open();
//        
//		Statement sqlStatement = con.createStatement();
		
        try {
        
        	this.stmt.execute("DROP TABLE COMPETITION");
        	this.stmt.execute("DROP TABLE PHASE");
        	this.stmt.execute("DROP TABLE TEAM");
        	this.stmt.execute("DROP TABLE MATCH_PAIR");
        	this.stmt.execute("DROP TABLE MATCH");
        	logger.log(Level.INFO, "First Time Initialization: Delete tables");
        	
        } catch (SQLException e) {
		} finally {
//			sqlStatement.close();
		}
		
	}
	
	private void createTables() throws SQLException {
		
        String COMPETITION_CREATE = "CREATE TABLE COMPETITION ( " +
        		"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
        		"name VARCHAR(50), " +
        		"season VARCHAR(10), " +
        		"start INTEGER, " +
        		"uri VARCHAR(80), " +
        		"CONSTRAINT competition_pk PRIMARY KEY (id)" +
        		")";

        String PHASE_CREATE = "CREATE TABLE PHASE (" +
        		"competition INTEGER NOT NULL," +
        		"name VARCHAR(50) NOT NULL," +
        		"numToFinal INTEGER," +
        		"uri VARCHAR(80)," +
        		"CONSTRAINT phase_pk PRIMARY KEY (competition,name)," +
        		"CONSTRAINT phase_fk FOREIGN KEY (competition) REFERENCES COMPETITION(id)" +
        		")";
        
        String TEAM_CREATE = "CREATE TABLE TEAM (" +
        		"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
        		"name VARCHAR(50) NOT NULL," +
        		"country VARCHAR(3)," +
        		"CONSTRAINT team_pk PRIMARY KEY (id)" +
        		")";


        String MATCH_PAIR_CREATE = "CREATE TABLE MATCH_PAIR (" +
        		"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
        		"team1 INTEGER NOT NULL," +
        		"team2 INTEGER NOT NULL," +
        		"leg1_1 INTEGER NOT NULL," +
        		"leg1_2 INTEGER NOT NULL," +
        		"leg2_1 INTEGER NOT NULL," +
        		"leg2_2 INTEGER NOT NULL," +
        		"total1 INTEGER NOT NULL," +
        		"total2 INTEGER NOT NULL," +
        		"competition INTEGER NOT NULL," +
        		"phase VARCHAR(50) NOT NULL," +
        		"uri VARCHAR(80), " +
        		"CONSTRAINT match_pair_pk PRIMARY KEY (id)," +
        		"CONSTRAINT match_pair_phase_fk FOREIGN KEY (competition,phase) REFERENCES PHASE(competition,name)," +
        		"CONSTRAINT match_pair_team1_fk FOREIGN KEY (team1) REFERENCES TEAM(id)," +
        		"CONSTRAINT match_pair_team2_fk FOREIGN KEY (team2) REFERENCES TEAM(id)" +
        		")";

        String MATCH_CREATE = "CREATE TABLE MATCH_SINGLE (" +
        		"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
        		"team1 INTEGER NOT NULL," +
        		"team2 INTEGER NOT NULL," +
        		"result1 INTEGER NOT NULL," +
        		"result2 INTEGER NOT NULL," +
        		"mid1 INTEGER," +
        		"mid2 INTEGER," +
        		"competition INTEGER NOT NULL," +
        		"phase VARCHAR(50) NOT NULL," +
        		"uri VARCHAR(80), " +
        		"CONSTRAINT match_single_pk PRIMARY KEY (id)," +
        		"CONSTRAINT match_single_phase_fk FOREIGN KEY (competition,phase) REFERENCES PHASE(competition,name)," +
        		"CONSTRAINT match_single_team1_fk FOREIGN KEY (team1) REFERENCES TEAM(id)," +
        		"CONSTRAINT match_single_team2_fk FOREIGN KEY (team2) REFERENCES TEAM(id)" +
        		")";
        
        
		
		this.stmt.execute(COMPETITION_CREATE);
		this.stmt.execute(PHASE_CREATE);
		this.stmt.execute(TEAM_CREATE);
		this.stmt.execute(MATCH_PAIR_CREATE);
		this.stmt.execute(MATCH_CREATE);

		logger.log(Level.INFO, "First Time Initialization: Create tables");        
		
	}
	
	/**
	 * 
	 * Find the id of a competition 
	 * 
	 * @param name
	 * @param year
	 * @return
	 * @throws SQLException
	 */
	public Integer findCompetition(String name, String year ) throws SQLException {
	
		Integer id = null;
		        
		PreparedStatement stmt = con.prepareStatement("SELECT id FROM COMPETITION WHERE name=? AND season=?");
		stmt.setString(1, name);
		stmt.setString(2, year);
		
		stmt.execute();
		ResultSet resultSet = stmt.getResultSet();
		
		if (resultSet != null && resultSet.next()) 			
			id = resultSet.getInt(1);
		
		stmt.close();
		return id ;
	}
	
	public boolean insertCompetition(String name, String season, Integer start, String origin) throws SQLException {
		
		String insert = "INSERT INTO COMPETITION (name,season,start,uri) VALUES (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, truncate(name,MAX_COMPETITION_LENGTH));
		stmt.setString(2, truncate(season,MAX_SEASON_LENGTH));
		stmt.setInt(3, start);
		stmt.setString(4, truncate(origin, MAX_URI_LENGTH));
		
		stmt.execute();
		
		logger.log(Level.FINER, "inserted competition");
		stmt.close();
		
		return false;
	}

	public boolean findPhase(Integer competitionId, String name) throws SQLException {
		
		boolean b = false;
		        
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM PHASE WHERE competition=? AND name=?");
		stmt.setInt(1, competitionId);
		stmt.setString(2, name);
		
		stmt.execute();
		ResultSet resultSet = stmt.getResultSet();
		
		if (resultSet != null && resultSet.next()) 			
			b = true;
		
		stmt.close();
		return b ;
	}

	public boolean insertPhase(Integer competitionId, String name, String origin) throws SQLException {
		
		String insert = "INSERT INTO PHASE (competition,name,uri) VALUES (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setInt(1, competitionId);
		stmt.setString(2, truncate(name,MAX_PHASE_LENGTH));
		stmt.setString(3, truncate(origin, MAX_URI_LENGTH));
		
		stmt.execute();
		
		logger.log(Level.FINER, "inserted competition");
		stmt.close();
		
		return false;
	}
	
	
	public Integer findTeam(String name, String country ) throws SQLException {
		
		Integer id = null;
		        
		PreparedStatement stmt;
		
		if (country != null) {
			stmt = con.prepareStatement("SELECT id FROM TEAM WHERE name=? AND country=?");
			stmt.setString(1, name);
			stmt.setString(2, country);			
		} else {			
			stmt = con.prepareStatement("SELECT id FROM TEAM WHERE name=? AND country IS NULL");
			stmt.setString(1, name);			
		}
			
		
		stmt.execute();
		ResultSet resultSet = stmt.getResultSet();
		
		if (resultSet != null && resultSet.next()) 			
			id = resultSet.getInt(1);
		
		stmt.close();
		return id ;
	}

	
	public Integer findTeam(String name) throws SQLException {
		
		Integer id = null;
		        
		PreparedStatement stmt = con.prepareStatement("SELECT id FROM TEAM WHERE name=?");
		stmt.setString(1, name);
		
		stmt.execute();
		ResultSet resultSet = stmt.getResultSet();
		
		if (resultSet != null && resultSet.next()) 			
			id = resultSet.getInt(1);
		
		stmt.close();
		return id ;
	}

	

	public boolean insertTeam(String name, String country) throws SQLException {
		
		String insert = "INSERT INTO TEAM (name,country) VALUES (?,?)";
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, truncate(name,MAX_TEAM_LENGTH));
		if (country != null)
			stmt.setString(2, truncate(country, MAX_COUNTRY_LENGTH));
		else 
			stmt.setNull(2, Types.VARCHAR);
		
		stmt.execute();
		
		logger.log(Level.FINER, "inserted competition");
		stmt.close();
		
		return false;
	}


	public boolean insertMatchPair(
			Integer team1,  Integer team2,
			Integer leg1_1, Integer leg1_2,
			Integer leg2_1, Integer leg2_2,
			Integer total1, Integer total2,
			Integer competition, String phase, String uri) throws SQLException {
		
		String insert = 
				"INSERT INTO MATCH_PAIR (team1,team2,leg1_1,leg1_2,leg2_1,leg2_2,total1,total2,competition,phase,uri) " +
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setInt(1, team1);
		stmt.setInt(2, team2);
		
		stmt.setInt(3, leg1_1);
		stmt.setInt(4, leg1_2);
		
		stmt.setInt(5, leg2_1);
		stmt.setInt(6, leg2_2);
		
		stmt.setInt(7, total1);
		stmt.setInt(8, total2);
		
		stmt.setInt(9, competition);
		stmt.setString(10, truncate(phase, MAX_PHASE_LENGTH));
		stmt.setString(11, truncate(uri, MAX_URI_LENGTH));
		
		stmt.execute();
		
		logger.log(Level.FINER, "inserted competition");
		stmt.close();
		
		return false;
	}

	public boolean insertMatch(
			Integer team1, Integer team2, 
			Integer result1, Integer result2, 
			Integer mid1, Integer mid2, 
			Integer competition, String phase, String uri) throws SQLException {
		
		String insert = 
				"INSERT INTO MATCH_SINGLE (team1,team2,result1,result2,mid1,mid2,competition,phase,uri) " +
				"VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setInt(1, team1);
		stmt.setInt(2, team2);
		
		stmt.setInt(3, result1);
		stmt.setInt(4, result2);

		if (mid1 != null && mid1 >= 0)
			stmt.setInt(5, mid1);
		else 
			stmt.setNull(5, Types.INTEGER);
		
		if (mid2 != null && mid2 >= 0)	
			stmt.setInt(6, mid2);
		else stmt.setNull(6, Types.INTEGER);

		stmt.setInt(7, competition);
		stmt.setString(8, truncate(phase, MAX_PHASE_LENGTH));
		stmt.setString(9, truncate(uri, MAX_URI_LENGTH));

		stmt.execute();
		
		logger.log(Level.FINER, "inserted competition");
		stmt.close();

		
		return false;
	}
	

	/**
	 * Loads the Derby driver
	 * 
	 */
	private static void loadDriver() {
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			logger.log(Level.INFO, "Loaded Derby driver Ok");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, "No driver found for derby - check class path");
			e.printStackTrace();
		}

	}


	/**
	 * Delete a directory and all of its content
	 * 
	 * @param f
	 */
	private void deleteDir(File f) {
		if (f.isDirectory()) {
			String[] contents = f.list();
			for (String content : contents) {
				deleteDir(new File(f.toString() + File.separator + content));
			}
		}
		f.delete();
	}


	   private String truncate(String s, int length) {
		    if (s.length() <= length)
		      return s;
		    return s.substring(0, length);
	   }

	
	public static void main(String[] args) {
		
		File file = new File("/home/cdepablo/tmp/rssf");
		
		DatabaseProxy db = new DatabaseProxy(file);
		
		try {
			db.open();
			db.createDatabase();
			
			
			db.insertCompetition("Champion's Cup", "1995-96",1995, "" );
			Integer competitionId = db.findCompetition("Champion's Cup", "1995-96");
			
			db.insertPhase(competitionId, "Semi-Finals", "");
			db.findPhase(competitionId, "Semi-Finals");
			
			db.insertTeam("FC Barcelona", "Esp");
			Integer teamId1 = db.findTeam("FC Barcelona", "Esp");
			
			db.insertTeam("Real Madrid FC", "Esp");
			Integer teamId2 = db.findTeam("Real Madrid FC", "Esp");
			
			db.insertMatchPair(teamId1, teamId2, 1, 1, 1, 1, 2, 2, competitionId, "Semi-Finals","");
			
			db.insertMatch(teamId1, teamId2, 1, 2, null, null, competitionId, "Semi-Finals","");
			db.insertMatch(teamId1, teamId2, 1, 2, 1, 1, competitionId, "Semi-Finals","");
			
			
		} catch (SQLException e) {
			logger.log(Level.INFO, "Database: Unexpected error");
			e.printStackTrace();
		} finally {
			db.close();
		}
		
		
	}
	

}
