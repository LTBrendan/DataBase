package query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {

	// the database connection
	private Connection conn;
	// the statement that allows to execute query from java
	private Statement statement;
	// the ResultSet that receive query results
	private ResultSet resultat = null;
	// the user using database
	
	
	public QueryExecutor (Connection conn, Statement statement) {
		this.setConn(conn);
		this.setStatement(statement);
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		System.out.println(query);
		resultat = statement.executeQuery(query);
		return resultat;
	}
	
	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}


	public Statement getStatement() {
		return statement;
	}


	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
