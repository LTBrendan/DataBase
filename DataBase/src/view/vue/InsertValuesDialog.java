package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.consoleControler.DatabaseControler;
import control.controller.InsertValuesDialogMouseListener;

/**
 * A dialog asking the user to insert a values in the selected table
 */
public class InsertValuesDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	JScrollPane centerScrollPane;
	JPanel centerPanel;
	JLabel titleLabel;
	JLabel confirmLabel;
	
	/**
	 * The constructor of the dialog
	 * @param tableName the table where to insert the values
	 */
	public InsertValuesDialog (String tableName) {
		
		this.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		this.setLayout(new BorderLayout ());
		
		this.confirmLabel = new JLabel ("Confirm");
		confirmLabel.setForeground(Color.WHITE);
		
		this.titleLabel = new JLabel ("Insert values into" + tableName);
		titleLabel.setForeground(Color.WHITE);

		String[] headers = DatabaseControler.getColumnName(tableName);
		String[] type = DatabaseControler.getColumnType(tableName);
		
		centerPanel = new JPanel (new GridLayout (2, headers.length));
		centerPanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		
		for (int i = 0; i < headers.length; i++) {
			
			JLabel columnTitle = new JLabel (headers[i]+"("+type[i]+")");
			columnTitle.setForeground(Color.WHITE);
			columnTitle.setVerticalAlignment(SwingConstants.CENTER);
			columnTitle.setHorizontalAlignment(SwingConstants.CENTER);
			centerPanel.add(columnTitle);
			
		}
		
		JTextField[] values = new JTextField[headers.length];
		
		for (int i = 0; i < values.length; i++) {
			 
			JTextField jtf = new JTextField();
			jtf.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
			jtf.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
			jtf.setForeground(Color.WHITE);
			
			values[i] = jtf;
			
			
			centerPanel.add(values[i]);
						
		}

		centerScrollPane = new JScrollPane(centerPanel);
		centerScrollPane.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));
		confirmLabel.addMouseListener(new InsertValuesDialogMouseListener (tableName, values, this) );
		
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(centerScrollPane, BorderLayout.CENTER);
		this.add(confirmLabel, BorderLayout.SOUTH);
		
	}

	/**
	 * Getter for confirmLabel
	 * @return the confirmLabel
	 */
	public JLabel getConfirmLabel() {
		return confirmLabel;
	}
}
