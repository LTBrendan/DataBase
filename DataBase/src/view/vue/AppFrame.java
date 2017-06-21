package view.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import control.consoleControler.DatabaseControler;
import control.consoleControler.LauncherControler;

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
					e.printStackTrace();
				}
			}
		});
	}

	public AppFrame() {

		frame = new JFrame("DataBase app");
		frame.setUndecorated(true);
		//frame.setPreferredSize(new Dimension(1080, 720));
		// frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setSize(LoginFrame.width, LoginFrame.height);
		// frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		appFrame = this;

		// MouseMovementAdapter.setMAIN_FRAME(frame);
		// try {
		// WindowResizer.WINDOW_RESIZER.register(frame);
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// }

		menuPanel = new MenuPanel();
		mainPanel = new MainPanel();

		frame.getContentPane().add(menuPanel, BorderLayout.WEST);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		frame.pack();
		frame.repaint();
	}

	public static JFrame getFrame() {
		return appFrame.frame;
	}

	public MenuPanel getMenuPanel() {
		return appFrame.menuPanel;
	}

	public static void setMenuPanel(MenuPanel menuPanel) {
		appFrame.menuPanel = menuPanel;
	}

	public MainPanel getMainPanel() {
		return appFrame.mainPanel;
	}

	public static void setMainPanel(MainPanel mainPanel) {
		appFrame.mainPanel = mainPanel;
	}

	public static DatabaseControler getDataBaseController() {
		return appFrame.databaseControler;
	}

	public LauncherControler getLauncherControler() {
		return AppFrame.launcherControler;
	}

	public static AppFrame getAppFrame() {
		return appFrame;
	}

	public static void setDatabaseControler(DatabaseControler dc) {
		appFrame.databaseControler = dc;
	}
}
