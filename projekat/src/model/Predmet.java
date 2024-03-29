package model;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2976371982658592118L;

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
	
	public void ukloniProfesora(Profesor p) {
		if(profesor!=null) {
		if(this.profesor.getBrojLicneKarte().equals(p.getBrojLicneKarte())) {
			
				this.profesor=null;
			}
		}
	}
}

