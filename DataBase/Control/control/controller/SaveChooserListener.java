package control.controller;
import static model.utils.RWFile.write;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;


/**
 * This listener is assigned to aJFileChooser and is used to save a script in a file
 */
public class SaveChooserListener implements ActionListener {
	
	private JFileChooser jfc;
	private String script;
	
	public SaveChooserListener (JFileChooser saveJFC, String script) {
		
		this.jfc = saveJFC;
		this.script = script;
		
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
			String file = jfc.getSelectedFile().getPath();
			write (file, script);
			
		} else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
			
		}
		
	}
	
}
