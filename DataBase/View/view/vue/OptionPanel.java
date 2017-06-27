package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.controller.CloseListener;
import control.controller.OptionPanelMouseListener;

/**
 * The panel where the user can choose to logout, quit the application or go to
 * the settings
 */
public class OptionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static OptionPanel optionPanel;

	private JLabel logoutLabel;
	private JLabel quitLabel;
	private JLabel settingLabel;

	/**
	 * Construct a new OptionPanel
	 */
	public OptionPanel() {

		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(northPanel, BorderLayout.NORTH);

		JPanel westPanel = new JPanel();
		westPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(westPanel, BorderLayout.WEST);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(southPanel, BorderLayout.SOUTH);

		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(eastPanel, BorderLayout.EAST);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0, 3, 0, 0));

		logoutLabel = new JLabel();
		logoutLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		centerPanel.add(logoutLabel);
		// logoutLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
		// Color.WHITE));
		logoutLabel.setToolTipText("Disconnect and change user");
		if (AppFrame.color == 54)
			logoutLabel.setIcon(new ImageIcon("rsc\\preSetting\\logoutWhite.PNG"));
		else
			logoutLabel.setIcon(new ImageIcon("rsc\\preSetting\\logoutBlack.PNG"));
		logoutLabel.setVerticalAlignment(SwingConstants.CENTER);
		logoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoutLabel.addMouseListener(new OptionPanelMouseListener());

		quitLabel = new JLabel();
		quitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		centerPanel.add(quitLabel);
		quitLabel.setToolTipText("Disconnect user and quit the app");
		// quitLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1,
		// Color.WHITE));
		if (AppFrame.color == 54)
			quitLabel.setIcon(new ImageIcon("rsc\\preSetting\\quitWhite.PNG"));
		else
			quitLabel.setIcon(new ImageIcon("rsc\\preSetting\\quitBlack.PNG"));
		quitLabel.setVerticalAlignment(SwingConstants.CENTER);
		quitLabel.addMouseListener(new CloseListener());
		quitLabel.setHorizontalAlignment(SwingConstants.CENTER);

		settingLabel = new JLabel();
		settingLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		centerPanel.add(settingLabel);
		settingLabel.setToolTipText("Go to user's and app's settings");
		// settingLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0,
		// Color.WHITE));
		if (AppFrame.color == 54)
			settingLabel.setIcon(new ImageIcon("rsc\\preSetting\\settingWhite.PNG"));
		else
			settingLabel.setIcon(new ImageIcon("rsc\\preSetting\\settingBlack.PNG"));
		settingLabel.setVerticalAlignment(SwingConstants.CENTER);
		settingLabel.addMouseListener(new OptionPanelMouseListener());
		settingLabel.setHorizontalAlignment(SwingConstants.CENTER);

		optionPanel = this;
	}

	/**
	 * Getter for this OptionPanel
	 * 
	 * @return this OptionPanel
	 */
	public static OptionPanel getOptionPanel() {
		return optionPanel;
	}

	/**
	 * Getter for logoutLabel
	 * 
	 * @return the logoutLabel
	 */
	public JLabel getLogoutLabel() {
		return optionPanel.logoutLabel;
	}

	/**
	 * Getter for quitLabel
	 * 
	 * @return the quitLabel
	 */
	public JLabel getQuitLabel() {
		return optionPanel.quitLabel;
	}

	/**
	 * Getter for logoutLabel
	 * 
	 * @return the logoutLabel
	 */
	public JLabel getSettingLabel() {
		return optionPanel.settingLabel;
	}

}
