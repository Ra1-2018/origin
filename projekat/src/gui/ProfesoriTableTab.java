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
	private JTable tabelaProfesora;
	private JScrollPane scrollPane;
	
	public ProfesoriTableTab(String text) {
			this.setLayout(new BorderLayout());
			this.tableName = text;
			tabelaProfesora = new ProfesoriJTable();
			this.scrollPane = new JScrollPane(tabelaProfesora);

			JPanel panNorth = new JPanel();
			panNorth.setPreferredSize(new Dimension(1000, 30));
			this.add(panNorth, BorderLayout.NORTH);
			
			JPanel panSouth = new JPanel();
			panSouth.setPreferredSize(new Dimension(1000, 30));
			this.add(panSouth, BorderLayout.SOUTH);
			
			JPanel panWest = new JPanel();
			panWest.setPreferredSize(new Dimension(80, 1000));
			this.add(panWest, BorderLayout.WEST);
			
			JPanel panEast = new JPanel();
			panEast.setPreferredSize(new Dimension(80, 1000));
			this.add(panEast, BorderLayout.EAST);
			
			add(scrollPane, BorderLayout.CENTER);
	}

	public void saveTableContent() {
		System.out.println("Saving table: " + this.tableName);
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		
		model.fireTableDataChanged();
		validate();
	}

	public JTable getTabelaProfesora() {
		return tabelaProfesora;
	}

	public void setTabelaProfesora(JTable tabelaProfesora) {
		this.tabelaProfesora = tabelaProfesora;
	}
}
