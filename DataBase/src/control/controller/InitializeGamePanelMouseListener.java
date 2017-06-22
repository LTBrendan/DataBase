package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.AppFrame;

public class InitializeGamePanelMouseListener implements MouseListener {

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
		
		AppFrame.getAppFrame().getMainPanel().getWorkPanel().initialiseGame(Integer.parseInt(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getTextField().getText()));
		AppFrame.getAppFrame().getMainPanel().getWorkPanel().addQuestionInt();
		
	}

}
