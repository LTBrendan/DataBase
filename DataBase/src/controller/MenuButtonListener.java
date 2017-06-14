package controller;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import vue.WorkPanel;

public class MenuButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {

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
	//	if ((e.getSource() == WorkPanel.getExecuteLabel()) || (e.getSource() == WorkPanel.getExecuteAllLabel())){
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			panel.add(new JLabel("Query : " + WorkPanel.getTextPane().getText()), BorderLayout.NORTH);
			WorkPanel.setUpPanel(panel);
			
			JScrollPane scrollPane = new JScrollPane(panel);
			scrollPane.setPreferredSize(new Dimension(20,250));
			WorkPanel.setUpScrollPane(scrollPane);
	//	}
	}
}