package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import control.controller.CloseListener;
import control.controller.WorkPanelMouseListener;

public class WorkPanel extends JPanel {

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

	private QueryPanel queryPanel = new QueryPanel();
	private SettingPanel settingPanel = new SettingPanel();
	private OptionPanel optionPanel = new OptionPanel();
	private HomePanel homePanel = new HomePanel();
	private SearchPanel searchPanel = new SearchPanel();
	private AdminPanel adminPanel = new AdminPanel();
	private NewDataBasePanel newDataBase = new NewDataBasePanel();
	private JComponent actualPanel;

	private static WorkPanel workPanel;

	public static int width = MenuPanel.width - DirectoryPanel.width;
	public static int height = MenuPanel.height;

	protected WorkPanel() {

		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());

		workPanel = this;

		this.add(createMenuPanel(), BorderLayout.NORTH);
		this.add(homePanel, BorderLayout.CENTER);

		this.actualPanel = this.getHomePanel();
	}

	public WorkPanel(JPanel panel) {
		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());

		this.add(createMenuPanel(), BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
	}

	public JPanel createMenuPanel() {

		this.menuPanel = new JPanel(new BorderLayout());
		this.menuPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.menuPanel.setPreferredSize(new Dimension(width, height / 15));
		this.menuPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				new Color(AppFrame.color - 14, AppFrame.color - 11, AppFrame.color - 6)));

		this.menuPanel.add(createControlPanel(), BorderLayout.EAST);
		this.menuPanel.add(createCenterPanel(), BorderLayout.CENTER);

		return this.menuPanel;
	}

	private JPanel createControlPanel() {

		this.controlPanel = new JPanel(new GridLayout(0, 3, 0, 0));
		this.controlPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		// this.controlPanel.setPreferredSize(new Dimension(width / 10, height /
		// 16));
		this.controlPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));

		this.controlPanel.add(createMinimizePanel());
		this.controlPanel.add(createMaximizePanel());
		this.controlPanel.add(createClosePanel());

		return this.controlPanel;
	}

	private JPanel createMinimizePanel() {

		this.minimizePanel = new JPanel(new BorderLayout());
		this.minimizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.minimizePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		this.minimizeLabel = new JLabel();
		this.minimizeLabel.addMouseListener(new WorkPanelMouseListener());
		if (AppFrame.color == 54)
			this.minimizeLabel.setIcon(new ImageIcon("rsc\\control\\minusWhite.PNG"));
		else
			this.minimizeLabel.setIcon(new ImageIcon("rsc\\control\\minusBlack.PNG"));

		this.minimizePanel.add(this.minimizeLabel);

		return this.minimizePanel;
	}

	private JPanel createMaximizePanel() {

		this.maximizePanel = new JPanel();
		this.maximizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.maximizePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.maximizePanel.setLayout(new BorderLayout(0, 0));

		this.maximizeLabel = new JLabel();
		this.maximizeLabel.addMouseListener(new WorkPanelMouseListener());
		if (AppFrame.color == 54)
			this.maximizeLabel.setIcon(new ImageIcon("rsc\\control\\expandWhite.PNG"));
		else
			this.maximizeLabel.setIcon(new ImageIcon("rsc\\control\\expandBlack.PNG"));

		this.maximizePanel.add(this.maximizeLabel, BorderLayout.CENTER);
		this.maximizePanel.add(new JLabel("   "), BorderLayout.EAST);
		return this.maximizePanel;
	}

	private JPanel createClosePanel() {

		this.closePanel = new JPanel();
		this.closePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.closePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.closePanel.setLayout(new BorderLayout(0, 0));

		this.closeLabel = new JLabel("");
		this.closeLabel.addMouseListener(new CloseListener());
		this.closeLabel.setBackground(new Color(AppFrame.color - 14, AppFrame.color - 11, AppFrame.color - 6));
		if (AppFrame.color == 54)
			this.closeLabel.setIcon(new ImageIcon("rsc\\control\\closeWhite.PNG"));
		else
			this.closeLabel.setIcon(new ImageIcon("rsc\\control\\closeBlack.PNG"));

		this.closePanel.add(this.closeLabel);

		return this.closePanel;
	}

	private JPanel createCenterPanel() {

		this.centerPanel = new JPanel();
		this.centerPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				frameMouseDragged(evt);
			}
		});
		this.centerPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				frameMousePressed(evt);
			}
		});
		this.centerPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		return this.centerPanel;
	}

	int xy, xx;

	private void frameMouseDragged(MouseEvent evt) {
		int depX = evt.getX() - xx;
		int depY = evt.getY() - xy;
		AppFrame.getFrame().setLocation(AppFrame.getFrame().getX() + depX, AppFrame.getFrame().getY() + depY);
	}

	private void frameMousePressed(MouseEvent evt) {
		xx = evt.getX();
		xy = evt.getY();
	}

	public QueryPanel getQueryPanel() {
		return workPanel.queryPanel;
	}

	public SettingPanel getSettingPanel() {
		return workPanel.settingPanel;
	}

	public OptionPanel getOptionPanel() {
		return workPanel.optionPanel;
	}

	public HomePanel getHomePanel() {
		return workPanel.homePanel;
	}

	public SearchPanel getSearchPanel() {
		return workPanel.searchPanel;
	}

	public AdminPanel getAdminPanel() {
		return workPanel.adminPanel;
	}

	public NewDataBasePanel getNewConnection() {
		return workPanel.newDataBase;
	}

	public static void setNewConnection() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getNewConnection();
		workPanel.add(workPanel.getNewConnection());
	}

	public static void setSearchPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getSearchPanel();
		workPanel.add(workPanel.getSearchPanel());
	}

	public static void setHomePanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getHomePanel();
		workPanel.add(workPanel.getHomePanel());
	}

	public static void setQueryPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getQueryPanel();
		workPanel.add(workPanel.getQueryPanel());
	}

	public static void setSettingPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getSettingPanel();
		workPanel.add(workPanel.getSettingPanel());
	}

	public static void setOptionPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getOptionPanel();
		workPanel.add(workPanel.getOptionPanel());
	}

	public static void setAdminPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.adminPanel = new AdminPanel();
		workPanel.actualPanel = workPanel.getAdminPanel();
		workPanel.add(workPanel.getAdminPanel());
	}

	public JComponent getActualPanel() {
		return workPanel.actualPanel;
	}

	public JLabel getMinimizeLabel() {
		return workPanel.minimizeLabel;
	}

	public JLabel getMaximizeLabel() {
		return workPanel.maximizeLabel;
	}

	public JLabel getCloseLabel() {
		return workPanel.closeLabel;
	}
}