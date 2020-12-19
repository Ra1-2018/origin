package model;

public class Ocena {

	private Student student;
//	private Predmet predmet;
	private long vrednost;
	private long datum;


	public Ocena() {}
	
	public Ocena(Student student, long vrednost, long datum) {
		super();
		this.student = student;
		this.vrednost = vrednost;
		this.datum = datum;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public long getVrednost() {
		return vrednost;
	}

	public void setVrednost(long vrednost) {
		this.vrednost = vrednost;
	}

	public long getDatum() {
		return datum;
	}

	public void setDatum(long datum) {
		this.datum = datum;
	}
	
//	public Predmet getPredmet() {
//		return predmet;
//	}
	
//	public void setPredmet(Predmet predmet) {
//		this.predmet = predmet;
//	}
	
}