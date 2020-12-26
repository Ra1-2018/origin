package gui;

//import java.awt.Color;
//import java.awt.Font;
import javax.swing.JDialog;
//import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DialogHelp extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4561836943292265193L;

	
	public DialogHelp() {
		super();
		
		setSize(700,500);
		setLocationRelativeTo(Frame.getInstance());
		setTitle("Help");
		
		JTextArea instrukcije = new JTextArea(300,300);
		
		
		String text = 
				"Uputstva za koriscenje aplikacije:\n\r"+
			    "1. Dodavanje studenta - pritiskom prvog dugmeta u ToolBar-u/izborom stavke menija New\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda\n\r"+
				"2. Dodavanje profesora - pritiskom prvog dugmeta u ToolBar-u/izborom stavke menija New\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda\n\r"+
				"\n\r"+
				"Akceleratori:"
				+ "CTRL-N - omogucava dodavanje novog entiteta sistem u zavisnosti od selektovanog taba";
		
		instrukcije.setText(text);
		add(instrukcije);
		setVisible(true);
	
	}
}
