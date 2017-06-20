package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.AppFrame;
import view.vue.MainPanel;
import view.vue.WorkPanel;

public class MenuPanelMouseListener implements MouseListener {

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
		
		if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getHome())) {
			
			WorkPanel.setHomePanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getEditor())) {

			WorkPanel.setQueryPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getSearch())) {

			WorkPanel.setSearchPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getVisual())) {

		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getStats())) {
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getGame())) {
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getExport())) {
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getAdmin())) {

			WorkPanel.setAdminPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getAvatarLabel())) {

			WorkPanel.setOptionPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		}
		
	}

}
