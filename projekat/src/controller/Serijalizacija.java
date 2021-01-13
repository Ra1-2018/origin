package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	
	
	@SuppressWarnings("unchecked")
	public List<Student> deserijalizacijaStudenta() throws FileNotFoundException, IOException, ClassNotFoundException{
		List<Student> student1;
		File f = new File("objectstreamStudenti.txt");
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		try {
			student1 = (List<Student>)ois.readObject();	
			return student1;
		}
		finally {
			ois.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Profesor> deserijalizacijaProfesora() throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Profesor> profesor1;
		File f = new File("objectstreamProfesori.txt");
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		try {
			profesor1 = (List<Profesor>)ois.readObject();	
			return profesor1;
		}
		finally {
			ois.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Predmet> deserijalizacijaPredmeta() throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Predmet> predmet1;
		File f = new File("objectstreamPredmeti.txt");
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		try {
			predmet1 = (List<Predmet>)ois.readObject();	
			return predmet1;
		}
		finally {
			ois.close();
		}
	}
}
