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
		this.setLayout(new BorderLayout());
		this.tableName = text;
		this.tabelaPredmeta = new PredmetiJTable();
		this.scrollPane = new JScrollPane(tabelaPredmeta);
		
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
		
		this.add(scrollPane, BorderLayout.CENTER);
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