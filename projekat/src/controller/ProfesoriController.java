package controller;

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
	
	public void dodajProfesora(Profesor profesor) {
		BazaProfesora.getInstance().dodajProfesora(profesor);
		Frame.getInstance().getProfTab().azurirajPrikaz("DODAT", -1);
	}
}
