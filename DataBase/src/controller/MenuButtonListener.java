package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import vue.DetailPanel;
import vue.Launcher;
import vue.MainPanel;
import vue.SettingPanel;
import vue.WorkPanel;

public class MenuButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("DEBUG LISTENER");
//		// if ((e.getSource() == WorkPanel.getExecuteLabel()) || (e.getSource()
//		// == WorkPanel.getExecuteAllLabel())){
//		JPanel panel = new JPanel();
//		panel.setLayout(new BorderLayout());
//
//		panel.add(new JLabel("Query : " + WorkPanel.getTextPane().getText()), BorderLayout.NORTH);
//		//WorkPanel.setUpPanel(panel);
//
//		JScrollPane scrollPane = new JScrollPane(panel);
//		scrollPane.setPreferredSize(new Dimension(20, 250));
//		//WorkPanel.setUpScrollPane(scrollPane);
//
//		DetailPanel.setWorkPanel(new WorkPanel(scrollPane, WorkPanel.getDownScrollPane()));
//		DetailPanel.getWorkPanel().repaint();
//		// WorkPanel.setLeftComponent(scrollPane);
//
////		WorkPanel.getUpPanel().add(new JLabel("Query : " + WorkPanel.getTextPane().getText()), BorderLayout.NORTH);
////		WorkPanel.getUpPanel().repaint();
//
//		Launcher.getFrame().repaint();
//		// }
		
		
		MainPanel.setDetailPanel(new DetailPanel(new SettingPanel()));
		MainPanel.getDetailPanel().repaint();
		Launcher.getFrame().repaint();
	}
}