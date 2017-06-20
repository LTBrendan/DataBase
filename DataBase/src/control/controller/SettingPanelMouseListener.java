package control.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.AppFrame;

public class SettingPanelMouseListener implements MouseListener {

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
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getDarkThemeButton())) {

			if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getDarkThemeButton()
					.isSelected()) {
				AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setColor(54);
				AppFrame.getAppFrame().getLauncherControler().save();
			} else {
				AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setColor(247);
				AppFrame.getAppFrame().getLauncherControler().save();
			}

		} else if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getWhiteThemeButton())) {

			if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getWhiteThemeButton()
					.isSelected()) {
				AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setColor(247);
				AppFrame.getAppFrame().getLauncherControler().save();
			} else {
				AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setColor(54);
				AppFrame.getAppFrame().getLauncherControler().save();
			}

		} else if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getValidateButton())) {

			AppFrame.getAppFrame().getLauncherControler().changeLogin(
					AppFrame.getAppFrame().getLauncherControler().getCurrentUserName(),
					new String(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getPassword()
							.getPassword()),
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getNewLogin().getText());

		}
	}

}
