package consoleMode;

import static utils.Scan.sc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.User;
import exception.ExceptionHandler;
import game.GameManager;
import logs.Log;

/**
 * This class allows a user to connect to a database
 *
 */
public class Connect {

	// the database connexion
	private Connection conn = null;
	// the statement that allows to execute query from java
	private static Statement statement = null;
	// the ResultSet that receive query results
	private ResultSet resultat = null;
	// the user using database
	private User currentUser;

	/**
	 * Constructor of the class Connect
	 * 
	 * @param adress database address
	 * @param login user's login for the database
	 * @param password user's password for the database
	 * @param currentUser user attempting to connect the database
	 */
	public Connect(String adress, String login, String password, User currentUser) {

		// Connection to the data base Using JDBC. Need the database address,
		// the username and the password
		try {
			System.out.println("\nConnection to database...");
			conn = DriverManager.getConnection(adress, login, password);
			System.out.println("Successful connection !");
			Log.out("connexion established : " + adress);
			this.currentUser = currentUser;
		} catch (SQLException e) {
			System.out.println("Connection error");
			Log.out("unable to connect to database" + adress);
			e.printStackTrace();
		}

		// Creation of a statement that allows to execute query after
		try {
			System.out.println("\nCreating statement...");
			statement = conn.createStatement();
			Log.database("statement created");
		} catch (SQLException e1) {
			System.out.println("Statement creation error !");
			Log.database("error creating statement");
			e1.printStackTrace();
		}
		this.start();
	}
	
	/**
	 * This method start interaction with user
	 */
	private void start () {
		String want = "";

		while ((!want.toLowerCase().contains("quit")) && (!want.toLowerCase().contains("8"))) {
			System.out.println("\nWhat do you want to do ?");
			System.out.println("1 - CREATE : create a new table on your dataBase");
			System.out.println("2 - DROP   : drop a table");
			System.out.println("3 - INSERT : insert values on a table");
			System.out.println("4 - SELECT : select all the values of a table");
			System.out.println("5 - DELETE : delete all or some values of your dataBase");
			System.out.println("6 - PLAY   : play a game to learn the basis of SQL");
			System.out.println("7 - EXPERT MODE : write the full query");
			System.out.println("8 - QUIT   : exit the app");
			System.out.print("> ");
			want = sc.next();
			if ((want.toLowerCase().contains("create")) || (want.equals("1"))) {
				String query = Create.getQuery();

				try {
					resultat = this.executeQuery(query);
					System.out.println("Query successfully executed !");
					Log.database("query executed : " + query);

				} catch (SQLException e) {
					System.out.println("Query error !");
					System.out.println("create : " + ExceptionHandler.analyse((e.getMessage())));
					Log.database("error executing query : " + query);
				}

			} else if ((want.toLowerCase().contains("drop")) || (want.equals("2"))) {
				String query = Drop.getQuery();

				try {
					resultat = this.executeQuery(query);
					System.out.println("Query successfully executed !");
					Log.database("query executed : " + query);

				} catch (SQLException e) {
					System.out.println("Query error !");
					System.out.println("drop : " + ExceptionHandler.analyse((e.getMessage())));
					Log.database("error executing query : " + query);
				}

			} else if ((want.toLowerCase().contains("insert")) || (want.equals("3"))) {
				String query = Insert.getQuery();

				try {
					resultat = this.executeQuery(query);
					System.out.println("Query successfully executed !");
					Log.database("query executed : " + query);

				} catch (SQLException e) {
					System.out.println("Query error !");
					System.out.println("insert : " + ExceptionHandler.analyse((e.getMessage())));
					Log.database("error executing query : " + query);
				}

			} else if ((want.toLowerCase().contains("select")) || (want.equals("4"))) {
				String query = Select.getQuery();

				try {
					Select.display(resultat = this.executeQuery(query));
					System.out.println("Query successfully executed !");
					Log.database("query executed : " + query);

				} catch (SQLException e) {
					System.out.println("Query error !");
					System.out.println("select : " + ExceptionHandler.analyse((e.getMessage())));
					Log.database("error executing query : " + query);
				}

			} else if ((want.toLowerCase().contains("delete")) || (want.equals("5"))) {
				String query = Delete.getQuery();

				try {
					resultat = this.executeQuery(query);
					System.out.println("Query successfully executed !");
					Log.database("query executed : " + query);

				} catch (SQLException e) {
					System.out.println("Query error !");
					System.out.println("delete : " + ExceptionHandler.analyse((e.getMessage())));
					Log.database("error executing query : " + query);
				}
			}

			else if ((want.toLowerCase().contains("play")) || (want.equals("6"))) {
				GameManager game = new GameManager(this.currentUser, this);
				System.out.println("Choose the number of question (max : 50)");
				int questionNumber = 0;
				questionNumber = Integer.parseInt(sc.next());

				while (questionNumber <= 0 && questionNumber > 50) {
					System.out.println("Choose the number of question (max : 50)");
					questionNumber = Integer.parseInt(sc.next());
				}
				game.launchGame(questionNumber);
				Log.database("game end");

			} else if ((want.toLowerCase().contains("expert")) || (want.equals("7"))) {
				System.out.println("\nWrite here your query");
				System.out.print("> ");
				String queryExpert = "";

				try {

					while ((queryExpert = sc.nextLine()).length() == 0)
						;

					resultat = this.executeQuery(queryExpert);

					if (queryExpert.toLowerCase().contains("select")) {
						Select.display(resultat);
					}
					Log.database("query executed : " + queryExpert);

				} catch (SQLException e) {
					System.out.println("Query error !");
					System.out.println(ExceptionHandler.analyse((e.getMessage())));
					Log.database("error executing query : " + queryExpert);
				}

			} else if ((want.toLowerCase().contains("quit")) || (want.equals("8"))) {
				quit();

			} else {
				System.out.println("Sorry but I don't understand what you wanna do");
			}
		}
	}

	/**
	 * Close all the connections to the data base
	 */
	public void quit() {
		if (resultat != null) {
			try {
				resultat.close();
				Log.database("Result set closed");
			} catch (SQLException ignore) {

			}
		}

		if (statement != null) {
			try {
				statement.close();
				Log.database("statement closed");
			} catch (SQLException ignore) {

			}
		}

		if (conn != null) {
			try {
				conn.close();
				Log.database("connexion closed");
			} catch (SQLException ignore) {

			}
		}
		Log.database("disconnected from data base");
	}

	/**
	 * This method execute the queries writen by the user
	 * @param query the query to execute
	 * @return query result, null if error
	 * @throws SQLException only if a SQLException is raised
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		ResultSet ret = null;
		System.out.println(query);
		ret = statement.executeQuery(query);
		return ret;
	}

	/**
	 * Getter for statement attribute
	 * @return the statement
	 */
	public static Statement getStatement() {
		return statement;
	}
}
