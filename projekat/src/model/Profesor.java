package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Profesor {
	
	public enum Zvanje {SARADNIK_U_NASTAVI, ASISTENT, ASISTENT_SA_DOKTORATOM, DOCENT, VANREDNI_PROFESOR, REDOVNI_PROFESOR, PROFESOR_EMERITUS}
	public enum Titula {BSC, MSC, MR, DR, PROF_DR}
	
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	private List<Predmet> predmeti;
	private List<Predmet> nePredaje;
	
	private List<String> kolonePredmeti;
	
	public Profesor() {}
	
	public Profesor(String ime, String prezime, Date datumRodjenja, String adresaStanovanja,
			String kontaktTelefon, String emailAdresa, String adresaKancelarije, String brojLicneKarte,
			Titula titula, Zvanje zvanje) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		
		predmeti = new ArrayList<Predmet>();
		
		this.kolonePredmeti = new ArrayList<String>();
		this.kolonePredmeti.add("Sifra");
		this.kolonePredmeti.add("Naziv");
		this.kolonePredmeti.add("Godina studija");
		this.kolonePredmeti.add("Semestar");
	}
	
	public void initNePredaje( ) {
		nePredaje = new ArrayList<Predmet>();
		List<Predmet> sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet predmet : sviPredmeti) {
			if(!predmeti.contains(predmet))
				nePredaje.add(predmet);
		}
	}
	
	public void initPredmete() {
		this.predmeti.add(BazaPredmeta.getInstance().getPredmeti().get(0));
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
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

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public List<Predmet> getListaPredmeta() {
		return predmeti;
	}

	public void setListaPredmeta(List<Predmet> listaPredmeta) {
		this.predmeti = listaPredmeta;
	}
	
	public int getColumnCountPredmeti() {
		return 4;
	}
	
	public String getColumnNamePredmeti(int index) {
		return this.kolonePredmeti.get(index);
	}
	
	public String getValueAtPredmeti(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch(column) {
		case 0:
			return predmet.getId();
		case 1:
			return predmet.getNaziv();
		case 2:
			String[] godine = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
			int idxGodine = predmet.getGodinaStudija().ordinal();
			return godine[idxGodine];
		case 3:
			String[] semestri = {"Letnji", "Zimski"};
			int idxSemestra = predmet.getSemestar().ordinal();
			return semestri[idxSemestra];
		default:
			return null;
		}
	}
	
	public int getSizeNePredaje() {
		return nePredaje.size();
	}
	
	public String getValueAtNePredaje(int index) {
		Predmet predmet = this.nePredaje.get(index);
		return predmet.getId() + " - " + predmet.getNaziv();
	}
	
	public void dodajPredmet(int index) {
		Predmet predmet = nePredaje.get(index);
		nePredaje.remove(index);
		predmeti.add(predmet);
	}
}
