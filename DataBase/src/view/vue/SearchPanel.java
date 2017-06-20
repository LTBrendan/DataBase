package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tableNameField;
	private JPanel centerPanel;
	private JScrollPane centerScrollPane;

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

		JPanel centerPanel2 = new JPanel();
		centerPanel2.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		add(centerPanel2, BorderLayout.CENTER);
		centerPanel2.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		centerPanel2.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel tableNamePanel = new JPanel();
		FlowLayout fl_tableNamePanel = (FlowLayout) tableNamePanel.getLayout();
		fl_tableNamePanel.setVgap(10);
		tableNamePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		topPanel.add(tableNamePanel);

		tableNameField = new JTextField("Table name");
		tableNameField.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent arg0) {
				tableNameField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				tableNameField.setText("Table name");
			}
		});
		tableNameField.setForeground(Color.WHITE);
		tableNamePanel.add(tableNameField);
		tableNameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		tableNameField.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		tableNameField.setColumns(10);

		JPanel columnsPanel = new JPanel();
		columnsPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		topPanel.add(columnsPanel);
		columnsPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel columnLabel = new JLabel("Column");
		columnsPanel.add(columnLabel);
		columnLabel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
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

		this.centerPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		this.centerPanel.setForeground(new Color(255, 255, 255));

		this.centerScrollPane = new JScrollPane(centerPanel);

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(100, 10));
		centerPanel2.add(panel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("+");

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				JPanel fieldPanel = new JPanel();
				fieldPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
				fieldPanel.setLayout(new GridLayout(1, 2));
				fieldPanel.setMinimumSize(new Dimension(100, 100));
				fieldPanel.setMaximumSize(new Dimension(100,100));

				JPanel columnFlowPanel = new JPanel(new FlowLayout());
				columnFlowPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

				JTextField columnField = new JTextField();
				columnField.setForeground(Color.WHITE);
				columnField.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
				columnField.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
				columnField.setColumns(10);
				columnField.setMinimumSize(new Dimension(100, 100));

				JPanel valueFlowPanel = new JPanel(new FlowLayout());
				valueFlowPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

				JTextField valueField = new JTextField();
				valueField.setForeground(Color.WHITE);
				valueField.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
				valueField.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
				valueField.setColumns(10);
				valueField.setMinimumSize(new Dimension(100, 100));

				columnFlowPanel.add(columnField);
				valueFlowPanel.add(valueField);

				fieldPanel.setVisible(true);

				fieldPanel.add(columnFlowPanel);
				fieldPanel.add(valueFlowPanel);

				centerPanel.add(fieldPanel);

				centerPanel.revalidate();
				centerPanel.repaint();

				centerScrollPane.revalidate();
				centerScrollPane.repaint();

			}
		});

		panel.add(btnNewButton);
		this.centerScrollPane.setBorder(null);
		this.centerScrollPane.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

		centerPanel2.add(centerScrollPane, BorderLayout.CENTER);

	}

}

/*
 * this.centerPanel = new JPanel(new GridLayout(15, 1)){
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * @Override public Component add(Component comp) { if(this.getComponentCount()
 * == 15) this.setLayout(new GridLayout(0, 1)); return super.add(comp); }
 * 
 * };
 * 
 * this.centerPanel.setBackground(new Color(Launcher.color - 8, Launcher.color -
 * 5, Launcher.color)); this.centerPanel.setForeground(new Color(255,255,255));
 * 
 * for (UserConnexion uc :
 * Launcher.getLauncher().getLauncherControler().getCurrentUser().
 * getConnexionList()) {
 * 
 * JLabel connection = new JLabel(" - " + uc.getConnexionName()); if
 * (Launcher.color == 54) connection.setForeground(new Color(255,255,255)); else
 * connection.setForeground(new Color(0,0,0));
 * connection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 * connection.addMouseListener(new ConnectDataBaseListener(uc.getAdresse(),
 * uc.getLogin(), uc.getPassword()));
 * 
 * //connection.setVerticalAlignment(HEIGHT); this.centerPanel.add(connection);
 * }
 * 
 * this.centerScrollPane = new JScrollPane(centerPanel);
 * this.centerScrollPane.setBorder(null);
 * this.centerScrollPane.setBackground(new Color(Launcher.color - 8,
 * Launcher.color - 5, Launcher.color));
 * 
 */
