package gui;

import javax.swing.JDialog;
//import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DialogAbout extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4561836943292265193L;

	
	public DialogAbout() {
		super();
		
		setSize(700,500);
		setLocationRelativeTo(Frame.getInstance());
		setTitle("About");
		
		JTextArea opis = new JTextArea(300,300);
		
		
		String text = 
				
				"\n Verzija aplikacije: Studentska služba v1.0\n\r"+
				"Aplikacija za potrebe referenta studentske službe\n\n\r"+
				"Aplikacija je implementirana upotrebom Java programskog jezika.\n\r"+
				"Grafička korisička sprega razvijena je upotrebom Swing biblioteke.\n\r"+
			    "Glavni prozor aplikacije sadrži MeniBar, ToolBar, tabele sa entitetima i StatusBar.\n\r"+
						"Funkcionalnosti aplikacije pojašnjene su korisniku u okviru dijaloga za pomoć 'Help'.\n\r"+
			    "\n\r"+
				"\n\n\n Student 1 - Bogdana Živković"
				+ "\nRođena u Novom Sadu 20. 7. 1999. . \n Trenutno pohađa 3. godinu osnovnih akademskih studija na Fakultetu tehničkih nauka na smeru Računarstvo i automatika.\n Pohađala prirodno-matematički smer Gimnazije 'Jovan Jovanović Zmaj'."
				+ "\n Student 2 - Nikola Ivanović"
				+ "\nRođen u Novom Sadu 17. 12. 1999. . \n Trenutno pohađa 3. godinu osnovnih akademskih studija na Fakultetu tehničkih nauka na smeru Računarstvo i automatika.\n Pohađao prirodno-matematički smer Gimnazije 'Jovan Jovanović Zmaj'.";
		opis.setText(text);
		add(opis);
		setVisible(true);
	
	}
}
