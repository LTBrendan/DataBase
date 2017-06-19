package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel notConnectedPanel;

	private JPanel connectedPanel;
	private JPanel tableListPanel;
	private JScrollPane tableListScrollPane;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {

		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setLayout(new BorderLayout(0, 0));
		
		try {
			add(connectedPanel(), BorderLayout.EAST);
		} catch (Exception p) {
			add(notConnectedPanel(), BorderLayout.EAST);
		}
	}

	private JPanel notConnectedPanel() {

		notConnectedPanel = new JPanel(new FlowLayout());
		notConnectedPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		
		JLabel notConnected = new JLabel("You are not connected to a dataBase, please connect and try again");
		notConnected.setForeground(Color.WHITE);
		
		notConnectedPanel.add(notConnected);
		
		return notConnectedPanel;
	}

	private JPanel connectedPanel() {
		
		connectedPanel = new JPanel();

		this.tableListPanel = new JPanel(new GridLayout(15, 1)) {

			private static final long serialVersionUID = 1L;

			@Override
			public Component add(Component comp) {
				if (this.getComponentCount() == 15)
					this.setLayout(new GridLayout(0, 1));
				return super.add(comp);
			}

		};

		this.tableListPanel.setBackground(new Color(Launcher.color - 8, Launcher.color - 5, Launcher.color));
		this.tableListPanel.setForeground(new Color(255, 255, 255));

		for (String tn : Launcher.getDataBaseController().getTableName()) {
			JLabel connection = new JLabel(" - " + tn);
			if (Launcher.color == 54)
				connection.setForeground(new Color(255, 255, 255));
			else
				connection.setForeground(new Color(0, 0, 0));

			// connection.setVerticalAlignment(HEIGHT);
			this.tableListPanel.add(connection);
		}

		this.tableListScrollPane = new JScrollPane(tableListPanel);
		this.tableListScrollPane.setBorder(null);
		this.tableListScrollPane.setBackground(new Color(Launcher.color - 8, Launcher.color - 5, Launcher.color));

		connectedPanel.add(tableListScrollPane);
		
		return connectedPanel;
	}

	public void setConnectedPanel() {
		
		this.remove(notConnectedPanel);
		this.add(connectedPanel);
	
	}
	
	public void setNotConnectedPanel() {
		
		this.remove(connectedPanel);
		this.add(notConnectedPanel);
		
	}
	
	public void changePanel() {
		
		try {
			add(connectedPanel(), BorderLayout.EAST);
		} catch (Exception p) {
			add(notConnectedPanel(), BorderLayout.EAST);
		}
		
	}
	
}
