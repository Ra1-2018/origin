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

public class StudentiJTable extends JTable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 3692546981412892622L;
	private static TableRowSorter<AbstractTableModelStudenti> sorter;

		public StudentiJTable() {
			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			
			
			AbstractTableModelStudenti model = new AbstractTableModelStudenti();
			sorter = new TableRowSorter<AbstractTableModelStudenti>(model);
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
			
			String[] reci = input.split(" ");
			if(reci.length>3) {
				JOptionPane.showMessageDialog(null,
						"Pretraga se izvrsava na osnovu dela prezimena, dela imena i dela indeksa",
						"Greska pri pretrazi studenta", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			List<RowFilter<AbstractTableModelStudenti, Object>> filters = new ArrayList<RowFilter<AbstractTableModelStudenti, Object>>();
			for(int i=0; i<reci.length; i++)
				filters.add(RowFilter.regexFilter(("(?i)" + reci[i]), 2-i));
			
			RowFilter<AbstractTableModelStudenti, Object> rf = null;
			try {
		        rf = RowFilter.andFilter(filters);
		    } catch (java.util.regex.PatternSyntaxException e) {
		        return;
		    }
		    sorter.setRowFilter(rf);
		}

}
