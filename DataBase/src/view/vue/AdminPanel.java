package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.controller.DeleteUserMouseListener;
import model.connexion.User;
import model.connexion.UserManager;

public class AdminPanel extends JPanel {
	
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

		setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		setBackground(new Color(54, 57, 62));
		setLayout(new BorderLayout(0, 0));

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 4, 0, 0));
		centerPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		userListPanel = new JPanel(new GridLayout(15, 1)) {

			private static final long serialVersionUID = 1L;

			@Override
			public Component add(Component comp) {
				if (this.getComponentCount() == 15)
					this.setLayout(new GridLayout(0, 1));
				return super.add(comp);
			}

		};

		userListPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		userListPanel.setForeground(new Color(255, 255, 255));

		for (User uc : UserManager.getUserList()) {

			JPanel userPanel = new JPanel(new BorderLayout());
			userPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

			JLabel tiretLabel = new JLabel(" - ");
			if (AppFrame.color == 54)
				tiretLabel.setForeground(new Color(255, 255, 255));
			else
				tiretLabel.setForeground(new Color(0, 0, 0));

			JLabel userLabel = new JLabel(uc.getLogin());
			if (AppFrame.color == 54)
				userLabel.setForeground(new Color(255, 255, 255));
			else
				userLabel.setForeground(new Color(0, 0, 0));

			JLabel deleteUser = new JLabel();
			deleteUser.setIcon(new ImageIcon("rsc\\login\\error.png"));
			deleteUser.setVisible(true);
			deleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			deleteUser.addMouseListener(new DeleteUserMouseListener(uc.getLogin(), uc.getPass()));

			userPanel.add(tiretLabel, BorderLayout.WEST);
			userPanel.add(deleteUser, BorderLayout.EAST);
			userPanel.add(userLabel, BorderLayout.CENTER);

			userListPanel.add(userPanel);
		}

		scrollPane = new JScrollPane(userListPanel);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		titlePanel.setForeground(new Color(255, 255, 255));

		JLabel lblAdminSettings = new JLabel("Admin Settings");
		lblAdminSettings.setForeground(new Color(255, 255, 255));

		titlePanel.add(lblAdminSettings);

		centerPanel.add(scrollPane);

		add(titlePanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);

		setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

	}

	/**
	 * Getter for the userListPanel
	 * @return the userListPanel
	 */
	public JPanel getUserListPanel() {
		return adminPanel.userListPanel;
	}

	/**
	 * Getter for this adminPanel
	 * @return this adminPanel
	 */
	public static JPanel getAdminPanel() {
		return adminPanel;
	}
	
	
}
