package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Serijalizacija {

	private static Serijalizacija instance = null;
	
	public static Serijalizacija getInstance() {
		if(instance == null) {
			instance = new Serijalizacija();
		}
		return instance;
	}
	
	private Serijalizacija() {}
	
	public void serijalizacijaStudenta() throws FileNotFoundException, IOException {
		File f = new File("objectstreamStudenti.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		List<Student> studenti = BazaStudenata.getInstance().getStudenti();
		try {
			oos.writeObject(studenti);
		} finally {
			oos.close();
		}
	}
	
	public void serijalizacijaProfesora() throws FileNotFoundException, IOException {
		File f = new File("objectstreamProfesori.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		List<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
		try {
			oos.writeObject(profesori);
		} finally {
			oos.close();
		}
	}
	
	public void serijalizacijaPredmeta() throws FileNotFoundException, IOException {
		File f = new File("objectstreamPredmeti.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
		try {
			oos.writeObject(predmeti);
		} finally {
			oos.close();
		}
	}
}
