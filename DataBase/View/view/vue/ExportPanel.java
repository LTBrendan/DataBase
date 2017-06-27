package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The panel where the user can export his database
 */
public class ExportPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JPanel titlePanel;
	private JPanel exportPanel;
	private JLabel titleLabel;
	private JLabel exportLabel;
	
	/**
	 * The constructor of export panel
	 */
	public ExportPanel () {
		
		setLayout(new BorderLayout());
		setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.titlePanel = new JPanel ();
		titlePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		
		this.titleLabel = new JLabel ("Export database");
		Font f = new Font("Calibri", Font.PLAIN, 50);
		titleLabel.setFont(f);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.exportLabel = new JLabel ("Export database");
		f = new Font("Calibri", Font.PLAIN, 30);
		exportLabel.setFont(f);
		exportLabel.setForeground(Color.WHITE);
		exportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exportLabel.setToolTipText("Click to export your databas");
		exportLabel.addMouseListener(new ExportPanelMouseListener ());
		
		this.exportPanel = new JPanel ();
		exportPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		
		exportPanel.add(exportLabel);
		titlePanel.add(titleLabel);
		
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(exportLabel, BorderLayout.CENTER);
	}
}
