package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.InvalidInfoDialog;
import view.vue.AppFrame;
import view.vue.LoginFrame;

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

		} else if (arg0.getComponent().equals(LoginFrame.getLoginFrame().getCreateNewUserLoginLabel())) {

			LoginFrame.getLoginFrame().createUserContentPanel();

		} else if (arg0.getComponent().equals(LoginFrame.getLoginFrame().getCreateUserButton())) {

			try {
				LoginFrame.getLoginFrame().getLauncherControler().addUser(
						LoginFrame.getLoginFrame().getLoginField().getText(),
						new String(LoginFrame.getLoginFrame().getCreateUserPasswordField().getPassword()));
				LoginFrame.getLoginFrame().getLauncherControler().save();

				LoginFrame.getLoginFrame().loginContentPanel();
			} catch (Exception e) {

			}

		}

	}

}
