package model;

enum Semestar {LETNJI, ZIMSKI}

public class Predmet {
	private long id;
	private String naziv;
	private Semestar semestar;
	private long godinaStudija;
	private Profesor profesor;
	private long espb;
	//private List<Student> studentiPolozili;
	//private List<Student> studentiPali;
	
	public Predmet() {}
	
	public Predmet(long id, String naziv, Semestar semestar, long godinaStudija, Profesor profesor, long espb) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.espb = espb;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(long godinaStudija) {
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

}
