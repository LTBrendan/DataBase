package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import logs.Log;
import vue.Launcher;

public class LabelCloseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		try {
			Launcher.getDataBaseController().quit();
			Log.close();
		} catch (NullPointerException h){
			
		} finally {
			System.exit(0);
		}
	}

}
