package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import vue.DetailPanel;
import vue.Launcher;
import vue.MainPanel;

public class MenuButtonListener implements MouseListener {

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

		if (e.getComponent().equals(Launcher.getStatePanel().getAvatarLabel())) {
			
			DetailPanel.setPreSettingPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getWorkPanel().getExecuteLabel())) {
			
			JLabel label = new JLabel(
					Launcher.getMainPanel().getDetailPanel().getWorkPanel().getTextPane().getText() + ":\n");
			if (Launcher.color == 54)
				label.setForeground(new Color(255, 255, 255));
			else 
				label.setForeground(new Color(0, 0, 0));
			Launcher.getMainPanel().getDetailPanel().getWorkPanel();
			Launcher.getMainPanel().getDetailPanel().getWorkPanel().getUpPanel().add(label, BorderLayout.NORTH);
			Launcher.getMainPanel().getDetailPanel().revalidate();
			Launcher.getMainPanel().getDetailPanel().repaint();
			
		}else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getPreSettingPanel().getSettingLabel())){
			
			DetailPanel.setSettingPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		}else if (e.getComponent().equals(Launcher.getStatePanel().getEditor())) {
			
			DetailPanel.setWorkPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getHome())) {
			
			DetailPanel.setHomePanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getMaximizeLabel())) {
			
			Launcher.getFrame().setLocationRelativeTo(null);
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getMinimizeLabel())) {
			
			Launcher.getFrame().setState(Frame.ICONIFIED);
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getSearch())) {
			
			DetailPanel.setSearchPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getSettingPanel().getValidateButton())) {
			
			Launcher.getLauncher().getLauncherControler().changeLogin(Launcher.getLauncher().getLauncherControler().getCurrentUserName(), new String(Launcher.getMainPanel().getDetailPanel().getSettingPanel().getNewPassword().getPassword()), Launcher.getMainPanel().getDetailPanel().getSettingPanel().getNewLogin().getText());
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getAdmin())) {
			
			DetailPanel.setAdminPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		}
	}
}
