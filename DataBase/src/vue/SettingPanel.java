package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SettingPanel settingPanel;
	
	public SettingPanel() {
		
		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setLayout(new GridLayout(5, 5, 0, 0));
		
		JPanel themePanel = new JPanel();
		add(themePanel);
		themePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		
		JLabel themeLabel = new JLabel(" Th\u00E8me : ");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if (Launcher.color == 54)
			themeLabel.setForeground(new Color(255,255,255));
		else
			themeLabel.setForeground(new Color(0,0,0));
		themePanel.add(themeLabel);
		
		ButtonGroup themeButton = new ButtonGroup();
			
		JRadioButton darkThemeButton = new JRadioButton("Dark");
		darkThemeButton.setSelected(true);
		darkThemeButton.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			darkThemeButton.setForeground(new Color(255,255,255));
		else
			darkThemeButton.setForeground(new Color(0,0,0));
		themeButton.add(darkThemeButton);
		themePanel.add(darkThemeButton);
		
		JRadioButton whiteThemeButton = new JRadioButton("White");
		whiteThemeButton.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			whiteThemeButton.setForeground(new Color(255,255,255));
		else
			whiteThemeButton.setForeground(new Color(0,0,0));
		themeButton.add(whiteThemeButton);
		themePanel.add(whiteThemeButton);
		
		settingPanel = this;
	}
	
	public static SettingPanel getSettingPanel() {
		return settingPanel;
	}
	
}
