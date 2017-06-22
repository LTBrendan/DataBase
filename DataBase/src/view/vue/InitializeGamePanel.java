package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.controller.InitializeGamePanelKeyListener;
import control.controller.InitializeGamePanelMouseListener;

public class InitializeGamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton startButton;
	private JLabel questionLabel;
	private JPanel panel;
	private JTextField textField;
	
	/**
	 * Create the panel.
	 */
	public InitializeGamePanel() {
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		
		questionLabel = new JLabel("How many questions ?");
		questionLabel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		questionLabel.setForeground(Color.WHITE);
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setPreferredSize(new Dimension(WorkPanel.width, WorkPanel.height / 15));
		add(questionLabel, BorderLayout.NORTH);

		panel = new JPanel();
		panel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		add(panel, BorderLayout.CENTER);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		textField.addKeyListener(new InitializeGamePanelKeyListener());
		textField.setColumns(20);
		panel.add(textField);

		startButton = new JButton("Start game");
		startButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		startButton.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		startButton.setForeground(Color.WHITE);
		startButton.addMouseListener(new InitializeGamePanelMouseListener());
		startButton.setEnabled(false);
		startButton.setPreferredSize(new Dimension(WorkPanel.width, WorkPanel.height / 15));
		startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(startButton, BorderLayout.SOUTH);
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getStartButton() {
		return startButton;
	}
}
