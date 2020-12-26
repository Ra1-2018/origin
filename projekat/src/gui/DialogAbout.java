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
				"OPIS";
		
		opis.setText(text);
		add(opis);
		setVisible(true);
	
	}
}
