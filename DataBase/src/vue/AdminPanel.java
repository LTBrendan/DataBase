package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import connexion.User;
import connexion.UserManager;
import controller.DeleteButtonListener;

public class AdminPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel titlePanel;
	private JPanel centerPanel;
	private JPanel userListPanel;
	private JScrollPane scrollPane;

	private static AdminPanel adminPanel;

	/**
	 * Create the panel.
	 */
	public AdminPanel() {

		setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setBackground(new Color(54, 57, 62));
		setLayout(new BorderLayout(0, 0));

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 4, 0, 0));

		userListPanel = new JPanel(new GridLayout(15, 1)) {

			private static final long serialVersionUID = 1L;

			@Override
			public Component add(Component comp) {
				if (this.getComponentCount() == 15)
					this.setLayout(new GridLayout(0, 1));
				return super.add(comp);
			}

		};

		userListPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		userListPanel.setForeground(new Color(255, 255, 255));

		for (User uc : UserManager.getUserList()) {

			JPanel userPanel = new JPanel(new BorderLayout());
			userPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

			JLabel tiretLabel = new JLabel(" - ");
			if (Launcher.color == 54)
				tiretLabel.setForeground(new Color(255, 255, 255));
			else
				tiretLabel.setForeground(new Color(0, 0, 0));

			JLabel userLabel = new JLabel(uc.getLogin());
			if (Launcher.color == 54)
				userLabel.setForeground(new Color(255, 255, 255));
			else
				userLabel.setForeground(new Color(0, 0, 0));

			JLabel deleteUser = new JLabel();
			deleteUser.setIcon(new ImageIcon("rsc\\login\\error.png"));
			deleteUser.setVisible(true);
			deleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			deleteUser.addMouseListener(new DeleteButtonListener(uc.getLogin(), uc.getPass()));

			userPanel.add(tiretLabel, BorderLayout.WEST);
			userPanel.add(deleteUser, BorderLayout.EAST);
			userPanel.add(userLabel, BorderLayout.CENTER);

			userListPanel.add(userPanel);
		}

		scrollPane = new JScrollPane(userListPanel);
		scrollPane.setBorder(null);

		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		titlePanel.setForeground(new Color(255, 255, 255));

		JLabel lblAdminSettings = new JLabel("Admin Settings");

		titlePanel.add(lblAdminSettings);

		centerPanel.add(scrollPane);

		add(titlePanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);

	}

	public JPanel getUserListPanel() {
		return adminPanel.userListPanel;
	}

	public static JPanel getAdminPanel() {
		return adminPanel;
	}
}
