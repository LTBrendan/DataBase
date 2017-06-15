package vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static DirectoryPanel directoryPanel = new DirectoryPanel();
	private static DetailPanel detailPanel = new DetailPanel();
	
	public MainPanel() {
		
		this.setLayout(new BorderLayout(0, 0));
		System.out.println(MainPanel.detailPanel.getName());
		this.add(directoryPanel, BorderLayout.WEST);
		this.add(detailPanel, BorderLayout.CENTER);
	}
	
	public MainPanel(JPanel panel) {
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(directoryPanel, BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);
		
		this.repaint();
	}

	public static DirectoryPanel getDirectoryPanel() {
		return directoryPanel;
	}

	public static void setDirectoryPanel(DirectoryPanel directoryPanel) {
		MainPanel.directoryPanel = directoryPanel;
	}

	public static DetailPanel getDetailPanel() {
		System.out.println("getDetailPanel");
		return detailPanel;
	}

	public static void setDetailPanel(DetailPanel detailPanel) {
		System.out.println("setDetailPanel");
		MainPanel.detailPanel = detailPanel;
		System.out.println(MainPanel.detailPanel.getName());
	}
}
