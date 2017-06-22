package view.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import control.consoleControler.DatabaseControler;
import control.consoleControler.LauncherControler;

/**
 * @author Patate1er
 *
 */
public class AppFrame {

	private JFrame frame;
	private MenuPanel menuPanel;
	private MainPanel mainPanel;

	private DatabaseControler databaseControler;
	private static AppFrame appFrame;
	private static LauncherControler launcherControler;

	public static int color;

	/**
	 * Launch the application.
	 */
	public static void main(LauncherControler launcherControler) {

		AppFrame.launcherControler = launcherControler;

		if (!(launcherControler.getCurrentUser().getColor() > 247)
				|| !(launcherControler.getCurrentUser().getColor() < 54))
			color = launcherControler.getCurrentUser().getColor();
		else
			color = 54;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AppFrame().frame.setVisible(true);
				} catch (Exception e) {

				}
			}
		});
	}

	/**
	 * Construct a new AppFrame and set up it
	 */
	public AppFrame() {

		frame = new JFrame("DataBase app");
		frame.setUndecorated(true);
		frame.setSize(LoginFrame.width, LoginFrame.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		appFrame = this;

		menuPanel = new MenuPanel();
		mainPanel = new MainPanel();

		frame.getContentPane().add(menuPanel, BorderLayout.WEST);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		frame.pack();
		frame.repaint();
	}

	/**
	 * Getter for the AppFrame frame
	 * @return the AppFrame
	 */
	public static JFrame getFrame() {
		return appFrame.frame;
	}

	/**
	 * Getter for the menuPanel
	 * @return the menuPanel
	 */
	public MenuPanel getMenuPanel() {
		return appFrame.menuPanel;
	}

	/**
	 * Set the menuPanel to the one in parameter
	 * @param menuPanel the menuPanel to set in
	 */
	public static void setMenuPanel(MenuPanel menuPanel) {
		appFrame.menuPanel = menuPanel;
	}

	/**
	 * Getter for the mainPanel
	 * @return the mainPanel
	 */
	public MainPanel getMainPanel() {
		return appFrame.mainPanel;
	}

	/**
	 * Set the mainPanel to the one in parameter
	 * @param menuPanel the mainPanel to set in
	 */
	public static void setMainPanel(MainPanel mainPanel) {
		appFrame.mainPanel = mainPanel;
	}

	/**
	 * Getter for the databaseControler
	 * @return the databaseControler
	 */
	public static DatabaseControler getDataBaseController() {
		return appFrame.databaseControler;
	}

	/**
	 * Getter for the launcherControler
	 * @return the laucherControler
	 */
	public LauncherControler getLauncherControler() {
		return AppFrame.launcherControler;
	}

	/**
	 * Getter for this AppFrame
	 * @return this AppFrame
	 */
	public static AppFrame getAppFrame() {
		return appFrame;
	}

	/**
	 * Setter for the databasControler
	 * @param dc the databaseControler to set in
	 */
	public static void setDatabaseControler(DatabaseControler dc) {
		appFrame.databaseControler = dc;
	}
}
