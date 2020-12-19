package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class TableTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6747903089342725243L;
	private String tableName;
	private JScrollPane scrollPane;

	public TableTab(String text) {
	
		if(text == "Studenti") {
			this.tableName = text;
		    StudentiJTable tabelaStudenata = new StudentiJTable();
	
			this.scrollPane = new JScrollPane(tabelaStudenata);
			scrollPane.setPreferredSize(new Dimension(1000, 700));
			add(scrollPane, BorderLayout.CENTER);
		}
		else if(text == "Profesori") {
			this.tableName = text;
			ProfesoriJTable tabelaProfesora = new ProfesoriJTable();
			
			this.scrollPane = new JScrollPane(tabelaProfesora);
			scrollPane.setPreferredSize(new Dimension(1000, 700));
			add(scrollPane, BorderLayout.CENTER);
		}
		else if(text == "Predmeti") {
			this.tableName = text;
			add(new JLabel("Table" + this.tableName + " content!"));
		}
			
	}

	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}
}
