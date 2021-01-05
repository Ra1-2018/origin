package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class PredmetiJTable extends JTable{
	
	private static final long serialVersionUID = -5663696672979969804L;

	private static TableRowSorter<AbstractTableModelPredmeti> sorter;
	
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		AbstractTableModelPredmeti model = new AbstractTableModelPredmeti();
		sorter = new TableRowSorter<AbstractTableModelPredmeti>(model);
		
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
		RowFilter< AbstractTableModelPredmeti,Object> rf = null;
		
		try {
			rf = RowFilter.regexFilter(("(?i)" + input), 1);
		} catch(java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
}