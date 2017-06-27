package control.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.vue.InvalidInfoDialog;
import view.vue.AppFrame;
import view.vue.LoginFrame;

/**
 * This listener is assigned to the loginFrame textFields and allow to login by pressing enter
 */
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
