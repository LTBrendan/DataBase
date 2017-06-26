package view.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private DirectoryPanel directoryPanel = new DirectoryPanel();
	private WorkPanel workPanel = new WorkPanel();

	private static MainPanel mainPanel;

	public static int height = LoginFrame.height;
	public static int width = LoginFrame.width - (LoginFrame.width / 100 * 6);

	/**
	 * Construct a new MainPanel
	 */
	public MainPanel() {

		this.setLayout(new BorderLayout(0, 0));
		this.setPreferredSize(new Dimension(width, height));

		this.add(directoryPanel, BorderLayout.WEST);
		this.add(workPanel, BorderLayout.CENTER);

		mainPanel = this;
	}

	/**
	 * Getter for the directoryPanem
	 * @return the directoryPanel
	 */
	public DirectoryPanel getDirectoryPanel() {
		return mainPanel.directoryPanel;
	}

	/**
	 * Setter for the directoryPanel
	 * @param directoryPanel the directory panel to set in
	 */
	public static void setDirectoryPanel(DirectoryPanel directoryPanel) {
		mainPanel.directoryPanel = directoryPanel;
	}

	/**
	 * Getter for the workPanel
	 * @return the workPanel
	 */
	public WorkPanel getWorkPanel() {
		return mainPanel.workPanel;
	}

	/**
	 * Reset the detailPanel with a new WorkPanel
	 * @param workPanel the new workPanel
	 */
	public static void setDetailPanel(WorkPanel workPanel) {
		mainPanel.remove(mainPanel.getWorkPanel());
		mainPanel.add(workPanel);
	}

	/**
	 * Getter for this mainPanel
	 * @return this mainPanel
	 */
	public static MainPanel getMainPanel() {
		return mainPanel;
	}
}
