package consoleMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Insert {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Add values into the new table
	 *
	 * @param table
	 *            The name of the table
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = null;
		try {
			tableName = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String queryInsertion = null;

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
					number = Integer.parseInt(br.readLine());
					queryInsertion += number;

					// If VARCHAR2 or DATE
				} else {
					System.out.print("> ");
					line = "'" + br.readLine() + "'";
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

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return queryInsertion;
	}
}
