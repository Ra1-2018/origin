package controller;

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
	
	public void dodajStudenta(Student student) {
		BazaStudenata.getInstance().dodajStudenta(student);
	}

}
