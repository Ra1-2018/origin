package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


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
	}


	public void initNepolozeneIspite() {
		nepolozeniIspiti = new ArrayList<Predmet>();
		nepolozeniIspiti = BazaPredmeta.getInstance().getPredmeti();
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
}