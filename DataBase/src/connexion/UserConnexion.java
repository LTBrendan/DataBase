package connexion;

import java.io.Serializable;

public class UserConnexion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String adresse;
	private String connexionName;
	private String login;
	private String password;
	
	public UserConnexion (String adress, String connexionName, String login, String password) {
		this.setAdresse(adress);
		this.setLogin(login);
		this.setPassword(password);
		this.setConnexionName(connexionName);
	}
	
	public String getConnexionName() {
		return connexionName;
	}

	public void setConnexionName(String connexionName) {
		this.connexionName = connexionName;
	}

	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
