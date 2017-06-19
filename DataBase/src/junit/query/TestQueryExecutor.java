package junit.query;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import exception.ExceptionHandler;
import query.QueryExecutor;


public class TestQueryExecutor {

	@Test
	public void testExecuteQuery() {

			//Connection to known database
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:PROJETDB", "SYSTEM",
						"Ikazoqx2");
			} catch (SQLException e) {
				
			}
			
			//Creation of the statement
			Statement statement = null;
			try {
				statement = conn.createStatement();
			} catch (SQLException e) {
				
			} catch (NullPointerException e) {
				
			}
			
			//Set up of the query executor
			QueryExecutor qe = new QueryExecutor(conn, statement);
			
			try {
				//if different of null, it means the query has been executed
				assertFalse (qe.executeQuery("CREATE TABLE test (primary number(2) CONSTRAINT pkTest PRIMARY KEY)").equals(null));
				
			} catch (SQLException e) {
				
			}
			
			try {
				//if different of null, it means the query has been executed
				assertFalse (qe.executeQuery("INSERT INTO test VALUES (0)").equals(null));
				
			} catch (SQLException e) {

			}
			
			try {
				qe.executeQuery("INSERT INTO test VALUES (0)");
				
			} catch (SQLException e) {
				assertTrue (ExceptionHandler.analyse(e.getMessage()).equals("violation de contrainte unique"));
			}
			
			try {
				ResultSet rs = qe.executeQuery("SELECT * FROM test");
				assertTrue (rs.next ());
				assertTrue (rs.getInt(1) == 0);
			} catch (SQLException e1) {
			
			}
			
			try {
				//if different of null, it means the query has been executed
				assertFalse (qe.executeQuery("DROP TABLE test").equals(null));
				
			} catch (SQLException e) {

			}

	
	}

}
