package controller;

import java.util.List;

import gui.Frame;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;


public class PredmetiController {

	private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	private PredmetiController() {}
	
	public List<Predmet> getPredmeti() {
		return BazaPredmeta.getInstance().getPredmeti();
	}
	
	public void izmeniPredmet(int i, Predmet p) {
		BazaPredmeta.getInstance().izmeniPredmet(i, p);
		Frame.getInstance().getPredTab().azurirajPrikaz(null, -1);
	}
	
	public void dodajPredmet(Predmet predmet) {
		BazaPredmeta.getInstance().dodajPredmet(predmet);
		Frame.getInstance().getPredTab().azurirajPrikaz("DODAT", -1);
	}
	
	public void obrisiPredmet(int index) {
		BazaPredmeta.getInstance().obrisiPredmet(index);
		Frame.getInstance().getPredTab().azurirajPrikaz("UKLONJEN", index);
	}
	
	public void obrisiProfesoraPredmetu(Profesor p) {
		for(Predmet predmet: BazaPredmeta.getInstance().getPredmeti())
		predmet.ukloniProfesora(p);
			
	}
}