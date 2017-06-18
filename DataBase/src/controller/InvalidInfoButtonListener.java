package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.InvalidInformations;
import vue.LoginFrame;

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
		
		if (arg0.getComponent().equals(InvalidInformations.getInvalidInformations().getOkButton())){
			
			InvalidInformations.getInvalidInformations().setVisible(false);
			
		} else if (arg0.getComponent().equals(InvalidInformations.getInvalidInformations().getCreateNewButton())){
			
			LoginFrame.getLoginFrame().changeContentPanel();
			InvalidInformations.getInvalidInformations().setVisible(false);
			
		}
		
	}

}
