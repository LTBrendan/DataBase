package control.controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;

import view.vue.AppFrame;

/**
 * This listener is assigned to the textField in the InitializeGame panel and give information of what number the user can enter
 */
public class InitializeGamePanelKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		keyReleased(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getStartButton().setText("Start game");
		AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getStartButton().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		
		try {
			
			int nombre = Integer.parseInt(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getTextField().getText());
			
			if ((nombre > 50) || (nombre < 0)) {
				
				AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getTextField().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
				AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getStartButton().setEnabled(false);
				
			} else {
				
				AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getTextField().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
				AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getStartButton().setEnabled(true);
			
			}
		} catch (NumberFormatException n) {
			
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getInitializeGamePanel().getTextField().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
		
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		keyReleased(arg0);
	}

}
