package consoleMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Delete {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Constructor
	 */
	public static String getQuery() {

		
		String tableName = null;
		String ret = null;
		try {
			
			while (tableName == null) {
				System.out.println("\nTable name ?");
				System.out.print("> ");
				tableName = br.readLine();
			}
			
			System.out.println("\nAll values (Y / N) ?");
			System.out.print("> ");
			String choice = br.readLine();
			
			while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
				System.out.println("\nAll values (Y / N) ?");
				System.out.print("> ");
				choice = br.readLine();
			}
			
			if (choice.equalsIgnoreCase("y")) {
				
				ret = deleteAllValues(tableName);
				
			} else if (choice.equalsIgnoreCase ("n")) {
				
				ret = deleteValues(tableName);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * Delete the values of the table
	 *
	 * @param table
	 *            The name of the table
	 * @param name
	 *            The name of the values to delete
	 * @return
	 */
	public static String deleteValues(String table) {

		String column = null;
		String value = null;
		String query = null;
		if (table != null){
			try {
				System.out.println("\nColumn ?");
				System.out.print("> ");
				column = br.readLine();
				System.out.println("\nValue ?");
				System.out.print("> ");
				value = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			query = "DELETE FROM " + table + " WHERE " + column + " = '" + value + "'";
		}
		return query;
	}

	/**
	 * Delete all the values of the table
	 *
	 * @param table
	 *            The name of the table
	 * @return
	 * 			  The query
	 */
	public static String deleteAllValues(String table) {
		String query = null;
		if (table != null)
			query = "DELETE FROM " + table;
		return query;
	}
	
	public static void main (String[] args) {
		System.out.println (getQuery ());
	}
}
