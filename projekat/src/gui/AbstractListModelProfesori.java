package gui;

import javax.swing.AbstractListModel;

import model.Predmet;

public class AbstractListModelProfesori extends AbstractListModel<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254484288779343278L;
    private Predmet predmet;
    
    AbstractListModelProfesori(Predmet p) {
    	this.predmet = p;
    }
    
	@Override
	public Object getElementAt(int i) {
		// TODO Auto-generated method stub
		return predmet.getValueAtProf(i);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return predmet.getSizeProf();
	}

}
