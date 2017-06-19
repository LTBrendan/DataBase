package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import connexion.User;
import connexion.UserManager;

public class AdminPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel titlePanel;
	private JPanel centerPanel;
	private JPanel userListPanel;
	private JScrollPane scrollPane;

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
			JLabel userLabel = new JLabel(" - " + uc.getLogin());
			if (Launcher.color == 54)
				userLabel.setForeground(new Color(255, 255, 255));
			else
				userLabel.setForeground(new Color(0, 0, 0));

			userListPanel.add(userLabel);
		}

		scrollPane = new JScrollPane(userListPanel);
		scrollPane.setBorder(null);

		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		titlePanel.setForeground(new Color(255,255,255));

		JLabel lblAdminSettings = new JLabel("Admin Settings");

		titlePanel.add(lblAdminSettings);

		centerPanel.add(scrollPane);

		add(titlePanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);

	}
}
