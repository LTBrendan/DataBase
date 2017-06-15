package vue;

import java.awt.Color;

import javax.swing.JPanel;

public class SettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SettingPanel settingPanel;
	
	public SettingPanel() {
		
		this.setBackground(new Color(54,57,62));
		
		settingPanel = this;
	}
	
	public static SettingPanel getSettingPanel() {
		return settingPanel;
	}
	
}
