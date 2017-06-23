package view.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VisualPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VisualPanel() {
		
		setLayout(new BorderLayout(0, 0));

		table = new JTable(new Object[][] {}, AppFrame.getDataBaseController().getColumnName("game"));

		JScrollPane scrollPane = new JScrollPane(table);
		

		add(scrollPane);

	}

}
