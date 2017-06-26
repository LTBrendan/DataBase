package control.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import view.vue.AppFrame;
import view.vue.InsertValuesDialog;

public class InsertValuesDialogMouseListener implements MouseListener {

	private String tableName;
	private JTextField[] values;
	private InsertValuesDialog dialog;

	public InsertValuesDialogMouseListener(String tableName, JTextField[] values, InsertValuesDialog dialog) {
		this.tableName = tableName;
		this.values = values;
		this.dialog = dialog;
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

		String query = "INSERT INTO " + tableName + " VALUES (";
		for (JTextField jtf : values) {
			query += jtf.getText() + ",";
		}

		query = query.substring(0, query.length() - 2) + ")";
		System.out.println(query);

		try {
			AppFrame.getDataBaseController().executeQuery(query);
			dialog.dispose();
		} catch (SQLException ex) {
			dialog.getConfirmLabel().setText("Incorrect value, please try again");
			dialog.getConfirmLabel().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
			ex.printStackTrace();
		}

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}
