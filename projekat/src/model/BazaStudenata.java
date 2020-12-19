package model;

import java.util.List;
import java.util.ArrayList;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudenata() {
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}
	
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		Status status1 = Status.B;
		Status status2 = Status.S;
		studenti.add(new Student("RA1-2018", "Nikola", "Ivanovic", 3, status1 , 9.76, "17. 12. 1999.", "Resavska 5", "0101010101", "nikolaiv@gmail.com", 2018));
		studenti.add(new Student("RA2-2018", "Bogdana", "Zivkovic", 3, status1 , 9.35, "20. 7. 1999.", "Iva Andrica 23", "0202020202", "bogdanaz@gmail.com", 2018));
		studenti.add(new Student("PSI55-2017", "Savo", "Oroz", 4, status2 , 7.55, "28. 5. 1998.", "Balzakova 17", "03030303", "jasamsavocarina@gmail.com", 2017));
	}
	
	
	
	public List<Student> getStudent() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
	//	case 3:
	//		return student.getTrenutnaGodinaStudija();
	//	case 4:
	//		return student.getStatus();
	//	case 5: 
	//		return student.getProsecnaOcena();
		default:
			return null;
		}
	}
}
