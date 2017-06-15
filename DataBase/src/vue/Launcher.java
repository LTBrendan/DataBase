package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import controller.MouseMovementAdapter;
import controller.WindowResizer;

public class Launcher {

	private JFrame frame;
	private StatePanel statePanel = new StatePanel();
	private MainPanel mainPanel = new MainPanel();
	private static Launcher launcher;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Launcher().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Launcher() {
		
		frame = new JFrame("DataBase app");
		frame.setUndecorated(true);
		frame.setPreferredSize(new Dimension(1080, 720));
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		launcher = this;
		
		MouseMovementAdapter.setMAIN_FRAME(frame);
		try {
			WindowResizer.WINDOW_RESIZER.register(frame);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		frame.getContentPane().add(statePanel, BorderLayout.WEST);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		frame.pack();
		frame.repaint();
	}

	public static JFrame getFrame() {
		return launcher.frame;
	}

	public static StatePanel getStatePanel() {
		return launcher.statePanel;
	}

	public static void setStatePanel(StatePanel statePanel) {
		launcher.statePanel = statePanel;
	}

	public static MainPanel getMainPanel() {
		return launcher.mainPanel;
	}

	public static void setMainPanel(MainPanel mainPanel) {
		launcher.mainPanel = mainPanel;
	}	
}
