package view.vue;

import java.awt.Color;

import javax.swing.JPanel;

public class StatsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StatsPanel statsPanel;
	/**
	 * Create the panel.
	 */
	public StatsPanel() {
		
		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		
		statsPanel = this;
	}
	
	public static StatsPanel getStatsPanel() {
		return statsPanel;
	}

}
