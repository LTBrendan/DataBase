package view.vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static HomePanel homePanel;

	public HomePanel() {

		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		JLabel bonjour = new JLabel("Welcome " + AppFrame.getAppFrame().getLauncherControler().getCurrentUserName());
		Font f = new Font("Calibri", Font.PLAIN, 50);
		if (AppFrame.color == 54)
			bonjour.setForeground(new Color(255,255,255));
		else
			bonjour.setForeground(new Color(0,0,0));
		bonjour.setFont(f);

		this.add(bonjour);
		
		homePanel = this;
	}

	public static HomePanel getHomePanel() {
		return homePanel;
	}

}
