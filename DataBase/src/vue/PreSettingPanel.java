package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PreSettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PreSettingPanel preSettingPanel;

	public PreSettingPanel() {

		this.setBackground(new Color(54, 57, 62));
		setLayout(new BorderLayout());

		JLabel lblDconnexion = new JLabel("D\u00E9connexion");
		lblDconnexion.setForeground(Color.WHITE);
		add(lblDconnexion, BorderLayout.WEST);

		JLabel lblQuitter = new JLabel("Quitter");
		lblQuitter.setForeground(Color.WHITE);
		add(lblQuitter, BorderLayout.CENTER);

		JLabel lblParamtres = new JLabel("Param\u00E8tres");
		lblParamtres.setForeground(Color.WHITE);
		add(lblParamtres, BorderLayout.EAST);

		preSettingPanel = this;
	}

	public static PreSettingPanel getPreSettingPanel() {
		return preSettingPanel;
	}
}
