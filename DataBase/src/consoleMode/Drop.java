package consoleMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drop {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Drop a table that exist
	 *
	 * @param tableName
	 *            The name of the table
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = null;
		try {
			tableName = br.readLine();
			// dropTable(tableName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "DROP TABLE " + tableName;
	}
}
