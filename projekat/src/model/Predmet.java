package model;

import java.util.List;
import java.util.ArrayList;

public class Predmet {
	
	public enum Semestar {LETNJI, ZIMSKI}
	public enum Godina {PRVA, DRUGA, TRECA, CETVRTA}
	
	private String id;
	private String naziv;
	private Semestar semestar;
	private Godina godinaStudija;
	private Profesor profesor;
	private long espb;
	private List<Student> studentiPolozili;
	private List<Student> studentiPali;
	private List<Profesor> profesori;
	
	public Predmet() {}
	
	public Predmet(String id, String naziv, Semestar semestar, Godina godinaStudija,Profesor profesor, long espb) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.espb = espb;
		studentiPolozili = new ArrayList<Student>();
		studentiPali = new ArrayList<Student>();
		profesori = new ArrayList<Profesor>();
		
		
		profesori.add(BazaProfesora.getInstance().getProfesori().get(0));
		profesori.add(BazaProfesora.getInstance().getProfesori().get(1));
		profesori.add(BazaProfesora.getInstance().getProfesori().get(2));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public Godina getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Godina godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public long getEspb() {
		return espb;
	}

	public void setEspb(long espb) {
		this.espb = espb;
	}

	public List<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(List<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public List<Student> getStudentiPali() {
		return studentiPali;
	}

	public void setStudentiPali(List<Student> studentiPali) {
		this.studentiPali = studentiPali;
	}

	public Object getValueAtProf(int i) {
		// TODO Auto-generated method stub
		Profesor profesor = this.profesori.get(i);
		return profesor.getIme() + " " + profesor.getPrezime();
	}

	public int getSizeProf() {
		// TODO Auto-generated method stub
		return profesori.size();
	}

	public Profesor dodajProfesora(int selectedIndex) {
		// TODO Auto-generated method stub
		profesor = profesori.get(selectedIndex);
		profesori.remove(selectedIndex);
		return profesor;
		}
}

