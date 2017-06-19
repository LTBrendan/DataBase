package connexion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import consoleControler.LauncherControler;

/**
 * This class allows to manage users by loading their information from a file and saving it to the same file
 *
 */
public class UserManager {
	//list containing all users and their information
	private static ArrayList<User> userList;
	//key used to generate the secret key
	private static String mykey = "1234567891234567";
	//the secret key used to encrypt user's password
    private static SecretKey key = new SecretKeySpec(mykey.getBytes(), "AES");
    //the encrypter used to encrypt user's password
    private static AES encrypter = new AES(key);
    
	/**
	 * Constructor for the user manager
	 */
	public UserManager () {
		UserManager.userList = new ArrayList<User>();
	}
	
	/**
	 * This method save the users in the user list into a file named user 
	 */
	public static void save () {
		 
		try {
			FileOutputStream fos = new FileOutputStream ("source/user");
			BufferedOutputStream bos = new BufferedOutputStream (fos);
			ObjectOutputStream oos = new ObjectOutputStream (bos);
			for (User us : UserManager.userList) {
				oos.writeObject(us);
			}
			oos.close ();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
				
	}
	
	/**
	 * This method load the users contained in the file 'user' and add them to the user list
	 */
	public static void load () {
		File file = new File ("source/user");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileInputStream fis = new FileInputStream (file);
			BufferedInputStream bis = new BufferedInputStream (fis);
			ObjectInputStream ois = new ObjectInputStream (bis);
			Object read;
			while ((read = ois.readObject ()) != null) {
				User us = (User)read;
				if (us.getColor() != 54 && us.getColor() != 247) 
					us.setColor(54);
				userList.add ((User)read);
			}
			ois.close ();
		} catch(EOFException ex){
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		if (!UserManager.checkUser ("admin", "admin")) {
			UserManager.createUser("admin", "admin");
		}
		
	}
	
	/**
	 * This method add a new user to the user list. Do nothing if a user with the same login and same password exists
	 * @param login new user's login
	 * @param pass new user's password
	 */
	public static void createUser (String login, String pass) {
		if (!UserManager.checkLogin(login)) {
			UserManager.userList.add(new User (login, encrypter.encrypt(pass)));
		}
	}
	
	/**
	 * This method check if a user with login and password exists in the user list
	 * @param login login to test
	 * @param pass pass password to test
	 * @return true only if a user exists with the informations in parameter
	 */
	public static boolean checkUser (String login, String pass) {
		boolean ret = false;
		for (User us : UserManager.userList) {
			if (us.getLogin ().equals(login)) {
				if (us.getPass ().equals (encrypter.encrypt(pass))) {
					ret = true;
				}
			}
		}
		return ret;
	}
	
	/**
	 * This method return the user with the information in parameter
	 * @param login user's login
	 * @param pass user's password
	 * @return the user if found, null if no
	 */
	public User getUser (String login , String pass) {
		User ret = null;
		for (User us : UserManager.userList) {
			if (us.getLogin().equals(login)) {
				if (us.getPass().equals(encrypter.encrypt(pass))) {
					ret = us;
				}
			}
		}
		return ret;
	}
	
	
	public String toString () {
		String ret = "";
		for (User us : UserManager.userList){
			ret += us.toString ()+"\n";
		}
		return ret;
	}
	
	/**
	 * This method remove a user with the informations in parameter
	 * @param login user's login
	 * @param pass user's password
	 * @return the removed user if found, null if no
	 */
	public static void removeUser (String login, String pass) {
		User removed = null;
		for (User us : UserManager.userList) {
			if (us.getLogin().equals(login)) {
				if (us.getPass().equals(encrypter.encrypt(pass))) {
					removed = us;
				}
			}
		}
		UserManager.userList.remove(removed);
	}
	
	public static boolean checkLogin (String login) {
		boolean ret = false;
		ArrayList<String> logins = new ArrayList<String>();
		
		for (User us : UserManager.userList) {
			logins.add(us.getLogin());
		}
		
		if (logins.contains(login)) {
			ret = true;
		}
		return ret;
	}
	
	public static ArrayList<User> getUserList () {
		return UserManager.userList;
	}
}
