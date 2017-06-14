package game;

import static utils.Scan.sc;

import java.sql.ResultSet;
import java.sql.SQLException;

import connexion.User;
import consoleMode.Connect;
import consoleMode.Select;
import exception.ExceptionHandler;
import logs.Log;

public class GameManager {
	User currentUser;
	Connect connex;
	QuestionManager qm;
	String tableName = "Game";

	public GameManager(User currentUser, Connect connex) {
		this.setCurrentUser(currentUser);
		this.setCurrentConnexion(connex);

	}

	public Connect getCurrentConnexion() {
		return connex;
	}

	public void setCurrentConnexion(Connect connex) {
		this.connex = connex;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void launchGame(int questionNumber) {
		Log.database("SQL game started");
		this.createTable();
		this.insertValues();
		qm = new QuestionManager(questionNumber);
		for (String s : qm.getQuestionList().keySet()) {
			System.out.println(s);
			System.out.println("Answer : ");
			for (String st : qm.getQuestionList().get(s)) {
				System.out.println(st.substring(0, st.length() - 1));
			}
			System.out.print("Execute the query\n>");
			String line;
			while((line = sc.nextLine()).length() == 0);
			try {
				ResultSet resultat = connex.executeQuery(line);
				if (line.toLowerCase().contains("select")) {
					Select.display(resultat);
				}
			} catch (SQLException e) {
				System.out.println("Query error !");
				System.out.println("You didn't execute the query correctly !");
				System.out.println(ExceptionHandler.analyse((e.getMessage())));
			}
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

		try {
			connex.executeQuery("DROP TABLE " + this.tableName);
			System.out.println("Query successfully executed !");
			Log.database("table for game dropped");
		} catch (SQLException ex) {
			Log.database("error dropping table for game");
		}
	}

	private void createTable() {
		try {
			connex.executeQuery("CREATE TABLE " + this.tableName
					+ " (primaryKey number(2) constraint pkGame PRIMARY KEY, name VARCHAR2 (10) CONSTRAINT nnName NOT NULL, surname VARCHAR2(20) CONSTRAINT nnSurname NOT NULL, age NUMBER(2) CONSTRAINT nnAge NOT NULL, CONSTRAINT nnNameSurname UNIQUE (name, surname))");
		} catch (SQLException e) {
			try {
				this.tableName += (int) (Math.random() * Math.pow(10, 9));
				connex.executeQuery("CREATE TABLE " + this.tableName
						+ " (primaryKey number(2) constraint pkGame PRIMARY KEY, name VARCHAR2 (10) CONSTRAINT nnName NOT NULL, surname VARCHAR2(20) CONSTRAINT nnSurname NOT NULL, age NUMBER(2) CONSTRAINT nnAge NOT NULL, CONSTRAINT nnNameSurname UNIQUE (name, surname))");
			} catch (SQLException ex) {
				Log.database("error creating tabl for game");
			}
		}
		Log.database("table for game created");
	}

	private void insertValues() {

		try {
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (0, 'Kent', 'Clark', 40)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (1, 'Wayne', 'Bruce', 45)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (2, 'Prince', 'Diana', 25)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (3, 'Parker', 'Peter', 27)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (4, 'Stark', 'Tony', 50)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (5, 'Rogers', 'Steven', 25)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (6, 'Cage', 'Luke', 21)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (7, 'Banner', 'Bruce', 48)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (8, 'Odinson', 'Thor', 34)");
			connex.executeQuery("INSERT INTO "+this.tableName+" VALUES (9, 'Howlett', 'James', 48)");

		} catch (SQLException e) {
			System.out.println("Query error !");
			System.out.println(ExceptionHandler.analyse((e.getMessage())));
		}

	}
}
