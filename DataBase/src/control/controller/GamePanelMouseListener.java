package control.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.vue.AppFrame;

public class GamePanelMouseListener implements MouseListener {

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

		if (arg0.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Panel())) {

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setSelectedPanel(
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Panel());
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Label()
					.setForeground(Color.BLUE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Label()
					.setForeground(Color.WHITE);

		} else if (arg0.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Panel())) {

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setSelectedPanel(
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Panel());
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Label()
					.setForeground(Color.BLUE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Label()
					.setForeground(Color.WHITE);

		} else if (arg0.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Panel())) {

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setSelectedPanel(
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Panel());
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Label()
					.setForeground(Color.BLUE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Label()
					.setForeground(Color.WHITE);

		} else if (arg0.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Panel())) {

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setSelectedPanel(
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Panel());
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Label()
					.setForeground(Color.WHITE);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Label()
					.setForeground(Color.BLUE);

		}else if (arg0.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getValidatePanel())) {
			
			if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getSelectedPanel()
					.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Panel())) {

				if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1CheckLabel()
						.getText().equals("1")) {
					
					AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setXp(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP());
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Label()
						.setForeground(Color.GREEN);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().addQuestionInt();
				} else {
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setQuestionXP(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP() - 1);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer1Label()
					.setForeground(Color.RED);
				}

			} else if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getSelectedPanel()
					.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Panel())) {

				if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2CheckLabel()
						.getText().equals("1")) {
					
					AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setXp(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP());
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Label()
						.setForeground(Color.GREEN);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().addQuestionInt();
				} else {
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setQuestionXP(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP() - 1);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer2Label()
					.setForeground(Color.RED);
				}

			} else if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getSelectedPanel()
					.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Panel())) {

				if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3CheckLabel()
						.getText().equals("1")) {
					
					AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setXp(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP());
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Label()
						.setForeground(Color.GREEN);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().addQuestionInt();
				} else {
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setQuestionXP(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP() - 1);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer3Label()
					.setForeground(Color.RED);
				}

			} else if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getSelectedPanel()
					.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Panel())) {

				if (AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4CheckLabel()
						.getText().equals("1")) {
					
					AppFrame.getAppFrame().getLauncherControler().getCurrentUser().setXp(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP());
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Label()
						.setForeground(Color.GREEN);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().addQuestionInt();
				} else {
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().setQuestionXP(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getQuestionXP() - 1);
					
					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getGamePanel().getAnswer4Label()
					.setForeground(Color.RED);
				}

			}
		}

	}

}
