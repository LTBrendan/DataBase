package vue;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LabelCloseListener;
import controller.LoginButtonListener;
import controller.TextFieldListener;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField focusedTextField;
	private JLabel avatarLabel;
	private JTextField loginField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel closeLabel;
	
	private static LoginFrame loginFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 475, 325);
		this.setResizable(false);

		loginFrame = this;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(54, 57, 62));
		contentPane.setLayout(null);

		focusedTextField = new JTextField();
		focusedTextField.setEditable(false);
		focusedTextField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		focusedTextField.setBorder(null);
		focusedTextField.setBounds(10, 11, 86, 20);
		focusedTextField.setColumns(10);
		focusedTextField.setBackground(new Color(54, 57, 62));

		avatarLabel = new JLabel();
		avatarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avatarLabel.setBounds(199, 43, 90, 70);
		avatarLabel.setIcon(new ImageIcon("rsc\\user-16.png"));

		loginField = new JTextField("Login");
		loginField.setBorder(null);
		loginField.setBounds(145, 137, 186, 20);
		loginField.setBackground(new Color(54, 57, 62));
		loginField.setForeground(new Color(255, 255, 255));
		loginField.setColumns(10);
		loginField.addFocusListener(new TextFieldListener());

		passwordField = new JPasswordField("Password");
		passwordField.setBorder(null);
		passwordField.setColumns(10);
		passwordField.setBackground(new Color(54, 57, 62));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBounds(145, 192, 186, 20);
		passwordField.addFocusListener(new TextFieldListener());

		loginButton = new JButton("Login");
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBorder(null);
		loginButton.setBounds(199, 236, 89, 23);
		loginButton.setBackground(new Color(Launcher.color - 24, Launcher.color - 21, Launcher.color - 18));
		loginButton.addMouseListener(new LoginButtonListener());

		JSeparator separator = new JSeparator();
		separator.setBounds(145, 159, 186, 2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(145, 214, 186, 2);

		setContentPane(contentPane);

		contentPane.add(focusedTextField);

		closeLabel = new JLabel("");
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.setBounds(445, 11, 20, 20);
		closeLabel.setIcon(new ImageIcon("rsc\\control\\closeWhite.PNG"));
		closeLabel.addMouseListener(new LabelCloseListener());

		contentPane.add(closeLabel);
		contentPane.add(avatarLabel);
		contentPane.add(loginField);
		contentPane.add(separator);
		contentPane.add(passwordField);
		contentPane.add(separator_1);
		contentPane.add(loginButton);
	}
	
	public static LoginFrame getLoginFrame() {
		return loginFrame;
	}
}
