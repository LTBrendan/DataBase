package junit.connexion;

import static org.junit.Assert.*;

import org.junit.Test;

import connexion.User;

public class TestUser {
	@Test ()
	public void testEquals () {
		User user1 = new User ("name1", "password1");
		User user2 = new User ("name2", "password2");
		assertFalse (user1.equals(null));
		assertFalse (user1.equals(user2));
		assertTrue (user1.equals(new User ("name1", "password1")));
		assertTrue (user1.equals(user1));
	}
}
