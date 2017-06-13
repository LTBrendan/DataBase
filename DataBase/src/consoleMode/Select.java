package consoleMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Select {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Select all the values of the table
	 *
	 * @param table
	 *            The name of the table
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = "";
		try {
			tableName = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "SELECT * FROM " +tableName;
	}
	
	public static void display (ResultSet rs) {
		
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
			System.out.println("\nSuccessful query execution !");
		} catch (SQLException e) {
			System.out.println("Query error !");
			//e.printStackTrace();
		} catch (NullPointerException ex){
			
		}
	}
}
