package connexion;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String pass;

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

}
