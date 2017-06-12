package connexion;

import java.util.Scanner;

public class Launcher {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		UserManager um = new UserManager ();
		UserManager.load ();
		UserManager.createUser("test", "test");
		System.out.println("Login :");
		String login = sc.next ();
		System.out.println("Password :");
		String pass = sc.next ();
		if (UserManager.checkUser (login, pass)) {
			System.out.println("Welcome "+login);
		} else {
			System.out.println("This user does not exist");
			System.out.println("Create a new user with this login and password ? (y/n)");
			if (sc.next ().equalsIgnoreCase("y"));
			UserManager.createUser(login, pass);
		}
		um.save ();
		sc.close ();
	}
	
}
