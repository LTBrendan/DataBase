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

public class QueryPanel extends JSplitPane {

	/**
	 * 
	 */
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

	private JScrollPane createUpScrollPane(JPanel panel) {

		this.upScrollPane = new JScrollPane(panel);
		//this.upScrollPane.setPreferredSize(new Dimension(20, 250));
		this.upScrollPane.setBorder(null);

		return this.upScrollPane;
	}

	private JPanel createDownPanel() {

		this.downPanel = new JPanel();
		this.downPanel.setLayout(new BorderLayout());
		this.downPanel.add(createMenuBarPanel(), BorderLayout.NORTH);
		this.downPanel.add(createDownScrollPane(createTextPane()), BorderLayout.CENTER);

		return this.downPanel;
	}

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

	private JScrollPane createDownScrollPane(JTextPane jTextPane) {

		this.downScrollPane = new JScrollPane(jTextPane);
		this.downScrollPane.setBorder(null);

		return this.downScrollPane;
	}

	public JLabel getExecuteLabel() {
		return executeLabel;
	}

	public JLabel getClearLabel() {
		return clearLabel;
	}

	public JLabel getSaveLabel() {
		return saveLabel;
	}

	public JLabel getExecuteAllLabel() {
		return executeAllLabel;
	}

	public JLabel getImportLabel() {
		return importLabel;
	}
	
	public JPanel getExecutePanel() {
		return executePanel;
	}

	public JPanel getClearPanel() {
		return clearPanel;
	}

	public JPanel getSavePanel() {
		return savePanel;
	}

	public JPanel getExecuteAllPanel() {
		return executeAllPanel;
	}

	public JPanel getImportPanel() {
		return importPanel;
	}

	public JPanel getUpPanel() {
		return queryPanel.upPanel;
	}

	public void setUpPanel(JPanel upPanel) {
		queryPanel.upPanel = upPanel;
	}

	public static JScrollPane getUpScrollPane() {
		return queryPanel.upScrollPane;
	}

	public void setUpScrollPane(JScrollPane upScrollPane) {
		queryPanel.upScrollPane = upScrollPane;
	}

	public JTextPane getTextPane() {
		return queryPanel.textPane;
	}

	public static JScrollPane getDownScrollPane() {
		return queryPanel.downScrollPane;
	}

	public static QueryPanel getQueryPanel() {
		return queryPanel;
	}
}
