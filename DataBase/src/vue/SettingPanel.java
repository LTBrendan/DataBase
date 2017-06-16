package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SettingPanel settingPanel;
	
	public SettingPanel() {
		
		this.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		setLayout(new GridLayout(5, 5, 0, 0));
		
		JPanel themePanel = new JPanel();
		add(themePanel);
		themePanel.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		
		JLabel themeLabel = new JLabel(" Th\u00E8me : ");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if (Launcher.color == 54)
			themeLabel.setForeground(new Color(255,255,255));
		else
			themeLabel.setForeground(new Color(0,0,0));
		themePanel.add(themeLabel);
		
		ButtonGroup themeButton = new ButtonGroup();
			
		JRadioButton darkThemeButton = new JRadioButton("Dark");
		darkThemeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (darkThemeButton.isSelected()){
					Launcher.color = 54;
				} else {
					Launcher.color = 247;
				}
				Launcher.getFrame().repaint();
				Launcher.getFrame().revalidate();
			}
		});
		darkThemeButton.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			darkThemeButton.setForeground(new Color(255,255,255));
		else
			darkThemeButton.setForeground(new Color(0,0,0));
		
		
		JRadioButton whiteThemeButton = new JRadioButton("White");
		whiteThemeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (whiteThemeButton.isSelected()){
					Launcher.color = 247;
				} else {
					Launcher.color = 54;
				}
				Launcher.getFrame().repaint();
				Launcher.getFrame().revalidate();
			}
		});
		whiteThemeButton.setBackground(new Color(Launcher.color, Launcher.color + 3, Launcher.color + 8));
		if (Launcher.color == 54)
			whiteThemeButton.setForeground(new Color(255,255,255));
		else
			whiteThemeButton.setForeground(new Color(0,0,0));
		
		
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
		
		settingPanel = this;
	}
	
	public static SettingPanel getSettingPanel() {
		return settingPanel;
	}
	
}
