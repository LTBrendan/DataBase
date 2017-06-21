package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.AppFrame;
import view.vue.MainPanel;
import view.vue.WorkPanel;

public class NewDataBaseMouseListener implements MouseListener {

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
		
		if (arg0.getComponent().equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getNewConnection().getAddDatabaseButton())) {

			AppFrame.getAppFrame().getLauncherControler().addDatabase(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getNewConnection().getNameField().getText(),AppFrame.getAppFrame().getMainPanel().getWorkPanel().getNewConnection().getAdressField().getText(),AppFrame.getAppFrame().getMainPanel().getWorkPanel().getNewConnection().getLoginField().getText(),AppFrame.getAppFrame().getMainPanel().getWorkPanel().getNewConnection().getPasswordField().getText());
			
			AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setDirectoryPanel();
			
			WorkPanel.setQueryPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		}
		
	}

}
