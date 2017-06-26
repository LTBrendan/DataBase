package control.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.text.JTextComponent;

/**
* This listener set the text to "" when a text field gain focus
*/
public class TextFieldListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent arg0) {
		((JTextComponent) arg0.getSource()).setText("");

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
	}

	
	
}
