package game;

import connexion.User;
import consoleMode.Connect;

public class GameManager {
	User currentUser;
	Connect connex;
	
	public GameManager(User currentUser, Connect connex) {
		this.setCurrentUser(currentUser);
		this.setCurrentConnexion(connex);
	}

	public Connect getCurrentConnexion() {
		return connex;
	}

	public void setCurrentConnexion(Connect connex) {
		this.connex = connex;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public void launchGame (int questionNumber) {
		this.createTable();
		this.insertValues();
	}
	
	private void createTable () {
		connex.executeQuery("CREATE TABLE Game (primaryKey number(2) constraint pkGame PRIMARY KEY, name VARCHAR2 (10) CONSTRAINT nnName NOT NULL, surname VARCHAR2(20) CONSTRAINT nnSurname NOT NULL, age NUMBER(2) CONSTRAINT nnAge NOT NULL, CONSTRAINT nnNameSurname UNIQUE (name, surname))");

	}
	
	private void insertValues () {
		connex.executeQuery("INSERT INTO Game VALUES (0, 'Kent', 'Clark', 40)");
		connex.executeQuery("INSERT INTO Game VALUES (1, 'Wayne', 'Bruce', 45)");
		connex.executeQuery("INSERT INTO Game VALUES (2, 'Prince', 'Diana', 25)");
	}
}
