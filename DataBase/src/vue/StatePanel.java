package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

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
	private JPanel upPanel;
	private JLabel avatarLabel;
	private JLabel userNameLabel;
	private JSeparator separator;
	
	private JPanel downPanel;
	private JLabel home;
	private JLabel editor;
	private JLabel search;
	private JLabel visual;
	private JLabel stats;
	private JLabel game;
	private JLabel export;
	private JLabel admin;

	private static StatePanel statePanel;

	public StatePanel() {

		this.setPreferredSize(new Dimension(80, 456));
		this.setBackground(new Color(Launcher.color - 24, Launcher.color - 21, Launcher.color - 18));
		this.setLayout(new BorderLayout());

		this.add(createUpPanel(), BorderLayout.NORTH);
		this.add(createDownPanel(), BorderLayout.CENTER);

		statePanel = this;
	}

	private JPanel createDownPanel() {

		downPanel = new JPanel(new GridLayout(8, 0));
		downPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

		stats = new JLabel();
		stats.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stats.setToolTipText("Stats");
		stats.setHorizontalAlignment(downPanel.getWidth() / 2);
		if (Launcher.color == 54)
			stats.setIcon(new ImageIcon("rsc\\stateBar\\statsWhite.PNG"));
		else
			stats.setIcon(new ImageIcon("rsc\\stateBar\\statsBlack.PNG"));

		downPanel.add(stats);
		
		return downPanel;
	}

	private JPanel createUpPanel() {

		upPanel = new JPanel(new BorderLayout());
		upPanel.setBackground(new Color(Launcher.color - 24, Launcher.color - 21, Launcher.color - 18));
		upPanel.add(createAvatarLanel(), BorderLayout.NORTH);
		upPanel.add(createUserNameLabel(), BorderLayout.CENTER);
		upPanel.add(createSeparator(), BorderLayout.SOUTH);

		return upPanel;
	}

	private JLabel createAvatarLanel() {

		this.avatarLabel = new JLabel();
		// this.avatarLabel.setBounds(0, 0, 80, 75);
		this.avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.avatarLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.avatarLabel.setIcon(new ImageIcon("rsc\\user-16.png"));
		this.avatarLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.avatarLabel.addMouseListener(new MenuButtonListener());

		return this.avatarLabel;
	}

	private JLabel createUserNameLabel() {

		this.userNameLabel = new JLabel("Admin");
		// this.userNameLabel.setBounds(0, 75, 80, 36);
		if (Launcher.color == 54)
			this.userNameLabel.setForeground(Color.WHITE);
		else
			this.userNameLabel.setForeground(Color.BLACK);
		this.userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		this.userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

		return this.userNameLabel;
	}

	public JSeparator createSeparator() {

		this.separator = new JSeparator();
		// this.separator.setBounds(10, 109, 60, 2);

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
