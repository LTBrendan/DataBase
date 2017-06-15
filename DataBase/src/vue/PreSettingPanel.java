package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.LabelCloseListener;
import controller.MenuButtonListener;

public class PreSettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PreSettingPanel preSettingPanel;
	
	private JLabel logoutLabel;
	private JLabel quitLabel;
	private JLabel settingLabel;
	
	public PreSettingPanel() {

		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		northPanel.setPreferredSize(new Dimension(10, 250));
		add(northPanel, BorderLayout.NORTH);

		JPanel westPanel = new JPanel();
		westPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		westPanel.setPreferredSize(new Dimension(200, 10));
		add(westPanel, BorderLayout.WEST);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		southPanel.setPreferredSize(new Dimension(10, 250));
		add(southPanel, BorderLayout.SOUTH);

		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		eastPanel.setPreferredSize(new Dimension(50, 10));
		add(eastPanel, BorderLayout.EAST);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0, 3, 0, 0));

		logoutLabel = new JLabel();
		logoutLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		centerPanel.add(logoutLabel);
		logoutLabel.setToolTipText("Disconnect and change user");
		if (Launcher.color == 54)
			logoutLabel.setIcon(new ImageIcon("rsc\\preSetting\\logoutWhite.PNG"));
		else
			logoutLabel.setIcon(new ImageIcon("rsc\\preSetting\\logoutBlack.PNG"));
		

		quitLabel = new JLabel();
		quitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		centerPanel.add(quitLabel);
		quitLabel.setToolTipText("Disconnect user and quit the app");
		if (Launcher.color == 54)
			quitLabel.setIcon(new ImageIcon("rsc\\preSetting\\quitWhite.PNG"));
		else
			quitLabel.setIcon(new ImageIcon("rsc\\preSetting\\quitBlack.PNG"));	
		
		quitLabel.addMouseListener(new LabelCloseListener());

		settingLabel = new JLabel();
		settingLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		centerPanel.add(settingLabel);
		settingLabel.setToolTipText("Go to user's and app's settings");
		if (Launcher.color == 54)
			settingLabel.setIcon(new ImageIcon("rsc\\preSetting\\settingWhite.PNG"));
		else
			settingLabel.setIcon(new ImageIcon("rsc\\preSetting\\settingBlack.PNG"));	
		settingLabel.addMouseListener(new MenuButtonListener());

		preSettingPanel = this;
	}

	public static PreSettingPanel getPreSettingPanel() {
		return preSettingPanel;
	}

	public JLabel getLogoutLabel() {
		return preSettingPanel.logoutLabel;
	}

	public JLabel getQuitLabel() {
		return preSettingPanel.quitLabel;
	}

	public JLabel getSettingLabel() {
		return preSettingPanel.settingLabel;
	}
	
	
}
