package view.vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ExportPanelMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		JFileChooser jfc = new JFileChooser ();
		JFrame frame = new JFrame ();
		jfc.addActionListener(new ExportChooserListener(jfc));
		jfc.showSaveDialog(frame);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
