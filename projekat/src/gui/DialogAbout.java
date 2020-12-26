package gui;

//import java.awt.Color;
//import java.awt.Font;
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
				
				"\n Verzija aplikacije: Studentska slu�ba v1.0 "
				+"\n\n\n Student 1 - Bogdana �ivkovi�"
				+ "\nRo�ena u Novom Sadu 20. 7. 1999. . \n Trenutno poha�a 3. godinu osnovnih akademskih studija na Fakultetu tehni�kih nauka na smeru Ra�unarstvo i automatika.\n Poha�ala prirodno-matemati�ki smer Gimnazije 'Jovan Jovanovi� Zmaj'."
				+ "\n Student 2 - Nikola Ivanovi�"
				+ "\nRo�en u Novom Sadu 17. 12. 1999. . \n Trenutno poha�a 3. godinu osnovnih akademskih studija na Fakultetu tehni�kih nauka na smeru Ra�unarstvo i automatika.\n Poha�ao prirodno-matemati�ki smer Gimnazije 'Jovan Jovanovi� Zmaj'.";
		opis.setText(text);
		add(opis);
		setVisible(true);
	
	}
}
