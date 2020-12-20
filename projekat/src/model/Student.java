package model;

import java.util.List;
import java.util.ArrayList;


public class Student {
	
	private String prezime;
	private String ime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private String godinaUpisa;
	private String trenutnaGodinaStudija;
	private Status status;
	private double prosecnaOcena;
	private List<Ocena> polozeniIspiti;
	private List<Ocena> nepolozeniIspiti;
	public enum Status {B, S}

	public Student() {}
	
	
	public Student(String brojIndeksa, String ime, String prezime, String trenutnaGodinaStudija, Status status, double prosecnaOcena, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String emailAdresa, String godinaUpisa) {
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
		nepolozeniIspiti = new ArrayList<Ocena>();
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


	public String getDatumRodjenja() {
		return datumRodjenja;
	}


	public void setDatumRodjenja(String datumRodjenja) {
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


	public List<Ocena> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}


	public void setNepolozeniIspiti(List<Ocena> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}

}