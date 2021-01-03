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

import model.Profesor;

public class DialogObrisiPredmetProfesoru extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2559431042899834732L;
	private PredmetiPoProfesoruJTable predmetiTable;

	public DialogObrisiPredmetProfesoru(PredmetiPoProfesoruJTable predmetiTable, Profesor profesor, int i) {
		
		super();
	
		this.predmetiTable = predmetiTable;
		
		setSize(400, 150);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Ukloni predmet");
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		dialogPanel.add(Box.createVerticalStrut(25));
		JPanel panelLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panelLabel, BoxLayout.X_AXIS);
		panelLabel.setLayout(labelLayout);
		JLabel poruka = new JLabel("Da li ste sigurni?");
		panelLabel.add(Box.createHorizontalGlue());
		panelLabel.add(poruka);
		panelLabel.add(Box.createHorizontalGlue());
		dialogPanel.add(panelLabel);
		dialogPanel.add(Box.createVerticalStrut(25));
		
		add(dialogPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(buttonLayout);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100, 30));
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100, 30));
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(btnPotvrdi);
		buttonPanel.add(Box.createHorizontalStrut(50));
		buttonPanel.add(btnOdustani);
		buttonPanel.add(Box.createHorizontalGlue());
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		btnPotvrdi.setEnabled(true);
			
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
				profesor.obrisiPredmet(i);
					azurirajPrikaz();
				
				dispose();
			}
			
		});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelPredmetiPoProfesoru predmetiModel = (AbstractTableModelPredmetiPoProfesoru) predmetiTable.getModel();
		
		predmetiModel.fireTableDataChanged();
		validate();
	}
}
