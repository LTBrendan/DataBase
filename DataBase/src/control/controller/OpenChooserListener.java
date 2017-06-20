package control.controller;

import static model.utils.RWFile.read;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import view.vue.Launcher;

public class OpenChooserListener implements ActionListener {

	private JFileChooser jfc;

	public OpenChooserListener(JFileChooser jfc) {
		this.jfc = jfc;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
			
			Launcher.getMainPanel().getDetailPanel().getWorkPanel().getTextPane().setText(read (jfc.getSelectedFile()));
			
		} else if (e.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
			
		}
	}
}
