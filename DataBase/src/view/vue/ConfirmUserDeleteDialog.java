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

import control.controller.ConfirmUserDeleteMouseListener;

public class ConfirmUserDeleteDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel titleLabel;
	JLabel infoLabel;
	JPanel buttonPane;
	JButton okButton;
	JButton cancel;

	static ConfirmUserDeleteDialog confirmUserDeleteDialog;

	private final JPanel contentPanel = new JPanel();

	private static String login;
	private static String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		login = args[0];
		password = args[1];
		try {
			ConfirmUserDeleteDialog dialog = new ConfirmUserDeleteDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmUserDeleteDialog() {

		setAlwaysOnTop(true);
		setResizable(false);

		setBounds(100, 100, 469, 168);
		this.setUndecorated(true);
		this.setBackground(new Color(54, 57, 62));

		confirmUserDeleteDialog = this;

		contentPanel.setBackground(new Color(54, 57, 62));
		contentPanel.setLayout(null);

		titleLabel = new JLabel("Delete ?");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		titleLabel.setBounds(10, 11, 341, 31);

		infoLabel = new JLabel("Are you shure you want to delete this dumb user ?");
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setBounds(10, 47, 433, 31);

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPane.setBackground(new Color(54, 57, 62));
		buttonPane.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

		okButton = new JButton("OK");
		okButton.setBackground(new Color(30, 33, 38));
		okButton.setForeground(new Color(255, 255, 255));
		okButton.addMouseListener(new ConfirmUserDeleteMouseListener(login, password));

		cancel = new JButton("Cancel");
		cancel.setBackground(new Color(30, 33, 38));
		cancel.setForeground(new Color(255, 255, 255));
		cancel.addMouseListener(new ConfirmUserDeleteMouseListener(login, password));

		contentPanel.add(titleLabel);
		contentPanel.add(infoLabel);

		getRootPane().setDefaultButton(okButton);
		buttonPane.add(okButton);
		buttonPane.add(cancel);
		getContentPane().setLayout(new BorderLayout(0, 0));

		getContentPane().add(contentPanel);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	public JButton getOkButton() {
		return confirmUserDeleteDialog.okButton;
	}

	public JButton getcancel() {
		return confirmUserDeleteDialog.cancel;
	}

	public static ConfirmUserDeleteDialog getConfirmUserDeleteDialog() {
		return confirmUserDeleteDialog;
	}

}
