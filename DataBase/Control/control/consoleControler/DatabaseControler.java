package control.consoleControler;

import static model.utils.Scan.sc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import control.game.GameManager;
import logs.Log;
import model.exception.ExceptionHandler;
import model.query.QueryExecutor;
import view.consoleView.Connect;
import view.consoleView.consoleMode.Create;
import view.consoleView.consoleMode.Delete;
import view.consoleView.consoleMode.Drop;
import view.consoleView.consoleMode.Insert;
import view.consoleView.consoleMode.Select;

/**
 * This class allow to manipulate database through different method
 */
public class DatabaseControler extends MainControler {

	// the DatabaseControler query executor
	QueryExecutor exec;
	// the database connection
	private Connection conn = null;
	// the statement that allows to execute query from java
	private static Statement statement = null;
	// the database address
	private String address;
	// the user's database login
	private String login;
	// the user's database password
	private String password;

	private static DatabaseControler databaseControler;

	/**
	 * DatabaseControler constructor
	 * 
	 * @param address
	 *            the database address
	 * @param login
	 *            the user's login to log into the database
	 * @param password
	 *            the user's password to log into the database
	 * @throws SQLException
	 *             if can not establish connection
	 */
	public DatabaseControler(String address, String login, String password) throws SQLException {
		//super();
		this.setAddress(address);
		this.setLogin(login);
		this.setPassword(password);

		databaseControler = this;
		// Connection to the data base Using JDBC. Need the database address,
		// the user name and the password
		conn = DriverManager.getConnection(address, login, password);
		try {
			// Creation of a statement that allows to execute query after
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			exec = new QueryExecutor(conn, statement);
		} catch (SQLException e) {
			System.out.println("Statement creation error !");
			Log.database("error creating statement");
			e.printStackTrace();
		}
	}

	/**
	 * Getter for address attribute
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for address attribute
	 * 
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for login attribute
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Setter for login attribute
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Getter for password attribute
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password attribute
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method get the query wanted by the user
	 * 
	 * @param want
	 *            what the user want to do
	 */
	public void getQuery(String want) {
		if (want.equalsIgnoreCase("create") || want.equals("1")) {
			try {
				String query = Create.getQuery();
				this.executeQuery(query);
				System.out.println(query);
				Log.database("query executed : " + query);
			} catch (SQLException e) {
				System.out.println("Query error");
				System.out.println("create : " + ExceptionHandler.analyse(e.getMessage()));
				Log.err("query error (create) : " + ExceptionHandler.analyse(e.getMessage()));
			}
		}

		if (want.equalsIgnoreCase("drop") || want.equals("2")) {
			try {
				String query = Drop.getQuery();
				this.executeQuery(query);
				Log.database("query executed : " + query);
			} catch (SQLException e) {
				System.out.println("Query error");
				System.out.println("drop : " + ExceptionHandler.analyse(e.getMessage()));
				Log.err("query error (drop) : " + ExceptionHandler.analyse(e.getMessage()));
			}
		}

		if (want.equalsIgnoreCase("insert") || want.equals("3")) {
			try {
				String query = Insert.getQuery();
				this.executeQuery(query);
				Log.database("query executed : " + query);
			} catch (SQLException e) {
				System.out.println("Query error");
				System.out.println("insert : " + ExceptionHandler.analyse(e.getMessage()));
				Log.err("query error (insert) : " + ExceptionHandler.analyse(e.getMessage()));
			}
		}

		if (want.equalsIgnoreCase("select") || want.equals("4")) {
			try {
				String query = Select.getQuery();
				display(this.executeQuery(query));
				Log.database("query executed : " + query);
			} catch (SQLException e) {
				System.out.println("Query error");
				System.out.println("select : " + ExceptionHandler.analyse(e.getMessage()));
				Log.err("query error (select) : " + ExceptionHandler.analyse(e.getMessage()));
			}
		}

		if (want.equalsIgnoreCase("delete") || want.equals("5")) {
			try {
				String query = Delete.getQuery();
				this.executeQuery(query);
				Log.database("query executed : " + query);
			} catch (SQLException e) {
				System.out.println("Query error");
				System.out.println("delete : " + ExceptionHandler.analyse(e.getMessage()));
				Log.err("query error (delete) : " + ExceptionHandler.analyse(e.getMessage()));
			}
		}

		if ((want.toLowerCase().contains("play")) || (want.equals("6"))) {
			GameManager game = new GameManager(this);
			System.out.println("Choose the number of question (max : 50)");
			int questionNumber = 0;
			questionNumber = Integer.parseInt(sc.next());

			while (questionNumber <= 0 && questionNumber > 50) {
				System.out.println("Choose the number of question (max : 50)");
				questionNumber = Integer.parseInt(sc.next());
			}
			game.setUpGame(questionNumber);
			game.launchGame();
			game.endGame();
			Log.database("SQL game ended");
		}

		if ((want.toLowerCase().contains("expert")) || (want.equals("7"))) {
			try {
				String query = Connect.getExpertQuery();
				if (query.toLowerCase().contains("select")) {
					display(this.executeQuery(query));
				}

				else {
					this.executeQuery(query);
				}
				Log.database("query executed : " + query);
			} catch (SQLException e) {
				System.out.println("Query error");
				System.out.println(ExceptionHandler.analyse(e.getMessage()));
				Log.err("query error : " + ExceptionHandler.analyse(e.getMessage()));
			}
		}
	}

