package vue;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTableName;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel sizePanel = new JPanel();
		sizePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		sizePanel.setForeground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		add(sizePanel, BorderLayout.WEST);
		
		JLabel sizeLabel = new JLabel("________");
		sizeLabel.setForeground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		sizePanel.add(sizeLabel);
		
		JPanel secondSizePanel = new JPanel();
		secondSizePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		secondSizePanel.setForeground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		add(secondSizePanel, BorderLayout.EAST);
		
		JLabel secondSizeLabel = new JLabel("________");
		secondSizeLabel.setForeground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		secondSizePanel.add(secondSizeLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		panel_3.add(panel_4);
		
		txtTableName = new JTextField();
		txtTableName.setForeground(Color.WHITE);
		txtTableName.setText("Table name");
		panel_4.add(txtTableName);
		txtTableName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtTableName.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		txtTableName.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel columnLabel = new JLabel("Column");
		panel_5.add(columnLabel);
		columnLabel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		columnLabel.setForeground(Color.WHITE);
		columnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Value");
		panel_5.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

	}

}
