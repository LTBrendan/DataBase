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

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName;
		String ret = null;
		try {
			tableName = br.readLine();
			System.out.println("\nAll values (Y / N) ?");
			System.out.print("> ");
			String choice = br.readLine();

			if (choice.equalsIgnoreCase("y")) {
				ret = deleteAllValues(tableName);
			} else {
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
		return "DELETE FROM " + table + " WHERE " + column + " = '" + value + "'";
	}

	/**
	 * Delete all the values of the table
	 *
	 * @param table
	 *            The name of the table
	 * @return
	 */
	public static String deleteAllValues(String table) {
		return "DELETE FROM " + table;
	}
}
