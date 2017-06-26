package control.game;

import static model.utils.Scan.sc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import control.consoleControler.DatabaseControler;
import logs.Log;
import model.exception.ExceptionHandler;

/**
 * This class manage the SQLGame
 */
public class GameManager {
	
	private DatabaseControler dc;
	private QuestionManager qm;
	private String tableName = "Game";
	private HashMap<String, ArrayList<String>> questionList;

	/**
	 * The constructor
	 * @param dc the databaseControler of the user
	 */
	public GameManager(DatabaseControler dc) {
		this.setDc(dc);
	}

	/**
	 * Getter for the databaseControler
	 * @return the databaseControler
	 */
	public DatabaseControler getDc() {
		return dc;
	}

	/**
	 * Setter for the databaseControler
	 * @param dc the new databaseControler
	 */
	public void setDc(DatabaseControler dc) {
		this.dc = dc;
	}

	/**
	 * This method launch the game
	 */
	public void launchGame() {
		for (String s : this.questionList.keySet()) {
			System.out.println(s);
			System.out.println("Answer : ");
			for (String st : qm.getQuestionList().get(s)) {
				System.out.println(st.substring(0, st.length() - 1));
			}
			System.out.print("Write your answer\n>");
			String answer = sc.next();
			for (String st : qm.getQuestionList().get(s)) {
				if (answer.equals(String.valueOf(st.charAt(0)))) {
					if (st.endsWith("1")) {
						System.out.println("Good answer");
					} else {
						System.out.println("Wrong");
					}
				}
			}
		}

		
	}
	
	/**
	 * This method end the game and drop the table
	 */
	public void endGame () {
		try {
			dc.executeQuery("DROP TABLE " + this.tableName);
			Log.database("table for SQL game dropped");
		} catch (SQLException ex) {
			Log.database("error dropping table for game");
		}
	}
	
	/**
	 * This method setup the game and create the table
	 * @param questionNumber the number of question the user want to answer
	 */
	public void setUpGame (int questionNumber) {
		Log.database("SQL game started");
		this.createTable();
		this.insertValues();
		qm = new QuestionManager(questionNumber);
		this.questionList = qm.getQuestionList();
	}
	
	/**
	 * This method create the table
	 */
	private void createTable() {
		try {
			dc.executeQuery("CREATE TABLE " + this.tableName
					+ " (primaryKey number(2) constraint pk"+this.tableName+"PRIMARY KEY, name VARCHAR2 (10) CONSTRAINT nnName"+this.tableName+" NOT NULL, surname VARCHAR2(20) CONSTRAINT nnSurname"+this.tableName+" NOT NULL, age NUMBER(2) CONSTRAINT nnAge"+this.tableName+" NOT NULL, CONSTRAINT uqNameSurname"+this.tableName+" UNIQUE (name, surname))");
		} catch (SQLException e) {
			
			try {
				this.tableName += (int) (Math.random() * Math.pow(10, 9));
				System.out.println (tableName);
				dc.executeQuery("CREATE TABLE " + this.tableName
						+ " (primaryKey number(2) constraint pk"+this.tableName+" PRIMARY KEY, name VARCHAR2 (10) CONSTRAINT nnName"+this.tableName+" NOT NULL, surname VARCHAR2(20) CONSTRAINT nnSurname"+this.tableName+" NOT NULL, age NUMBER(2) CONSTRAINT nnAge"+this.tableName+" NOT NULL, CONSTRAINT uqNameSurname"+this.tableName+" UNIQUE (name, surname))");
			} catch (SQLException ex) {
				System.out.println(ExceptionHandler.analyse (ex.getMessage()));
				Log.database("error creating table for SQL game");
			}
		}
		Log.database("table for SQL game created");
	}

	/**
	 * This method insert the values
	 */
	private void insertValues() {

		try {
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (0, 'Kent', 'Clark', 40)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (1, 'Wayne', 'Bruce', 45)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (2, 'Prince', 'Diana', 25)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (3, 'Parker', 'Peter', 27)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (4, 'Stark', 'Tony', 50)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (5, 'Rogers', 'Steven', 25)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (6, 'Cage', 'Luke', 21)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (7, 'Banner', 'Bruce', 48)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (8, 'Odinson', 'Thor', 34)");
			dc.executeQuery("INSERT INTO " + this.tableName + " VALUES (9, 'Howlett', 'James', 48)");

		} catch (SQLException e) {
			System.out.println("Query error !");
			System.out.println(ExceptionHandler.analyse((e.getMessage())));
		}

	}
	
	/**
	 * Getter for the questionList
	 * @return the questionList
	 */
	public HashMap<String, ArrayList<String>> getQuestionList () {
		return this.questionList;
	}
}
