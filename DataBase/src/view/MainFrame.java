package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneLayout;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JPanel rightPanel;
	private JPanel leftPanel;
	public MainFrame () {
		this.initComponent ();
		setSize (500,500);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		
	}
	
	private void initComponent () {
		menuBar = new JMenuBar ();
		menu = new JMenu ("Fichier");
		menuItem = new JMenuItem ("Enregistrer");
		menu.add(menuItem);
		menuBar.add(menu);
		rightPanel = new JPanel ();
		initLeftPanel ();
		JSplitPane splitPane = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		setJMenuBar (menuBar);
		add (splitPane);
		splitPane.setDividerLocation(125);
	}
	
	private void initLeftPanel () {
		leftPanel = new JPanel ();
		leftPanel.setLayout(new GridLayout (3,1));
		leftPanel.add(new JLabel (new ImageIcon ("source/login.png")));
		JScrollPane scrollPane = new JScrollPane ();
		scrollPane.setLayout(new ScrollPaneLayout ());
		scrollPane.add((new JLabel ("blabla")));
		scrollPane.add((new JLabel ("blabla")));
		scrollPane.add((new JLabel ("blabla")));
		scrollPane.createHorizontalScrollBar ();
		leftPanel.add(scrollPane);
	}
}
