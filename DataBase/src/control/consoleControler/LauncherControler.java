package control.consoleControler;

import logs.Log;
import model.connexion.User;
import model.connexion.UserConnexion;
import model.connexion.UserManager;
import view.consoleView.Connect;

/**
 * This class allow to manipulate the users through different methods
 */
/**
 * @author Patate1er
 *
 */
public class LauncherControler extends MainControler {

	private static LauncherControler launcherControler;

	/**
	 * The LauncherControler constructor
	 */
	public LauncherControler() {

		super();

		launcherControler = this;
	}

	/**
	 * This method allow a user to connect to one of his database through the
	 * name he gave to it
	 * 
	 * @param connectionName
	 *            the name given by the user to his connection
	 */
	public void connectDatabase(String connectionName) {
		Connect connect = null;
		for (UserConnexion uc : currentUser.getConnexionList()) {
			if (uc.getConnexionName().equals(connectionName)) {
				System.out.println(uc.getAdresse());
				Log.out("successful connection : " + connectionName);
				connect = new Connect(uc.getAdresse(), uc.getLogin(), uc.getPassword());
				connect.start();
			}
		}
		if (connect == null) {
			System.out.println("Connexion failed");
			Log.err("connection failed : " + connectionName);
		}

	}

	/**
	 * This method allow a user to add a new database to his list
	 * 
	 * @param connectionName
	 *            the name the user want to give to his connection
	 * @param address
	 *            the database address
	 * @param login
	 *            the user's login for the database
	 * @param password
	 *            the user's password for the database
	 */
	public void addDatabase(String connectionName, String address, String login, String password) {
		currentUser.addNewConnexion(new UserConnexion(address, connectionName, login, password));
		save();
	}

	/**
	 * This method add a new user to the UserManager's list only if the login is
	 * available
	 * 
	 * @param login
	 *            the user's login
	 * @param password
	 *            the user's password
	 * @return true only if the user was added
	 */
	public boolean addUser(String login, String password) {
		boolean ret = false;
		if (!this.checkLogin(login)) {
			UserManager.createUser(login, password);
			ret = true;
		}
		this.save();
		return ret;
	}

	/**
	 * This method remove a user
	 * 
	 * @param login
	 *            the user's login
	 * @param password
	 *            the user's password
	 */
	public void removeUser(String login, String password) {
		UserManager.removeUser(login, password);
	}

	/**
	 * This method allow a user to change his password only if the new one is
	 * available
	 * 
	 * @param currentLogin
	 *            the current user's login
	 * @param password
	 *            the current user's password
	 * @param newLogin
	 *            the new user's login
	 */
	public void changeLogin(String currentLogin, String password, String newLogin) {
		if (this.checkUser(currentLogin, password)) {

			if (!this.checkLogin(newLogin)) {
				um.getUser(currentLogin, password).setLogin(newLogin);
				Log.out("login changed : " + newLogin);

			} else {
				System.out.println("Login already used");
				Log.err("login already used");
			}

		} else {
			System.out.println("Wrong password");
			Log.err("wrong password");
		}
		this.save();
	}

	/**
	 * This method set the currentUser if the login and the password are correct
	 * 
	 * @param login
	 *            the user's login
	 * @param password
	 *            the user's password
	 * @return true only if the couple of login/password is correct
	 */
	public boolean connect(String login, String password) {
		boolean ret = UserManager.checkUser(login, password);
		if (ret) {
			this.currentUser = um.getUser(login, password);
		}
		return ret;
	}

	/**
	 * This method return this LauncherControler
	 * 
	 * @return this LauncherControler
	 */
	public static LauncherControler getLauncherControler() {
		return launcherControler;
	}

	/**
	 * This method return the currentUser
	 * 
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return launcherControler.currentUser;
	}
}
