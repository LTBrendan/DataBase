package vue;

import java.awt.Color;

import javax.swing.JPanel;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static HomePanel homePanel;

	public HomePanel() {

		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

		homePanel = this;
	}

	public static HomePanel getHomePanel() {
		return homePanel;
	}

}
