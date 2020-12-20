package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentiTableTab extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2992467426807680946L;
	
	
	private String tableName;
	JTable tabelaStudenata;
	private JScrollPane scrollPane;
	
	public StudentiTableTab(String text) {
		this.tableName = text;
		tabelaStudenata = new StudentiJTable();
		
		this.scrollPane = new JScrollPane(tabelaStudenata);
		scrollPane.setPreferredSize(new Dimension (1000, 700));
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelStudenti modelStudenata = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		modelStudenata.fireTableDataChanged();
		validate();
	}

}
