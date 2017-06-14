package vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected MainPanel() {
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(new DirectoryPanel(), BorderLayout.WEST);
		this.add(new DetailPanel(), BorderLayout.CENTER);
	}
}
