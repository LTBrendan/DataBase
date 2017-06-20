package consoleControler;


import connexion.User;
import connexion.UserManager;

/**
 * This method is the controller's super class 
 */
public class MainControler {
	//The controller's UserManager
	protected static UserManager um;
	//The current user
	protected User currentUser;
	
	/**
	 * The MainControler constructor
	 */
	public MainControler () {
		um = new UserManager();
		UserManager.load();
	}
	
	/**
	 * This method save all the users
	 */
	public void save (){
		UserManager.save();
	}
	
	/**
	 * This method save all the user's in the UserManager's list
	 */
	public void load() {
		UserManager.load();
	}
	
	/**
	 * This method return the current user's name
	 * @return the current user's name
	 */
	public String getCurrentUserName () {
		return this.currentUser.getLogin();
	}
	
	/**
	 * This method check if the user's with the informations in parameter is contained in the UserManager's list
	 * @param login the user's login
	 * @param password the user's password
	 * @return true only if a user with those informations is contained in the UserManager's list
	 */
	public boolean checkUser (String login, String password) {
		return UserManager.checkUser(login, password);
	}
	
	/**
	 * This method check if the login is already used by a user
	 * @param login the login to check
	 * @return true only if the login is used
	 */
	protected boolean checkLogin (String login) {
		return UserManager.checkLogin(login);
	}
}
