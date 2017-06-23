package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.controller.CloseListener;
import control.controller.WorkPanelMouseListener;
import control.game.GameManager;

public class WorkPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel menuPanel;
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
	private VisualPanel visualPanel;
	private StatsPanel statsPanel;

	private boolean firstTime = true;
	private GameManager gameManager;
	private InitializeGamePanel initializeGamePanel = new InitializeGamePanel();
	private GamePanel gamePanel;
	private ArrayList<GamePanel> game = new ArrayList<GamePanel>();
	public int y = -1;
	public int questionNumber;

	private JComponent actualPanel;

	private static WorkPanel workPanel;

	public static int width = MenuPanel.width - DirectoryPanel.width;
	public static int height = MenuPanel.height;

	/**
	 * Construct a new workPanel and set the homePanel by default
	 */
	protected WorkPanel() {

		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());

		workPanel = this;

		this.add(createMenuPanel(), BorderLayout.NORTH);
		this.add(homePanel, BorderLayout.CENTER);

		this.actualPanel = this.getHomePanel();
	}

	/**
	 * Construct a new workPanel and set the panel in parameter
	 * 
	 * @param panel
	 *            the panel to set
	 */
	public WorkPanel(JPanel panel) {
		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());

		this.add(createMenuPanel(), BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
	}

	/**
	 * Initialize the menuPanel
	 * 
	 * @return the initialized menuPanel
	 */
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

	/**
	 * Initialize the controlePanel
	 * 
	 * @return the initialized controlPanel
	 */
	private JPanel createControlPanel() {

		this.controlPanel = new JPanel(new GridLayout(0, 3, 0, 0));
		this.controlPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.controlPanel.add(createMinimizePanel());
		this.controlPanel.add(createMaximizePanel());
		this.controlPanel.add(createClosePanel());

		return this.controlPanel;
	}

	/**
	 * Initialize the minimizePanel
	 * 
	 * @return the initialized initialized minimizePanel
	 */
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

	/**
	 * Initialize the maximizePanel
	 * 
	 * @return the initialized maximizePanel
	 */
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

	/**
	 * Initialize the closePanel
	 * 
	 * @return the initialized closePanel
	 */
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

	/**
	 * Initialize the centerPanel
	 * 
	 * @return the initialized centerPanel
	 */
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

	/**
	 * Set the new location of the AppFrame by dragging it
	 * 
	 * @param evt
	 *            the thrown event
	 */
	private void frameMouseDragged(MouseEvent evt) {
		int depX = evt.getX() - xx;
		int depY = evt.getY() - xy;
		AppFrame.getFrame().setLocation(AppFrame.getFrame().getX() + depX, AppFrame.getFrame().getY() + depY);
	}

	/**
	 * Get the mouse location when pressed event is thrown
	 * 
	 * @param evt
	 *            the thrown event
	 */
	private void frameMousePressed(MouseEvent evt) {
		xx = evt.getX();
		xy = evt.getY();
	}

	/**
	 * Getter for the queryPanel
	 * 
	 * @return the queryPanel
	 */
	public QueryPanel getQueryPanel() {
		return workPanel.queryPanel;
	}

	/**
	 * Getter for the settingPanel
	 * 
	 * @return the settingPanel
	 */
	public SettingPanel getSettingPanel() {
		return workPanel.settingPanel;
	}

	/**
	 * Getter for the optionPanel
	 * 
	 * @return the optionPanel
	 */
	public OptionPanel getOptionPanel() {
		return workPanel.optionPanel;
	}

	/**
	 * Getter for the homePanel
	 * 
	 * @return the homePanel
	 */
	public HomePanel getHomePanel() {
		return workPanel.homePanel;
	}

	/**
	 * Getter for the searchPanel
	 * 
	 * @return the searchPanel
	 */
	public SearchPanel getSearchPanel() {
		return workPanel.searchPanel;
	}

	/**
	 * Getter for the adminPanel
	 * 
	 * @return the adminPanel
	 */
	public AdminPanel getAdminPanel() {
		return workPanel.adminPanel;
	}

	/**
	 * Getter for the newConnectionPanel
	 * 
	 * @return the newConnectionPanel
	 */
	public NewDataBasePanel getNewConnection() {
		return workPanel.newDataBase;
	}

	public VisualPanel getVisualPanel() {
		return workPanel.visualPanel;
	}

	public InitializeGamePanel getInitializeGamePanel() {
		return workPanel.initializeGamePanel;
	}

	public GamePanel getGamePanel() {
		return workPanel.gamePanel;
	}

	public StatsPanel getStatsPanel() {
		return workPanel.statsPanel;
	}

	/**
	 * Set workPanel's actualPanel to homePanel
	 */
	public static void setStatsPanel() {
		workPanel.statsPanel = new StatsPanel();
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getStatsPanel();
		workPanel.add(workPanel.getStatsPanel());
	}

	public static void setGamePanel() {

		if (workPanel.firstTime) {

			workPanel.remove(workPanel.getActualPanel());
			workPanel.actualPanel = workPanel.getInitializeGamePanel();
			workPanel.add(workPanel.getInitializeGamePanel());
			workPanel.firstTime = false;

		} else {

			WorkPanel.setGamePanel(workPanel.getQuestionGamePanel(workPanel.y));

			workPanel.revalidate();
			workPanel.repaint();

		}

	}

	public static void setGamePanel(GamePanel panel) {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = panel;
		workPanel.add(panel);
	}

	/**
	 * Set workPanel's actualPanel to newConnectionPanel
	 */
	public static void setNewConnection() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getNewConnection();
		workPanel.add(workPanel.getNewConnection());
	}

	/**
	 * Set workPanel's actualPanel to searchPanel
	 */
	public static void setSearchPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getSearchPanel();
		workPanel.add(workPanel.getSearchPanel());
	}

	/**
	 * Set workPanel's actualPanel to homePanel
	 */
	public static void setHomePanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getHomePanel();
		workPanel.add(workPanel.getHomePanel());
	}

	/**
	 * Set workPanel's actualPanel to queryPanel
	 */
	public static void setQueryPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getQueryPanel();
		workPanel.add(workPanel.getQueryPanel());
	}

	/**
	 * Set workPanel's actualPanel to settingPanel
	 */
	public static void setSettingPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getSettingPanel();
		workPanel.add(workPanel.getSettingPanel());
	}

	/**
	 * Set workPanel's actualPanel to optionPanel
	 */
	public static void setOptionPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getOptionPanel();
		workPanel.add(workPanel.getOptionPanel());
	}

	/**
	 * Set workPanel's actualPanel to adminPanel
	 */
	public static void setAdminPanel() {
		workPanel.remove(workPanel.getActualPanel());
		workPanel.adminPanel = new AdminPanel();
		workPanel.actualPanel = workPanel.getAdminPanel();
		workPanel.add(workPanel.getAdminPanel());
	}

	public static void setVisualPanel() {
		ResultSet rs = null;
		try {
			rs = AppFrame.getDataBaseController().executeQuery("SELECT * FROM agent");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSetTableModel rtm = new ResultSetTableModel(rs);
		workPanel.visualPanel = new VisualPanel(rtm);
		workPanel.remove(workPanel.getActualPanel());
		workPanel.actualPanel = workPanel.getVisualPanel();
		workPanel.add(workPanel.getVisualPanel());
	}

	/**
	 * Getter for the actual panel
	 * 
	 * @return the workPanel's actual panel
	 */
	public JComponent getActualPanel() {
		return workPanel.actualPanel;
	}

	/**
	 * Getter for minimizeLabel
	 * 
	 * @return the minimizeLabel
	 */
	public JLabel getMinimizeLabel() {
		return workPanel.minimizeLabel;
	}

	/**
	 * Getter for maximizeLabel
	 * 
	 * @return the maximizeLabel
	 */
	public JLabel getMaximizeLabel() {
		return workPanel.maximizeLabel;
	}

	/**
	 * Getter for closeLabel
	 * 
	 * @return the closeLabel
	 */
	public JLabel getCloseLabel() {
		return workPanel.closeLabel;
	}

	public void initialiseGame(int questionNumber) {
		gameManager = new GameManager(AppFrame.getDataBaseController());
		gameManager.setUpGame(questionNumber);

		workPanel.questionNumber = questionNumber;

		String question = null;
		String[] answers = new String[4];
		for (String s : gameManager.getQuestionList().keySet()) {
			question = s;
			int j = 0;
			for (String st : gameManager.getQuestionList().get(s)) {
				answers[j] = st;
				j++;
			}
			game.add(new GamePanel(question, answers[0], answers[1], answers[2], answers[3]));
		}

	}

	public GamePanel getQuestionGamePanel(int t) {

		try {
			workPanel.gamePanel = workPanel.game.get(t);
		} catch (IndexOutOfBoundsException a) {

		}

		return workPanel.gamePanel;
	}

	public void addQuestionInt() {

		if (workPanel.y < questionNumber) {
			workPanel.y++;
			setGamePanel();
		} else {
			gameManager.endGame();

			workPanel.firstTime = true;
			WorkPanel.setGamePanel();

			workPanel.revalidate();
			workPanel.repaint();
		}
	}
}
