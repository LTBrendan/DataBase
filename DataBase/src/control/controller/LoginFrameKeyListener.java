package control.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.vue.AppFrame;
import view.vue.InvalidInfoDialog;
import view.vue.LoginFrame;

public class LoginFrameKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		if (arg0.getComponent().equals(LoginFrame.getLoginFrame().getConfirmPasswordField())) {
			if (!(new String(LoginFrame.getLoginFrame().getConfirmPasswordField().getPassword()).equalsIgnoreCase(new String(LoginFrame.getLoginFrame().getCreateUserPasswordField().getPassword())))){
				LoginFrame.getLoginFrame().getWrongPasswordLabel().setVisible(true);
			} else {
				LoginFrame.getLoginFrame().getWrongPasswordLabel().setVisible(false);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		if ((arg0.getComponent().equals(LoginFrame.getLoginFrame().getLoginField())) || (arg0.getComponent().equals(LoginFrame.getLoginFrame().getPasswordField()))) {
		
			if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
	
				boolean connected = false;
				try {
	
					if (LoginFrame.getLoginFrame().getLauncherControler().connect(
							LoginFrame.getLoginFrame().getLoginField().getText(),
							new String(LoginFrame.getLoginFrame().getPasswordField().getPassword()))) {
						AppFrame.main(LoginFrame.getLoginFrame().getLauncherControler());
						connected = true;
					}
	
				} catch (NullPointerException n) {
	
				} finally {
	
					if (connected == false)
						InvalidInfoDialog.main(null);
					else
						LoginFrame.getLoginFrame().setVisible(false);
	
				}
			}
		}
	}

}
