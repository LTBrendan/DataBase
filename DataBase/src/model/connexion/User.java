package model.connexion;

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
	// user's xp
	private int xp;
	//user's level, based on user's xp
	private int level;
	//number of SQL Game the user played
	private int nbGame;
	//number of good answer the user gave
	private int nbGoodAnswer;
	//number of wrong answer the user gave
	private int nbWrongAnswer;

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
	
	/**
	 * Getter for xp user
	 * @return user's xp
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * Setter for the xp user
	 * @param xp the xp
	 */
	public void setXp(int xp) {
		this.xp = xp;
		if (this.xp > 6) 
			this.level++;
	}

	/**
	 * Getter for level user
	 * @return user's level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Setter for the lever user
	 * @param level the level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getNbGame() {
		return nbGame;
	}

	public void setNbGame(int nbGame) {
		this.nbGame = nbGame;
	}

	public int getNbGoodAnswer() {
		return nbGoodAnswer;
	}

	public void setNbGoodAnswer(int nbGoodAnswer) {
		this.nbGoodAnswer = nbGoodAnswer;
	}

	public int getNbWrongAnswer() {
		return nbWrongAnswer;
	}

	public void setNbWrongAnswer(int nbWrongAnswer) {
		this.nbWrongAnswer = nbWrongAnswer;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
