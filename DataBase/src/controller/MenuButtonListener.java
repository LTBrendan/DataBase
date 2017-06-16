package controller;

import java.awt.BorderLayout;
import java.awt.Color;
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
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getUserNameLabel())) {
			
			System.out.println("Coming Soon !");
			
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
		}
	}
}
