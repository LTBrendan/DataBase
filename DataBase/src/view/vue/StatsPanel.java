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
		
		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		
		statsPanel = this;
	}
	
	public static StatsPanel getStatsPanel() {
		return statsPanel;
	}

}
