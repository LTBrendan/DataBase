package consoleMode;

import static utils.Scan.sc;

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
	
	
}
