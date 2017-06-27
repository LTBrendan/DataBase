package view.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class ExportChooserListener implements ActionListener {
	
	private JFileChooser jfc;
	
	public ExportChooserListener (JFileChooser jfc) {
		this.jfc = jfc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/*Runtime.getRuntime().exec("exp "+AppFrame.getDataBaseController().getCurrentConnexion().getLogin()+"/"+AppFrame.getDataBaseController().getCurrentConnexion().getPassword()+" full=yes consistent=yes file='"+jfc.getSelectedFile().getPath()+".dmp' log='"+jfc.getSelectedFile().getPath()+".dmp.log'");
		} catch (IOException ex) {*/
			System.out.println(AppFrame.getDataBaseController().getCurrentConnexion().getLogin());
			System.out.println(AppFrame.getDataBaseController().getCurrentConnexion().getPassword());
			System.out.println(jfc.getSelectedFile().getPath());

		} catch (NullPointerException ex){
			
		}
	}

}
