package control.controller;

import java.awt.Color;
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
			
			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getHomePanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getHomePanel());
			
			WorkPanel.setHomePanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getEditor())) {
			
			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getEditorPanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getEditorPanel());
			
			WorkPanel.setQueryPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getSearch())) {

			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getSearchPanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getSearchPanel());
			
			WorkPanel.setSearchPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getVisual())) {

			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getVisualPanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getVisualPanel());
			
			WorkPanel.setVisualPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getStats())) {
			
			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getStatsPanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getStatsPanel());
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getGame())) {
			
			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getGamePanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getGamePanel());
			
			WorkPanel.setGamePanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getExport())) {
			
			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getExportPanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getExportPanel());
			
		} else if (e.getComponent().equals(AppFrame.getAppFrame().getMenuPanel().getAdmin())) {

			AppFrame.getAppFrame().getMenuPanel().getActualPanel().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
			AppFrame.getAppFrame().getMenuPanel().getAdminPanel().setBackground(new Color(AppFrame.color - 8, AppFrame.color - 5, AppFrame.color));
			AppFrame.getAppFrame().getMenuPanel().setActualPanel(AppFrame.getAppFrame().getMenuPanel().getAdminPanel());
			
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
