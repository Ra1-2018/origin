package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Student {
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private String godinaUpisa;
	private String trenutnaGodinaStudija;
	private Status status;
	private double prosecnaOcena;
	private List<Ocena> polozeniIspiti;
	private List<Predmet> nepolozeniIspiti;
	public enum Status {B, S}
	
	private List<String> koloneNepolozeni;
	private List<String> kolonePolozeni;

	public Student() {}
	
	
	public Student(String brojIndeksa, String ime, String prezime, String trenutnaGodinaStudija, Status status, double prosecnaOcena, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon, String emailAdresa, String godinaUpisa) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		polozeniIspiti = new ArrayList<Ocena>();

		initNepolozeneIspite();
		this.koloneNepolozeni = new ArrayList<String>();
		//---------------------------------------------
		this.koloneNepolozeni.add("Sifra");
		this.koloneNepolozeni.add("Naziv");
		this.koloneNepolozeni.add("Semestar");
		this.koloneNepolozeni.add("Godina");
		this.koloneNepolozeni.add("ESPB");
		
		initPolozeneIspite();
		this.kolonePolozeni = new ArrayList<String>();
		this.kolonePolozeni.add("Sifra predmeta");
		this.kolonePolozeni.add("Naziv predmeta");
		this.kolonePolozeni.add("ESPB");
		this.kolonePolozeni.add("Ocena");
		this.kolonePolozeni.add("Datum");
	}


	public void initNepolozeneIspite() {
		nepolozeniIspiti = new ArrayList<Predmet>();
		nepolozeniIspiti = BazaPredmeta.getInstance().getPredmeti();
	}
	
	public void initPolozeneIspite() {
		polozeniIspiti = new ArrayList<Ocena>();
		//Ocena ocena = new Ocena(BazaStudenata.getInstance().getStudenti().get(1), BazaPredmeta.getInstance().getPredmeti().get(1), 6, new GregorianCalendar(2020, Calendar.DECEMBER, 10).getTime());
		//Ocena ocena1 = new Ocena(BazaStudenata.getInstance().getStudenti().get(1), BazaPredmeta.getInstance().getPredmeti().get(2), 8, new GregorianCalendar(2020, Calendar.NOVEMBER, 11).getTime());
		//polozeniIspiti.add(ocena);
		//polozeniIspiti.add(ocena1);
	}
	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public Date getDatumRodjenja() {
		return datumRodjenja;
	}


	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}


	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}


	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}


	public String getKontaktTelefon() {
		return kontaktTelefon;
	}


	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}


	public String getEmailAdresa() {
		return emailAdresa;
	}


	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}


	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public String getGodinaUpisa() {
		return godinaUpisa;
	}


	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}


	public String getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}


	public void setTrenutnaGodinaStudija(String trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public double getProsecnaOcena() {
		return prosecnaOcena;
	}


	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}


	public List<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}


	public void setPolozeniIspiti(List<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}


	public List<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}


	public void setNepolozeniIspiti(List<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}

	//------------------------------------------------------------------------
	public int getColumnCountNepolozeni() {
		return 5;
	}
	
	public String getColumnNameNepolozeni(int index) {
		return this.koloneNepolozeni.get(index);
	}
	
	public Predmet getRowNepolozeni(int rowIndex) {
		return this.nepolozeniIspiti.get(rowIndex);
	}
	
	public String getValueAtNepolozeni(int row, int column) {
		Predmet predmet = this.nepolozeniIspiti.get(row);
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
	//--------------------------------------------------------------------
	
	//metode iz apstraktne klase realizovane
	public int getColumnCountPolozeni() {
		return 5;
	}
	
	public String getColumnNamePolozeni(int index) {
		return this.kolonePolozeni.get(index);
	}
	
	public String getValueAtPolozeni(int row, int column) {
		Ocena ocena = this.polozeniIspiti.get(row);
		switch(column) {
		case 0:
			return ocena.getPredmet().getId();
		case 1:
			return ocena.getPredmet().getNaziv();
		case 2:
			return "" + ocena.getPredmet().getEspb();
		case 3:
			return "" + ocena.getVrednost();
		case 4:
			return "" + ocena.getDatum();
		default:
			return null;
		}
	}
	
}