package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import control.consoleControler.DatabaseControler;
import control.controller.DirectoryPanelFocusListener;
import control.controller.DirectoryPanelMouseListener;
import logs.Log;
import model.connexion.UserConnexion;

public class DirectoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel searchPanel;
	private JSeparator separator;
	private JLabel infoLabel;

	private JPanel bottomPanel;
	private JLabel addLabel;

	private JPanel centerPanel;
	private JScrollPane centerScrollPane;

	private static DirectoryPanel directoryPanel;

	public DirectoryPanel() {

		this.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
		this.setPreferredSize(new Dimension(225, 456));
		this.setLayout(new BorderLayout(0, 0));

		this.add(createSearchPanel(), BorderLayout.NORTH);
		this.add(createCenterPanel(), BorderLayout.CENTER);
		this.add(createBottomPanel(), BorderLayout.SOUTH);

		directoryPanel = this;
	}

	private JPanel createSearchPanel() {

		this.searchPanel = new JPanel();
		this.searchPanel.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
		this.searchPanel.setPreferredSize(new Dimension(225, 60));
		this.searchPanel.setLayout(null);

		this.searchPanel.add(createInfoLabel());
		this.searchPanel.add(createSeparator());

		return this.searchPanel;
	}

	private JSeparator createSeparator() {

		this.separator = new JSeparator();
		this.separator.setBounds(0, 58, 225, 2);
		this.separator.setForeground(new Color(AppFrame.color - 14, AppFrame.color - 11, AppFrame.color - 6));
		this.separator.setBackground(new Color(AppFrame.color - 14, AppFrame.color - 11, AppFrame.color - 6));

		return this.separator;
	}

	private JLabel createInfoLabel() {

		this.infoLabel = new JLabel();
		this.infoLabel.setBounds(20, 11, 184, 25);
		this.infoLabel.setMinimumSize(new Dimension(3, 20));
		this.infoLabel.setToolTipText("Dans les bases de donn\u00E9es");
		this.infoLabel.setText("Logged as " + AppFrame.getAppFrame().getLauncherControler().getCurrentUserName());
		this.infoLabel.setForeground(Color.WHITE);
		this.infoLabel.setBorder(null);
		this.infoLabel.setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		this.infoLabel.addFocusListener(new DirectoryPanelFocusListener());
		this.searchPanel.add(infoLabel);

		return this.infoLabel;
	}

	private JScrollPane createCenterPanel() {

		this.centerPanel = new JPanel(new GridLayout(15, 1)) {

			private static final long serialVersionUID = 1L;

			@Override
			public Component add(Component comp) {
				if (this.getComponentCount() == 15)
					this.setLayout(new GridLayout(0, 1));
				return super.add(comp);
			}

		};

		this.centerPanel.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
		this.centerPanel.setForeground(new Color(255, 255, 255));

		for (UserConnexion uc : AppFrame.getAppFrame().getLauncherControler().getCurrentUser().getConnexionList()) {

			JPanel connPanel = new JPanel(new BorderLayout());
			connPanel.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));

			JLabel connection = new JLabel(" - " + uc.getConnexionName());
			if (AppFrame.color == 54)
				connection.setForeground(new Color(255, 255, 255));
			else
				connection.setForeground(new Color(0, 0, 0));
			connection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			connection.addMouseListener(
					new DirectoryPanelMouseListener(uc.getAdresse(), uc.getLogin(), uc.getPassword()));

			// connection.setVerticalAlignment(HEIGHT);

			JLabel inLine = new JLabel();
			inLine.setIcon(new ImageIcon("rsc\\dataBase\\ok.png"));
			try {
				AppFrame.setDatabaseControler(new DatabaseControler(uc.getAdresse(), uc.getLogin(), uc.getPassword()));
				Log.database("connection established");
				Log.database("statement created");
			} catch (SQLException e) {
				inLine.setIcon(new ImageIcon("rsc\\dataBase\\error.png"));
			} finally {
				try {
					AppFrame.getDataBaseController().quit();
				} catch (NullPointerException ex) {

				}
				AppFrame.setDatabaseControler(null);
			}
			connPanel.add(connection, BorderLayout.CENTER);
			connPanel.add(inLine, BorderLayout.EAST);
			this.centerPanel.add(connPanel);
		}

		this.centerScrollPane = new JScrollPane(centerPanel);
		this.centerScrollPane.setBorder(null);
		this.centerScrollPane.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));

		return this.centerScrollPane;
	}

	public JPanel createBottomPanel() {

		this.bottomPanel = new JPanel();
		this.bottomPanel.setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		this.bottomPanel.setPreferredSize(new Dimension(225, 60));

		addLabel = new JLabel(" + Add new Connection");
		addLabel.setForeground(Color.WHITE);
		addLabel.addMouseListener(new DirectoryPanelMouseListener(null, null, null));
		addLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.bottomPanel.add(addLabel);

		addLabel.setHorizontalAlignment(JLabel.CENTER);
		addLabel.setVerticalAlignment(bottomPanel.getHeight() / 2);

		return this.bottomPanel;
	}

	public static DirectoryPanel getDirectoryPanel() {
		return directoryPanel;
	}

	public JLabel getAddLabel() {
		return addLabel;
	}

	public void setDirectoryPanel() {
		this.remove(centerScrollPane);
		this.add(createCenterPanel(), BorderLayout.CENTER);
	}

	public void setInfoLabelText(String message) {
		this.infoLabel.setText(message);
	}

}
