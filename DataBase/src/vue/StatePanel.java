package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.MenuButtonListener;

public class StatePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel avatarLabel;
	private JLabel userNameLabel;
	private JSeparator separator;
	
	private static StatePanel statePanel;

	public StatePanel() {
		
		this.setPreferredSize(new Dimension(80, 456));
		this.setBackground(new Color(30, 33, 36));
		this.setLayout(null);

		this.add(createAvatarLanel());

		this.add(createUserNameLabel());

		this.add(createSeparator());
		
		statePanel = this;
	}

	private JLabel createAvatarLanel() {

		this.avatarLabel = new JLabel("");
		this.avatarLabel.setBounds(0, 0, 80, 75);
		this.avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.avatarLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.avatarLabel.setIcon(new ImageIcon("rsc\\user-16.png"));
		this.avatarLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.avatarLabel.addMouseListener(new MenuButtonListener());
		
		return this.avatarLabel;
	}

	private JLabel createUserNameLabel() {

		this.userNameLabel = new JLabel("Admin");
		this.userNameLabel.setBounds(0, 75, 80, 36);
		this.userNameLabel.setForeground(Color.WHITE);
		this.userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		this.userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

		return this.userNameLabel;
	}

	public JSeparator createSeparator() {
		
		this.separator = new JSeparator();
		this.separator.setBounds(10, 109, 60, 2);

		return this.separator;
	}
	
	public static StatePanel getStatePanel() {
		return statePanel;
	}
	
	public JComponent getAvatarLabel() {
		return statePanel.avatarLabel;
	}
	
	public JComponent getUserNameLabel() {
		return statePanel.userNameLabel;
	}
}