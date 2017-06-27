package view.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;

public class ExportChooserListener implements ActionListener {

	private JFileChooser jfc;

	public ExportChooserListener(JFileChooser jfc) {
		this.jfc = jfc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {

			try {

				Runtime.getRuntime()
						.exec("exp " + AppFrame.getDataBaseController().getCurrentConnexion().getLogin() + "/"
								+ AppFrame.getDataBaseController().getCurrentConnexion().getPassword()
								+ " full=yes consistent=yes file='" + jfc.getSelectedFile().getPath() + ".dmp' log='"
								+ jfc.getSelectedFile().getPath() + ".dmp.log'");

			} catch (IOException ex) {

			} catch (NullPointerException ex) {
				AppFrame.getAppFrame().getMainPanel().getDirectoryPanel()
						.setInfoLabelText("You must be connected to a database");

			}

		} else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {

		}
	}

}
