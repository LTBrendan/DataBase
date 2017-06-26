package control.controller;

import static model.utils.RWFile.read;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import view.vue.AppFrame;

/**
* This method is assigned to a JFileChooser and allow to open a script
*/
public class OpenChooserListener implements ActionListener {

	private JFileChooser jfc;

	public OpenChooserListener(JFileChooser jfc) {
		this.jfc = jfc;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
			
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getTextPane().setText(read (jfc.getSelectedFile()));
			
		} else if (e.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
			
		}
	}
}
