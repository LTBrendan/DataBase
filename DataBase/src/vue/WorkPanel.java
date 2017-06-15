package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import controller.MenuButtonListener;
import utils.WordBasedStyledDocument;

public class WorkPanel extends JSplitPane {

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
	private static JLabel exportLabel;
	private static JLabel executeAllLabel;
	private static JLabel importLabel;

	private static WorkPanel workPanel;

	public WorkPanel() {

		this.setDoubleBuffered(true);
		this.setOneTouchExpandable(true);
		this.setBorder(null);
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);

		this.setLeftComponent(createUpScrollPane(createUpPanel()));
		this.setRightComponent(createDownScrollPane(createDownPanel()));

		this.setDividerLocation(0.8);

		this.repaint();

		workPanel = this;
	}

	public WorkPanel(Component comp, Component comp2) {

		this.setDoubleBuffered(true);
		this.setOneTouchExpandable(true);
		this.setBorder(null);
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);

		this.setLeftComponent(comp);
		this.setRightComponent(comp2);

		this.setDividerLocation(0.8);

		this.repaint();

		workPanel = this;
	}

	private JPanel createUpPanel() {

		this.upPanel = new JPanel();
		this.upPanel.setBorder(null);
		this.upPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			this.upPanel.setForeground(new Color(255,255,255));
		else
			this.upPanel.setForeground(new Color(0,0,0));
		this.upPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		return this.upPanel;
	}

	private JScrollPane createUpScrollPane(JPanel panel) {

		UIManager.put("ScrollBar.trackHighlightForeground", (new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("scrollbar", (new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.thumb", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.thumbHeight", 2);
		UIManager.put("ScrollBar.background", (new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.trackForeground", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.trackHighlight", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.foreground", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.shadow", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));
		UIManager.put("ScrollBar.highlight", new ColorUIResource(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8)));

		this.upScrollPane = new JScrollPane(panel);
		this.upScrollPane.setPreferredSize(new Dimension(20, 250));
		this.upScrollPane.setBorder(null);

		return this.upScrollPane;
	}

	private JPanel createDownPanel() {

		this.downPanel = new JPanel();
		this.downPanel.setLayout(new BorderLayout());
		this.downPanel.add(createMenuBarPanel(), BorderLayout.NORTH);
		this.downPanel.add(createTextPane(), BorderLayout.CENTER);

		return this.downPanel;
	}

	private JPanel createMenuBarPanel() {

		this.menuBarPanel = new JPanel();
		this.menuBarPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			this.menuBarPanel.setForeground(new Color(255,255,255));
		else
			this.menuBarPanel.setForeground(new Color(0,0,0));
		this.menuBarPanel.setLayout(new GridLayout(0, 6, 0, 0));

		executeLabel = new JLabel("Execute");
		executeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executeLabel.addMouseListener(new MenuButtonListener());
		if (Launcher.color == 54)
			executeLabel.setForeground(new Color(255,255,255));
		else
			executeLabel.setForeground(new Color(0,0,0));

		clearLabel = new JLabel("Clear");
		clearLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearLabel.addMouseListener(new MenuButtonListener());
		if (Launcher.color == 54)
			clearLabel.setForeground(new Color(255,255,255));
		else
			clearLabel.setForeground(new Color(0,0,0));

		saveLabel = new JLabel("Save");
		saveLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saveLabel.addMouseListener(new MenuButtonListener());
		if (Launcher.color == 54)
			saveLabel.setForeground(new Color(255,255,255));
		else
			saveLabel.setForeground(new Color(0,0,0));

		exportLabel = new JLabel("Export");
		exportLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportLabel.addMouseListener(new MenuButtonListener());
		if (Launcher.color == 54)
			exportLabel.setForeground(new Color(255,255,255));
		else
			exportLabel.setForeground(new Color(0,0,0));

		executeAllLabel = new JLabel("Execute All");
		executeAllLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executeAllLabel.addMouseListener(new MenuButtonListener());
		if (Launcher.color == 54)
			executeAllLabel.setForeground(new Color(255,255,255));
		else
			executeAllLabel.setForeground(new Color(0,0,0));

		importLabel = new JLabel("Import");
		importLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		importLabel.addMouseListener(new MenuButtonListener());
		if (Launcher.color == 54)
			importLabel.setForeground(new Color(255,255,255));
		else
			importLabel.setForeground(new Color(0,0,0));

		this.menuBarPanel.add(executeLabel);
		this.menuBarPanel.add(executeAllLabel);
		this.menuBarPanel.add(clearLabel);
		this.menuBarPanel.add(saveLabel);
		this.menuBarPanel.add(exportLabel);
		this.menuBarPanel.add(importLabel);

		return this.menuBarPanel;
	}

	private JTextPane createTextPane() {

		this.textPane = new JTextPane();
		this.textPane.setBorder(null);
		this.textPane.setFont(new Font("Calibri", Font.PLAIN, 20));
		this.textPane.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			textPane.setForeground(new Color(255,255,255));
		else
			textPane.setForeground(new Color(0,0,0));

		StyleContext cont = StyleContext.getDefaultStyleContext();
		AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
		attr = cont.addAttribute(attr.copyAttributes(), StyleConstants.Bold, true);
		Style c = cont.getStyle("default");
		c.addAttributes(attr);

		this.textPane.setStyledDocument(new WordBasedStyledDocument(this.textPane.getLogicalStyle(), c));

		return this.textPane;
	}

	private JScrollPane createDownScrollPane(JPanel panel) {

		this.downScrollPane = new JScrollPane(panel);
		this.downScrollPane.setBorder(null);

		return this.downScrollPane;
	}

	public JLabel getExecuteLabel() {
		return executeLabel;
	}

	public static JLabel getClearLabel() {
		return clearLabel;
	}

	public static JLabel getSaveLabel() {
		return saveLabel;
	}

	public static JLabel getExportLabel() {
		return exportLabel;
	}

	public static JLabel getExecuteAllLabel() {
		return executeAllLabel;
	}

	public static JLabel getImportLabel() {
		return importLabel;
	}

	public JPanel getUpPanel() {
		return workPanel.upPanel;
	}

	public void setUpPanel(JPanel upPanel) {
		workPanel.upPanel = upPanel;
	}

	public static JScrollPane getUpScrollPane() {
		return workPanel.upScrollPane;
	}

	public void setUpScrollPane(JScrollPane upScrollPane) {
		workPanel.upScrollPane = upScrollPane;
	}

	public JTextPane getTextPane() {
		return workPanel.textPane;
	}

	public static JScrollPane getDownScrollPane() {
		return workPanel.downScrollPane;
	}

	public static WorkPanel getWorkPanel() {
		return workPanel;
	}
}
