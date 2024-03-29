package model;

import java.util.List;
import controller.Serijalizacija;
import java.util.ArrayList;
import model.Student.Status;
import java.io.FileNotFoundException;
import java.io.IOException;

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

	
	Status status1 = Status.B;
	Status status2 = Status.S;
	
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
		try {
			this.studenti = Serijalizacija.getInstance().deserijalizacijaStudenta();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudenti() {
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
		case 3:
			return student.getTrenutnaGodinaStudija();
		case 4:
			if(student.getStatus()==status1) 
				return "B";
			else if (student.getStatus()==status2)
				return "S";
		case 5: 
			return student.prosecnaOcena();
					
		default:
			return null;
		}
	}
	
	public void dodajStudenta(Student student) {
		this.studenti.add(student);
	}
	
	public void izmeniStudenta(int i, Student s) {
		Student stari = studenti.get(i);
		stari.setIme(s.getIme());
		stari.setPrezime(s.getPrezime());
		stari.setDatumRodjenja(s.getDatumRodjenja());
		stari.setAdresaStanovanja(s.getAdresaStanovanja());
		stari.setBrojIndeksa(s.getBrojIndeksa());
		stari.setEmailAdresa(s.getEmailAdresa());
		stari.setGodinaUpisa(s.getGodinaUpisa());
		stari.setTrenutnaGodinaStudija(s.getTrenutnaGodinaStudija());
		stari.setKontaktTelefon(s.getKontaktTelefon());
		stari.setProsecnaOcena(s.getProsecnaOcena());
		stari.setStatus(s.getStatus());
		
	}
	
	public void obrisiStudenta(int index) {
		this.studenti.remove(index);
	}
}
