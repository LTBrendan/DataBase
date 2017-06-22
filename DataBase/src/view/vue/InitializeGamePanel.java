package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.controller.InitializeGamePanelMouseListener;

public class InitializeGamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public InitializeGamePanel() {
		setLayout(new BorderLayout(0, 0));

		JLabel lblNombreDeQuestion = new JLabel("How many questions ?");
		lblNombreDeQuestion.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		lblNombreDeQuestion.setForeground(Color.WHITE);
		lblNombreDeQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNombreDeQuestion, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(panel, BorderLayout.CENTER);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		panel.add(textField);
		textField.setColumns(10);

		JButton btnStartGame = new JButton("Start game");
		btnStartGame.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		btnStartGame.setForeground(Color.WHITE);
		btnStartGame.addMouseListener(new InitializeGamePanelMouseListener());
		add(btnStartGame, BorderLayout.SOUTH);
	}

	public JTextField getTextField() {
		return textField;
	}
}
