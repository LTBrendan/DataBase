package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import control.controller.SearchPanelFocusListener;
import control.controller.SearchPanelMouseListener;

/**
 * The panel where the user can search rows
 */
public class SearchPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField tableNameField;
	private JPanel centerPanel;
	private JScrollPane centerScrollPane;
	private JButton addNewButton;
	private JButton researchButton;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel sizePanel = new JPanel();
		sizePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		sizePanel.setForeground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(sizePanel, BorderLayout.WEST);

		JLabel sizeLabel = new JLabel("________");
		sizeLabel.setForeground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		sizePanel.add(sizeLabel);

		JPanel secondSizePanel = new JPanel();
		secondSizePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		secondSizePanel.setForeground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(secondSizePanel, BorderLayout.EAST);

		JLabel secondSizeLabel = new JLabel("________");
		secondSizeLabel.setForeground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		secondSizePanel.add(secondSizeLabel);

		JPanel centerPanel2 = new JPanel();
		centerPanel2.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(centerPanel2, BorderLayout.CENTER);
		centerPanel2.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		centerPanel2.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel tableNamePanel = new JPanel();
		FlowLayout fl_tableNamePanel = (FlowLayout) tableNamePanel.getLayout();
		fl_tableNamePanel.setVgap(10);
		tableNamePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		topPanel.add(tableNamePanel);

		tableNameField = new JTextField("Table name");
		tableNameField.addFocusListener(new SearchPanelFocusListener());
		tableNameField.setForeground(Color.WHITE);
		tableNamePanel.add(tableNameField);
		tableNameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		tableNameField.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		tableNameField.setColumns(10);

		JPanel columnsPanel = new JPanel();
		columnsPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		topPanel.add(columnsPanel);
		columnsPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel columnLabel = new JLabel("Column");
		columnsPanel.add(columnLabel);
		columnLabel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		columnLabel.setForeground(Color.WHITE);
		columnLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel valueLabel = new JLabel("Value");
		columnsPanel.add(valueLabel);
		valueLabel.setForeground(Color.WHITE);
		valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

		this.centerPanel = new JPanel(new GridLayout(10, 1)) {

			private static final long serialVersionUID = 1L;

			@Override
			public Component add(Component comp) {
				if (this.getComponentCount() == 10)
					this.setLayout(new GridLayout(0, 1));
				return super.add(comp);
			}

		};

		this.centerPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.centerPanel.setForeground(new Color(255, 255, 255));
		this.centerScrollPane = new JScrollPane(centerPanel);

		JPanel bottomPanel = new JPanel();
		//bottomPanel.setMinimumSize(new Dimension(100, 10));
		bottomPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		centerPanel2.add(bottomPanel, BorderLayout.SOUTH);

		addNewButton = new JButton("+");
		addNewButton.setForeground(Color.WHITE);
		addNewButton.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		addNewButton.addMouseListener(new SearchPanelMouseListener());

		researchButton = new JButton ("Research");
		researchButton.setForeground(Color.WHITE);
		researchButton.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		addNewButton.addMouseListener(new SearchPanelMouseListener());
		
		bottomPanel.add(addNewButton);
		bottomPanel.add(researchButton);
		this.centerScrollPane.setBorder(null);
		this.centerScrollPane.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		centerPanel2.add(centerScrollPane, BorderLayout.CENTER);
	}

	/**
	 * Getter for the tableNameField
	 * @return the tableNameField
	 */
	public JTextField getTableNameField() {
		return tableNameField;
	}

	/**
	 * Getter for the addNewButton
	 * @return the addNewButton
	 */
	public JButton getAddNewButton() {
		return addNewButton;
	}
	
	/**
	 * Getter for the researchButton
	 * @return the researchButton
	 */
	public JButton getResearchButton () {
		return researchButton;
	}

	/**
	 * Getter for the centerPanel
	 * @return the centerPanel
	 */
	public JPanel getCenterPanel() {
		return centerPanel;
	}

	/**
	 * Getter for the centerScrollPane
	 * @return the centerScrollPane
	 */
	public JScrollPane getCenterScrollPane() {
		return centerScrollPane;
	}
}
