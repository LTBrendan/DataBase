package consoleControler;

import connexion.UserConnexion;
import connexion.UserManager;
import consoleView.Connect;
import logs.Log;

public class LauncherControler extends MainControler {

	public LauncherControler() {

		super();

	}

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

	public void addDatabase(String connectionName, String address, String login, String password) {
		currentUser.addNewConnexion(new UserConnexion(address, connectionName, login, password));
	}

	public boolean addUser(String login, String password) {
		boolean ret = false;
		if (!this.checkLogin(login)) {
			UserManager.createUser(login, password);
			ret = true;
		}
		this.save();
		return ret;
	}

	public void removeUser(String login, String password) {
		UserManager.removeUser(login, password);
	}

	public void changeLogin(String currentLogin, String password, String newLogin) {
		if (this.checkUser(currentLogin, password)) {
			
			if (!this.checkLogin(newLogin)) {
				um.getUser(currentLogin, password).setLogin (newLogin);
				Log.out("login changed : "+newLogin);
				
			}else {
				System.out.println("Login already used");
				Log.err("login already used");
			}
			
		}else {
			System.out.println("Wrong password");
			Log.err("wrong password");
		}
		this.save();
	}
}