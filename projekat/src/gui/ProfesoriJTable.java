package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class ProfesoriJTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5663696672979969804L;
	private static TableRowSorter<AbstractTableModelProfesori> sorter;
	
	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		AbstractTableModelProfesori model = new AbstractTableModelProfesori();
		sorter = new TableRowSorter<AbstractTableModelProfesori>(model);
		
		this.setModel(model);
		this.setRowSorter(sorter);
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

		Component c = super.prepareRenderer(renderer, row, column);

		if (isRowSelected(row)) {
			c.setBackground(Color.ORANGE);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public static void newFilter(String input) {
		/*RowFilter<AbstractTableModelProfesori, Object> rf = null;
		try {
	        rf = RowFilter.regexFilter(filterText, column);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(rf);*/
		String[] reci = input.split(" ");
		if(reci.length>2) {
			JOptionPane.showMessageDialog(null,
					"Pretraga se izvrsava na osnovu dela prezimena i dela imena",
					"Greska pri pretrazi profesora", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		List<RowFilter<AbstractTableModelProfesori, Object>> filters = new ArrayList<RowFilter<AbstractTableModelProfesori, Object>>();
		for(int i=0; i<reci.length; i++)
			filters.add(RowFilter.regexFilter(("(?i)" + reci[i]), 1-i));
		
		RowFilter<AbstractTableModelProfesori, Object> rf = null;
		try {
	        rf = RowFilter.andFilter(filters);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(rf);
	}
}
