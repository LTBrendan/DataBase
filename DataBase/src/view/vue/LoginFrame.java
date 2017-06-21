package view.vue;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.consoleControler.LauncherControler;
import control.controller.CloseListener;
import control.controller.LoginFrameFocusListener;
import control.controller.LoginFrameKeyListener;
import control.controller.LoginFrameMouseListener;
import logs.Log;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel loginPane;
	private JTextField focusedTextField;
	private JLabel avatarLabel;
	private JLabel userLabel;
	private JTextField loginField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel closeLabel;
	private JLabel createNewUserLoginLabel;

	private JPanel createUserPane;
	private JLabel loginTextLabel;
	private JLabel passwordTextLabel;
	private JPasswordField createUserPasswordField;
	private JLabel confirmPasswordTextLabel;
	private JPasswordField confirmPasswordField;
	private JButton createUserButton;
	private JLabel wrongPasswordLabel;

	private static LoginFrame loginFrame;
	private LauncherControler launcherControler = new LauncherControler();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Log.open();
		Log.clean();
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

		loginPane = new JPanel();
		createUserPane = new JPanel();

		focusedTextField = new JTextField();
		focusedTextField.setEditable(false);
		focusedTextField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		focusedTextField.setBorder(null);
		focusedTextField.setColumns(10);
		focusedTextField.setBackground(new Color(54, 57, 62));

		avatarLabel = new JLabel();
		avatarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avatarLabel.setIcon(new ImageIcon("rsc\\user-16.png"));

		closeLabel = new JLabel();
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.setIcon(new ImageIcon("rsc\\control\\closeWhite.PNG"));
		closeLabel.addMouseListener(new CloseListener());

		loginField = new JTextField();
		loginField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		loginField.setBackground(new Color(54, 57, 62));
		loginField.setForeground(new Color(255, 255, 255));
		loginField.setColumns(10);

		this.setContentPane(loginPanel());

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				frameMouseDragged(evt);
			}
		});

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				frameMousePressed(evt);
			}
		});

	}

	private JPanel loginPanel() {

		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginPane.setBackground(new Color(54, 57, 62));
		loginPane.setLayout(null);

		focusedTextField.setBounds(10, 11, 86, 20);

		avatarLabel.setBounds(199, 43, 90, 70);

		closeLabel.setBounds(445, 11, 20, 20);

		userLabel = new JLabel();
		userLabel.setIcon(new ImageIcon("rsc\\login\\userWhite.png"));
		userLabel.setBounds(115, 145, 20, 16);

		loginField.setBounds(145, 137, 186, 20);
		loginField.setText("Login");
		loginField.addFocusListener(new LoginFrameFocusListener());
		loginField.addKeyListener(new LoginFrameKeyListener());

		passwordLabel = new JLabel();
		passwordLabel.setIcon(new ImageIcon("rsc\\login\\passwordWhite.png"));
		passwordLabel.setBounds(115, 196, 20, 16);

		passwordField = new JPasswordField("Password");
		passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		passwordField.setColumns(10);
		passwordField.setBackground(new Color(54, 57, 62));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBounds(145, 192, 186, 20);
		passwordField.addFocusListener(new LoginFrameFocusListener());
		passwordField.addKeyListener(new LoginFrameKeyListener());

		loginButton = new JButton("Login");
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBorder(null);
		loginButton.setBounds(199, 236, 89, 23);
		loginButton.setBackground(new Color(30, 33, 38));
		loginButton.addMouseListener(new LoginFrameMouseListener());

		createNewUserLoginLabel = new JLabel();
		createNewUserLoginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createNewUserLoginLabel.setIcon(new ImageIcon("rsc\\login\\addUserWhite.png"));
		createNewUserLoginLabel.setBounds(417, 267, 48, 47);
		createNewUserLoginLabel.addMouseListener(new LoginFrameMouseListener());

		loginPane.add(focusedTextField);
		loginPane.add(closeLabel);
		loginPane.add(avatarLabel);
		loginPane.add(loginField);
		loginPane.add(passwordField);
		loginPane.add(loginButton);
		loginPane.add(userLabel);
		loginPane.add(passwordLabel);
		loginPane.add(createNewUserLoginLabel);

		return loginPane;
	}

	private JPanel createUserPanel() {

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
		loginField.addFocusListener(new LoginFrameFocusListener());

		passwordTextLabel = new JLabel("Password :");
		passwordTextLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		passwordTextLabel.setForeground(Color.WHITE);
		passwordTextLabel.setBounds(132, 118, 71, 14);

		createUserPasswordField = new JPasswordField();
		createUserPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		createUserPasswordField.setColumns(10);
		createUserPasswordField.setBackground(new Color(54, 57, 62));
		createUserPasswordField.setForeground(new Color(255, 255, 255));
		createUserPasswordField.setBounds(133, 137, 186, 20);

		confirmPasswordTextLabel = new JLabel("Confirm password");
		confirmPasswordTextLabel.setForeground(Color.WHITE);
		confirmPasswordTextLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		confirmPasswordTextLabel.setBounds(133, 182, 120, 14);

		confirmPasswordField = new JPasswordField("");
		confirmPasswordField.setForeground(Color.WHITE);
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		confirmPasswordField.setBackground(new Color(54, 57, 62));
		confirmPasswordField.setBounds(133, 199, 186, 20);
		confirmPasswordField.addKeyListener(new LoginFrameKeyListener());

		createUserButton = new JButton("Create user");
		createUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createUserButton.setForeground(Color.WHITE);
		createUserButton.setBorder(null);
		createUserButton.setBounds(132, 260, 89, 23);
		createUserButton.setBackground(new Color(30, 33, 38));
		createUserButton.addMouseListener(new LoginFrameMouseListener());

		wrongPasswordLabel = new JLabel();
		wrongPasswordLabel.setIcon(new ImageIcon("rsc\\login\\error.png"));
		wrongPasswordLabel.setBounds(329, 199, 16, 17);
		wrongPasswordLabel.setVisible(false);

		createUserPane.add(focusedTextField);
		createUserPane.add(closeLabel);
		createUserPane.add(avatarLabel);

		createUserPane.add(loginTextLabel);
		createUserPane.add(loginField);

		createUserPane.add(passwordTextLabel);
		createUserPane.add(createUserPasswordField);

		createUserPane.add(confirmPasswordTextLabel);
		createUserPane.add(confirmPasswordField);

		createUserPane.add(createUserButton);
		createUserPane.add(wrongPasswordLabel);

		return createUserPane;
	}

	int xy, xx;

	private void frameMouseDragged(MouseEvent evt) {
		int depX = evt.getX() - xx;
		int depY = evt.getY() - xy;
		this.setLocation(this.getX() + depX, this.getY() + depY);
	}

	private void frameMousePressed(MouseEvent evt) {
		xx = evt.getX();
		xy = evt.getY();
	}

	public static LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public JTextField getLoginField() {
		return loginFrame.loginField;
	}

	public JPasswordField getPasswordField() {
		return loginFrame.passwordField;
	}

	public LauncherControler getLauncherControler() {
		return loginFrame.launcherControler;
	}

	public JPasswordField getConfirmPasswordField() {
		return confirmPasswordField;
	}

	public JPasswordField getCreateUserPasswordField() {
		return createUserPasswordField;
	}

	public JLabel getWrongPasswordLabel() {
		return loginFrame.wrongPasswordLabel;
	}

	public JLabel getCreateNewUserLoginLabel() {
		return loginFrame.createNewUserLoginLabel;
	}

	public JButton getLoginButton() {
		return loginFrame.loginButton;
	}

	public JButton getCreateUserButton() {
		return loginFrame.createUserButton;
	}

	public void loginContentPanel() {

		loginPane = new JPanel();
		loginFrame.setContentPane(loginFrame.loginPanel());
		loginFrame.revalidate();
		loginFrame.repaint();
	}

	public void createUserContentPanel() {

		createUserPane = new JPanel();
		loginFrame.setContentPane(loginFrame.createUserPanel());
		loginFrame.revalidate();
		loginFrame.repaint();
	}

}