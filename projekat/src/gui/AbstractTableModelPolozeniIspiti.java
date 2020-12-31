package gui;

import javax.swing.table.AbstractTableModel;

import model.Student;

public class AbstractTableModelPolozeniIspiti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2633403946930461999L;

	Student student;
	
	AbstractTableModelPolozeniIspiti(Student student) {
		this.student = student;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return student.getColumnCountPolozeni();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return student.getPolozeniIspiti().size();
	}

	@Override
	public Object getValueAt(int i, int j) {
		// TODO Auto-generated method stub
		return student.getValueAtPolozeni(i, j);
	}
	
	@Override
	public String getColumnName(int column) {
		return student.getColumnNamePolozeni(column);
	}

}
