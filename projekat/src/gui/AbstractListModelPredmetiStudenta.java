package gui;

import javax.swing.AbstractListModel;

import model.Student;

public class AbstractListModelPredmetiStudenta extends AbstractListModel<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9095628081614008022L;
	
	private Student student;
	
	AbstractListModelPredmetiStudenta(Student student) {
		this.student = student;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return student.getValueAtNePohadja(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return student.getSizeNePohadja();
	}

}
