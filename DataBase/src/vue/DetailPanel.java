package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.LabelCloseListener;

public class DetailPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel menuPanel;
	private JSeparator separator;
	private JPanel controlPanel;
	private JPanel minimizePanel;
	private JLabel minimizeLabel;
	private JPanel maximizePanel;
	private JLabel maximizeLabel;
	private JPanel closePanel;
	private JLabel closeLabel;
	private JPanel centerPanel;
	
	private static WorkPanel workPanel = new WorkPanel();

	protected DetailPanel() {

		this.setBackground(new Color(54, 57, 62));
		this.setPreferredSize(new Dimension(468, 452));
		this.setLayout(new BorderLayout(0, 0));

		this.add(createMenuPanel(), BorderLayout.NORTH);
		this.add(workPanel, BorderLayout.CENTER);
	}

	public DetailPanel(JPanel panel) {
		this.setBackground(new Color(54, 57, 62));
		this.setPreferredSize(new Dimension(468, 452));
		this.setLayout(new BorderLayout(0, 0));

		this.add(createMenuPanel(), BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
	}
	
	public JPanel createMenuPanel() {

		this.menuPanel = new JPanel();
		this.menuPanel.setBackground(new Color(54, 57, 62));
		this.menuPanel.setPreferredSize(new Dimension(225, 60));
		this.menuPanel.setLayout(new BorderLayout(0, 0));

		this.menuPanel.add(createSeparator(), BorderLayout.SOUTH);
		this.menuPanel.add(createControlPanel(), BorderLayout.EAST);
		this.menuPanel.add(createCenterPanel(), BorderLayout.CENTER);

		return this.menuPanel;
	}

	private JSeparator createSeparator() {

		this.separator = new JSeparator();
		this.separator.setForeground(new Color(40, 43, 48));
		this.separator.setBackground(new Color(40, 43, 48));

		return this.separator;
	}

	private JPanel createControlPanel() {

		this.controlPanel = new JPanel();
		this.controlPanel.setBackground(new Color(54, 57, 62));
		this.controlPanel.setLayout(new GridLayout(0, 3, 0, 0));
		this.controlPanel.add(createMinimizePanel());
		this.controlPanel.add(createMaximizePanel());
		this.controlPanel.add(createClosePanel());

		return this.controlPanel;
	}

	private JPanel createMinimizePanel() {

		this.minimizePanel = new JPanel();
		this.minimizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.minimizePanel.setBackground(new Color(54, 57, 62));
		this.minimizePanel.setLayout(new BorderLayout(0, 0));

		this.minimizeLabel = new JLabel();
		// this.minimizeLabel.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mousePressed(MouseEvent e) {
		// frame.setState(Frame.ICONIFIED);
		// }
		// });
		this.minimizeLabel.setBackground(new Color(40, 43, 48));
		this.minimizeLabel.setIcon(new ImageIcon("rsc\\minimize.PNG"));
		this.minimizePanel.add(this.minimizeLabel);

		return this.minimizePanel;
	}

	private JPanel createMaximizePanel() {

		this.maximizePanel = new JPanel();
		this.maximizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.maximizePanel.setBackground(new Color(54, 57, 62));
		this.maximizePanel.setLayout(new BorderLayout(0, 0));

		this.maximizeLabel = new JLabel();
		// this.maximizeLabel.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseReleased(MouseEvent e) {
		// frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		// }
		// });
		this.maximizeLabel.setBackground(new Color(40, 43, 48));
		this.maximizeLabel.setIcon(new ImageIcon("rsc\\maximize.PNG"));
		this.maximizePanel.add(this.maximizeLabel, BorderLayout.CENTER);

		return this.maximizePanel;
	}

	private JPanel createClosePanel() {

		this.closePanel = new JPanel();
		this.closePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.closePanel.setBackground(new Color(54, 57, 62));
		this.closePanel.setLayout(new BorderLayout(0, 0));

		this.closeLabel = new JLabel("");
		this.closeLabel.addMouseListener(new LabelCloseListener());
		this.closeLabel.setBackground(new Color(40, 43, 48));
		this.closeLabel.setIcon(new ImageIcon("rsc\\close.PNG"));
		this.closePanel.add(this.closeLabel);

		return this.closePanel;
	}

	private JPanel createCenterPanel() {

		this.centerPanel = new JPanel();
		// this.centerPanel.addMouseMotionListener(new MouseMotionAdapter() {
		// public void mouseDragged(MouseEvent evt) {
		// loginMouseDragged(evt);
		// }
		// });
		// this.centerPanel.addMouseListener(new MouseAdapter() {
		// public void mousePressed(MouseEvent evt) {
		// loginMousePressed(evt);
		// }
		// });
		this.centerPanel.setBackground(new Color(54, 57, 62));

		return this.centerPanel;
	}
	
	public static WorkPanel getWorkPanel() {
		return workPanel;
	}

	public static void setWorkPanel(WorkPanel workPanel) {
		DetailPanel.workPanel = workPanel;
	}
}