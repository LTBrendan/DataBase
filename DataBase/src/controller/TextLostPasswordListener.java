package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextLostPasswordListener implements MouseListener {

	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Enter a new password");
	}

	public void mouseEntered(MouseEvent arg0) {	
		mouseClicked(arg0);
	}

	public void mouseExited(MouseEvent arg0) {
		mouseClicked(arg0);
	}

	public void mousePressed(MouseEvent arg0) {
		mouseClicked(arg0);
	}

	public void mouseReleased(MouseEvent arg0) {
		mouseClicked(arg0);
	}

}
