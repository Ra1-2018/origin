package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Ocena;
import model.Predmet;
import model.Student;

public class DialogObrisiOcenu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1599877757650275252L;

	
	private Predmet predmet;
	private NepolozeniPredmetiJTable nepolozeni;

	public DialogObrisiOcenu(PolozeniIspitiJTable polozeni, NepolozeniPredmetiJTable nepolozeni, Student student) {
		
		super();
		this.nepolozeni = nepolozeni;
		
		setSize(400, 150);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Ponistavanje ocene");
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		dialogPanel.add(Box.createVerticalStrut(25));
		JPanel panelLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panelLabel, BoxLayout.X_AXIS);
		panelLabel.setLayout(labelLayout);
		JLabel poruka = new JLabel("Da li ste sigurni da zelite da ponistite ocenu?");
		panelLabel.add(Box.createHorizontalGlue());
		panelLabel.add(poruka);
		panelLabel.add(Box.createHorizontalGlue());
		dialogPanel.add(panelLabel);
		dialogPanel.add(Box.createVerticalStrut(25));
		
		add(dialogPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(buttonLayout);
		
		JButton btnDa = new JButton("Da");
		btnDa.setPreferredSize(new Dimension(50, 30));
		JButton btnNe = new JButton("Ne");
		btnNe.setPreferredSize(new Dimension(50, 30));
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(btnDa);
		buttonPanel.add(Box.createHorizontalStrut(50));
		buttonPanel.add(btnNe);
		buttonPanel.add(Box.createHorizontalGlue());
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		btnDa.setEnabled(true);
			
		btnDa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				Ocena ocena = student.getPolozeniIspiti().get(polozeni.getSelectedRow());
				predmet = ocena.getPredmet();
					student.insertPredmet(predmet);
					student.removeOcena(ocena);
					azurirajPrikaz();
				
				dispose();
			}
			
		});
		
		btnNe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelNepolozeniIspiti nepolozeniModel = (AbstractTableModelNepolozeniIspiti) nepolozeni.getModel();
		
		nepolozeniModel.fireTableDataChanged();
		validate();
		
		validate();
	}
	
}
