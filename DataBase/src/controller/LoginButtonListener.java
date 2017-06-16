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
		boolean connected = false;
		try {
			if (LoginFrame.getLoginFrame().getLauncherControler().connect(LoginFrame.getLoginFrame().getLoginField().getText(), new String(LoginFrame.getLoginFrame().getPasswordField().getPassword()))) {
				Launcher.main(LoginFrame.getLoginFrame().getLauncherControler());
				connected = true;
			}
		} catch (NullPointerException n){
			
		} finally {
			if (connected == false)
				System.exit(0);
			else
				LoginFrame.getLoginFrame().setVisible(false);
		}
		
	}

}
