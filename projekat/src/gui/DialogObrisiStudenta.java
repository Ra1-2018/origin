package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StudentiController;

public class DialogObrisiStudenta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1903496684347185001L;

	public DialogObrisiStudenta(int selectedIndex) {
		super();
		setTitle("Brisanje studenta");
		setSize(450, 200);
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
		
		dugmad.add(Box.createHorizontalGlue());
		dugmad.add(btnPotvrda);
		dugmad.add(Box.createHorizontalStrut(50));
		dugmad.add(btnOdustanak);
		dugmad.add(Box.createHorizontalGlue());
		
		add(dugmad,BorderLayout.SOUTH);
		
		btnPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				StudentiController.getInstance();
				dispose();
			}
		});
		
		btnOdustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	
	
	}
}
