package vue;

import java.awt.BorderLayout;
import java.awt.Color;
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
	
	public WorkPanel() {
		
		this.setDoubleBuffered(true);
		this.setOneTouchExpandable(true);
		this.setBorder(null);
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		this.setLeftComponent(createUpScrollPane(createUpPanel()));
		this.setRightComponent(createDownScrollPane(createDownPanel()));
		
		this.setDividerLocation(0);
		this.setDividerLocation(0.8);
	}

	private JPanel createUpPanel() {
		
		this.upPanel = new JPanel();
		this.upPanel.setBorder(null);
		this.upPanel.setBackground(new Color(54,57,62));
		this.upPanel.setForeground(new Color(255, 255, 255));
		this.upPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		return this.upPanel;
	}
	
	private JScrollPane createUpScrollPane(JPanel panel) {
		
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
		
		this.upScrollPane = new JScrollPane(panel);
		this.upScrollPane.setPreferredSize(new Dimension(20,250));
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
		this.menuBarPanel.setBackground(new Color(54, 57, 62));
		this.menuBarPanel.setForeground(new Color(255, 255, 255));
		this.menuBarPanel.setLayout(new GridLayout(0, 6, 0, 0));
		
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
		
		JLabel executeAllLabel = new JLabel("Execute All");
		executeAllLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executeAllLabel.addMouseListener(new MenuButtonListener());
		executeAllLabel.setForeground(new Color(255, 255, 255));
		
		JLabel importLabel = new JLabel("Import");
		importLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		importLabel.addMouseListener(new MenuButtonListener());
		importLabel.setForeground(new Color(255, 255, 255));
		
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
		this.textPane.setBackground(new Color(54, 57, 62));
		this.textPane.setForeground(new Color(255, 255, 255));
		
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
}
