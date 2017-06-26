package control.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import view.vue.AppFrame;

/**
* This listener is assigned to the searchPanel and add a new search or make the research
*/
public class SearchPanelMouseListener implements MouseListener {

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

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSearchPanel().getAddNewButton())) {
			JPanel fieldPanel = new JPanel();
			fieldPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
			fieldPanel.setLayout(new GridLayout(1, 2));
			fieldPanel.setMinimumSize(new Dimension(100, 100));
			fieldPanel.setMaximumSize(new Dimension(100, 100));

			JPanel columnFlowPanel = new JPanel(new FlowLayout());
			columnFlowPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

			JTextField columnField = new JTextField();
			columnField.setForeground(Color.WHITE);
			columnField.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
			columnField.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
			columnField.setColumns(10);
			columnField.setMinimumSize(new Dimension(100, 100));

			JPanel valueFlowPanel = new JPanel(new FlowLayout());
			valueFlowPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

			JTextField valueField = new JTextField();
			valueField.setForeground(Color.WHITE);
			valueField.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
			valueField.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
			valueField.setColumns(10);
			valueField.setMinimumSize(new Dimension(100, 100));

			columnFlowPanel.add(columnField);
			valueFlowPanel.add(valueField);
			
			fieldPanel.add(columnFlowPanel);
			fieldPanel.add(valueFlowPanel);

			fieldPanel.setVisible(true);

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSearchPanel().getCenterPanel().add(fieldPanel);

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSearchPanel().getCenterPanel().revalidate();
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSearchPanel().getCenterPanel().repaint();

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSearchPanel().getCenterScrollPane().revalidate();
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getSearchPanel().getCenterScrollPane().repaint();
		}

	}

}
