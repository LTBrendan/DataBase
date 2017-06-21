package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.connexion.UserManager;
import view.vue.AppFrame;
import view.vue.ConfirmUserDeleteDialog;

public class ConfirmUserDeleteMouseListener implements MouseListener {

	String login;
	String password;

	public ConfirmUserDeleteMouseListener(String login, String password) {
		this.login = login;
		this.password = password;
	}

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

		if (e.getComponent().equals(ConfirmUserDeleteDialog.getConfirmUserDeleteDialog().getOkButton())) {

			ConfirmUserDeleteDialog.getConfirmUserDeleteDialog().setVisible(false);

			try {
				AppFrame.getAppFrame().getLauncherControler().removeUser(login, UserManager.decrypt(password));
			} catch (Exception u) {

			}

		} else {
			ConfirmUserDeleteDialog.getConfirmUserDeleteDialog().setVisible(false);
		}

	}

}
