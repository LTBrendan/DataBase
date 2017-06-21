package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.AppFrame;
import view.vue.MainPanel;
import view.vue.WorkPanel;

public class OptionPanelMouseListener implements MouseListener {

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

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getOptionPanel().getSettingLabel())) {

			WorkPanel.setSettingPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		}

	}

}
