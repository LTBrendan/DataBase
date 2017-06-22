package control.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

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
		
		try {
			
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().initialiseGame(Integer.parseInt(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getTextField().getText()));
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().addQuestionInt();
			
		} catch (NullPointerException e) {
			
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getStartButton().setText("You need to be connected to a database !");
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getStartButton().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
			
		}
		
	}

}
