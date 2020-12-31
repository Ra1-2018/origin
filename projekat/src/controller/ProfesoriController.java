package controller;

import java.util.List;

import gui.Frame;
import model.BazaProfesora;
import model.Profesor;

public class ProfesoriController {
private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public List<Profesor> getProfesori() {
		return BazaProfesora.getInstance().getProfesori();
	}
	
	public void dodajProfesora(Profesor profesor) {
		BazaProfesora.getInstance().dodajProfesora(profesor);
		Frame.getInstance().getProfTab().azurirajPrikaz("DODAT", -1);
	}
	
	public void izmeniProfesora(int index, Profesor profesor) {
		BazaProfesora.getInstance().izmeniProfesora(index, profesor);
		Frame.getInstance().getProfTab().azurirajPrikaz(null, -1);
	}
	
	public void obrisiProfesora(int index) {
		BazaProfesora.getInstance().obrisiProfesora(index);
		Frame.getInstance().getProfTab().azurirajPrikaz("UKLONJEN", index);
	}

}
