package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesoriController;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;


public class DialogDodajProfesora extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3690682637438183192L;

	DialogDodajProfesora() {
		super();
		setTitle("Dodavanje profesora");
		setSize(750, 750);
		setLocationRelativeTo(Frame.getInstance());
		this.setModal(true);
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		Dimension dimension1 = new Dimension(200, 30);
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER);
		
		JPanel imePanel = new JPanel(layout1);
		JPanel prezimePanel = new JPanel(layout1);
		JPanel datumPanel = new JPanel(layout1);
		JPanel adresaStanPanel = new JPanel(layout1);
		JPanel telefonPanel = new JPanel(layout1);
		JPanel emailPanel = new JPanel(layout1);
		JPanel adresaKancPanel = new JPanel(layout1);
		JPanel brLicneKartePanel = new JPanel(layout1);
		JPanel titulaPanel = new JPanel(layout1);
		JPanel zvanjePanel = new JPanel(layout1);
		
		JLabel imeLabel = new JLabel("Ime*:");
		imeLabel.setPreferredSize(dimension1);
		JLabel prezimeLabel = new JLabel("Prezime*:");
		prezimeLabel.setPreferredSize(dimension1);
		JLabel datumLabel = new JLabel("Datum rodjenja*:");
		datumLabel.setPreferredSize(dimension1);
		JLabel adresaStanLabel = new JLabel("Adresa stanovanja*:");
		adresaStanLabel.setPreferredSize(dimension1);
		JLabel telefonLabel = new JLabel("Broj telefona*:");
		telefonLabel.setPreferredSize(dimension1);
		JLabel emailLabel = new JLabel("E-mail adresa*:");
		emailLabel.setPreferredSize(dimension1);
		JLabel adresaKancLabel = new JLabel("Adresa kancelarije*:");
		adresaKancLabel.setPreferredSize(dimension1);
		JLabel brLicneKarteLabel = new JLabel("Broj licne karte*:");
		brLicneKarteLabel.setPreferredSize(dimension1);
		JLabel titulaLabel = new JLabel("Titula*:");
		titulaLabel.setPreferredSize(dimension1);
		JLabel zvanjeLabel = new JLabel("Zvanje*:");
		zvanjeLabel.setPreferredSize(dimension1);
		
		JTextField imeTF = new JTextField();
		imeTF.setPreferredSize(dimension1);
		JTextField prezimeTF = new JTextField();
		prezimeTF.setPreferredSize(dimension1);
		JTextField datumTF = new JTextField();
		datumTF.setPreferredSize(dimension1);
		JTextField adresaStanTF = new JTextField();
		adresaStanTF.setPreferredSize(dimension1);
		JTextField telefonTF = new JTextField();
		telefonTF.setPreferredSize(dimension1);
		JTextField emailTF = new JTextField();
		emailTF.setPreferredSize(dimension1);
		JTextField adresaKancTF = new JTextField();
		adresaKancTF.setPreferredSize(dimension1);
		JTextField brLicneKarteTF = new JTextField();
		brLicneKarteTF.setPreferredSize(dimension1);
		
		String[] titule = { "BSc", "MSc", "mr", "dr", "prof.dr" };
		JComboBox<String> titulaComboBox = new JComboBox<String>(titule);
		titulaComboBox.setPreferredSize(dimension1);
		String[] zvanja = { "saradnik u nastavi", "asistent", "asistent sa doktoratom", "docent", "vanredni profesor", "redovni profesor", "profesor emeritus" };
		JComboBox<String> zvanjeComboBox = new JComboBox<String>(zvanja);
		zvanjeComboBox.setPreferredSize(dimension1);
		
		
		imePanel.add(imeLabel);
		imePanel.add(imeTF);
		prezimePanel.add(prezimeLabel);
		prezimePanel.add(prezimeTF);
		datumPanel.add(datumLabel);
		datumPanel.add(datumTF);
		adresaStanPanel.add(adresaStanLabel);
		adresaStanPanel.add(adresaStanTF);
		telefonPanel.add(telefonLabel);
		telefonPanel.add(telefonTF);
		emailPanel.add(emailLabel);
		emailPanel.add(emailTF);
		adresaKancPanel.add(adresaKancLabel);
		adresaKancPanel.add(adresaKancTF);
		brLicneKartePanel.add(brLicneKarteLabel);
		brLicneKartePanel.add(brLicneKarteTF);
		titulaPanel.add(titulaLabel);
		titulaPanel.add(titulaComboBox);
		zvanjePanel.add(zvanjeLabel);
		zvanjePanel.add(zvanjeComboBox);
		
		dialogPanel.add(imePanel);
		dialogPanel.add(prezimePanel);
		dialogPanel.add(datumPanel);
		dialogPanel.add(adresaStanPanel);
		dialogPanel.add(telefonPanel);
		dialogPanel.add(emailPanel);
		dialogPanel.add(adresaKancPanel);
		dialogPanel.add(brLicneKartePanel);
		dialogPanel.add(titulaPanel);
		dialogPanel.add(zvanjePanel);
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
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ime = imeTF.getText();
				String prezime = prezimeTF.getText();
				String datumRodjenjaString = datumTF.getText();
				String adresaStanovanja = adresaStanTF.getText();
				String kontaktTelefon = telefonTF.getText();
				String emailAdresa = emailTF.getText();
				String adresaKancelarije = adresaKancTF.getText();
				String brojLicneKarte = brLicneKarteTF.getText();
				Titula titula = Titula.values()[titulaComboBox.getSelectedIndex()];
				Zvanje zvanje = Zvanje.values()[zvanjeComboBox.getSelectedIndex()];
				
				if (!ime.matches("[a-zA-Z\s]+")) {
					JOptionPane.showMessageDialog(null,
							"Unos ne odgovara ocekivanom formatu",
							"Greska pri unosu imena", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (!prezime.matches("[a-zA-Z\s]+")) {
					JOptionPane.showMessageDialog(null,
							"Unos ne odgovara ocekivanom formatu",
							"Greska pri unosu prezimena", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (!datumRodjenjaString.matches("\\d{1,2}-\\d{1,2}-\\d{4}")) {
					JOptionPane.showMessageDialog(null,
							"Unos ne odgovara ocekivanom formatu: dd-mm-yyyy",
							"Greska pri unosu datuma", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (!adresaStanovanja.matches("[a-zA-Z\s]+\\d+\\,[a-zA-Z\s]+")) {
					JOptionPane.showMessageDialog(null,
							"Unos ne odgovara ocekivanom formatu: [ulica] [broj],[grad]",
							"Greska pri unosu adrese stanovanja", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (!kontaktTelefon.matches("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")) {
					JOptionPane.showMessageDialog(null,
							"Unos ne odgovara ocekivanom formatu",
							"Greska pri unosu kontakt telefona", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(!emailMatches(emailAdresa)) {
					JOptionPane.showMessageDialog(null,
							"Unos ne odgovara ocekivanom formatu",
							"Greska pri unosu e-mail adrese", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (!brojLicneKarte.matches("\\d{9}")) {
					JOptionPane.showMessageDialog(null,
							"Unos ne odgovara ocekivanom formatu: 9 cifara",
							"Greska pri unosu broja licne karte", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(Profesor p : ProfesoriController.getInstance().getProfesori()) {
					if(p.getBrojLicneKarte().equals(brojLicneKarte)) {
						JOptionPane.showMessageDialog(null,
								"Profesor sa datim brojem licne karte vec postoji u sistemu",
								"Greska pri unosu broja licne karte", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				try {
					Date datumRodjenja = new SimpleDateFormat("dd-MM-yyy").parse(datumRodjenjaString);
					System.out.println(datumRodjenja);
					Profesor profesor = new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, adresaKancelarije, brojLicneKarte, titula, zvanje);
					ProfesoriController.getInstance().dodajProfesora(profesor);
					}
					catch(java.text.ParseException pe) {
						pe.printStackTrace();
					}
			}
		});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
	}
	public boolean emailMatches(String email) {
	String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	 
	Pattern pattern = Pattern.compile(regex);
	 

	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}

}
