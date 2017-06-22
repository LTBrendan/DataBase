package control.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.vue.AppFrame;

public class InitializeGamePanelKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		int nombre = Integer.parseInt(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getTextField().getText());
		if ((nombre > 50) || (nombre < 0)) {
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
