package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JLabel;

import exception.ExceptionHandler;
import vue.DetailPanel;
import vue.Launcher;
import vue.MainPanel;

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

		if (e.getComponent().equals(Launcher.getStatePanel().getAvatarLabel())) {
			
			DetailPanel.setPreSettingPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getWorkPanel().getExecuteLabel())) {
			String query = Launcher.getMainPanel().getDetailPanel().getWorkPanel().getTextPane().getText().split(";")[0];
			String result = query + ": \n";
			if (query.toLowerCase().contains("create")) {
				try {
					Launcher.getDataBaseController().executeQuery(query);
					result +="table created \n";
				} catch (SQLException ex) {
					result +=ExceptionHandler.analyse (ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			}
			if (query.toLowerCase().contains("insert")) {
				try {
					Launcher.getDataBaseController().executeQuery(query);
					result +="line inserted \n";
				} catch (SQLException ex) {
					result +=ExceptionHandler.analyse (ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			}
			if (query.toLowerCase().contains("drop")) {
				try {
					Launcher.getDataBaseController().executeQuery(query);
					result +="table dropped \n";
				} catch (SQLException ex) {
					result +=ExceptionHandler.analyse (ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			}
			if (query.toLowerCase().contains("delete")) {
				try {
					Launcher.getDataBaseController().executeQuery(query);
					result +="line deleted \n";
				} catch (SQLException ex) {
					result +=ExceptionHandler.analyse (ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			}
			if (query.toLowerCase().contains("select")) {
				try {
					ResultSet rs = Launcher.getDataBaseController().executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount; i++) {
						result += rsmd.getColumnName(i) + " \t|\t ";
					}
					result += rsmd.getColumnName(columnCount)+"\n";
					while (rs.next()) {
						for (int j = 1; j < columnCount; j++) {
							result += rs.getString(j) + " \t\t\t\t ";
						}
						result +=rs.getString(columnCount)+"\n";
					}
				} catch (SQLException ex) {
					result +=ExceptionHandler.analyse (ex.getMessage());
				} catch (NullPointerException ex) {
					result += "You must be connected to a database to execute query";
				}
			}
			JLabel label = new JLabel("<HTML>"+result.replaceAll("\n", "<br>").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")+"</HTML>");
			if (Launcher.color == 54)
				label.setForeground(new Color(255, 255, 255));
			else 
				label.setForeground(new Color(0, 0, 0));
			Launcher.getMainPanel().getDetailPanel().getWorkPanel().getUpPanel().removeAll();
			Launcher.getMainPanel().getDetailPanel().getWorkPanel().getUpPanel().add(label, BorderLayout.NORTH);
			Launcher.getMainPanel().getDetailPanel().revalidate();
			Launcher.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getPreSettingPanel().getSettingLabel())){
			
			DetailPanel.setSettingPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getEditor())) {
			
			DetailPanel.setWorkPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getHome())) {
			
			DetailPanel.setHomePanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getMaximizeLabel())) {
			
			Launcher.getFrame().setLocationRelativeTo(null);
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getMinimizeLabel())) {
			
			Launcher.getFrame().setState(Frame.ICONIFIED);
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getSearch())) {
			
			DetailPanel.setSearchPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getSettingPanel().getValidateButton())) {

			Launcher.getLauncher().getLauncherControler().changeLogin(Launcher.getLauncher().getLauncherControler().getCurrentUserName(), new String(Launcher.getMainPanel().getDetailPanel().getSettingPanel().getNewPassword().getPassword()), Launcher.getMainPanel().getDetailPanel().getSettingPanel().getNewLogin().getText());
			
		} else if (e.getComponent().equals(Launcher.getStatePanel().getAdmin())) {
			
			DetailPanel.setAdminPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
		
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDirectoryPanel().getAddLabel())) {
			
			DetailPanel.setNewConnection();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getNewConnection().getAddDatabaseButton())) {
			
			Launcher.getLauncher().getLauncherControler().addDatabase(Launcher.getMainPanel().getDetailPanel().getNewConnection().getNameField().getText(), Launcher.getMainPanel().getDetailPanel().getNewConnection().getAdressField().getText(), Launcher.getMainPanel().getDetailPanel().getNewConnection().getLoginField().getText(), Launcher.getMainPanel().getDetailPanel().getNewConnection().getPasswordField().getText());
			Launcher.getMainPanel().getDirectoryPanel().setDirectoryPanel();
			DetailPanel.setWorkPanel();
			MainPanel.getMainPanel().getDetailPanel().revalidate();
			MainPanel.getMainPanel().getDetailPanel().repaint();
			
		} else if (e.getComponent().equals(Launcher.getMainPanel().getDetailPanel().getWorkPanel().getClearLabel())) {
			Launcher.getMainPanel().getDetailPanel().getWorkPanel().getTextPane().setText(null);
		}
	}
}
