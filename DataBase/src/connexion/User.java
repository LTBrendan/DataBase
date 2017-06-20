package connexion;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * This class allows to manipulate users
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// user's login for the application
	private String login;
	// user's password for the application
	private String pass;
	// contains all user's connexion
	private ArrayList<UserConnexion> connexionList;
	private ImageIcon avatar;
	// user's color identifier
	private int color;

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Constructor for class User
	 * @param login user's login
	 * @param pass user's password
	 */
	public User(String login, String pass) {

		this.setPass(pass);
		this.setLogin(login);
		this.connexionList = new ArrayList<UserConnexion>();
		this.color = 54;
	}

	/**
	 * Setter for login attribute
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Setter for password attribute
	 * @param pass the new password
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Getter for login attribute
	 * 
	 * @return user's login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Getter for password attribute
	 * 
	 * @return user's password
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * Add a new connexion to the list
	 * @param connexion the connexion to add to the list
	 */
	public void addNewConnexion(UserConnexion connexion) {
		this.connexionList.add(connexion);
	}

	/**
	 * Getter for connexionList attribute
	 * @return user's connexionList
	 */
	public ArrayList<UserConnexion> getConnexionList() {
		return this.connexionList;
	}

	/**
	 * Getter for avatar attribute
	 * @return user's avatar
	 */
	public ImageIcon getAvatar() {
		return avatar;
	}

	/**
	 * Setter for avatar attribute
	 * @param avatar the new avatar
	 */
	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}

	public String toString() {
		return "Login : " + this.getLogin() + "\nPassword : " + this.getPass();
	}

	/**
	 * This method check if 2 users are equals
	 * @param anotherUs the us to check
	 * @return true only if the 2 users have the same password and the same login
	 */
	public boolean equals(User anotherUs) {
		boolean ret = false;
		if (anotherUs != null) {
			if (this.getLogin().equals(anotherUs.getLogin()) && this.getPass().equals(anotherUs.getPass())) {
				ret = true;
			}
		}
		return ret;
	}
	
}
