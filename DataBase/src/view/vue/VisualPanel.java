package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * The panel where the user can see a table in form of table
 */
public class VisualPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel
	 * @param model the table model
	 */
	public VisualPanel(TableModel model) {
		
		setLayout(new BorderLayout());
		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		table = new JTable(model);
		table.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		table.setForeground(Color.WHITE);
		table.setCellSelectionEnabled(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		add(scrollPane);

	}

}
