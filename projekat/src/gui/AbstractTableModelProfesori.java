package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9031655068332887694L;

	public AbstractTableModelProfesori() {}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}
}
