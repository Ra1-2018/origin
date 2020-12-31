package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.PredmetiController;
import model.Predmet;
import model.Predmet.Godina;
import model.Predmet.Semestar;

public class DialogIzmeniPredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -680864083765738860L;
	private boolean ispravno[] = {true, true, true};
	private String id;
	private String naziv;
	private String espbString;
	
	DialogIzmeniPredmet(int selectedIndex) {
		super();
		setTitle("Dodavanje predmeta");
		setSize(750, 750);
		setLocationRelativeTo(Frame.getInstance());
		this.setModal(true);
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		Dimension dimension1 = new Dimension(200, 30);
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER);
		
		JPanel idPanel = new JPanel(layout1);
		JPanel nazivPanel = new JPanel(layout1);
		JPanel semestarPanel = new JPanel(layout1);
		JPanel godinaPanel = new JPanel(layout1);
		JPanel espbPanel = new JPanel(layout1);
		
		Predmet predmet = PredmetiController.getInstance().getPredmeti().get(selectedIndex);
		naziv = predmet.getNaziv();
		id = predmet.getId();
		espbString = Long.toString(predmet.getEspb());
	
		JLabel idLabel = new JLabel("Sifra predmeta*:");
		idLabel.setPreferredSize(dimension1);
		JLabel nazivLabel = new JLabel("Naziv predmeta*:");
		nazivLabel.setPreferredSize(dimension1);
		JLabel semestarLabel = new JLabel("Semestar*:");
		semestarLabel.setPreferredSize(dimension1);
		JLabel godinaLabel = new JLabel("Godina studija*:");
		godinaLabel.setPreferredSize(dimension1);
		JLabel espbLabel = new JLabel("Broj ESPB bodova*:");
		espbLabel.setPreferredSize(dimension1);
		
		JTextField idTF = new JTextField(id);
		idTF.setPreferredSize(dimension1);
		JTextField nazivTF = new JTextField(naziv);
		nazivTF.setPreferredSize(dimension1);
		JTextField espbTF = new JTextField(espbString);
		espbTF.setPreferredSize(dimension1);
		
		String[] semestri = {"Letnji", "Zimski"};
		JComboBox<String> semestarComboBox = new JComboBox<String>(semestri);
		semestarComboBox.setPreferredSize(dimension1);
		
		String[] godine = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
		JComboBox<String> godinaComboBox = new JComboBox<String>(godine);
		godinaComboBox.setPreferredSize(dimension1);
		
		semestarComboBox.setSelectedIndex(predmet.getSemestar().ordinal());
	    godinaComboBox.setSelectedIndex(predmet.getGodinaStudija().ordinal());
	    
		idPanel.add(idLabel);
		idPanel.add(idTF);
		nazivPanel.add(nazivLabel);
		nazivPanel.add(nazivTF);
		semestarPanel.add(semestarLabel);
		semestarPanel.add(semestarComboBox);
		godinaPanel.add(godinaLabel);
		godinaPanel.add(godinaComboBox);
		espbPanel.add(espbLabel);
		espbPanel.add(espbTF);
		
		dialogPanel.add(idPanel);
		dialogPanel.add(nazivPanel);
		dialogPanel.add(semestarPanel);
		dialogPanel.add(godinaPanel);
		dialogPanel.add(espbPanel);
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
		
		idTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				id = idTF.getText();
				String idRegex = "[\\da-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(id, idRegex, 0));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				id = idTF.getText();
				String idRegex = "[\\da-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(id, idRegex, 0));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				id = idTF.getText();
				String idRegex = "[\\da-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(id, idRegex, 0));
			}
			
		});
		
		nazivTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				naziv = nazivTF.getText();
				String nazivRegex = "[\\da-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(id, nazivRegex, 1));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				naziv = nazivTF.getText();
				String nazivRegex = "[\\da-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(id, nazivRegex, 1));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				naziv = nazivTF.getText();
				String nazivRegex = "[\\da-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(id, nazivRegex, 1));
			}
			
		});
		
		espbTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				espbString = espbTF.getText();
				String espbRegex = "\\d+";
				btnPotvrdi.setEnabled(proveraUnosa(espbString, espbRegex, 2));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				espbString = espbTF.getText();
				String espbRegex = "\\d+";
				btnPotvrdi.setEnabled(proveraUnosa(espbString, espbRegex, 2));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				espbString = espbTF.getText();
				String espbRegex = "\\d+";
				btnPotvrdi.setEnabled(proveraUnosa(espbString, espbRegex, 2));
			}
			
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Semestar semestar = Semestar.values()[semestarComboBox.getSelectedIndex()];
				Godina godina = Godina.values()[godinaComboBox.getSelectedIndex()];
				
				for(Predmet p: PredmetiController.getInstance().getPredmeti()) {
					if(p.getId().equals(id)) {
						JOptionPane.showMessageDialog(null,
								"Predmet sa datom sifrom vec postoji u sistemu",
								"Greska pri unosu predmeta", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				Predmet predmet = new Predmet(id, naziv, semestar, godina, null, Long.parseLong(espbString));
				PredmetiController.getInstance().izmeniPredmet(selectedIndex, predmet);
			}
			
		});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
	}
	
	public boolean proveraUnosa(String fieldText, String fieldRegex, int index) {
		if (!fieldText.matches(fieldRegex))
			ispravno[index] = false;			
		else 
			ispravno[index] = true;
		boolean sviIspravni = true;
		for(boolean i : ispravno)
			if(i == false)
				sviIspravni = false;
		
		if(sviIspravni == true)
			return true;
		else
			return false;
	}
}
