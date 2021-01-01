package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.PredmetiController;
import model.Ocena;
import model.Predmet;
import model.Student;

public class DialogUpisiOcenu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4995830860042707038L;
	
	private Predmet predmet;
	private String datumPolaganjaString;
	private NepolozeniPredmetiJTable nepolozeni;
	private PolozeniIspitiJTable polozeni;
	//private Student student;

	public DialogUpisiOcenu(NepolozeniPredmetiJTable nepolozeni, PolozeniIspitiJTable polozeni, Student student) {
		
		super();
		this.nepolozeni = nepolozeni;
		this.polozeni = polozeni;
		//this.student = student;
		
		setSize(500, 500);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Unos ocene");
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		Dimension dimension = new Dimension(200, 30);
		
		JPanel sifraPanel = new JPanel(layout);
		JPanel nazivPanel = new JPanel(layout);
		JPanel ocenaPanel = new JPanel(layout);
		JPanel datumPanel = new JPanel(layout);
		
		JLabel sifraLabel = new JLabel("Sifra*:");
		sifraLabel.setPreferredSize(dimension);
		JLabel nazivLabel = new JLabel("Naziv*:");
		nazivLabel.setPreferredSize(dimension);
		JLabel ocenaLabel = new JLabel("Ocena*:");
		ocenaLabel.setPreferredSize(dimension);
		JLabel datumLabel = new JLabel("Datum*:");
		datumLabel.setPreferredSize(dimension);
		
		predmet = PredmetiController.getInstance().getPredmeti().get(nepolozeni.getSelectedRow());
		
		JLabel sifraPrikaz = new JLabel(predmet.getId());
		sifraPrikaz.setPreferredSize(dimension);
		sifraPrikaz.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		JLabel nazivPrikaz = new JLabel(predmet.getNaziv());
		nazivPrikaz.setPreferredSize(dimension);
		nazivPrikaz.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		String[] ocene = {"6", "7", "8", "9", "10"};
		JComboBox<String> ocenaComboBox = new JComboBox<String>(ocene);
		ocenaComboBox.setPreferredSize(dimension);
		
		JTextField datumTF = new JTextField();
		datumTF.setPreferredSize(dimension);
		datumTF.setToolTipText("dd-MM-yyyy");
		
		sifraPanel.add(sifraLabel);
		sifraPanel.add(sifraPrikaz);
		nazivPanel.add(nazivLabel);
		nazivPanel.add(nazivPrikaz);
		ocenaPanel.add(ocenaLabel);
		ocenaPanel.add(ocenaComboBox);
		datumPanel.add(datumLabel);
		datumPanel.add(datumTF);
		
		dialogPanel.add(sifraPanel);
		dialogPanel.add(nazivPanel);
		dialogPanel.add(ocenaPanel);
		dialogPanel.add(datumPanel);
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
		
		btnPotvrdi.setEnabled(false);
		
		datumTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumPolaganjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumPolaganjaString, datumRodjenjaRegex));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumPolaganjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumPolaganjaString, datumRodjenjaRegex));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumPolaganjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumPolaganjaString, datumRodjenjaRegex));
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				long vrednost = Long.parseLong((String)ocenaComboBox.getSelectedItem());
				Predmet predmet = student.getNepolozeniIspiti().get(nepolozeni.getSelectedRow());
				datumPolaganjaString = datumTF.getText();
				try {
					Date datumPolaganja = new SimpleDateFormat("dd-MM-yyyy").parse(datumPolaganjaString);
					Ocena ocena = new Ocena(student, predmet, vrednost, datumPolaganja);
					student.insertOcena(ocena);
					student.removePredmet(predmet);
					azurirajPrikaz();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		AbstractTableModelNepolozeniIspiti nepolozeniModel = (AbstractTableModelNepolozeniIspiti) nepolozeni.getModel();
		
		nepolozeniModel.fireTableDataChanged();
		validate();
		
		AbstractTableModelPolozeniIspiti polozeniModel = (AbstractTableModelPolozeniIspiti) polozeni.getModel();
		
		polozeniModel.fireTableDataChanged();
		validate();
	}
	
	public boolean proveraUnosa(String fieldText, String fieldRegex) {
		if (!fieldText.matches(fieldRegex))
			return false;			
		else 
			return true;
	}
}
