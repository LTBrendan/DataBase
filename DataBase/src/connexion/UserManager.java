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

public class UserManager {
	
	private static ArrayList<User> userList;
	
	public UserManager () {
		UserManager.userList = new ArrayList<User>();
	}
	public void save () {
		
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
				userList.add ((User)read);
			}
			ois.close ();
		} catch(EOFException ex){
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void createUser (String login, String pass) {
		if (!UserManager.checkUser(login, pass)) {
			UserManager.userList.add(new User (login, pass));
		}else {
			System.out.println("This user already exists");
		}
	}
	
	public static boolean checkUser (String login, String pass) {
		boolean ret = false;
		for (User us : UserManager.userList) {
			if (us.getLogin ().equals(login)) {
				if (us.getPass ().equals (pass)) {
					ret = true;
				}
			}
		}
		return ret;
	}
	
	public User getUser (String login , String pass) {
		User ret = null;
		for (User us : UserManager.userList) {
			if (us.getLogin().equals(login)) {
				if (us.getPass().equals(pass)) {
					ret = us;
				}
			}
		}
		return ret;
	}
}
