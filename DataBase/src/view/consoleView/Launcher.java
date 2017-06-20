package view.consoleView;

import static model.utils.Scan.sc;

import control.consoleControler.LauncherControler;
import logs.Log;

/**
 * This class contains the main to launch the application
 *
 */
public class Launcher {
	// the LauncherControler
	private static LauncherControler mc;
	// the current user
	private static String currentUser;

	public static void main(String[] args) {
		Log.open();
		Log.clean();
		mc = new LauncherControler();
		boolean connected = Launcher.connect();
		if (connected) {
			Log.out("successful connection");
			currentUser = mc.getCurrentUserName();
			System.out.println("Connected as " + currentUser);
			if (currentUser.equalsIgnoreCase("admin")) {
				Launcher.adminAction();

			} else {
				Launcher.userAction();
			}
		}
		mc.save();
		Log.close();
	}

	/**
	 * This method ask a user to connect with his login and password
	 * 
	 * @return true only if the couple of login and password exists in the
	 *         UserManager's list
	 */
	private static boolean connect() {
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Password ?");
		String password = sc.next();
		String s = "";
		Log.out("connection attempt : " + login);
		boolean ret = mc.connect(login, password);
		while (!ret && !s.equals("quit")) {
			Log.err("connection failed");
			System.out.println("This user does not exist");
			System.out.println("Type quit to quit, connect to try again");
			s = sc.next();

			while (!s.equals("quit") && !s.equals("connect")) {
				System.out.println("Type quit to quit, connect to try again");
				s = sc.next();
			}

			if (s.equals("connect")) {
				System.out.println("Login ?");
				login = sc.next();
				System.out.println("Password ?");
				password = sc.next();
				ret = mc.connect(login, password);
				Log.out("connection attempt : " + login);
			}

		}

		return ret;
	}

	/**
	 * This method ask the user what he want to do
	 */
	private static void userAction() {
		String s = "";

		while (!s.equalsIgnoreCase("logout")) {
			System.out.println("Select an action :");
			System.out.println("Connect to a database\nNew database connection\nParameter\nLog out");
			s = sc.next();

			while (!s.equalsIgnoreCase("connect") && !s.equalsIgnoreCase("new") && !s.equalsIgnoreCase("parameter")
					&& !s.equalsIgnoreCase("logout")) {
				System.out.println("Select an action :");
				System.out.println("Connect to a database\nAdd a new database connection\nLog out");
				s = sc.next();
			}
			if (s.equalsIgnoreCase("connect")) {
				Launcher.useConnect();
			}

			if (s.equalsIgnoreCase("new")) {
				Launcher.newConnect();
			}

			if (s.equalsIgnoreCase("parameter")) {
				Launcher.parameter();
			}

		}

		if (s.equalsIgnoreCase("logout")) {
			Log.out("logged out");
			System.out.println("logging out");
		}
	}

	/**
	 * This method ask the administrator what he want to do
	 */
	private static void adminAction() {
		String s = "";

		while (!s.equalsIgnoreCase("logout")) {

			System.out.println("Select an action :");
			System.out.println(
					"Add user\nRemove user\nConnect to a database\nNew database connection\nParameter\nLog out");
			s = sc.next();

			while (!s.equalsIgnoreCase("add") && !s.equalsIgnoreCase("remove") && !s.equalsIgnoreCase("connect")
					&& !s.equalsIgnoreCase("new") && !s.equalsIgnoreCase("parameter")
					&& !s.equalsIgnoreCase("logout")) {
				System.out.println("Select an action :");
				System.out.println(
						"Add user\nRemove user\nConnect to a database\nAdd a new database connection\nLog out");
				s = sc.next();
			}

			if (s.equalsIgnoreCase("add")) {
				Launcher.add();
			}

			if (s.equalsIgnoreCase("remove")) {
				Launcher.remove();
			}

			if (s.equalsIgnoreCase("connect")) {
				Launcher.useConnect();
			}

			if (s.equalsIgnoreCase("new")) {
				Launcher.newConnect();
			}

			if (s.equalsIgnoreCase("parameter")) {
				Launcher.parameter();
			}
		}

		if (s.equalsIgnoreCase("logout")) {
			System.out.println("logging out");
		}
	}

	/**
	 * This method allow the adminstrator to add a new user
	 */
	private static void add() {
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Confirm");
		String loginBis = sc.next();

		if (login.equals(loginBis)) {
			System.out.println("Password ?");
			String password = sc.next();
			System.out.println("Confirm");
			String passwordBis = sc.next();

			if (password.equals(passwordBis)) {

				if (mc.addUser(login, password)) {
					System.out.println("User added");
					Log.out("user added : " + login);

				} else {
					System.out.println("A user with the login " + login + " already exists");
				}

			} else {
				System.out.println("The 2 passwords mut be equal");
			}

		} else {
			System.out.println("The 2 logins must be equal");
		}
	}

	/**
	 * This method allows the administrator to remove a user
	 */
	private static void remove() {
		String s = "";
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Password ?");
		String password = sc.next();
		System.out.println(mc.checkUser(login, password));

		if (mc.checkUser(login, password)) {
			System.out.println("Type undo to undo, confirm to confirm");
			s = sc.next();

			while (!s.equalsIgnoreCase("undo") && !s.equalsIgnoreCase("confirm")) {
				System.out.println("Type undo to undo, confirm to confirm");
				s = sc.next();
			}

			if (s.equalsIgnoreCase("confirm")) {
				mc.removeUser(login, password);
				System.out.println("User removed");
				Log.out("user removed : " + login);

			} else if (s.equalsIgnoreCase("undo")) {
				System.out.println("Undone");
			}
		}

	}

	/**
	 * This method show the option in the application parameters
	 */
	private static void parameter() {
		String s = "";
		System.out.println("Change login");
		s = sc.next();

		while (!s.equalsIgnoreCase("change")) {
			System.out.println("Change login");
			s = sc.next();
		}

		if (s.equalsIgnoreCase("change")) {
			Launcher.changeLogin();
		}
	}

	/**
	 * This method allow a user to change his password
	 */
	private static void changeLogin() {
		Log.out("Attempt to change login");
		System.out.println("Choose a new login");
		String login = "";
		login = sc.next();
		System.out.println("Enter your password");
		String password = "";
		password = sc.next();
		mc.changeLogin(currentUser, password, login);
	}

	/**
	 * This method allow a user to use one of his database connection
	 */
	private static void useConnect() {
		System.out.println("Connection name ?");
		String connectionName = sc.next();
		Log.out("Database connection attempt : " + connectionName);
		mc.connectDatabase(connectionName);
	}

	/**
	 * This method allow a user to add a new database connection
	 */
	private static void newConnect() {
		System.out.println("Choose a connection name ?");
		String connectionName = sc.next();
		System.out.println("Database address ?");
		String databaseAddress = sc.next();
		System.out.println("Database login ?");
		String databaseLogin = sc.next();
		System.out.println("Database password ?");
		String databasePassword = sc.next();
		mc.addDatabase(connectionName, databaseAddress, databaseLogin, databasePassword);
		System.out.println("Connection added to your list");
		Log.out("New connexion added to " + Launcher.currentUser + "'s list");

	}
}
