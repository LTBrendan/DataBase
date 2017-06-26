package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExportPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JPanel titlePanel;
	private JLabel titleLabel;
	
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
		
		titlePanel.add(titleLabel);
		this.add(titlePanel, BorderLayout.NORTH);
	}
}
