package controller;
import static utils.RWFile.write;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;


public class SaveChooserListener implements ActionListener {
	
	private JFileChooser jfc;
	private String script;
	
	public SaveChooserListener (JFileChooser jfc, String script) {
		
		this.jfc = jfc;
		this.script = script;
		
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
			
			String file = jfc.getSelectedFile ().getPath ();
			write (file, script);
			
		} else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
			
		}
		
	}
	
}
