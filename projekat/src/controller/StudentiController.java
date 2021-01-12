package controller;

import java.util.List;

import gui.Frame;
import model.BazaStudenata;
import model.Student;

public class StudentiController {
	
	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if(instance == null) {
			instance = new StudentiController();
		}
		
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(Student student) {
		BazaStudenata.getInstance().dodajStudenta(student);
		Frame.getInstance().getStudTab().azurirajPrikaz("DODAT", -1 );
	}
	
	public void izmeniStudenta(int i, Student s) {
		BazaStudenata.getInstance().izmeniStudenta(i, s);
		Frame.getInstance().getStudTab().azurirajPrikaz(null, -1);
	}

	public List<Student> getListaSvihStudenata() {
		return BazaStudenata.getInstance().getStudenti();
	}
	
	public void obrisiStudenta(int index) {
		BazaStudenata.getInstance().obrisiStudenta(index);
		Frame.getInstance().getStudTab().azurirajPrikaz("UKLONJEN", index);
	}
	
	public void updatePrikaz() {
		Frame.getInstance().getStudTab().azurirajPrikaz(null, -1);
	}

}
