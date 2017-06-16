package vue;

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

		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

		JLabel bonjour = new JLabel("BONJOUR");
		Font f = new Font("Serif", Font.PLAIN, 200);
		bonjour.setForeground(Color.WHITE);
		bonjour.setFont(f);

		this.add(bonjour);
		
		homePanel = this;
	}

	public static HomePanel getHomePanel() {
		return homePanel;
	}

}
