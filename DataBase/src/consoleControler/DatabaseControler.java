package consoleControler;

import static utils.Scan.sc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import consoleMode.Create;
import consoleMode.Delete;
import consoleMode.Drop;
import consoleMode.Insert;
import consoleMode.Select;
import consoleView.Connect;
import exception.ExceptionHandler;
import game.GameManager;
import logs.Log;
import query.QueryExecutor;

public class DatabaseControler extends MainControler {

	QueryExecutor exec;
	// the database connection
	private Connection conn = null;
	// the statement that allows to execute query from java
	private static Statement statement = null;
	private String address;
	private String login;
	private String password;

	private static DatabaseControler databaseControler;

	public DatabaseControler(String address, String login, String password) {
		super();
		this.setAddress(address);
		this.setLogin(login);
		this.setPassword(password);

		databaseControler = this;
		// Connection to the data base Using JDBC. Need the database address,
		// the user name and the password
		try {
			System.out.println("\nConnection to database...");
			conn = DriverManager.getConnection(address, login, password);
			System.out.println("Successful connection !");// Creation of a
															// statement that
															// allows to execute
															// query after
			try {
				System.out.println("\nCreating statement...");
				statement = conn.createStatement();
				Log.database("statement created");
				System.out.println("Statement created");
			} catch (SQLException e2) {
				System.out.println("Statement creation error !");
				Log.database("error creating statement");
				e2.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println("Connection error");
			Log.out("unable to connect to database" + address);
			// e1.printStackTrace();
		}
		exec = new QueryExecutor(conn, statement);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
			game.launchGame(questionNumber);
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

		}
		return ret;
	}

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

		}
		return ret;
	}

	// public String[] getTableName() {

	// String[] ret = null;
	// try {
	//
	// ResultSet rs = exec.executeQuery("Select table_name from all_tables");
	// //Select * from (Select table_name from dba_tables)
	// ResultSetMetaData rsmd = rs.getMetaData();
	//
	// int count = rsmd.getColumnCount();
	// ret = new String[250];
	// while (rs.next())
	// for (int i = 1; i <= 250; i++) {
	// ret[i - 1] = rs.getString(i);
	// }
	// } catch (SQLException e) {
	//
	// }

	//
	// try {
	// ResultSet rs = exec.executeQuery("Select table_name from all_tables");
	// ResultSetMetaData rsmd = rs.getMetaData();
	// int columnCount = rsmd.getColumnCount();
	// int i =0;
	// // For each line of the table
	// while (rs.next()) {
	// ret[i] = (rs.getString(columnCount));
	// i++;
	// }
	// } catch (SQLException e) {
	// System.out.println("Query error !");
	// System.out.println (ExceptionHandler.analyse (e.getMessage()));
	// } catch (NullPointerException ex) {
	//
	// }
	//
	//
	// return ret;
	// }

	public ResultSet executeQuery(String query) throws SQLException {
		return exec.executeQuery(query);
	}

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

	public static DatabaseControler getDataBaseControler() {
		return databaseControler;
	}
}
