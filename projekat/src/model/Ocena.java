package model;

import java.io.Serializable;
import java.util.Date;

public class Ocena implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5165565334626819873L;
	private Student student;
	private Predmet predmet;
	private long vrednost;
	private Date datum;


	public Ocena() {}
	
	public Ocena(Student student, Predmet predmet, long vrednost, Date datum) {
		super();
		this.student = student;
		this.vrednost = vrednost;
		this.datum = datum;
		this.predmet = predmet;
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

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Predmet getPredmet() {
		return predmet;
	}
	
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
}