package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import controller.LabelCloseListener;
import controller.MenuButtonListener;
import controller.TextFieldListener;
import utils.WordBasedStyledDocument;

/**
 * @author mroge
 *
 */
public class BaseDeDonnees {

	private JFrame frame;
	private JTextField searchTexte;
	private static JTextPane txtpnK;
	private static JScrollPane scrollPane;
	private static JPanel panel_1;
	private static JSplitPane splitPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseDeDonnees window = new BaseDeDonnees();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BaseDeDonnees() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setPreferredSize(new Dimension(1080, 720));
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 1080, 720);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel statePanel = new JPanel();
		statePanel.setPreferredSize(new Dimension(80, 456));
		statePanel.setBackground(new Color(30, 33, 36));
		frame.getContentPane().add(statePanel, BorderLayout.WEST);
		statePanel.setLayout(null);

		JLabel avatarLabel = new JLabel("");
		avatarLabel.setBounds(0, 0, 80, 75);
		avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statePanel.add(avatarLabel);
		avatarLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		avatarLabel.setIcon(new ImageIcon("D:\\workspace\\DataBaseApp\\rsc\\user-16.png"));

		JLabel userNamePanel = new JLabel("Admin");
		userNamePanel.setBounds(0, 75, 80, 36);
		userNamePanel.setForeground(Color.WHITE);
		userNamePanel.setFont(new Font("Calibri", Font.PLAIN, 15));
		userNamePanel.setHorizontalAlignment(SwingConstants.CENTER);
		statePanel.add(userNamePanel);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 109, 60, 2);
		statePanel.add(separator_2);

		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel directoryPanel = new JPanel();
		directoryPanel.setBackground(new Color(46, 49, 54));
		directoryPanel.setPreferredSize(new Dimension(225, 456));
		mainPanel.add(directoryPanel, BorderLayout.WEST);
		directoryPanel.setLayout(new BorderLayout(0, 0));

		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(46, 49, 53));
		searchPanel.setPreferredSize(new Dimension(225, 60));
		directoryPanel.add(searchPanel, BorderLayout.NORTH);
		searchPanel.setLayout(null);

		JSeparator searchSeparator = new JSeparator();
		searchSeparator.setBounds(0, 58, 225, 2);
		searchSeparator.setForeground(new Color(40, 43, 48));
		searchSeparator.setBackground(new Color(40, 43, 48));
		searchPanel.add(searchSeparator);

		searchTexte = new JTextField();
		searchTexte.setBounds(20, 11, 184, 25);
		searchTexte.setMinimumSize(new Dimension(3, 20));
		searchTexte.setToolTipText("Dans les bases de donn\u00E9es");
		searchTexte.setText("Rechercher...");
		searchTexte.setForeground(Color.WHITE);
		searchTexte.setBorder(null);
		searchTexte.setBackground(new Color(36, 39, 43));
		searchTexte.addFocusListener(new TextFieldListener());
		searchPanel.add(searchTexte);
		searchTexte.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(41, 44, 49));
		panel_5.setPreferredSize(new Dimension(225, 60));
		directoryPanel.add(panel_5, BorderLayout.SOUTH);

		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(new Color(54, 57, 62));
		detailPanel.setPreferredSize(new Dimension(468, 452));
		mainPanel.add(detailPanel, BorderLayout.CENTER);
		detailPanel.setLayout(new BorderLayout(0, 0));

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(54, 57, 62));
		menuPanel.setPreferredSize(new Dimension(225, 60));
		detailPanel.add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BorderLayout(0, 0));

		JSeparator menuSeparator = new JSeparator();
		menuSeparator.setForeground(new Color(40, 43, 48));
		menuSeparator.setBackground(new Color(40, 43, 48));
		menuPanel.add(menuSeparator, BorderLayout.SOUTH);

		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(new Color(54, 57, 62));
		menuPanel.add(controlPanel, BorderLayout.EAST);
		controlPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel minimizePanel = new JPanel();
		minimizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizePanel.setBackground(new Color(54, 57, 62));
		controlPanel.add(minimizePanel);
		minimizePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setState(Frame.ICONIFIED);
			}
		});
		minimizePanel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(40, 43, 48));
		lblNewLabel.setIcon(new ImageIcon("D:\\workspace\\DataBaseApp\\rsc\\minimize.PNG"));

		JPanel maximizePanel = new JPanel();
		maximizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		maximizePanel.setBackground(new Color(54, 57, 62));
		controlPanel.add(maximizePanel);
		maximizePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setState(Frame.NORMAL);
			}
		});
		maximizePanel.add(lblNewLabel_1, BorderLayout.CENTER);
		lblNewLabel_1.setBackground(new Color(40, 43, 48));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\workspace\\DataBaseApp\\rsc\\maximize.PNG"));

		JPanel closePanel = new JPanel();
		closePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closePanel.setBackground(new Color(54, 57, 62));
		controlPanel.add(closePanel);
		closePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new LabelCloseListener());
		closePanel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(40, 43, 48));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\workspace\\DataBaseApp\\rsc\\close.PNG"));

		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				loginMouseDragged(evt);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				loginMousePressed(evt);
			}
		});
		panel.setBackground(new Color(54, 57, 62));
		menuPanel.add(panel, BorderLayout.CENTER);

		splitPane = new JSplitPane();
		splitPane.setDoubleBuffered(true);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBorder(null);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		detailPanel.add(splitPane, BorderLayout.CENTER);

		panel_1 = new JPanel();
		panel_1.setBorder(null);
		// panel_1.setBackground(new Color(54,57,62));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		UIManager.put("ScrollBar.trackHighlightForeground", (new Color(57, 57, 62)));
		UIManager.put("scrollbar", (new Color(57, 57, 62)));
		UIManager.put("ScrollBar.thumb", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.thumbHeight", 2);
		UIManager.put("ScrollBar.background", (new Color(57, 57, 62)));
		UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.trackForeground", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.trackHighlight", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.foreground", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.shadow", new ColorUIResource(new Color(57, 57, 62)));
		UIManager.put("ScrollBar.highlight", new ColorUIResource(new Color(57, 57, 62)));

		scrollPane = new JScrollPane(panel_1);
		scrollPane.setBorder(null);
		// scrollPane.setBackground(new Color(54,57,62));
		splitPane.setLeftComponent(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		txtpnK = new JTextPane();
		panel_2.add(txtpnK);
		txtpnK.setBorder(null);
		txtpnK.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtpnK.setBackground(new Color(54, 57, 62));
		txtpnK.setForeground(new Color(255, 255, 255));

		StyleContext cont = StyleContext.getDefaultStyleContext();
		AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
		attr = cont.addAttribute(attr.copyAttributes(), StyleConstants.Bold, true);
		Style c = cont.getStyle("default");
		c.addAttributes(attr);

		txtpnK.setStyledDocument(new WordBasedStyledDocument(txtpnK.getLogicalStyle(), c));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(54, 57, 62));
		panel_3.setForeground(new Color(255, 255, 255));
		panel_2.add(panel_3, BorderLayout.NORTH);

		JLabel executeLabel = new JLabel("Execute");
		executeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executeLabel.addMouseListener(new MenuButtonListener());
		executeLabel.setForeground(new Color(255, 255, 255));

		JLabel clearLabel = new JLabel("Clear");
		clearLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearLabel.addMouseListener(new MenuButtonListener());
		clearLabel.setForeground(new Color(255, 255, 255));

		JLabel saveLabel = new JLabel("Save");
		saveLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saveLabel.addMouseListener(new MenuButtonListener());
		saveLabel.setForeground(new Color(255, 255, 255));

		JLabel exportLabel = new JLabel("Export");
		exportLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportLabel.addMouseListener(new MenuButtonListener());
		exportLabel.setForeground(new Color(255, 255, 255));
		panel_3.setLayout(new GridLayout(0, 6, 0, 0));
		panel_3.add(executeLabel);

		JLabel executeAllLabel = new JLabel("Execute All");
		executeAllLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executeAllLabel.addMouseListener(new MenuButtonListener());
		executeAllLabel.setForeground(new Color(255, 255, 255));
		panel_3.add(executeAllLabel);
		panel_3.add(clearLabel);
		panel_3.add(saveLabel);
		panel_3.add(exportLabel);

		JLabel importLabel = new JLabel("Import");
		importLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		importLabel.addMouseListener(new MenuButtonListener());
		importLabel.setForeground(new Color(255, 255, 255));
		panel_3.add(importLabel);
		splitPane.setDividerLocation(0);
		splitPane.setDividerLocation(0.8);
		//splitPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { scrollPane, panel_2, txtpnK,
		//		panel_3, executeLabel, executeAllLabel, clearLabel, saveLabel, exportLabel, importLabel }));
	}

	public static JTextPane getTextPane() {
		return txtpnK;
	}

	int xy, xx;

	private void loginMouseDragged(MouseEvent evt) {
		int depX = evt.getX() - xx;
		int depY = evt.getY() - xy;
		frame.setLocation(frame.getX() + depX, frame.getY() + depY);
	}

	private void loginMousePressed(MouseEvent evt) {
		xx = evt.getX();
		xy = evt.getY();
	}

	public static JScrollPane getScrollPane() {
		return scrollPane;
	}

	public static JPanel getPanel_1() {
		return panel_1;
	}

	public static void setScrollPane(JScrollPane scrollPane) {
		BaseDeDonnees.scrollPane = scrollPane;
	}

	public static void setPanel_1(JPanel panel_1) {
		BaseDeDonnees.panel_1 = panel_1;
	}

	public static JSplitPane getSplitPane() {
		return splitPane;
	}
}
