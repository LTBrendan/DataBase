package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The panel where the user can see some statistics about his database and the application
 */
public class StatsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static StatsPanel statsPanel;
	private JPanel centerPanel;

	/**
	 * Create the panel.
	 */
	public StatsPanel() {

		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.setLayout(new BorderLayout());

		JLabel stat = new JLabel("Statistics");
		Font f = new Font("Calibri", Font.PLAIN, 50);
		if (AppFrame.color == 54)
			stat.setForeground(new Color(255, 255, 255));
		else
			stat.setForeground(new Color(0, 0, 0));
		stat.setFont(f);
		stat.setHorizontalAlignment(SwingConstants.CENTER);

		this.centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 1));
		centerPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		centerPanel.setForeground(new Color(255, 255, 255));

		f = new Font("Calibri", Font.PLAIN, 30);
		
		String connectionHour = "Connection hour : " + new SimpleDateFormat("hh:mm").format(new Date());
		JLabel connectionHourLabel = new JLabel(connectionHour);
		connectionHourLabel.setHorizontalAlignment(SwingConstants.CENTER);

		if (AppFrame.color == 54)
			connectionHourLabel.setForeground(new Color(255, 255, 255));
		else
			connectionHourLabel.setForeground(new Color(0, 0, 0));
		connectionHourLabel.setFont(f);

		String databaseAddress = null;
		try {
			databaseAddress = "Database address : "+AppFrame.getDataBaseController().getAddress();
		} catch (NullPointerException e) {
			databaseAddress = "Database address : You must be connected to a database";
		}
		JLabel databaseAddressLabel = new JLabel (databaseAddress);
		databaseAddressLabel.setHorizontalAlignment(SwingConstants.CENTER);

		if (AppFrame.color == 54)
			databaseAddressLabel.setForeground(new Color(255, 255, 255));
		else
			databaseAddressLabel.setForeground(new Color(0, 0, 0));
		databaseAddressLabel.setFont(f);
		
		int number = -1;
		String tableNumber = null;
		try {
			ResultSet rs = AppFrame.getDataBaseController().executeQuery("SELECT COUNT(table_name) FROM all_tables");
			if (rs.next()) {
				number = rs.getInt(1);
			}
			tableNumber = "Number of table : "+number;
		} catch (SQLException e) {
			tableNumber = "Number of table : You must be connected to a database";
		} catch (NullPointerException e) {
			tableNumber = "Number of table : You must be connected to a database";
		}
		JLabel tableNumberLabel = new JLabel(tableNumber);
		tableNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);

		if (AppFrame.color == 54)
			tableNumberLabel.setForeground(new Color(255, 255, 255));
		else
			tableNumberLabel.setForeground(new Color(0, 0, 0));
		tableNumberLabel.setFont(f);

		int gameNumber = AppFrame.getAppFrame().getLauncherControler().getCurrentUser().getNbGame();
		int wrongAnswers = AppFrame.getAppFrame().getLauncherControler().getCurrentUser().getNbGame();
		int goodAnswers = AppFrame.getAppFrame().getLauncherControler().getCurrentUser().getNbGame();
		
		JLabel gameNumberLabel = new JLabel ("Number of game : "+gameNumber);
		gameNumberLabel.setForeground(new Color(255, 255, 255));
		gameNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameNumberLabel.setFont(f);
		
		JLabel wrongAnswersLabel = new JLabel ("Number of game : "+wrongAnswers);
		wrongAnswersLabel.setFont(f);
		wrongAnswersLabel.setForeground(new Color(255, 255, 255));
		wrongAnswersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel goodAnswersLabel = new JLabel ("Number of game : "+goodAnswers);
		goodAnswersLabel.setFont(f);
		goodAnswersLabel.setForeground(new Color(255, 255, 255));
		goodAnswersLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
		centerPanel.add(connectionHourLabel);
		centerPanel.add(databaseAddressLabel);
		centerPanel.add(tableNumberLabel);
		centerPanel.add(gameNumberLabel);
		centerPanel.add(goodAnswersLabel);
		centerPanel.add(wrongAnswersLabel);

		this.add(stat, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);

		statsPanel = this;

	}

	/**
	 * Getter for this statsPanel
	 * @return this statsPanel
	 */
	public static StatsPanel getStatsPanel() {
		return statsPanel;
	}

}
