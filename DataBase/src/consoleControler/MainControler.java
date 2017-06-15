package consoleControler;


import connexion.User;
import connexion.UserManager;

/**
 * This class contains the main to launch the application
 *
 */
public class MainControler {
	
	protected static UserManager um;
	protected User currentUser;
	public MainControler () {
		
		um = new UserManager();
		//load all users
		UserManager.load();
		
	}
	
	public void save (){
		UserManager.save();
	}
	
	public String getCurrentUserName () {
		return this.currentUser.getLogin();
	}
	
	public boolean checkUser (String login, String password) {
		return UserManager.checkUser(login, password);
	}
	
	protected boolean checkLogin (String login) {
		return UserManager.checkLogin(login);
	}
	
	public boolean connect  (String login, String password) {
		boolean ret = UserManager.checkUser(login, password);
		if (ret) {
			this.currentUser = um.getUser(login, password);
		}
		return ret;
	}
}