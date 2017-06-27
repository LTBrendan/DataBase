package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import control.consoleControler.DatabaseControler;
import logs.Log;
import model.connexion.UserConnexion;
import view.vue.AppFrame;
import view.vue.MainPanel;
import view.vue.WorkPanel;

/**
 * This listener is assigned to the database labels and allow to connect to a database. If an exception occurs, set the icon to red, green if no exception
 */
public class DirectoryPanelMouseListener implements MouseListener {

	UserConnexion uc;
	private JLabel inLine;

	public DirectoryPanelMouseListener(UserConnexion uc, JLabel inLine) {
		this.uc = uc;
		this.inLine = inLine;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		if (arg0.getComponent().equals(AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().getAddLabel())) {

			WorkPanel.setNewConnection();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else {
			try {
				AppFrame.getDataBaseController().quit();
				AppFrame.getAppFrame().getMainPanel().getDirectoryPanel()
						.setInfoLabelText("Disconnected from the database");

			} catch (NullPointerException e) {

			}
			try {
				AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("Connecting to database");
				AppFrame.setDatabaseControler(new DatabaseControler(uc.getAdresse(), uc.getLogin(), uc.getPassword()));
				Log.database("connection established");
				Log.database("statement created");
				AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("Connected to database");
				this.inLine.setIcon(new ImageIcon ("rsc\\dataBase\\ok.png"));
			} catch (SQLException ex) {
				AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("Connection error");
				this.inLine.setIcon(new ImageIcon ("rsc\\dataBase\\error.png"));
				Log.database("connection error");
			}
		}
	}

}
