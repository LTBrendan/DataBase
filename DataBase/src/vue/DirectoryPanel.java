package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controller.TextFieldListener;

public class DirectoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel searchPanel;
	private JSeparator separator;
	private JTextField searchTexte;
	private JPanel bottomPanel;
	
	protected DirectoryPanel() {
		
		this.setBackground(new Color(46, 49, 54));
		this.setPreferredSize(new Dimension(225, 456));
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(createSearchPanel(), BorderLayout.NORTH);
		this.add(createBottomPanel(), BorderLayout.SOUTH);
	}
	
	private JPanel createSearchPanel() {
		
		this.searchPanel = new JPanel();
		this.searchPanel.setBackground(new Color(46, 49, 53));
		this.searchPanel.setPreferredSize(new Dimension(225, 60));
		this.searchPanel.setLayout(null);
		
		this.searchPanel.add(createSearchTextField());
		this.searchPanel.add(createSeparator());
		
		return this.searchPanel;
	}
	
	private JSeparator createSeparator() {
		
		this.separator = new JSeparator();
		this.separator.setBounds(0, 58, 225, 2);
		this.separator.setForeground(new Color(40, 43, 48));
		this.separator.setBackground(new Color(40, 43, 48));
		
		return this.separator;
	}
	
	private JTextField createSearchTextField() {
		
		this.searchTexte = new JTextField();
		this.searchTexte.setBounds(20, 11, 184, 25);
		this.searchTexte.setMinimumSize(new Dimension(3, 20));
		this.searchTexte.setToolTipText("Dans les bases de donn\u00E9es");
		this.searchTexte.setText("Rechercher...");
		this.searchTexte.setForeground(Color.WHITE);
		this.searchTexte.setBorder(null);
		this.searchTexte.setBackground(new Color(36, 39, 43));
		this.searchTexte.addFocusListener(new TextFieldListener());
		this.searchPanel.add(searchTexte);
		this.searchTexte.setColumns(10);
		
		return this.searchTexte;
	}
	
	private JPanel createBottomPanel() {
		
		this.bottomPanel = new JPanel();
		this.bottomPanel.setBackground(new Color(41, 44, 49));
		this.bottomPanel.setPreferredSize(new Dimension(225, 60));
		
		return this.bottomPanel;
	}
}
