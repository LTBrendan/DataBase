package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vue.InvalidInformations;
import vue.Launcher;
import vue.LoginFrame;

public class KeyboardListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
			
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
		}
		
	}

}
