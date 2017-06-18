package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.InvalidInformations;
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
		
		if (arg0.getComponent().equals(LoginFrame.getLoginFrame().getLoginButton())) {
			boolean connected = false;
			try {
				
				if (LoginFrame.getLoginFrame().getLauncherControler().connect(LoginFrame.getLoginFrame().getLoginField().getText(), new String(LoginFrame.getLoginFrame().getPasswordField().getPassword()))) {
					Launcher.main(LoginFrame.getLoginFrame().getLauncherControler());
					connected = true;
				}
				
			} catch (NullPointerException n){
				
			} finally {
				
				if (connected == false)
					InvalidInformations.main(null);
				else
					LoginFrame.getLoginFrame().setVisible(false);
				
			}
		
		} else if (arg0.getComponent().equals(LoginFrame.getLoginFrame().getCreateNewUserLoginLabel())) {
			
			LoginFrame.getLoginFrame().changeContentPanel();
			
		}
		
	}

}
