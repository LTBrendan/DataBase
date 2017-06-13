package consoleMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.User;
import game.GameManager;

public class Connect {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Connection conn = null;
	private static Statement statement = null;
	private ResultSet resultat = null;
	private User currentUser;

	/**
	 * Constructor of the class
	 */
	public Connect(String adress, String login, String password, User currentUser) {

		/**
		 * Connection to the data base Using JDBC Need the database address, the
		 * username and the password
		 */
		try {
			System.out.println("\nConnection to database...");
			conn = DriverManager.getConnection(adress, login, password);
			System.out.println("Successful connection !");
			this.currentUser = currentUser;
		} catch (SQLException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}

		/**
		 * Creation of a statement The statement allow to execute query after
		 */
		try {
			System.out.println("\nCreating statement...");
			statement = conn.createStatement();
			System.out.println("Successful statement creation !");
		} catch (SQLException e1) {
			System.out.println("Statement creation error !");
			e1.printStackTrace();
		}

		String want = " ";
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
			try {
				want = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if ((want.toLowerCase().contains("create")) || (want.toLowerCase().contains("1"))) {
				resultat = this.executeQuery(Create.getQuery());
				
			} else if ((want.toLowerCase().contains("drop")) || (want.toLowerCase().contains("2"))) {
				resultat = this.executeQuery(Drop.getQuery());

			} else if ((want.toLowerCase().contains("insert")) || (want.toLowerCase().contains("3"))) {
				resultat = this.executeQuery(Insert.getQuery());

			} else if ((want.toLowerCase().contains("select")) || (want.toLowerCase().contains("4"))) {
				Select.getQuery();

			} else if ((want.toLowerCase().contains("delete")) || (want.toLowerCase().contains("5"))) {
				resultat = this.executeQuery(Delete.getQuery());

			} else if ((want.toLowerCase().contains("play")) || (want.toLowerCase().contains("6"))) {

				GameManager game = new GameManager (this.currentUser, this);
				System.out.println("Choose the number of question");
				int questionNumber = 0;
				try {
				questionNumber = Integer.parseInt(br.readLine());
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				game.launchGame (questionNumber);

			} else if ((want.toLowerCase().contains("expert")) || (want.toLowerCase().contains("7"))) {
				System.out.println("\nWrite here your query");
				System.out.print("> ");
				String queryExpert;
				try {
					queryExpert = br.readLine();
					resultat = statement.executeQuery(queryExpert);
					System.out.println("Successful query execution !");
				} catch (SQLException e) {
					System.out.println("Query error !");
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if ((!want.toLowerCase().contains("quit")) && (!want.toLowerCase().contains("8"))) {
				System.out.println("Sorry, but I don't know what you want...");
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
			} catch (SQLException ignore) {

			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException ignore) {

			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ignore) {

			}
		}
	}

	public ResultSet executeQuery(String query) {
		ResultSet ret = null;
		try {
			statement.executeQuery(query);
			System.out.println("Query successfully executed !");
		} catch (SQLException e) {
			System.out.println("Query error !");
			e.printStackTrace();
		}
		return ret;
	}

	public static Statement getStatement() {
		return statement;
	}
}
