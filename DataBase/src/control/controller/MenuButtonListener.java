package control.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.exception.ExceptionHandler;
import view.vue.WorkPanel;
import view.vue.AppFrame;
import view.vue.MainPanel;

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

		 if (e.getComponent()
				.equals(AppFrame.getMainPanel().getWorkPanel().getPreSettingPanel().getSettingLabel())) {

			WorkPanel.setSettingPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent().equals(AppFrame.getMainPanel().getWorkPanel().getMaximizeLabel())) {

			AppFrame.getFrame().setLocationRelativeTo(null);

		} else if (e.getComponent().equals(AppFrame.getMainPanel().getWorkPanel().getMinimizeLabel())) {

			AppFrame.getFrame().setState(Frame.ICONIFIED);

		} else if (e.getComponent().equals(AppFrame.getMainPanel().getDirectoryPanel().getAddLabel())) {

			WorkPanel.setNewConnection();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent()
				.equals(AppFrame.getMainPanel().getWorkPanel().getNewConnection().getAddDatabaseButton())) {

			AppFrame.getAppFrame().getLauncherControler().addDatabase(
					AppFrame.getMainPanel().getWorkPanel().getNewConnection().getNameField().getText(),
					AppFrame.getMainPanel().getWorkPanel().getNewConnection().getAdressField().getText(),
					AppFrame.getMainPanel().getWorkPanel().getNewConnection().getLoginField().getText(),
					AppFrame.getMainPanel().getWorkPanel().getNewConnection().getPasswordField().getText());
			AppFrame.getMainPanel().getDirectoryPanel().setDirectoryPanel();
			WorkPanel.setQueryPanel();
			MainPanel.getMainPanel().getWorkPanel().revalidate();
			MainPanel.getMainPanel().getWorkPanel().repaint();

		}
	}
}
