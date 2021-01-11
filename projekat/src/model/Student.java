package model;

import java.util.List;

import model.Predmet.Godina;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2565540264479146400L;
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
	private List<Predmet> nePohadja;

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

		//initNePohadja();
		
		initNepolozeneIspite();
		this.koloneNepolozeni = new ArrayList<String>();
		//---------------------------------------------
		this.koloneNepolozeni.add("Sifra predmeta");
		this.koloneNepolozeni.add("Naziv predmeta");
		this.koloneNepolozeni.add("ESPB");
		this.koloneNepolozeni.add("Godina studija");
		this.koloneNepolozeni.add("Semestar");
		
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
		//nepolozeniIspiti.add(BazaPredmeta.getInstance().getPredmeti().get(0));
	}
	
	public void initPolozeneIspite() {
		polozeniIspiti = new ArrayList<Ocena>();
	//	Ocena ocena = new Ocena(this, BazaPredmeta.getInstance().getPredmeti().get(1), 6, new GregorianCalendar(2020, Calendar.DECEMBER, 10).getTime());
	//	Ocena ocena1 = new Ocena(this, BazaPredmeta.getInstance().getPredmeti().get(2), 8, new GregorianCalendar(2020, Calendar.NOVEMBER, 11).getTime());
	//	polozeniIspiti.add(ocena);
	//	polozeniIspiti.add(ocena1);
	}
	
	public void initNePohadja() {
		nePohadja = new ArrayList<Predmet>();
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			
			boolean ima = false;
			
			int godinaP=0;
			
			if(p.getGodinaStudija().equals(Godina.PRVA)) {
				godinaP=1;
			}
			else if(p.getGodinaStudija().equals(Godina.DRUGA)) {
				godinaP=2;
			}
			else if(p.getGodinaStudija().equals(Godina.TRECA)) {
				godinaP=3;
			}
			else {
				godinaP=4;
			}
		
			String godina = this.getTrenutnaGodinaStudija();
			int godStud = 0;
			
			if(godina.equals("IV (cetvrta)")) {
				godStud = 4;
			}
			else if(godina.equals("III (treca)")) {
				godStud = 3;
			}
			else if(godina.equals("II (druga)")) {
				godStud = 2;
			}
			else {
				godStud = 1;
			}
			
			if(godStud < godinaP) {
				ima = true;
			}
			
			for(Ocena o : polozeniIspiti) {
				if(p.getId().equals(o.getPredmet().getId())) {
					ima = true;
				}
			}
			
			for(Predmet p1 : nepolozeniIspiti) {
				if(p.getId().equals(p1.getId())) {
					ima = true;
				}
			}
			
			if(!ima) {
				nePohadja.add(p);
			}
		}
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
	
	public List<Predmet> nePohadja() {
		return nePohadja;
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
			return predmet.getEspb() + "";
		case 3:
			String[] godine = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
			int idxGodine = predmet.getGodinaStudija().ordinal();
			return godine[idxGodine];
		case 4:
			String[] semestri = {"Letnji", "Zimski"};
			int idxSemestra = predmet.getSemestar().ordinal();
			return semestri[idxSemestra];
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
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date d = ocena.getDatum();
			String newDateString = sdf.format(d);
			return "" + newDateString;
		default:
			return null;
		}
	}
	
	public long ukupnoBodova() {
		long suma=0;
		
		for(int i=0; i<polozeniIspiti.size(); i++) {
			suma+=polozeniIspiti.get(i).getPredmet().getEspb();
		}
		return suma;
	}
	
	public String prosecnaOcena() {
		long suma = 0;
		double srednjaOcena=0;
		
		for(int i=0; i<polozeniIspiti.size(); i++) {
			suma+=polozeniIspiti.get(i).getVrednost();
		}
		String sumica = suma+"";
		srednjaOcena=Double.parseDouble(sumica)/polozeniIspiti.size();
		
		DecimalFormat df=new DecimalFormat("0.00");
		String formate = df.format(srednjaOcena);
		return formate;
	}
	
	public void insertOcena(Ocena ocena) {
		polozeniIspiti.add(ocena);
	}
	
	public void removeOcena(Ocena ocena) {
		polozeniIspiti.remove(ocena);
	}
	
	public void insertPredmet(Predmet predmet) {
		nepolozeniIspiti.add(predmet);
	}
	
	public void removePredmet(Predmet predmet) {
		nepolozeniIspiti.remove(predmet);
	}

	public Object getValueAtNePohadja(int index) {
		// TODO Auto-generated method stub
		Predmet predmet = this.nePohadja.get(index);
		return predmet.getId() + " - " + predmet.getNaziv();
	}

	public int getSizeNePohadja() {
		// TODO Auto-generated method stub
		return nePohadja.size();
	}

	public void dodajPredmet(int index) {
		
		Predmet predmet = nePohadja.get(index);
		nePohadja.remove(index);
		nepolozeniIspiti.add(predmet);
	}
		
	
	public void dodajNepohadjani(Predmet predmet) {
		nePohadja.add(predmet);
	}


}