package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import control.controller.QueryPanelMouseListener;
import model.utils.WordBasedStyledDocument;

/**
 * The panel where the user can execute queries
 */
public class QueryPanel extends JSplitPane {

	private static final long serialVersionUID = 1L;
	private JPanel upPanel;
	private JScrollPane upScrollPane;
	private JPanel downPanel;
	private JPanel menuBarPanel;
	private JTextPane textPane;
	private JScrollPane downScrollPane;

	private static JLabel executeLabel;
	private static JLabel clearLabel;
	private static JLabel saveLabel;
	private static JLabel executeAllLabel;
	private static JLabel importLabel;

	private static JPanel executePanel;
	private static JPanel clearPanel;
	private static JPanel savePanel;
	private static JPanel executeAllPanel;
	private static JPanel importPanel;

	
	private static QueryPanel queryPanel;

	/**
	 * The constructor of the panel
	 */
	public QueryPanel() {

		this.setDoubleBuffered(true);
		this.setOneTouchExpandable(true);
		this.setBorder(null);
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);

		this.setLeftComponent(createUpScrollPane(createUpPanel()));
		this.setRightComponent(createDownPanel());

		this.setDividerLocation(0.8);

		this.repaint();

		queryPanel = this;
	}

	/**
	 * Initialize the upper panel
	 * @return the initialized upperPanel
	 */
	private JPanel createUpPanel() {

		this.upPanel = new JPanel();
		this.upPanel.setBorder(null);
		this.upPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		if (AppFrame.color == 54)
			this.upPanel.setForeground(new Color(255, 255, 255));
		else
			this.upPanel.setForeground(new Color(0, 0, 0));
		this.upPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		return this.upPanel;
	}

	/**
	 * Initialize the upper scroll pane
	 * @param panel the panel to put in the scroll pane
	 * @return the initialized scroll pane
	 */
	private JScrollPane createUpScrollPane(JPanel panel) {

		this.upScrollPane = new JScrollPane(panel);
		//this.upScrollPane.setPreferredSize(new Dimension(20, 250));
		this.upScrollPane.setBorder(null);

		return this.upScrollPane;
	}

	/**
	 * Initialize the lower panel
	 * @return the initialized downPanel
	 */
	private JPanel createDownPanel() {

		this.downPanel = new JPanel();
		this.downPanel.setLayout(new BorderLayout());
		this.downPanel.add(createMenuBarPanel(), BorderLayout.NORTH);
		this.downPanel.add(createDownScrollPane(createTextPane()), BorderLayout.CENTER);

		return this.downPanel;
	}

	/**
	 * Initialize the menuBarPanel
	 * @return the initialized menuBarPanel
	 */
	private JPanel createMenuBarPanel() {

		this.menuBarPanel = new JPanel();
		this.menuBarPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		if (AppFrame.color == 54)
			this.menuBarPanel.setForeground(new Color(255, 255, 255));
		else
			this.menuBarPanel.setForeground(new Color(0, 0, 0));
		this.menuBarPanel.setLayout(new GridLayout(0, 5, 0, 0));

		executePanel = new JPanel ();
		executePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		executePanel.addMouseListener(new QueryPanelMouseListener());
		if (AppFrame.color == 54)
			executePanel.setForeground(new Color(255, 255, 255));
		else
			executePanel.setForeground(new Color(0, 0, 0));
		
		executeLabel = new JLabel("Execute");
		executeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if (AppFrame.color == 54)
			executeLabel.setForeground(new Color(255, 255, 255));
		else
			executeLabel.setForeground(new Color(0, 0, 0));
		
		clearPanel = new JPanel ();
		clearPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		clearPanel.addMouseListener(new QueryPanelMouseListener());
		if (AppFrame.color == 54)
			clearPanel.setForeground(new Color(255, 255, 255));
		else
			clearPanel.setForeground(new Color(0, 0, 0));
		
		clearLabel = new JLabel("Clear");
		clearLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if (AppFrame.color == 54)
			clearLabel.setForeground(new Color(255, 255, 255));
		else
			clearLabel.setForeground(new Color(0, 0, 0));

		savePanel = new JPanel ();
		savePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		savePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		savePanel.addMouseListener(new QueryPanelMouseListener());
		if (AppFrame.color == 54)
			savePanel.setForeground(new Color(255, 255, 255));
		else
			savePanel.setForeground(new Color(0, 0, 0));
		
		saveLabel = new JLabel("Save");
		saveLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if (AppFrame.color == 54)
			saveLabel.setForeground(new Color(255, 255, 255));
		else
			saveLabel.setForeground(new Color(0, 0, 0));

		executeAllPanel = new JPanel ();
		executeAllPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executeAllPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		executeAllPanel.addMouseListener(new QueryPanelMouseListener());
		if (AppFrame.color == 54)
			executeAllPanel.setForeground(new Color(255, 255, 255));
		else
			executeAllPanel.setForeground(new Color(0, 0, 0));
		
		executeAllLabel = new JLabel("Execute All");
		executeAllLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if (AppFrame.color == 54)
			executeAllLabel.setForeground(new Color(255, 255, 255));
		else
			executeAllLabel.setForeground(new Color(0, 0, 0));

		importPanel = new JPanel ();
		importPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		importPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		importPanel.addMouseListener(new QueryPanelMouseListener());
		if (AppFrame.color == 54)
			importPanel.setForeground(new Color(255, 255, 255));
		else
			importPanel.setForeground(new Color(0, 0, 0));
		
		importLabel = new JLabel("Import");
		importLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if (AppFrame.color == 54)
			importLabel.setForeground(new Color(255, 255, 255));
		else
			importLabel.setForeground(new Color(0, 0, 0));

		QueryPanel.executePanel.add(executeLabel);
		QueryPanel.executeAllPanel.add(executeAllLabel);
		QueryPanel.clearPanel.add(clearLabel);
		QueryPanel.savePanel.add(saveLabel);
		QueryPanel.importPanel.add(importLabel);
		
		this.menuBarPanel.add(executePanel);
		this.menuBarPanel.add(executeAllPanel);
		this.menuBarPanel.add(clearPanel);
		this.menuBarPanel.add(savePanel);
		this.menuBarPanel.add(importPanel);

		return this.menuBarPanel;
	}

	/**
	 * Initialize the text panel
	 * @return the initialized textPanel
	 */
	private JTextPane createTextPane() {

		this.textPane = new JTextPane();
		this.textPane.setBorder(null);
		this.textPane.setDragEnabled(true);
		this.textPane.setFont(new Font("Calibri", Font.PLAIN, 20));
		this.textPane.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		if (AppFrame.color == 54)
			textPane.setForeground(new Color(255, 255, 255));
		else
			textPane.setForeground(new Color(0, 0, 0));

		StyleContext cont = StyleContext.getDefaultStyleContext();
		AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
		attr = cont.addAttribute(attr.copyAttributes(), StyleConstants.Bold, true);
		Style c = cont.getStyle("default");
		c.addAttributes(attr);

		this.textPane.setStyledDocument(new WordBasedStyledDocument(this.textPane.getLogicalStyle(), c));

		return this.textPane;
	}

	/**
	 * Initialize the down scroll pane
	 * @param jTextPane the jTextPane to put in the scroll pane
	 * @return the initialized scroll pane
	 */
	private JScrollPane createDownScrollPane(JTextPane jTextPane) {

		this.downScrollPane = new JScrollPane(jTextPane);
		this.downScrollPane.setBorder(null);

		return this.downScrollPane;
	}

	/**
	 * Getter for the executeLabel
	 * @return the executeLabel
	 */
	public JLabel getExecuteLabel() {
		return executeLabel;
	}

	/**
	 * Getter for the clearLabel
	 * @return the clearLabel
	 */
	public JLabel getClearLabel() {
		return clearLabel;
	}

	/**
	 * Getter for the saveLabel
	 * @return the saveLabel
	 */
	public JLabel getSaveLabel() {
		return saveLabel;
	}

	/**
	 * Getter for the executeAllLabel
	 * @return the executeAllLabel
	 */
	public JLabel getExecuteAllLabel() {
		return executeAllLabel;
	}

	/**
	 * Getter for the importLabel
	 * @return the importLabel
	 */
	public JLabel getImportLabel() {
		return importLabel;
	}
	
	/**
	 * Getter for the executePanel
	 * @return the executePanel
	 */
	public JPanel getExecutePanel() {
		return executePanel;
	}

	/**
	 * Getter for the clearPanel
	 * @return the clearPanel
	 */
	public JPanel getClearPanel() {
		return clearPanel;
	}

	/**
	 * Getter for the savePanel
	 * @return the savePanel
	 */
	public JPanel getSavePanel() {
		return savePanel;
	}

	/**
	 * Getter for the executeAllLabel
	 * @return the executeAllLabel
	 */
	public JPanel getExecuteAllPanel() {
		return executeAllPanel;
	}

	/**
	 * Getter for the importPanel
	 * @return the importPanel
	 */
	public JPanel getImportPanel() {
		return importPanel;
	}

	/**
	 * Getter for the upPanel
	 * @return the upPanel
	 */
	public JPanel getUpPanel() {
		return queryPanel.upPanel;
	}

	/**
	 * Setter for the upPanel
	 * @param upPanel the new upPanel
	 */
	public void setUpPanel(JPanel upPanel) {
		queryPanel.upPanel = upPanel;
	}

	/**
	 * Getter for the upScrollPane
	 * @return the upScrollPane
	 */
	public static JScrollPane getUpScrollPane() {
		return queryPanel.upScrollPane;
	}

	/**
	 * Setter for the upScrolPane
	 * @param upScrollPane the new upScrollPane
	 */
	public void setUpScrollPane(JScrollPane upScrollPane) {
		queryPanel.upScrollPane = upScrollPane;
	}

	/**
	 * Getter for the textPane
	 * @return the textPane
	 */
	public JTextPane getTextPane() {
		return queryPanel.textPane;
	}

	/**
	 * Getter for the downScrollPane
	 * @return the downScrollPane
	 */
	public static JScrollPane getDownScrollPane() {
		return queryPanel.downScrollPane;
	}

	/**
	 * Getter for this queryPanel
	 * @return this queryPanel
	 */
	public static QueryPanel getQueryPanel() {
		return queryPanel;
	}
}
