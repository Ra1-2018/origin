package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PredmetiTableTab extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8591224408195745175L;
	private String tableName;
	private JTable tabelaPredmeta;
	private JScrollPane scrollPane;
	
	public PredmetiTableTab(String text) {
		this.tableName = text;
		this.tabelaPredmeta = new PredmetiJTable();
		this.scrollPane = new JScrollPane(tabelaPredmeta);
		
		scrollPane.setPreferredSize(new Dimension(1000, 700));
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		
		model.fireTableDataChanged();
		validate();
	}

	public JTable getTabelaPredmeta() {
		return tabelaPredmeta;
	}

	public void setTabelaPredmeta(JTable tabelaPredmeta) {
		this.tabelaPredmeta = tabelaPredmeta;
	}
}