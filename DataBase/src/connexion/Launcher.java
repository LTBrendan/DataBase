package connexion;

import consoleMode.*;
import logs.Log;

import static utils.Scan.sc;

/**
 * This class contains the main to launch the application
 *
 */
public class Launcher {
	private static UserManager um = new UserManager();

	/**
	 * The applications enter point
	 * @param args 
	 */
	public static void main(String[] args) {
		//log opened
		Log.open();
		//log cleaned
		Log.clean();
		//load all users
		UserManager.load();
		System.out.println(um.toString());
		User currentUser = Launcher.connect();
		String  s = "";
		while (currentUser == null && !s.equals("quit")) {
			System.out.println("This user does not exist");
			Log.out("connexion failed");
			System.out.println ("Type quit to quit, connect to try again");
			s = sc.next ();
			
			while (!s.equals("quit") && !s.equals("connect")) {
				System.out.println ("Type quit to quit, connect to try again");
				s = sc.next ();
				
			}
			
			while (s.equals("connect")) {
				currentUser = Launcher.connect();
				s ="";
			}
			
		}
		
		if (currentUser != null) {
			User admin = um.getUser("admin", "admin");
			s = "";

			if (currentUser.equals(admin)) {
				System.out.println("add\nremove\nuse existing connexion\ncreate a new connexion\nlogout");
				s = sc.next();

				while (!s.equals("logout")) {

					while (!s.equals("add") && !s.equals("remove") && !s.equals("use") && !s.equals("new")
							&& !s.equals("logout")) {
						System.out.println("add\nremove\nuse existing connexion\ncreate a new connexion\nlogout");
						s = sc.next();
					}

					if (s.equals("add")) {
						Launcher.add();
						s = "";
					}

					if (s.equals("remove")) {
						Launcher.remove();
						s = "";
					}

					if (s.equals("use")) {
						Launcher.useConnexion(currentUser);
						s = "";
					}

					if (s.equals("new")) {
						Launcher.addConnexion(currentUser);
						s = "";
					}

					if (s.equals("logout")) {
						System.out.println("See you soon !! :)");
					}

				}

			} else {
				System.out.println("use existing connexion\ncreate a new connexion\nlogout");
				s = sc.next();

				while (!s.equals("logout")) {

					while (!s.equals("use") && !s.equals("new") && !s.equals("logout")) {
						System.out.println("use existing connexion\ncreate a new connexion\nlogout");
						s = sc.next();
					}

					if (s.equals("use")) {
						Launcher.useConnexion(currentUser);
						s = "";
					}

					if (s.equals("new")) {
						Launcher.addConnexion(currentUser);
						s = "";
					}

					if (s.equals("logout")) {
						System.out.println("See you soon !! :)");
					}
				}
			}

		}
		//save all users
		UserManager.save();
		utils.Scan.close();
		Log.out("disconnected");
		//log closed
		Log.close();

	}

	/**
	 * This method allows the application administrator to add a new user
	 */
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
				Log.out("user created (login : " + login + ")");
			} else {
				System.out.println("The 2 passwords must be equals");
			}
		} else {
			System.out.println("The 2 logins must be equals");
		}
	}

	/**
	 * This method allows the administrator to remove an existing user
	 */
	private static void remove() {
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Password ?");
		String pass = sc.next();
		User removed = UserManager.removeUser(login, pass);
		if (removed != null) {
			Log.out("user removed (login : " + login + ")");
		}
		if (removed != null) {
			System.out.println("Type undo to undo, confirm to confirm");
			String s = sc.next();

			while (!s.equals("undo") && !s.equals("confirm")) {
				System.out.println("Type undo to undo, confirm to confirm");
				s = sc.next();
			}

			if (s.equals("undo")) {
				UserManager.createUser(removed.getLogin(), removed.getPass());
				Log.out("action undone");
			}

			if (s.equals("confirm")) {
				System.out.println("User removed");
				Log.out("action confirmed");
			}

		} else {
			System.out.println("This user does not exist");
		}
	}

	/**
	 * This method allows a user to connect himself to the application if he possesses an account
	 * @return the currentUser if he connected successfully, null if not
	 */
	private static User connect() {
		User ret = null;
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Password ?");
		String pass = sc.next();
		Log.out("connexion attempt (login : " + login + ")");
		if (UserManager.checkUser(login, pass)) {
			System.out.println("Connected as " + login);
			Log.out("successful connexion");
			ret = um.getUser(login, pass);
		}
		return ret;
	}

	/**
	 * This method allows a user to connect himself to a database contained in his connexionList
	 * @param currentUser the user attempting to connect to one of his database
	 */
	private static void useConnexion(User currentUser) {
		if (currentUser.getConnexionList().isEmpty()) {
			System.out.println("Your connexion list is empty");
			System.out.println("Create a new one\nlogout");
			String s = sc.next();

			while (!s.equals("new") && !s.equals("logout")) {
				System.out.println("create a new one\nlogout");
				s = sc.next();
			}

			if (s.equals("new")) {
				Launcher.addConnexion(currentUser);
			}

		} else {
			System.out.println("Connexion name ?");
			String connexionName = sc.next();
			Log.out("data base connexion attempt : " + connexionName);
			Connect connect = null;
			for (UserConnexion uc : currentUser.getConnexionList()) {
				if (uc.getConnexionName().equals(connexionName)) {
					System.out.println(uc.getAdresse());
					connect = new Connect(uc.getAdresse(), uc.getLogin(), uc.getPassword(), currentUser);
				}
			}
			if (connect == null) {
				System.out.println("Connexion failed");
				Log.out("data base connexion failed");
			}
		}
	}

	/**
	 * This method allows a user to add a new connexion to his connexionList
	 * @param currentUser the user to add a new connexion
	 */
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
		Log.out("new data base added to " + currentUser.getLogin() + "'s list : (name : " + connexionName
				+ ", adress : " + adress + ")");
	}
}
