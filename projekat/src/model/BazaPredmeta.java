package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.Serijalizacija;
//import model.Predmet.Godina;
//import model.Predmet.Semestar;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private BazaPredmeta() {
		
		initPredmete();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina");
		this.kolone.add("ESPB");
	}
	
	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		//	predmeti.add(new Predmet("A1", "Analiza 1", Semestar.ZIMSKI, Godina.PRVA, BazaProfesora.getInstance().getProfesori().get(0), 9));
		//	predmeti.add(new Predmet("A2", "Analiza 2", Semestar.ZIMSKI, Godina.DRUGA, BazaProfesora.getInstance().getProfesori().get(1), 9));
		//	predmeti.add(new Predmet("OP", "Objektno programiranje", Semestar.ZIMSKI, Godina.DRUGA, BazaProfesora.getInstance().getProfesori().get(2), 6));
		
		try {
			this.predmeti = Serijalizacija.getInstance().deserijalizacijaPredmeta();
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

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch(column) {
		case 0:
			return predmet.getId();
		case 1:
			return predmet.getNaziv();
		case 2:
			String[] semestri = {"Letnji", "Zimski"};
			int idxSemestra = predmet.getSemestar().ordinal();
			return semestri[idxSemestra];
		case 3:
			String[] godine = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
			int idxGodine = predmet.getGodinaStudija().ordinal();
			return godine[idxGodine];
		case 4:
			return predmet.getEspb() + "";
		default:
			return null;
		}
	}
	
	public void dodajPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}
	
	public void izmeniPredmet(int i, Predmet p) {
		Predmet predmet = predmeti.get(i);
		predmet.setId(p.getId());
		predmet.setNaziv(p.getNaziv());
		predmet.setSemestar(p.getSemestar());
		predmet.setEspb(p.getEspb());
		predmet.setGodinaStudija(p.getGodinaStudija());
		predmet.setProfesor(p.getProfesor());	
	}
	
	public void obrisiPredmet(int index) {
		this.predmeti.remove(index);
	}

}
