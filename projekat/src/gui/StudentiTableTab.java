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
		this.setLayout(new BorderLayout());
		this.tableName = text;
		tabelaStudenata = new StudentiJTable();
		this.scrollPane = new JScrollPane(tabelaStudenata);
		
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
		AbstractTableModelStudenti modelStudenata = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		modelStudenata.fireTableDataChanged();
		validate();
	}

	public JTable getTabelaStudenata() {
		return tabelaStudenata;
	}

	public void setTabelaStudenata(JTable tabelaStudenata) {
		this.tabelaStudenata = tabelaStudenata;
	}
	

}
