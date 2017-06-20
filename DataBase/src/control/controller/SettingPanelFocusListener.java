package control.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.text.JTextComponent;

import view.vue.AppFrame;

public class SettingPanelFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		
		((JTextComponent) arg0.getSource()).setText("");
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		if (arg0.getComponent().equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getNewLogin())) {
			
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getNewLogin().setText("New Login");
			
		} else if (arg0.getComponent().equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getPassword())) {
			
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSettingPanel().getPassword().setText("Password");
		}
		
	}

}
