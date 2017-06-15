package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import controller.MouseMovementAdapter;
import controller.WindowResizer;

public class Launcher {

	private static JFrame frame;
	private static StatePanel statePanel = new StatePanel();
	private static MainPanel mainPanel = new MainPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frame.setVisible(true);
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
		return frame;
	}

	public static StatePanel getStatePanel() {
		return statePanel;
	}

	public static void setStatePanel(StatePanel statePanel) {
		Launcher.statePanel = statePanel;
	}

	public static MainPanel getMainPanel() {
		return mainPanel;
	}

	public static void setMainPanel(MainPanel mainPanel) {
		Launcher.mainPanel = mainPanel;
	}	
}
