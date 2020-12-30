package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogObrisiStudenta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1903496684347185001L;

	public DialogObrisiStudenta() {
		super();
		setTitle("Brisanje studenta");
		setSize(400, 200);
		setLocationRelativeTo(this.getParent());
		setModal(true);
		
		JPanel dialog = new JPanel();
		BoxLayout box = new BoxLayout(dialog, BoxLayout.Y_AXIS);
		dialog.setLayout(box);
		dialog.add(Box.createVerticalStrut(25));
		
		JLabel labela = new JLabel("Da li ste sigurni da zelite da obrisete studenta?");
		labela.setPreferredSize(new Dimension(380, 20));
		
		dialog.add(labela);
		
		JPanel dugmad = new JPanel();
		BoxLayout box1 = new BoxLayout(dugmad, BoxLayout.X_AXIS);
		dugmad.setLayout(box1);
		
		JButton btnPotvrda = new JButton("Da");
		JButton btnOdustanak = new JButton("Ne");
		btnPotvrda.setPreferredSize(new Dimension(100, 30));
		btnOdustanak.setPreferredSize(new Dimension(100, 30));
		
	
	
	}
}
