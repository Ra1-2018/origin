package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class TableTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6747903089342725243L;
	private String tableName;

	public TableTab(String text) {
	
		if(text == "Studenti") {
	    StudentiJTable tabelaStudenata = new StudentiJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
		add(scrollPane, BorderLayout.CENTER);
		}
			
	}

	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}
}
