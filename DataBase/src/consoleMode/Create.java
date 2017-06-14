package consoleMode;

import static utils.Scan.sc;

/**
 * This class allows to generate 'Create' instruction
 */
public class Create {

	/**
	 * This method ask the user to construct the query
	 * @return the query
	 */
	public static String getQuery() {

		System.out.println("\nTable name ?");
		System.out.print("> ");
		String tableName = null;
		tableName = sc.next();

		String queryCreation = "CREATE TABLE " + tableName + "(";
		boolean primaryKeyUse = false;
		boolean primaryKeyTurn = false;

		// Get the number of columns
		int columns = 0;
		System.out.println("\nNumber of column(s) ?");
		System.out.print("> ");
		try {
			columns = Integer.parseInt(sc.next());
		} catch (java.lang.NumberFormatException e1) {
			e1.printStackTrace();
		}

		// For each column, what name and type is
		for (int i = 1; i <= columns; i++) {

			// Name
			String name = null;
			System.out.println("\nName of column " + i + " ?");
			System.out.print("> ");
			name = sc.next() + " ";

			if (name != null) {
				queryCreation += name.toUpperCase();
			}

			// Type
			String type = null;
			int numberOfTerms = 0;
			System.out.println("\nType of column " + i + " ? (VARCHAR2, NUMBER, DATE)");
			System.out.print("> ");
			type = sc.next();

			// If VARCHAR2
			if ((name != null) && (type.equalsIgnoreCase("varchar2"))) {

				// Get numbers of terms max
				System.out.println("\nNumber of terms ? (VARCHAR2(?))");
				System.out.print("> ");
				numberOfTerms = Integer.parseInt(sc.next());
				queryCreation += type.toUpperCase() + "(" + numberOfTerms + ")";

				// if NUMBER or DATE
			} else {
				queryCreation += type.toUpperCase();
			}

			// Primary Key
			if (primaryKeyUse == false) {
				System.out.println("\nPrimary key ? (Y / N)");
				System.out.print("> ");
				String primaryKey = " CONSTRAINT pk" + name + " PRIMARY KEY ";
				String choicePrimaryKey = null;
				choicePrimaryKey = sc.next();
				if (choicePrimaryKey.equalsIgnoreCase("y")) {
					queryCreation += primaryKey.toUpperCase();
					primaryKeyUse = true;
					primaryKeyTurn = true;
				}
			}
			System.out.println(primaryKeyTurn);
			if (!primaryKeyTurn) {
				// Column NOT NULL
				String notNull = " NOT NULL ";
				System.out.println("\nNot Null ? (Y / N)");
				System.out.print("> ");
				String choiceNN = null;
				choiceNN = sc.next();
				if (choiceNN.equalsIgnoreCase("y")) {
					queryCreation += notNull.toUpperCase();
				}

				// Column UNIQUE
				String unique = " UNIQUE ";
				System.out.println("\nUnique ? (Y / N)");
				System.out.print("> ");
				String choiceUQ = null;
				choiceUQ = sc.next();
				if (choiceUQ.equalsIgnoreCase("y")) {
					queryCreation += unique.toUpperCase();
				}
			}
			primaryKeyTurn = false;

			// Shaping of the query
			if (i < columns) {
				queryCreation += ", ";
			} else {
				queryCreation += ")";
			}
		}
		
		if (primaryKeyUse == false) {
			System.out.println("You must have a primary key");
			queryCreation = null;
		}
		
		return queryCreation;
	}
}
