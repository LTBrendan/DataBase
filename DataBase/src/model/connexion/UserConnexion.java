package model.connexion;

import java.io.Serializable;

/**
 * This class allows to manipulate user's connexions
 *
 */
public class UserConnexion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//connexion address
	private String adresse;
	//connexion name chosen by user
	private String connexionName;
	//user's login to connect to the database
	private String login;
	//user's password to connect to the database
	private String password;
	
	/**
	 * Constructor for class UserConnexion
	 * @param adress connexion's address
	 * @param connexionName connexion's name
	 * @param login user's login
	 * @param password user's password
	 */
	public UserConnexion (String adress, String connexionName, String login, String password) {
		this.setAdresse(adress);
		this.setLogin(login);
		this.setPassword(password);
		this.setConnexionName(connexionName);
	}
	
	/**
	 * Getter for connexionName attribute
	 * @return connexion's name
	 */
	public String getConnexionName() {
		return connexionName;
	}

	/**
	 * Setter for connexionName attribute
	 * @param connexionName the connexionName
	 */
	public void setConnexionName(String connexionName) {
		this.connexionName = connexionName;
	}

	/**
	 * Getter for adresse attribute
	 * @return database's address
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * Setter for adresse attribute
	 * @param adresse the new address
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Getter for login attribute
	 * @return user's login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Setter for login attribute
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Getter for password attribute
	 * @return user's password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Setter for password attribute
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}

