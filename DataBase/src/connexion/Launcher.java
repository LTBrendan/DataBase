package connexion;

import java.util.Scanner;
import consoleMode.*;

public class Launcher {

	private static Scanner sc = new Scanner(System.in);
	private static UserManager um = new UserManager();

	public static void main(String[] args) {
		UserManager.load();
		System.out.println(um.toString());
		System.out.println("connect\nadd\nremove");
		String s = sc.next();
		
		while (!s.equals("connect") && !s.equals("add") && !s.equals("remove")) {
			System.out.println("connect\nadd");
			s = sc.next();
		}

		if (s.equals("add")) {
			Launcher.add();
		}

		if (s.equals("connect")) {
			User currentUser = Launcher.connect();
			
			if (currentUser != null) {
				System.out.println("use an existing connexion\ncreate a new connexion");
				s = sc.next();
				
				while (!s.equals("new") && !s.equals("use")) {
					System.out.println("use an existing connexion\ncreate a new connexion");
					s = sc.next();
				}
				
				if (s.equals("use")) {
					Launcher.useConnexion(currentUser);
				} else {
					Launcher.addConnexion(currentUser);
				}
				
			} else {
				System.out.println("This user does not exist");
			}
		}

		if (s.equals("remove")) {
			Launcher.remove();
		}
		sc.close();
		um.save();

	}

	private static void add() {
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Confirm");
		String loginBis = sc.next();
		if (login.equals(loginBis)) {
			System.out.println("Password ?");
			String pass = sc.next();
			System.out.println("Confirm");
			String passBis = sc.next();
			if (pass.equals(passBis)) {
				UserManager.createUser(login, pass);
			} else {
				System.out.println("The 2 passwords must be equals");
			}
		} else {
			System.out.println("The 2 logins must be equals");
		}
	}

	private static void remove() {
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Password ?");
		String pass = sc.next();
		User removed = UserManager.removeUser(login, pass);
		if (removed != null) {
			System.out.println("Type undo to undo, confirm to confirm");
			String s = sc.next();
			
			while (!s.equals("undo") && !s.equals("confirm")) {
				System.out.println("Type undo to undo, confirm to confirm");
				s = sc.next();
			}
			
			if (s.equals("undo")) {
				UserManager.createUser(removed.getLogin(), removed.getPass());
			}
			
			if (s.equals("confirm")) {
				System.out.println("User removed");
			}
			
		} else {
			System.out.println("This user does not exist");
		}
	}

	private static User connect() {
		User ret = null;
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Password ?");
		String pass = sc.next();
		if (UserManager.checkUser(login, pass)) {
			System.out.println("Connected as " + login);
			ret = um.getUser(login, pass);
		}
		return ret;
	}

	private static void useConnexion(User currentUser) {
		if (currentUser.getConnexionList().isEmpty()) {
			System.out.println("Your connexion list is empty");
		} else {
			System.out.println("Connexion name ?");
			String connexionName = sc.next();
			System.out.println("login ?");
			String login = sc.next();
			System.out.println("password ?");
			String password = sc.next();
			Connect connect = null;
			for (UserConnexion uc : currentUser.getConnexionList()) {
				if (uc.getConnexionName().equals(connexionName)) {
					if (uc.getLogin().equals(login)) {
						if (uc.getPassword().equals(password)) {
							connect = new Connect(uc.getAdresse(), login, password);
						}
					}
				}
			}
			if (connect == null) {
				System.out.println("Connexion failed");
			}
		}
	}

	private static void addConnexion(User currentUser) {
		System.out.println("Choose a name for your connexion ?");
		String connexionName = sc.next();
		System.out.println("adress ?");
		String adress = sc.next();
		System.out.println("login ?");
		String login = sc.next();
		System.out.println("password ?");
		String password = sc.next();
		currentUser.addNewConnexion(new UserConnexion(adress, connexionName, login, password));
	}
}
