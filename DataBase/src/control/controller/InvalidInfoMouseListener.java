package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.InvalidInfoDialog;
import view.vue.LoginFrame;

/**
 * This listener is assigned to the dialog advertising the user entered the wrong informations and allow to create a new user
 */
public class InvalidInfoMouseListener implements MouseListener {

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
		
		if (e.getComponent().equals(InvalidInfoDialog.getInvalidInfoDialog().getOkButton())){

			InvalidInfoDialog.getInvalidInfoDialog().dispose();
			
		} else if (e.getComponent().equals(InvalidInfoDialog.getInvalidInfoDialog().getCreateNewButton())){
			
			LoginFrame.getLoginFrame().createUserContentPanel();
			InvalidInfoDialog.getInvalidInfoDialog().dispose();
			
		} else if (e.getComponent().equals(LoginFrame.getLoginFrame().getCreateNewUserLoginLabel())) {
			
			LoginFrame.getLoginFrame().createUserContentPanel();
			
		}
		
	}

}
