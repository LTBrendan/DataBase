package consoleMode;

import static utils.Scan.sc;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * This class allows to generate 'Insert' instruction
 */
public class Insert {

	/**
	 * This method ask the user to construct the query
	 * @return the query
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = null;
		tableName = sc.next();

		String queryInsertion = "";

		try {
			// Get the number of columns
			ResultSet rs = Connect.getStatement().executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			// Initialize the query
			queryInsertion = "INSERT INTO " + tableName + " VALUES (";

			// For each column, insert a value
			for (int i = 1; i <= columnCount; i++) {
				String name = rsmd.getColumnName(i);
				String type = rsmd.getColumnTypeName(i);

				// Display the name of the column, the type and the number of
				// terms max
				System.out.println(name + "( Type : " + type.toLowerCase() + "(" + rsmd.getColumnDisplaySize(i) + "))");

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
				if (i < columnCount) {
					queryInsertion += ", ";
				} else {
					queryInsertion += ")";
				}
			}

			System.out.println(queryInsertion);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryInsertion;
	}
}
