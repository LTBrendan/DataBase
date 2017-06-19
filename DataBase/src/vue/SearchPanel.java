package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {

		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setLayout(new BorderLayout(0, 0));

		// JList list = new JList();
		// list.setEnabled(true);
		// String[] tables = Launcher.getDataBaseController().getTableName();
		// for (String name : tables) {
		// list.add(new JLabel(name));
		// }
		// add(list, BorderLayout.WEST);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

	}

}
