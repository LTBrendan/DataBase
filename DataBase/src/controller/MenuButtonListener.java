package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import vue.DetailPanel;
import vue.Launcher;
import vue.MainPanel;
import vue.PreSettingPanel;

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
			DetailPanel.setWorkPanel(new PreSettingPanel());
			MainPanel.getMainPanel().getDetailPanel().revalidate();
		}

		if (e.getComponent().equals(Launcher.getStatePanel().getUserNameLabel())) {
			System.out.println("Coming Soon !");
		}

		if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getWorkPanel().getExecuteLabel())) {
			JLabel label = new JLabel(
					Launcher.getMainPanel().getDetailPanel().getWorkPanel().getTextPane().getText() + ":\n");
			label.setForeground(new Color(255, 255, 255));
			Launcher.getMainPanel().getDetailPanel().getWorkPanel();
			Launcher.getMainPanel().getDetailPanel().getWorkPanel().getUpPanel().add(label, BorderLayout.NORTH);

			Launcher.getMainPanel().getDetailPanel().revalidate();
		}
	}
}
