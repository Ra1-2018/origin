package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProfesoriTableTab extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4032485403494609921L;
	private String tableName;
	JTable tabelaProfesora;
	private JScrollPane scrollPane;
	
	public ProfesoriTableTab(String text) {
		
			this.tableName = text;
			tabelaProfesora = new ProfesoriJTable();
			
			this.scrollPane = new JScrollPane(tabelaProfesora);
			scrollPane.setPreferredSize(new Dimension(1000, 700));
			add(scrollPane, BorderLayout.CENTER);

	}

	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}
}
