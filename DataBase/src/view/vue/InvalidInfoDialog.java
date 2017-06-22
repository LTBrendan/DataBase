package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.controller.InvalidInfoMouseListener;

public class InvalidInfoDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	JLabel titleLabel;
	JLabel infoLabel;
	JPanel buttonPane;
	JButton okButton;
	JButton createNewButton;

	static InvalidInfoDialog invalidInfoDialog;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the dialog
	 */
	public static void main(String[] args) {
		try {
			InvalidInfoDialog dialog = new InvalidInfoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InvalidInfoDialog() {

		setAlwaysOnTop(true);
		setResizable(false);

		setBounds(100, 100, 469, 168);
		this.setUndecorated(true);
		this.setBackground(new Color(54, 57, 62));

		invalidInfoDialog = this;

		contentPanel.setBackground(new Color(54, 57, 62));
		contentPanel.setLayout(null);

		titleLabel = new JLabel("The user name or password is incorrect");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		titleLabel.setBounds(10, 11, 341, 31);

		infoLabel = new JLabel("Please try entering your information again, or create a new user profile");
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setBounds(10, 47, 433, 31);

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPane.setBackground(new Color(54, 57, 62));
		buttonPane.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

		okButton = new JButton("OK");
		okButton.setBackground(new Color(30, 33, 38));
		okButton.setForeground(new Color(255, 255, 255));
		okButton.addMouseListener(new InvalidInfoMouseListener());

		createNewButton = new JButton("Create new user");
		createNewButton.setBackground(new Color(30, 33, 38));
		createNewButton.setForeground(new Color(255, 255, 255));
		createNewButton.addMouseListener(new InvalidInfoMouseListener());

		contentPanel.add(titleLabel);
		contentPanel.add(infoLabel);

		getRootPane().setDefaultButton(okButton);
		buttonPane.add(okButton);
		buttonPane.add(createNewButton);
		getContentPane().setLayout(new BorderLayout(0, 0));

		getContentPane().add(contentPanel);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Getter for okButton
	 * @return the okButton
	 */
	public JButton getOkButton() {
		return invalidInfoDialog.okButton;
	}

	/**
	 * Getter for createNewButton
	 * @return the createNewButton
	 */
	public JButton getCreateNewButton() {
		return invalidInfoDialog.createNewButton;
	}

	/**
	 * Getter for this InvalidInfoDialog
	 * @return this InvalidInfoDialog
	 */
	public static InvalidInfoDialog getInvalidInfoDialog() {
		return invalidInfoDialog;
	}

}
