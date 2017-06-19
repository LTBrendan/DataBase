package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tableNameField;
	private JTextField textField;
	private JTextField txtWhere;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {

		//this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setLayout(new BorderLayout(0, 0));
		
		JPanel tableNamePanel = new JPanel();
		tableNamePanel.setBackground(Color.DARK_GRAY);
		add(tableNamePanel, BorderLayout.NORTH);
		tableNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tableNameField = new JTextField();
		tableNameField.setText("Table name");
		tableNameField.setBackground(Color.BLACK);
		tableNameField.setFont(new Font("Calibri", Font.PLAIN, 11));
		tableNameField.setForeground(Color.WHITE);
		tableNamePanel.add(tableNameField);
		tableNameField.setColumns(10);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel attributesPanel = new JPanel();
		attributesPanel.setBackground(Color.DARK_GRAY);
		panel.add(attributesPanel, BorderLayout.CENTER);
		attributesPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WHERE");
		lblNewLabel.setBounds(51, 1, 61, 17);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		attributesPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 0, 112, 17);
		textField.setBackground(Color.GRAY);
		attributesPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("=");
		lblNewLabel_1.setBounds(225, 0, 46, 17);
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		attributesPanel.add(lblNewLabel_1);
		
		txtWhere = new JTextField();
		txtWhere.setBounds(268, 0, 112, 17);
		txtWhere.setBackground(Color.GRAY);
		attributesPanel.add(txtWhere);
		txtWhere.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 15));
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSearch);

	}

}
