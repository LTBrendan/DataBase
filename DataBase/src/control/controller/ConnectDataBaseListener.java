package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import control.consoleControler.DatabaseControler;
import logs.Log;
import view.vue.AppFrame;

public class ConnectDataBaseListener implements MouseListener {

	String adress, login, password;

	public ConnectDataBaseListener(String connectionAdress, String connectionLogin, String connectionPassword) {
		adress = connectionAdress;
		login = connectionLogin;
		password = connectionPassword;
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
		try {
			AppFrame.getDataBaseController().quit();
			AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("Disconnected from the database");

		} catch (NullPointerException e) {

		}
		try {
			AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("Connecting to database");
			AppFrame.setDatabaseControler(new DatabaseControler(adress, login, password));
			Log.database("connection established");
			Log.database("statement created");
			AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("Connected to database");
		} catch (SQLException ex) {
			AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("Connection error");
			Log.database("connection error");
		}
	}

}
