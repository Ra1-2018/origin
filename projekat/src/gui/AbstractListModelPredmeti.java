package gui;

import javax.swing.AbstractListModel;

import model.Profesor;

public class AbstractListModelPredmeti extends AbstractListModel<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2471379725770481721L;
	private Profesor profesor;
	
	AbstractListModelPredmeti(Profesor profesor) {
		this.profesor = profesor;
		profesor.updateNePredaje();
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return profesor.getSizeNePredaje();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return profesor.getValueAtNePredaje(index);
	}

}
