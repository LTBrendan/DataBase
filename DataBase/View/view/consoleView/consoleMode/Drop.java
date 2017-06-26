package view.consoleView.consoleMode;

import static model.utils.Scan.sc;

/**
 * This class allows to generate 'Drop' instruction
 */
public class Drop {
	
	/**
	 * This method ask the user to construct the query
	 * @return the query
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = null;
		tableName = sc.next();
		return "DROP TABLE " + tableName;
	}
}
