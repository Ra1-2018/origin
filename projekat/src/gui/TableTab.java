package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6747903089342725243L;
	private String tableName;

	public TableTab(String text) {
		this.tableName = text;
		add(new JLabel("Table" + this.tableName + " content!"));
	}

	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}
}
