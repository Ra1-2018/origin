package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class BazaProfesora {
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<String> kolone;

	private BazaProfesora() {
	
		initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}

	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();	
			profesori.add(new Profesor("Mika", "Mikic",new GregorianCalendar(1971, Calendar.JANUARY, 1).getTime() ,"Bul. Oslobodjenja 58", "065128291", "mika.mikic@gmail.com", "Balzakova 13", "123456789", Titula.DR, Zvanje.REDOVNI_PROFESOR));
			profesori.add(new Profesor("Pera", "Peric", new GregorianCalendar(1971, Calendar.FEBRUARY, 2).getTime(),"Bul. Oslobodjenja 59", "065128292", "pera.peric@gmail.com", "Balzakova 14", "123456788", Titula.MR, Zvanje.DOCENT));
			profesori.add(new Profesor("Djordje", "Djordjic", new GregorianCalendar(1971, Calendar.MARCH, 3).getTime(),"Bul. Oslobodjenja 60", "065128293", "djordje.djordjic@gmail.com", "Balzakova 15", "123456787", Titula.PROF_DR, Zvanje.ASISTENT));
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			String[] titule = { "BSc", "MSc", "mr", "dr", "prof.dr" };
			int idxTitule = profesor.getTitula().ordinal();
			return titule[idxTitule];
		case 3:
			String[] zvanja = { "saradnik u nastavi", "asistent", "asistent sa doktoratom", "docent", "vanredni profesor", "redovni profesor", "profesor emeritus" };
			int idxZvanja = profesor.getZvanje().ordinal();
			return zvanja[idxZvanja];
		default:
			return null;
		}
	}
	
	public void dodajProfesora(Profesor profesor) {
		this.profesori.add(profesor);
	}
}