	/**
	 * This method return the name of all the table's column
	 * 
	 * @param tableName
	 *            the table from where to get the column names
	 * @return a String table with all the tables names
	 */
	public static String[] getColumnName(String tableName) {
		// Get the number of columns
		String[] ret = null;
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			ret = new String[count];
			for (int i = 1; i <= count; i++) {
				ret[i - 1] = rsmd.getColumnName(i);
			}
		} catch (SQLException e) {

		} catch (NullPointerException e) {
			
		}
		return ret;
	}

	/**
	 * This method return the type of all the table's column
	 * 
	 * @param tableName
	 *            the table from where to get the column types
	 * @return a String table with all the tables types
	 */
	public static String[] getColumnType(String tableName) {
		// Get the number of columns
		String[] ret = null;
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			ret = new String[count];
			for (int i = 1; i <= count; i++) {
				ret[i - 1] = rsmd.getColumnTypeName(i);
			}
		} catch (SQLException e) {

		} catch (NullPointerException e) {
			
		}
		return ret;
	}

	/**
	 * This method call the QueryExecutor to execute the query in parameter
	 * 
	 * @param query
	 *            the query to execute
	 * @return the query's ResultSet
	 * @throws SQLException
	 *             only if an SQLException is detected
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		return exec.executeQuery(query);
	}

	/**
	 * This method display a ResultSet obtained through a select
	 * 
	 * @param rs
	 *            the ResultSet to display
	 */
	public void display(ResultSet rs) {

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			// Display the select query
			String displayQuery = "";
			for (int i = 1; i < columnCount; i++) {
				displayQuery += rsmd.getColumnName(i) + " \t|\t ";
			}
			displayQuery += rsmd.getColumnName(columnCount);
			System.out.println(displayQuery);

			// For each line of the table
			while (rs.next()) {
				for (int j = 1; j < columnCount; j++) {
					System.out.print(rs.getString(j) + " \t\t\t ");
				}
				System.out.print(rs.getString(columnCount));
				System.out.print("\n");
			}
		} catch (SQLException e) {
			System.out.println("Query error !");
			System.out.println(ExceptionHandler.analyse(e.getMessage()));
		} catch (NullPointerException ex) {

		}
	}

	/**
	 * This method is called when leaving a database to close the statement and
	 * the connection
	 */
	public void quit() {
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
	}

	/**
	 * This method return this database controller
	 * 
	 * @return this database controller
	 */
	public static DatabaseControler getDataBaseControler() {
		return databaseControler;
	}
}
