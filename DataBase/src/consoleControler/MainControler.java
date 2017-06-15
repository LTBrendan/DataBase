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
	


	/*public static void main(String[] args) {
		String  s = "";
		while (currentUser == null && !s.equals("quit")) {
			System.out.println("This user does not exist");
			Log.out("connexion failed");
			
			
			
		}
		
		if (currentUser != null) {
			User admin = um.getUser("admin", "admin");
			s = "";

			if (currentUser.equals(admin)) {
				System.out.println("add\nremove\nuse existing connexion\ncreate a new connexion\nlogout");
				s = sc.next();

				while (!s.equals("logout")) {

					while (!s.equals("add") && !s.equals("remove") && !s.equals("use") && !s.equals("new")
							&& !s.equals("logout")) {
						System.out.println("add\nremove\nuse existing connexion\ncreate a new connexion\nlogout");
						s = sc.next();
					}

					if (s.equals("add")) {
						MainControler.add();
						s = "";
					}

					if (s.equals("remove")) {
						MainControler.remove();
						s = "";
					}

					if (s.equals("use")) {
						MainControler.useConnexion(currentUser);
						s = "";
					}

					if (s.equals("new")) {
						MainControler.addConnexion(currentUser);
						s = "";
					}

					if (s.equals("logout")) {
						System.out.println("See you soon !! :)");
					}

				}

			} else {
				System.out.println("use existing connexion\ncreate a new connexion\nlogout");
				s = sc.next();

				while (!s.equals("logout")) {

					while (!s.equals("use") && !s.equals("new") && !s.equals("logout")) {
						System.out.println("use existing connexion\ncreate a new connexion\nlogout");
						s = sc.next();
					}

					if (s.equals("use")) {
						MainControler.useConnexion(currentUser);
						s = "";
					}

					if (s.equals("new")) {
						MainControler.addConnexion(currentUser);
						s = "";
					}

					if (s.equals("logout")) {
						System.out.println("See you soon !! :)");
					}
				}
			}

		}
		//save all users
		UserManager.save();
		utils.Scan.close();
		Log.out("disconnected");
		//log closed
		Log.close();

	}

	
	private static void add() {
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Confirm");
		String loginBis = sc.next();
		if (login.equals(loginBis)) {
			System.out.println("Password ?");
			String pass = sc.next();
			System.out.println("Confirm");
			String passBis = sc.next();
			if (pass.equals(passBis)) {
				UserManager.createUser(login, pass);
				Log.out("user created (login : " + login + ")");
			} else {
				System.out.println("The 2 passwords must be equals");
			}
		} else {
			System.out.println("The 2 logins must be equals");
		}
	}

	
	private static void remove() {
		System.out.println("Login ?");
		String login = sc.next();
		System.out.println("Password ?");
		String pass = sc.next();
		User removed = UserManager.removeUser(login, pass);
		if (removed != null) {
			Log.out("user removed (login : " + login + ")");
		}
		if (removed != null) {
			
			

			

			if (s.equals("undo")) {
				UserManager.createUser(removed.getLogin(), removed.getPass());
				Log.out("action undone");
			}

			if (s.equals("confirm")) {
				System.out.println("User removed");
				Log.out("action confirmed");
			}

		} else {
			System.out.println("This user does not exist");
		}
	}

	*/
	public boolean connect  (String login, String password) {
		boolean ret = UserManager.checkUser(login, password);
		if (ret) {
			this.currentUser = um.getUser(login, password);
		}
		return ret;
	}

	/*
	private static void useConnexion(User currentUser) {
		if (currentUser.getConnexionList().isEmpty()) {
			System.out.println("Your connexion list is empty");
			System.out.println("Create a new one\nlogout");
			String s = sc.next();

			while (!s.equals("new") && !s.equals("logout")) {
				System.out.println("create a new one\nlogout");
				s = sc.next();
			}

			if (s.equals("new")) {
				MainControler.addConnexion(currentUser);
			}

		} else {
			System.out.println("Connexion name ?");
			String connexionName = sc.next();
			Log.out("data base connexion attempt : " + connexionName);
			Connect connect = null;
			for (UserConnexion uc : currentUser.getConnexionList()) {
				if (uc.getConnexionName().equals(connexionName)) {
					System.out.println(uc.getAdresse());
					connect = new Connect(uc.getAdresse(), uc.getLogin(), uc.getPassword(), currentUser);
				}
			}
			if (connect == null) {
				System.out.println("Connexion failed");
				Log.out("data base connexion failed");
			}
		}
	}

	
	private static void addConnexion(User currentUser) {
		System.out.println("Choose a name for your connexion ?");
		String connexionName = sc.next();
		System.out.println("adress ?");
		String adress = sc.next();
		System.out.println("login ?");
		String login = sc.next();
		System.out.println("password ?");
		String password = sc.next();
		currentUser.addNewConnexion(new UserConnexion(adress, connexionName, login, password));
		Log.out("new data base added to " + currentUser.getLogin() + "'s list : (name : " + connexionName
				+ ", adress : " + adress + ")");
	}*/
}
