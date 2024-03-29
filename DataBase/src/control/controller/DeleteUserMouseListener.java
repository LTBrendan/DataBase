package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.ConfirmUserDeleteDialog;

/**
 * This use ris assigned to the deleteUser label for the administrator. It makes the confirmDeleteUser dialog to pup.
 */
public class DeleteUserMouseListener implements MouseListener {

	String login;
	String password;

	public DeleteUserMouseListener(String login, String password) {
		this.login = login;
		this.password = password;
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

		ConfirmUserDeleteDialog.main(new String[]{login, password});

	}

}
