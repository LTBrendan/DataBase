package vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DirectoryPanel directoryPanel = new DirectoryPanel();
	private DetailPanel detailPanel = new DetailPanel();
	
	private static MainPanel mainPanel;
	
	public MainPanel() {
		
		this.setLayout(new BorderLayout(0, 0));
		this.add(directoryPanel, BorderLayout.WEST);
		this.add(detailPanel, BorderLayout.CENTER);
		
		mainPanel = this;
	}

	public DirectoryPanel getDirectoryPanel() {
		return mainPanel.directoryPanel;
	}

	public static void setDirectoryPanel(DirectoryPanel directoryPanel) {
		mainPanel.directoryPanel = directoryPanel;
	}

	public DetailPanel getDetailPanel() {
		return mainPanel.detailPanel;
	}

	public static void setDetailPanel(DetailPanel detailPanel) {
		mainPanel.remove(mainPanel.getDetailPanel());
		mainPanel.add(detailPanel);
	}
	
	public static MainPanel getMainPanel(){
		return mainPanel;
	}
}
