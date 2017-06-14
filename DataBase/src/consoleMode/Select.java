package consoleMode;

import static utils.Scan.sc;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * This class allows to generate 'Select' instruction
 */
public class Select {

	/**
	 * This method ask the user to construct the query
	 * @return the query
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = "";
		tableName = sc.next();
		return "SELECT * FROM " +tableName;
	}
	
	/**
	 * This class this play a Select ResultSet
	 * @param rs the ResultSet to display
	 */
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
		} catch (SQLException e) {
			System.out.println("Query error !");
			//e.printStackTrace();
		} catch (NullPointerException ex){
			
		}
	}
}
