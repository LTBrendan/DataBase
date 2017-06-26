package model.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class allows to execute a query
 */
public class QueryExecutor {

	// the database connection
	private Connection conn;
	// the statement that allows to execute query from java
	private Statement statement;
	// the ResultSet that receive query results
	private ResultSet resultat = null;
	// the user using database
	
	
	/**
	 * The constructor
	 * @param conn the database connection
	 * @param statement the database statement
	 */
	public QueryExecutor (Connection conn, Statement statement) {
		this.setConn(conn);
		this.setStatement(statement);
	}
	
	/**
	 * This method execute a query
	 * @param query the query to execute
	 * @return the query ResultSet
	 * @throws SQLException only if an exception occurs
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		resultat = statement.executeQuery(query);
		return resultat;
	}
	
	/**
	 * Getter for the connection
	 * @return the connection
	 */
	public Connection getConn() {
		return conn;
	}


	/**
	 * Setter for the connection
	 * @param conn the new connection
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}


	/**
	 * Getter for the statement
	 * @return the tatement
	 */
	public Statement getStatement() {
		return statement;
	}


	/**
	 * Setter for the statement
	 * @param statement the new statement
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
