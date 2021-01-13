package gui;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import model.BazaStudenata;

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
			sorter.setComparator(5, new Comparator<String>() {

				@Override
				public int compare(String arg0, String arg1) {
					
					Double double1 = Double.parseDouble(arg0.replace(',', '.'));
					Double double2 = Double.parseDouble(arg1.replace(',', '.'));
					return double1.compareTo(double2);
					}
	
			});
		
			
			sorter.setComparator(0, new Comparator<String>() {
				
				public int compare(String o1, String o2) {
					
					String[] parts1 = o1.split("-");
					String p11 = parts1[0];
					String p21 = parts1[1];
					
					String[] parts2 = o2.split("-");
					String p12 = parts2[0];
					String p22 = parts2[1];
					
					int razlika;
					
					int ret = extractString(p11).compareTo(extractString(p12));
					if(ret==0) {
						razlika = extractInt(p21) - extractInt(p22);
						
						if(razlika==0) {
							return extractInt(p11) - extractInt(p12);
						}
						
						else 
							return razlika;
					}
						
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
