package control.controller;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.AppFrame;

public class WorkPanelMouseListener implements MouseListener {

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

		if (e.getComponent().equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getMaximizeLabel())) {

			AppFrame.getFrame().setLocationRelativeTo(null);

		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getMinimizeLabel())) {

			AppFrame.getFrame().setState(Frame.ICONIFIED);

		}

	}

}
