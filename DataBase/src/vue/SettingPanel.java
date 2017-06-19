package vue;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MenuButtonListener;
import controller.TextFieldListener;

public class SettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel themePanel;
	private JLabel themeLabel;
	private ButtonGroup themeButton;
	private JRadioButton darkThemeButton;
	private JRadioButton whiteThemeButton;
	
	private JPanel changeUserPanel;
	private JLabel changeUserLabel;
	private JButton validateChange;
	private JPasswordField newPassword;
	private JTextField newLogin;
	
	private static SettingPanel settingPanel;

	public SettingPanel() {

		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setLayout(new GridLayout(5, 5, 0, 0));

		this.add(createChangeThemePanel());
		this.add(createChangeLoginPanel());

		settingPanel = this;
	}

	public JPanel createChangeThemePanel() {
		
		themePanel = new JPanel();
		themePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

		themeLabel = new JLabel(" Th\u00E8me : ");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if (Launcher.color == 54)
			themeLabel.setForeground(new Color(255, 255, 255));
		else
			themeLabel.setForeground(new Color(0, 0, 0));
		themePanel.add(themeLabel);

		themeButton = new ButtonGroup();

		darkThemeButton = new JRadioButton("Dark");
		darkThemeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (darkThemeButton.isSelected()) {
					Launcher.getLauncher().getLauncherControler().getCurrentUser().setColor(54);
					Launcher.getLauncher().getLauncherControler().save();
				} else {
					Launcher.getLauncher().getLauncherControler().getCurrentUser().setColor(247);
					Launcher.getLauncher().getLauncherControler().save();
				}
			}
		});
		darkThemeButton.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			darkThemeButton.setForeground(new Color(255, 255, 255));
		else
			darkThemeButton.setForeground(new Color(0, 0, 0));

		whiteThemeButton = new JRadioButton("White");
		whiteThemeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (whiteThemeButton.isSelected()) {
					Launcher.getLauncher().getLauncherControler().getCurrentUser().setColor(247);
					Launcher.getLauncher().getLauncherControler().save();
				} else {
					Launcher.getLauncher().getLauncherControler().getCurrentUser().setColor(54);
					Launcher.getLauncher().getLauncherControler().save();
				}
				
			}
		});
		whiteThemeButton.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			whiteThemeButton.setForeground(new Color(255, 255, 255));
		else
			whiteThemeButton.setForeground(new Color(0, 0, 0));

		if (Launcher.color == 54) {
			whiteThemeButton.setSelected(false);
			darkThemeButton.setSelected(true);
		} else {
			darkThemeButton.setSelected(false);
			whiteThemeButton.setSelected(true);
		}
		
		themeButton.add(darkThemeButton);
		themePanel.add(darkThemeButton);
		themeButton.add(whiteThemeButton);
		themePanel.add(whiteThemeButton);
		
		return themePanel;
	}
	
	public JPanel createChangeLoginPanel() {
		
		changeUserPanel = new JPanel();
		changeUserPanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));

		changeUserLabel = new JLabel("Change your login : ");
		changeUserLabel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			changeUserLabel.setForeground(new Color(255,255,255));
		else
			changeUserLabel.setForeground(new Color(0,0,0));
		
		newLogin = new JTextField("New login...");
		newLogin.addFocusListener(new TextFieldListener());
		if (Launcher.color == 54) {
			newLogin.setBackground(new Color(54,57,62));
			newLogin.setForeground(new Color(255,255,255));
		} else {
			newLogin.setBackground(new Color(255,255,255));
			newLogin.setForeground(new Color(0,0,0));
		}
		
		newPassword = new JPasswordField("Password");
		newPassword.addFocusListener(new TextFieldListener());
		if (Launcher.color == 54) {
			newPassword.setBackground(new Color(54,57,62));
			newPassword.setForeground(new Color(255,255,255));
		} else {
			newPassword.setBackground(new Color(255,255,255));
			newPassword.setForeground(new Color(0,0,0));
		}
		
		validateChange = new JButton("Validate");
		validateChange.setBorder(null);
		validateChange.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		validateChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		validateChange.addMouseListener(new MenuButtonListener());
		if (Launcher.color == 54)
			validateChange.setForeground(new Color(255,255,255));
		else
			validateChange.setForeground(new Color(0,0,0));
		
		changeUserPanel.add(changeUserLabel);
		changeUserPanel.add(newLogin);
		changeUserPanel.add(newPassword);
		changeUserPanel.add(validateChange);
		
		return changeUserPanel;
	}
	
	public static SettingPanel getSettingPanel() {
		return settingPanel;
	}
	
	public JTextField getNewLogin() {
		return settingPanel.newLogin;
	}
	
	public JPasswordField getNewPassword() {
		return settingPanel.newPassword;
	}
	
	public JButton getValidateButton() {
		return settingPanel.validateChange;
	}
}
