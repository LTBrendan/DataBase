package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.ConfirmDelete;

public class DeleteButtonListener implements MouseListener {

	String login;
	String password;

	public DeleteButtonListener(String login, String password) {
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

		ConfirmDelete.main(new String[]{login, password});

	}

}
