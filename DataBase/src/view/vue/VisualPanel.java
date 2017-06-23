package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class VisualPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VisualPanel(TableModel model) {

		setLayout(new BorderLayout());

		table = new JTable(model);
		table.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		table.setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane);

	}

}
