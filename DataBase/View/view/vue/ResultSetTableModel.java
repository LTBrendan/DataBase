package view.vue;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

/**
 * This class allows to construct a table representing a table of the database
 */
public class ResultSetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;

	/**
	 * The constructor of the ResultetTableModel
	 * @param resultSet the ResultSet from where extract meta data
	 */
	public ResultSetTableModel (ResultSet resultSet) {
		this.resultSet = resultSet;

		try {
			this.resultSetMetaData = resultSet.getMetaData();
			
		} catch (SQLException e) {

		} catch (NullPointerException e) {
			
			AppFrame.getAppFrame().getMainPanel().getDirectoryPanel().setInfoLabelText("You must be connected to a database");
			
		}
	}

	@Override
	public int getColumnCount() {
		int ret = 0;
		
		try {
			
			ret = resultSetMetaData.getColumnCount();
			
		} catch (SQLException e) {

		} catch (NullPointerException e) {
			
		}
		return ret;
	}

	@Override
	public int getRowCount() {
		int ret = 0;
		
		try {
			resultSet.last();
			ret = resultSet.getRow();
			
		} catch (SQLException e) {

		} catch (NullPointerException e) {
			
		}
		return ret;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object ret = null;
		
		try {
			resultSet.absolute(rowIndex + 1);
			ret = resultSet.getObject(columnIndex + 1);
			
		} catch (SQLException e) {

		} catch (NullPointerException e) {
			
		}
		return ret;
	}

	@Override
	public String getColumnName(int column) {
		String ret = "";
		try {
			ret = resultSetMetaData.getColumnName(column + 1);
		} catch (SQLException e) {

		} catch (NullPointerException e) {
			
		}
		return ret;
	}

}
