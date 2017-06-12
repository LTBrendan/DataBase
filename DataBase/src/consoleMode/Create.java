package consoleMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Create {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Create a new table
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

		String queryCreation = "CREATE TABLE " + tableName + "(";
		boolean primaryKeyUse = false;

		// Get the number of columns
		int columns = 0;
		System.out.println("\nNumber of column(s) ?");
		System.out.print("> ");
		try {
			columns = Integer.parseInt(br.readLine());
		} catch (java.lang.NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		// For each column, what name and type is
		for (int i = 1; i <= columns; i++) {

			// Name
			String name = null;
			System.out.println("\nName of column " + i + " ?");
			System.out.print("> ");
			try {
				name = br.readLine() + " ";
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (name != null) {
				queryCreation += name.toUpperCase();
			}

			// Type
			String type = null;
			int numberOfTerms = 0;
			System.out.println("\nType of column " + i + " ? (VARCHAR2, NUMBER, DATE)");
			System.out.print("> ");
			try {
				type = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// If VARCHAR2
			if ((name != null) && (type.equalsIgnoreCase("varchar2"))) {

				// Get numbers of terms max
				System.out.println("\nNumber of terms ? (VARCHAR2(?))");
				System.out.print("> ");
				try {
					numberOfTerms = Integer.parseInt(br.readLine());
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				queryCreation += type.toUpperCase() + "(" + numberOfTerms + ")";

				// if NUMBER or DATE
			} else {
				queryCreation += type.toUpperCase();
			}

			// Column NOT NULL
			String notNull = " NOT NULL ";
			System.out.println("\nNot Null ? (Y / N)");
			System.out.print("> ");
			String choiceNN = null;
			try {
				choiceNN = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (choiceNN.equalsIgnoreCase("y")) {
				queryCreation += notNull.toUpperCase();
			}

			// Column UNIQUE
			String unique = " UNIQUE ";
			System.out.println("\nUnique ? (Y / N)");
			System.out.print("> ");
			String choiceUQ = null;
			try {
				choiceUQ = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (choiceUQ.equalsIgnoreCase("y")) {
				queryCreation += unique.toUpperCase();
			}

			// Primary Key
			if (primaryKeyUse == false) {
				System.out.println("\nPrimary key ? (Y / N)");
				System.out.print("> ");
				String primaryKey = " CONSTRAINT pk" + name + " PRIMARY KEY ";
				String choicePrimaryKey = null;
				try {
					choicePrimaryKey = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (choicePrimaryKey.equalsIgnoreCase("y")) {
					queryCreation += primaryKey.toUpperCase();
				}
				if (i < columns) {
					System.out.println("You must have a primary key in your table");
					break;
				}
			}

			// Shaping of the query
			if (i < columns) {
				queryCreation += ", ";
			} else {
				queryCreation += ")";
				System.out.println(queryCreation);
			}
		}
		return queryCreation;
	}
}
