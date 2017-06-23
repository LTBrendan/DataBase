package control.controller;
import static model.utils.RWFile.write;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;


public class SaveChooserListener implements ActionListener {
	
	private FileDialog jfc;
	private String script;
	
	public SaveChooserListener (FileDialog saveJFC, String script) {
		
		this.jfc = saveJFC;
		this.script = script;
		
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
			String file = jfc.getDirectory();
			write (file, script);
			
		} else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
			
		}
		
	}
	
}
