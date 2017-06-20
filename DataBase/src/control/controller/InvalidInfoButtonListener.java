package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.InvalidInfoDialog;
import view.vue.LoginFrame;

public class InvalidInfoButtonListener implements MouseListener {

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
		
		if (arg0.getComponent().equals(InvalidInfoDialog.getInvalidInfoDialog().getOkButton())){
			
			InvalidInfoDialog.getInvalidInfoDialog().setVisible(false);
			
		} else if (arg0.getComponent().equals(InvalidInfoDialog.getInvalidInfoDialog().getCreateNewButton())){
			
			LoginFrame.getLoginFrame().createUserContentPanel();
			InvalidInfoDialog.getInvalidInfoDialog().setVisible(false);
			
		} else if (arg0.getComponent().equals(LoginFrame.getLoginFrame().getCreateNewUserLoginLabel())) {
			
			LoginFrame.getLoginFrame().createUserContentPanel();
			
		}
		
	}

}
