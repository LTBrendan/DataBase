package control.game;

import static model.utils.Scan.sc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import control.consoleControler.DatabaseControler;
import logs.Log;
import model.exception.ExceptionHandler;

public class GameManager {
	private DatabaseControler dc;
	private QuestionManager qm;
	private String tableName = "Game";
	private HashMap<String, ArrayList<String>> questionList;

	public GameManager(DatabaseControler dc) {
		this.setDc(dc);
	}

	public DatabaseControler getDc() {
		return dc;
	}

	public void setDc(DatabaseControler dc) {
		this.dc = dc;
	}

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
	
	public void endGame () {
		try {
			dc.executeQuery("DROP TABLE " + this.tableName);
			Log.database("table for SQL game dropped");
		} catch (SQLException ex) {
			Log.database("error dropping table for game");
		}
	}
	
	public void setUpGame (int questionNumber) {
		Log.database("SQL game started");
		this.createTable();
		this.insertValues();
		qm = new QuestionManager(questionNumber);
		this.questionList = qm.getQuestionList();
	}
	
	private void createTable() {
		try {
			dc.executeQuery("CREATE TABLE " + this.tableName
					+ " (primaryKey number(2) constraint pkGame PRIMARY KEY, name VARCHAR2 (10) CONSTRAINT nnName NOT NULL, surname VARCHAR2(20) CONSTRAINT nnSurname NOT NULL, age NUMBER(2) CONSTRAINT nnAge NOT NULL, CONSTRAINT nnNameSurname UNIQUE (name, surname))");
		} catch (SQLException e) {
			try {
				this.tableName += (int) (Math.random() * Math.pow(10, 9));
				dc.executeQuery("CREATE TABLE " + this.tableName
						+ " (primaryKey number(2) constraint pkGame PRIMARY KEY, name VARCHAR2 (10) CONSTRAINT nnName NOT NULL, surname VARCHAR2(20) CONSTRAINT nnSurname NOT NULL, age NUMBER(2) CONSTRAINT nnAge NOT NULL, CONSTRAINT nnNameSurname UNIQUE (name, surname))");
			} catch (SQLException ex) {
				Log.database("error creating table for SQL game");
			}
		}
		Log.database("table for SQL game created");
	}

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
	
	public HashMap<String, ArrayList<String>> getQuestionList () {
		return this.questionList;
	}
}
