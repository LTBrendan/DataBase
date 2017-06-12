package connexion;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String pass;
	private ArrayList<UserConnexion> connexionList;
	public User(String login, String pass) {

		this.setPass(pass);
		this.setLogin(login);

	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPass() {
		return this.pass;
	}
	
	public void addNewConnexion (UserConnexion connexion) {
		this.connexionList.add(connexion);
	}
}
