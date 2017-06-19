package junit.connexion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connexion.AES;
import connexion.User;
import connexion.UserManager;

public class TestUserManager {
	private UserManager testUM;
	private User us1;
	private User us2;
	private String user1;
	private String user2;
	private String password1;
	private String password2;
	private static String mykey = "1234567891234567";
	private static SecretKey key = new SecretKeySpec(mykey.getBytes(), "AES");
	private static AES encrypter = new AES(key);

	@Before
	public void setUp() {
		testUM = new UserManager();
		user1 = "user1";
		user2 = "user2";
		password1 = "password1";
		password2 = "password2";

		us1 = new User(user1, encrypter.encrypt(password1));
		us2 = new User(user2, encrypter.encrypt(password2));
	}

	@Test
	public void testCreateUser() {
		UserManager.createUser(user1, password1);
		assertTrue(testUM.getUser(user1, password1).equals(us1));
		assertFalse(UserManager.getUserList().contains(user2));
		assertTrue(UserManager.getUserList().size() == 1);
		UserManager.createUser(new String("user1"), new String("password1"));
		assertFalse(UserManager.getUserList().size() == 2);
	}

	@Test
	public void testCheckUser() {
		UserManager.createUser(user1, password1);
		assertTrue(UserManager.checkUser(user1, password1));
		assertFalse(UserManager.checkUser(us2.getLogin(), us2.getPass()));
		assertFalse(UserManager.checkUser(null, null));
		// assertTrue (UserManager.checkUser(new String("user1"), new String
		// ("password1")));
	}

	@Test
	public void testGetUser() {
		UserManager.createUser(user1, password1);
		User test = testUM.getUser(user1, password1);
		assertTrue(test.equals(us1));
		assertFalse(test.equals(us2));
		assertTrue(test.equals(new User(user1, encrypter.encrypt(password1))));
	}

	@Test
	public void testRemoveUser() {
		UserManager.createUser(user1, password1);
		UserManager.createUser(user2, password2);
		assertTrue(UserManager.getUserList().size() == 2);
		UserManager.removeUser(user1, password1);
		assertTrue(UserManager.getUserList().size() == 1);
		UserManager.removeUser("test", "test");
		assertTrue(UserManager.getUserList().size() == 1);
	}

	@Test
	public void testCheckLogin() {
		UserManager.getUserList().add(us1);
		assertTrue(UserManager.checkLogin(us1.getLogin()));
		assertTrue(UserManager.checkLogin(new String("user1")));
		assertFalse(UserManager.checkLogin(us2.getLogin()));
	}

	@After
	public void tearDown() {
		this.testUM = null;
		this.user1 = null;
		this.user2 = null;
	}
}
