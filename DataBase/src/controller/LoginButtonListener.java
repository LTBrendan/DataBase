package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.Launcher;
import vue.LoginFrame;

public class LoginButtonListener implements MouseListener {

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
		LoginFrame.getLoginFrame().setVisible(false);
		Launcher.main();
	}

}
