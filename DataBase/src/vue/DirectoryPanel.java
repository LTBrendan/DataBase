package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import connexion.UserConnexion;
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
	
	private JPanel centerPanel;
	private JScrollPane centerScrollPane;
	
	private static DirectoryPanel directoryPanel;
	
	public DirectoryPanel() {
		
		this.setBackground(new Color(Launcher.color - 8, Launcher.color - 5, Launcher.color));
		this.setPreferredSize(new Dimension(225, 456));
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(createSearchPanel(), BorderLayout.NORTH);
		this.add(createCenterPanel(), BorderLayout.CENTER);
		this.add(createBottomPanel(), BorderLayout.SOUTH);
		
		directoryPanel = this;
	}
	
	private JPanel createSearchPanel() {
		
		this.searchPanel = new JPanel();
		this.searchPanel.setBackground(new Color(Launcher.color - 8, Launcher.color - 5, Launcher.color));
		this.searchPanel.setPreferredSize(new Dimension(225, 60));
		this.searchPanel.setLayout(null);
		
		this.searchPanel.add(createSearchTextField());
		this.searchPanel.add(createSeparator());
		
		return this.searchPanel;
	}
	
	private JSeparator createSeparator() {
		
		this.separator = new JSeparator();
		this.separator.setBounds(0, 58, 225, 2);
		this.separator.setForeground(new Color(Launcher.color - 14, Launcher.color - 11, Launcher.color - 6));
		this.separator.setBackground(new Color(Launcher.color - 14, Launcher.color - 11, Launcher.color - 6));
		
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
		this.searchTexte.setBackground(new Color(Launcher.color - 24, Launcher.color - 21, Launcher.color - 18));
		this.searchTexte.addFocusListener(new TextFieldListener());
		this.searchPanel.add(searchTexte);
		this.searchTexte.setColumns(10);
		
		return this.searchTexte;
	}
	
	private JScrollPane createCenterPanel() {
		
		this.centerPanel = new JPanel(new GridLayout(1, 1));
		this.centerPanel.setBackground(new Color(Launcher.color - 8, Launcher.color - 5, Launcher.color));
		this.centerPanel.setForeground(new Color(255,255,255));
		
		for (UserConnexion uc : Launcher.getLauncher().getLauncherControler().getCurrentUser().getConnexionList()) {
			JLabel connection = new JLabel(" - " + uc.getConnexionName());
			if (Launcher.color == 54)
				connection.setForeground(new Color(255,255,255));
			else
				connection.setForeground(new Color(0,0,0));
				
			//connection.setVerticalAlignment(HEIGHT);
			this.centerPanel.add(connection);
		}

		this.centerScrollPane = new JScrollPane(centerPanel);
		this.centerScrollPane.setBorder(null);
		this.centerScrollPane.setBackground(new Color(Launcher.color - 8, Launcher.color - 5, Launcher.color));
		
		return this.centerScrollPane;
	}
	
	public JPanel createBottomPanel() {
		
		this.bottomPanel = new JPanel();
		this.bottomPanel.setBackground(new Color(Launcher.color - 24, Launcher.color - 21, Launcher.color - 18));
		this.bottomPanel.setPreferredSize(new Dimension(225, 60));
		
		JLabel addLabel = new JLabel(" + Add new Connection");
		addLabel.setForeground(Color.WHITE);
		this.bottomPanel.add(addLabel);
		
		addLabel.setHorizontalAlignment(JLabel.CENTER);
		addLabel.setVerticalAlignment(bottomPanel.getHeight() / 2);
		
		return this.bottomPanel;
	}
	
	public static DirectoryPanel getDirectoryPanel() {
		return directoryPanel;
	}
}
