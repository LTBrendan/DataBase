package view.consoleView.consoleMode;

import static model.utils.Scan.sc;

import control.consoleControler.DatabaseControler;

/**
 * This class allows to generate 'Insert' instruction
 */
public class Insert {

	/**
	 * This method ask the user to construct the query
	 * 
	 * @return the query
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = null;
		tableName = sc.next();

		String queryInsertion = "";
		String[] columnName = DatabaseControler.getColumnName(tableName);
		String[] columnType = DatabaseControler.getColumnType(tableName);
		// Initialize the query
		queryInsertion = "INSERT INTO " + tableName + " VALUES (";

		// For each column, insert a value
		for (int i = 0; i < columnName.length; i++) {
			String name = columnName[i];
			String type = columnType[i];
			// Display the name of the column, the type and the number of
			// terms max
			System.out.println(name + " (Type : " + type.toLowerCase() + ")");

			int number = 0;
			String line = null;

			// If NUMBER
			if (type.equalsIgnoreCase("number")) {
				System.out.print("> ");
				number = Integer.parseInt(sc.next());
				queryInsertion += number;

				// If VARCHAR2 or DATE
			} else {
				System.out.print("> ");
				line = "'" + sc.next() + "'";
				queryInsertion += line;
			}

			// Shaping of the query
			if (i < columnName.length - 1) {
				queryInsertion += ", ";
			} else {
				queryInsertion += ")";
			}
		}

		return queryInsertion;
	}
}
