package control.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.text.JTextComponent;

/**
*This method is assigned to the textFields in the setting panel and set the text to "" when focus is gained
*/
public class SettingPanelFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		
		((JTextComponent) arg0.getSource()).setText("");
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
	}

}
