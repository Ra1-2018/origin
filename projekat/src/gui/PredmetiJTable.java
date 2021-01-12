package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

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
		
		sorter.setComparator(0, new Comparator<String>() {

			@Override
			public int compare(String name1, String name2) {
				int ret = extractString(name1).compareTo(extractString(name2));
				if(ret == 0)
					return extractInt(name1) - extractInt(name2);
				else
					return ret;
			}
			
			String extractString(String s) {
				return s.replaceAll("\\d", "");
			}
			
			int extractInt(String s) {
				String num = s.replaceAll("\\D", "");
				return num.isEmpty() ? 0 : Integer.parseInt(num);
			}
		});
		
		sorter.setComparator(4, new Comparator<String>() {
			 
		    @Override
		    public int compare(String name1, String name2) {
		    	Long long1 = Long.parseLong(name1);
		    	Long long2 = Long.parseLong(name2);
                return long1.compareTo(long2);
		    }
		});
		
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