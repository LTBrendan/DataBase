package controller;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import vue.BaseDeDonnees;

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
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(new JLabel("Query : " + BaseDeDonnees.getTextPane().getText()), BorderLayout.NORTH);
		BaseDeDonnees.setPanel_1(panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setPreferredSize(new Dimension(20,250));
		BaseDeDonnees.setScrollPane(scrollPane);

		BaseDeDonnees.getSplitPane().setLeftComponent(scrollPane);
	}
}