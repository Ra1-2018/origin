package gui;

import javax.swing.table.AbstractTableModel;

import model.Profesor;

public class AbstractTableModelPredmetiPoProfesoru extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6643396654384128386L;

	Profesor profesor;
	
	AbstractTableModelPredmetiPoProfesoru(Profesor profesor) {
		this.profesor = profesor;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return profesor.getListaPredmeta().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return profesor.getColumnCountPredmeti();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return profesor.getValueAtPredmeti(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return profesor.getColumnNamePredmeti(column);
	}
	
}
