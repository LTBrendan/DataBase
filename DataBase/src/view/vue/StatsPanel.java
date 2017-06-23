package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		this.setLayout(new BorderLayout ());
		
		JLabel stat = new JLabel("Statistics");
		Font f = new Font("Calibri", Font.PLAIN, 50);
		if (AppFrame.color == 54)
			stat.setForeground(new Color(255,255,255));
		else
			stat.setForeground(new Color(0,0,0));
		stat.setFont(f);
		stat.setHorizontalAlignment(SwingConstants.CENTER);
		
		String connectionHour = new SimpleDateFormat ("hh:mm").format (new Date ());
		JLabel connectionHourLabel = new JLabel (connectionHour);
		connectionHourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		if (AppFrame.color == 54)
			connectionHourLabel.setForeground(new Color(255,255,255));
		else
			connectionHourLabel.setForeground(new Color(0,0,0));
		
		this.add(stat, BorderLayout.NORTH);
		this.add(connectionHourLabel, BorderLayout.CENTER);
		statsPanel = this;
		
	}
	
	public static StatsPanel getStatsPanel() {
		return statsPanel;
	}

}
