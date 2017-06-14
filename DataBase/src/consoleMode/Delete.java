package consoleMode;

import static utils.Scan.sc;

/**
 * This class allows to generate 'Delete' instruction
 */
public class Delete {

	/**
	 * This method ask the user to construct the query
	 * @return the query
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName;
		String ret = null;
		tableName = sc.next();
		System.out.println("\nAll values (Y / N) ?");
		System.out.print("> ");
		String choice = sc.next();

		if (choice.equalsIgnoreCase("y")) {
			ret = deleteAllValues(tableName);
		} else {
			ret = deleteValues(tableName);
		}
		return ret;
	}

	/**
	 * This method ask the user the values to delete from table
	 * @param table the table's name
	 * @return the query
	 */
	public static String deleteValues(String table) {

		String column = null;
		String value = null;
		System.out.println("\nColumn ?");
		System.out.print("> ");
		column = sc.next();
		System.out.println("\nValue ?");
		System.out.print("> ");
		value = sc.next();
		return "DELETE FROM " + table + " WHERE " + column + " = '" + value + "'";
	}

	/**
	 * This method construct a query that delete allthe values from table
	 * @param table the table's name
	 * @return the query
	 */
	public static String deleteAllValues(String table) {
		return "DELETE FROM " + table;
	}
}
