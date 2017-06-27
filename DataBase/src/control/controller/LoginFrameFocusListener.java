package control.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.text.JTextComponent;

/**
 * This listener is assigned to the loginFrame textField and set text to "" when the focus is gained
 */
public class LoginFrameFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {

		((JTextComponent) e.getSource()).setText("");

	}

	@Override
	public void focusLost(FocusEvent e) {

	}

}
