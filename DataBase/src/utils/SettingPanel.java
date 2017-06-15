package utils;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;

public class SettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SettingPanel() {

		this.setBackground(new Color(54, 57, 62));
		setLayout(new GridLayout(5, 5, 0, 0));
		
		JPanel themePanel = new JPanel();
		add(themePanel);
		themePanel.setBackground(new Color(54,57,62));
		
		JLabel themeLabel = new JLabel(" Th\u00E8me : ");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setForeground(new Color(255,255,255));
		themePanel.add(themeLabel);
		
		JRadioButtonMenuItem themeButton = new JRadioButtonMenuItem();
		themePanel.add(themeButton);
			
		JRadioButton darkThemeButton = new JRadioButton("Dark");
		darkThemeButton.setSelected(true);
		darkThemeButton.setBackground(new Color(54,57,62));
		darkThemeButton.setForeground(new Color(255,255,255));
		themeButton.add(darkThemeButton);
		
		JRadioButton whiteThemeButton = new JRadioButton("White");
		whiteThemeButton.setBackground(new Color(54,57,62));
		whiteThemeButton.setForeground(new Color(255,255,255));
		themeButton.add(whiteThemeButton);
	}

}
