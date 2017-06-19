package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.Launcher;

public class ConnectDataBaseListener implements MouseListener {

	String name;
	
	public ConnectDataBaseListener(String connectionName) { 
		name = connectionName;
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
		Launcher.getLauncher().getLauncherControler().connectDatabase(name);
	}

}
