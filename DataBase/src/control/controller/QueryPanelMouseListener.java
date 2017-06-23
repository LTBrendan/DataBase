package control.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.exception.ExceptionHandler;
import view.vue.AppFrame;

public class QueryPanelMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getExecutePanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getExecuteAllPanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getClearPanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getSavePanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getImportPanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getExecutePanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getExecuteAllPanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getClearPanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getSavePanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		}

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getImportPanel())) {
			e.getComponent().setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getExecutePanel())) {

			String query = AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getTextPane().getText()
					.split(";")[0];
			String result = query + ": \n";

			if (query.toLowerCase().contains("create")) {
				try {
					AppFrame.getDataBaseController().executeQuery(query);
					result += "table created \n";
				} catch (SQLException ex) {
					result += ExceptionHandler.analyse(ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			} else if (query.toLowerCase().contains("insert")) {
				try {
					AppFrame.getDataBaseController().executeQuery(query);
					result += "line inserted \n";
				} catch (SQLException ex) {
					result += ExceptionHandler.analyse(ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			} else if (query.toLowerCase().contains("drop")) {
				try {
					AppFrame.getDataBaseController().executeQuery(query);
					result += "table dropped \n";
				} catch (SQLException ex) {
					result += ExceptionHandler.analyse(ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			} else if (query.toLowerCase().contains("delete")) {
				try {
					AppFrame.getDataBaseController().executeQuery(query);
					result += "line deleted \n";
				} catch (SQLException ex) {
					result += ExceptionHandler.analyse(ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			} else if (query.toLowerCase().contains("select")) {
				try {
					ResultSet rs = AppFrame.getDataBaseController().executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount; i++) {
						result += rsmd.getColumnName(i) + " \t|\t ";
					}
					result += rsmd.getColumnName(columnCount) + "\n";
					while (rs.next()) {
						for (int j = 1; j < columnCount; j++) {
							result += rs.getString(j) + " \t\t\t\t ";
						}
						result += rs.getString(columnCount) + "\n";
					}
				} catch (SQLException ex) {
					result += ExceptionHandler.analyse(ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			} else if ((!query.toLowerCase().contains("create")) && (!query.toLowerCase().contains("drop"))
					&& (!query.toLowerCase().contains("insert")) && (!query.toLowerCase().contains("delete"))
					&& (!query.toLowerCase().contains("select"))) {
				result += "Invalid SQL Query";
			}

			JLabel label = new JLabel(
					"<HTML>" + result.replaceAll("\n", "<br>").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
							+ "</HTML>");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			if (AppFrame.color == 54)
				label.setForeground(new Color(255, 255, 255));
			else
				label.setForeground(new Color(0, 0, 0));

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getUpPanel().removeAll();
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getUpPanel().add(label,
					BorderLayout.NORTH);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().revalidate();
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().repaint();

		} else if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getClearPanel())) {

			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getTextPane().setText(null);

		} else if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getSavePanel())) {

			FileDialog saveJFC = new FileDialog((Frame) null, "Fichier ?", FileDialog.SAVE);
//			JFrame frame = new JFrame();
//			saveJFC.addActionListener(new SaveChooserListener(saveJFC,
//					AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getTextPane().getText()));
//			saveJFC.showSaveDialog(frame);
			saveJFC.setLocationRelativeTo(null);
			saveJFC.setVisible(true);

		} else if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getImportPanel())) {

			JFileChooser openJFC = new JFileChooser();
			JFrame frame = new JFrame();
			openJFC.addActionListener(new OpenChooserListener(openJFC));
			openJFC.showOpenDialog(frame);

		} else if (e.getComponent()
				.equals(AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getExecuteAllPanel())) {

			String[] query = AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getTextPane()
					.getText().split(";");
			String result = "";
			for (String s : query) {
				result += s + ": \n";
				if (s.toLowerCase().contains("create")) {
					try {
						AppFrame.getDataBaseController().executeQuery(s);
						result += "table created \n";
					} catch (SQLException ex) {
						result += ExceptionHandler.analyse(ex.getMessage());
					} catch (NullPointerException ex) {
						result += "You must be connected to a database to execute query";
					}

				} else if (s.toLowerCase().contains("insert")) {
					try {
						AppFrame.getDataBaseController().executeQuery(s);
						result += "line inserted \n";
					} catch (SQLException ex) {
						result += ExceptionHandler.analyse(ex.getMessage());
					} catch (NullPointerException ex) {
						result += "You must be connected to a database to execute query";
					}

				} else if (s.toLowerCase().contains("drop")) {
					try {
						AppFrame.getDataBaseController().executeQuery(s);
						result += "table dropped \n";
					} catch (SQLException ex) {
						result += ExceptionHandler.analyse(ex.getMessage());
					} catch (NullPointerException ex) {
						result += "You must be connected to a database to execute query";
					}

				} else if (s.toLowerCase().contains("delete")) {
					try {
						AppFrame.getDataBaseController().executeQuery(s);
						result += "line deleted \n";
					} catch (SQLException ex) {
						result += ExceptionHandler.analyse(ex.getMessage());
					} catch (NullPointerException ex) {
						result += "You must be connected to a database to execute query";
					}

				} else if (s.toLowerCase().contains("select")) {
					try {
						ResultSet rs = AppFrame.getDataBaseController().executeQuery(s);
						ResultSetMetaData rsmd = rs.getMetaData();
						int columnCount = rsmd.getColumnCount();
						for (int i = 1; i < columnCount; i++) {
							result += rsmd.getColumnName(i) + " \t|\t ";
						}
						result += rsmd.getColumnName(columnCount) + "\n";
						while (rs.next()) {
							for (int j = 1; j < columnCount; j++) {
								result += rs.getString(j) + " \t\t\t\t ";
							}
							result += rs.getString(columnCount) + "\n";
						}
					} catch (SQLException ex) {
						result += ExceptionHandler.analyse(ex.getMessage());
					} catch (NullPointerException ex) {
						result += "You must be connected to a database to execute query";
					}
				} else if ((!s.toLowerCase().contains("create")) && (!s.toLowerCase().contains("drop"))
						&& (!s.toLowerCase().contains("insert")) && (!s.toLowerCase().contains("delete"))
						&& (!s.toLowerCase().contains("select"))) {
					result += "Invalid SQL Query";
				}
			}
			JLabel label = new JLabel(
					"<HTML>" + result.replaceAll("\n", "<br>").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
							+ "</HTML>");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			if (AppFrame.color == 54)
				label.setForeground(new Color(255, 255, 255));
			else
				label.setForeground(new Color(0, 0, 0));
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getUpPanel().removeAll();
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().getQueryPanel().getUpPanel().add(label,
					BorderLayout.NORTH);
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().revalidate();
			AppFrame.getAppFrame().getMainPanel().getWorkPanel().repaint();

		}
	}
}
