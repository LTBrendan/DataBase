package control.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.text.JTextComponent;

public class LoginFrameFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {

		((JTextComponent) e.getSource()).setText("");

	}

	@Override
	public void focusLost(FocusEvent e) {

	}

}
