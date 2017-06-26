package control.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.text.JTextComponent;

/**
 * This listener is assigned to the searchPanel and set the text to "" when the textField get the focus
 */
public class SearchPanelFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {

		((JTextComponent) e.getSource()).setText("");

	}

	@Override
	public void focusLost(FocusEvent e) {

	}

}
