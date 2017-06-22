package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import control.controller.DirectoryPanelFocusListener;
import control.controller.DirectoryPanelMouseListener;
import model.connexion.UserConnexion;

public class DirectoryPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JPanel searchPanel;
	private JLabel infoLabel;

	private JPanel bottomPanel;
	private JLabel addLabel;

	private JPanel centerPanel;
	private JScrollPane centerScrollPane;

	private static DirectoryPanel directoryPanel;
	
	public static int width = MainPanel.width / 6;
	public static int height = MainPanel.height;

	/**
	 * Construct a new DirectoryPanel
	 */
	public DirectoryPanel() {

		this.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());

		this.add(createSearchPanel(), BorderLayout.NORTH);
		this.add(createCenterPanel(), BorderLayout.CENTER);
		this.add(createBottomPanel(), BorderLayout.SOUTH);

		directoryPanel = this;
	}

	/**
	 * Create the searchPanel and return it
	 * @return the created searchPanel
	 */
	private JPanel createSearchPanel() {

		this.searchPanel = new JPanel();
		this.searchPanel.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
		this.searchPanel.setPreferredSize(new Dimension(width, height / 15));
		this.searchPanel.setLayout(new BorderLayout());

		this.searchPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(AppFrame.color - 14, AppFrame.color - 11, AppFrame.color - 6)));
		
		this.searchPanel.add(createInfoLabel());

		return this.searchPanel;
	}

	/**
	 * Create the infoLabel and return it
	 * @return the created infoLabel
	 */
	private JLabel createInfoLabel() {

		this.infoLabel = new JLabel();
		this.infoLabel.setText("Logged as " + AppFrame.getAppFrame().getLauncherControler().getCurrentUserName());
		this.infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.infoLabel.setForeground(Color.WHITE);
		this.infoLabel.setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		this.infoLabel.addFocusListener(new DirectoryPanelFocusListener());

		return this.infoLabel;
	}

	/**
	 * Create the centerPanel and return it
	 * @return the created centerPanel
	 */
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
			JLabel inLine = new JLabel ();
			if (AppFrame.color == 54)
				connection.setForeground(new Color(255, 255, 255));
			else
				connection.setForeground(new Color(0, 0, 0));
			connection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			connection.addMouseListener(
					new DirectoryPanelMouseListener(uc.getAdresse(), uc.getLogin(), uc.getPassword(), inLine));
			connPanel.add(connection, BorderLayout.CENTER);
			connPanel.add(inLine, BorderLayout.EAST);
			this.centerPanel.add(connPanel);
		}

		this.centerScrollPane = new JScrollPane(centerPanel);
		this.centerScrollPane.setBorder(null);
		this.centerScrollPane.setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));

		return this.centerScrollPane;
	}

	/**
	 * Create the bottomPanel and return it
	 * @return the created bottomPanel
	 */
	public JPanel createBottomPanel() {

		this.bottomPanel = new JPanel(new BorderLayout());
		this.bottomPanel.setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		this.bottomPanel.setPreferredSize(new Dimension(width, height / 15));

		this.addLabel = new JLabel("Add new Connection");
		this.addLabel.setForeground(Color.WHITE);
		this.addLabel.addMouseListener(new DirectoryPanelMouseListener(null, null, null, null));
		this.addLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.addLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.bottomPanel.add(this.addLabel, BorderLayout.CENTER);

		return this.bottomPanel;
	}

	/**
	 * Getter for this directoryPanel
	 * @return this directoryPanel
	 */
	public static DirectoryPanel getDirectoryPanel() {
		return directoryPanel;
	}

	/**
	 * Getter for the addLabel
	 * @return the addLabel
	 */
	public JLabel getAddLabel() {
		return addLabel;
	}

	/**
	 * Reset the centerScrollPanel
	 */
	public void setDirectoryPanel() {
		this.remove(centerScrollPane);
		this.add(createCenterPanel(), BorderLayout.CENTER);
	}

	/**
	 * Set the message in parameter in the infoLabel
	 * @param message the message to display
	 */
	public void setInfoLabelText(String message) {
		this.infoLabel.setText(message);
	}
	
}
