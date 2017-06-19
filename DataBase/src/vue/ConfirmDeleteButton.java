package vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import connexion.UserManager;

public class ConfirmDeleteButton implements MouseListener {

	String login;
	String password;

	public ConfirmDeleteButton(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (e.getComponent().equals(ConfirmDelete.getConfirmDelete().getOkButton())) {
			
			ConfirmDelete.getConfirmDelete().setVisible(false);
			
			try {
				
				 System.out.println(login);
				 System.out.println(UserManager.decrypt(password));
				 Launcher.getLauncher().getLauncherControler().removeUser(login,
				 UserManager.decrypt(password));
				 
			} catch (Exception u){
				
			}
			
		} else {
			
			ConfirmDelete.getConfirmDelete().setVisible(false);
			
		}
	}

}
