package connexion;

import java.util.Scanner;
import consoleMode.*;

public class Launcher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserManager um = new UserManager();
		UserManager.load();
		System.out.println("connect\nadd");
		String s = sc.next();
		while (!s.equals("connect") && !s.equals("add")) {
			System.out.println("connect\nadd");
			s = sc.next();
		}
		if (s.equals("add")) {
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

		if (s.equals("connect")) {
			System.out.println("Login ?");
			String login = sc.next();
			System.out.println("Password ?");
			String pass = sc.next();
			if (UserManager.checkUser(login, pass)) {
				System.out.println("Connected as " + login);
				User currentUser = um.getUser(login, pass);
				System.out.println("use an existing connexion\ncreate a new connexion");
				s = sc.next();
				while (!s.equals("new") && !s.equals("use")) {
					System.out.println("use an existing connexion\ncreate a new connexion");
					s = sc.next();
				}
				if (s.equals("use")) {
					if (currentUser.getConnexionList().isEmpty()) {
						System.out.println ("Your connexion list is empty");
					} else {
						System.out.println("Connexion name ?");
						String connexionName = sc.next();
						System.out.println("login ?");
						login = sc.next();
						System.out.println("password ?");
						String password = sc.next();
						Connect connect = null;
						for (UserConnexion uc : currentUser.getConnexionList()) {
							if (uc.getConnexionName ().equals(connexionName)) {
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
				} else {
					System.out.println("Choose a name for your connexion ?");
					String connexionName = sc.next();
					System.out.println("adress ?");
					String adress = sc.next();
					System.out.println("login ?");
					login = sc.next();
					System.out.println("password ?");
					String password = sc.next();
					currentUser.addNewConnexion(new UserConnexion(adress, connexionName, login, password));
				}
			} else {
				System.out.println("This user does not exist");
			}
		}
		sc.close();
		um.save();
	}
}
