package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CreateUserTextFieldListener;
import controller.LoginButtonListener;
import controller.TextFieldListener;
import javax.swing.ImageIcon;

public class Qtdfqd extends JFrame {

	private JPanel loginPane;
	private JTextField focusedTextField;
	private JLabel avatarLabel;
	private JLabel userLabel;
	private JTextField loginField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel closeLabel;

	private JPanel createUserPane;
	private JLabel loginTextLabel;
	private JLabel passwordTextLabel;
	private JPasswordField createUserPasswordField;
	private JLabel confirmPasswordTextLabel;
	private JPasswordField confirmPasswordField;
	private JButton createUserButton;
	
	private JPanel contentPane;
	private JLabel wrongPasswordLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qtdfqd frame = new Qtdfqd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Qtdfqd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		
		createUserPane = new JPanel();
		createUserPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		createUserPane.setBackground(new Color(54, 57, 62));
		createUserPane.setLayout(null);
		
		focusedTextField.setBounds(10, 11, 86, 20);
		
		avatarLabel.setBounds(20, 36, 90, 70);
		
		closeLabel.setBounds(445, 11, 20, 20);
		
		loginTextLabel = new JLabel("Login :");
		loginTextLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		loginTextLabel.setForeground(Color.WHITE);
		loginTextLabel.setBounds(133, 54, 46, 14);
		
		loginField.setBounds(133, 69, 186, 20);
		loginField.setText("");
		loginField.addFocusListener(new TextFieldListener());
		
		JSeparator loginSeparator = new JSeparator();
		loginSeparator.setBounds(133, 91, 186, 2);
		
		passwordTextLabel = new JLabel("Password :");
		passwordTextLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		passwordTextLabel.setForeground(Color.WHITE);
		passwordTextLabel.setBounds(132, 118, 71, 14);
		
		createUserPasswordField = new JPasswordField();
		createUserPasswordField.setBorder(null);
		createUserPasswordField.setColumns(10);
		createUserPasswordField.setBackground(new Color(54, 57, 62));
		createUserPasswordField.setForeground(new Color(255, 255, 255));
		createUserPasswordField.setBounds(133, 137, 186, 20);
		
		JSeparator passwordSeparator = new JSeparator();
		passwordSeparator.setBounds(133, 159, 186, 2);
		
		confirmPasswordTextLabel = new JLabel("Confirm password");
		confirmPasswordTextLabel.setForeground(Color.WHITE);
		confirmPasswordTextLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		confirmPasswordTextLabel.setBounds(133, 182, 120, 14);
		
		confirmPasswordField = new JPasswordField("");
		confirmPasswordField.setForeground(Color.WHITE);
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBorder(null);
		confirmPasswordField.setBackground(new Color(54, 57, 62));
		confirmPasswordField.setBounds(133, 199, 186, 20);
		confirmPasswordField.addKeyListener(new CreateUserTextFieldListener());
		
		createUserButton = new JButton("Create user");
		createUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createUserButton.setForeground(Color.WHITE);
		createUserButton.setBorder(null);
		createUserButton.setBounds(132, 260, 89, 23);
		createUserButton.setBackground(new Color(30, 33, 38));
		createUserButton.addMouseListener(new LoginButtonListener());
		
		JSeparator confirmPasswordSeparator = new JSeparator();
		confirmPasswordSeparator.setBounds(133, 221, 186, 2);
		
		createUserPane.add(focusedTextField);
		createUserPane.add(closeLabel);
		createUserPane.add(avatarLabel);
		
		createUserPane.add(loginTextLabel);
		createUserPane.add(loginField);
		createUserPane.add(loginSeparator);
		
		createUserPane.add(passwordTextLabel);
		createUserPane.add(createUserPasswordField);
		createUserPane.add(passwordSeparator);
		
		createUserPane.add(confirmPasswordTextLabel);
		createUserPane.add(confirmPasswordField);
		createUserPane.add(confirmPasswordSeparator);
		
		createUserPane.add(createUserButton);
		
		setContentPane(createUserPane);
		
		wrongPasswordLabel = new JLabel("");
		wrongPasswordLabel.setIcon(new ImageIcon("D:\\workspace\\DataBase\\DataBase\\rsc\\login\\error.png"));
		wrongPasswordLabel.setBounds(329, 199, 16, 17);
		createUserPane.add(wrongPasswordLabel);
	}

}
