package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
		
		JPanel messageBox = new JPanel();
		JLabel labela = new JLabel("Da li ste sigurni da zelite da obrisete studenta?");
		
		messageBox.setLayout(new GridBagLayout());	
		messageBox.add(labela);
		messageBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(messageBox, BorderLayout.CENTER);
		
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
				StudentiController.getInstance().obrisiStudenta(selectedIndex);
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
