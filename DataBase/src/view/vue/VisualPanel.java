package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

		
		DefaultTableModel tableModel = new DefaultTableModel()
		{
		@Override
		public boolean isCellEditable(int row, int column) {
		return column==0;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
		if(columnIndex==0)
		return Boolean.class;
		return super.getColumnClass(columnIndex);
		}
		};
		JTable maTable = new JTable(tableModel);
		
		
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
