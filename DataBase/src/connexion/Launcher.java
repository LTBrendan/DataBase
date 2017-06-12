package connexion;

import java.util.Scanner;
public class Launcher {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		UserManager um = new UserManager ();
		UserManager.load ();
		System.out.println("connect\nadd");
		String s = sc.next ();
		while (!s.equals("connect") && !s.equals("add")) {
			System.out.println("connect\nadd");
			s = sc.next ();
		}
		if (s.equals("add")) {
			System.out.println ("Login ?");
			String login = sc.next();
			System.out.println ("Confirm");
			String loginBis = sc.next();
			if (login.equals(loginBis)) {
				System.out.println ("Password ?");
				String pass = sc.next();
				System.out.println ("Confirm");
				String passBis = sc.next();
				if (pass.equals(passBis)) {
					UserManager.createUser (login, pass);
				} else {
					System.out.println("The 2 passwords must be equals");
				}
			} else {
				System.out.println("The 2 logins must be equals");
			}
		}
		
		if (s.equals("connect")) {
			System.out.println ("Login ?");
			String login = sc.next();
			System.out.println ("Password ?");
			String pass = sc.next();
			if (UserManager.checkUser(login, pass)) {
				System.out.println("Connected as "+login);
			} else {
				System.out.println("This user does not exist");
			}
		}
		sc.close ();
		um.save();
	}
}
