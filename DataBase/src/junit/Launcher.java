package junit;

import junit.connexion.TestUser;
import junit.connexion.TestUserManager;

public class Launcher {
	
	public static void main (String[] args) {
		TestUser tu = new TestUser ();
		tu.testEquals();
		TestUserManager tum = new TestUserManager ();
		tum.setUp();
		tum.testCheckLogin();
		tum.tearDown();
		tum.setUp();
		tum.testCheckUser();
		tum.tearDown();
		tum.setUp();
		tum.testCreateUser();
		tum.tearDown();
		tum.setUp();
		tum.testGetUser();
		tum.tearDown();
		tum.setUp();
		tum.testRemoveUser();
		tum.tearDown();
	}
	
}
