package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.ProfesoriController;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class DialogIzmeniProfesora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3210992766218300112L;
	
	private boolean ispravno[] = {true, true, true, true, true, true, true, true};
	private String ime;
	private String prezime;
	private String datumRodjenjaString;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private Profesor profesor;

	DialogIzmeniProfesora(int selectedIndex) {
		super();
		setTitle("Izmeni profesora");
		setSize(750, 750);
		setLocationRelativeTo(Frame.getInstance());
		this.setModal(true);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panelInfo = new JPanel();
		//--------------------------------------------
		BoxLayout dialogLayout = new BoxLayout(panelInfo, BoxLayout.Y_AXIS);
		panelInfo.setLayout(dialogLayout);
		
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
		
		profesor = ProfesoriController.getInstance().getProfesori().get(selectedIndex);
		ime = profesor.getIme();
		prezime = profesor.getPrezime();
		datumRodjenja = profesor.getDatumRodjenja();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		datumRodjenjaString = dateFormat.format(datumRodjenja);
		adresaStanovanja = profesor.getAdresaStanovanja();
		kontaktTelefon = profesor.getKontaktTelefon();
		emailAdresa = profesor.getEmailAdresa();
		adresaKancelarije = profesor.getAdresaKancelarije();
		brojLicneKarte = profesor.getBrojLicneKarte();
		
		JTextField imeTF = new JTextField(ime);
		imeTF.setPreferredSize(dimension1);
		JTextField prezimeTF = new JTextField(prezime);
		prezimeTF.setPreferredSize(dimension1);
		JTextField datumTF = new JTextField(datumRodjenjaString);
		datumTF.setPreferredSize(dimension1);
		datumTF.setToolTipText("Format: dd-mm-yyyy");
		JTextField adresaStanTF = new JTextField(adresaStanovanja);
		adresaStanTF.setPreferredSize(dimension1);
		adresaStanTF.setToolTipText("Format: ulica broj, grad");
		JTextField telefonTF = new JTextField(kontaktTelefon);
		telefonTF.setPreferredSize(dimension1);
		JTextField emailTF = new JTextField(emailAdresa);
		emailTF.setPreferredSize(dimension1);
		JTextField adresaKancTF = new JTextField(adresaKancelarije);
		adresaKancTF.setPreferredSize(dimension1);
		adresaKancTF.setToolTipText("Format: ulica broj, grad");
		JTextField brLicneKarteTF = new JTextField(brojLicneKarte);
		brLicneKarteTF.setPreferredSize(dimension1);
		
		String[] titule = { "BSc", "MSc", "mr", "dr", "prof.dr" };
		JComboBox<String> titulaComboBox = new JComboBox<String>(titule);
		titulaComboBox.setPreferredSize(dimension1);
		titulaComboBox.setSelectedIndex(profesor.getTitula().ordinal());
		String[] zvanja = { "saradnik u nastavi", "asistent", "asistent sa doktoratom", "docent", "vanredni profesor", "redovni profesor", "profesor emeritus" };
		JComboBox<String> zvanjeComboBox = new JComboBox<String>(zvanja);
		zvanjeComboBox.setPreferredSize(dimension1);
		zvanjeComboBox.setSelectedIndex(profesor.getZvanje().ordinal());
		
		
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
		
		panelInfo.add(imePanel);
		panelInfo.add(prezimePanel);
		panelInfo.add(datumPanel);
		panelInfo.add(adresaStanPanel);
		panelInfo.add(telefonPanel);
		panelInfo.add(emailPanel);
		panelInfo.add(adresaKancPanel);
		panelInfo.add(brLicneKartePanel);
		panelInfo.add(titulaPanel);
		panelInfo.add(zvanjePanel);
		panelInfo.add(Box.createVerticalStrut(25));
		
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
		
		panelInfo.add(buttonPanel, BorderLayout.SOUTH);
		//--------------------------------------------
		tabbedPane.addTab("Info", panelInfo);
		
		JPanel panelPredmeti = new JPanel();
		//BoxLayout predmetiLayout = new BoxLayout(panelPredmeti, BoxLayout.Y_AXIS);
		//panelPredmeti.setLayout(predmetiLayout);
		//tabbedPane.addTab("Predmeti", panelPredmeti);
		BorderLayout predmetiLayout = new BorderLayout();
		panelPredmeti.setLayout(predmetiLayout);
		tabbedPane.addTab("Predmeti", panelPredmeti);
		
		add(tabbedPane, BorderLayout.CENTER);
		//--------------------------------------------
		btnPotvrdi.setEnabled(true);
		
		imeTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ime = imeTF.getText();
				String imeRegex = "[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(ime, imeRegex, 0));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ime = imeTF.getText();
				String imeRegex = "[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(ime, imeRegex, 0));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ime = imeTF.getText();
				String imeRegex = "[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(ime, imeRegex, 0));
			}
		});
		
		prezimeTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				prezime = prezimeTF.getText();
				String prezimeRegex = "[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(prezime, prezimeRegex, 1));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				prezime = prezimeTF.getText();
				String prezimeRegex = "[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(prezime, prezimeRegex, 1));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				prezime = prezimeTF.getText();
				String prezimeRegex = "[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(prezime, prezimeRegex, 1));
			}
		});
		
		datumTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumRodjenjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumRodjenjaString, datumRodjenjaRegex, 2));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumRodjenjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumRodjenjaString, datumRodjenjaRegex, 2));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumRodjenjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumRodjenjaString, datumRodjenjaRegex, 2));
			}
		});
		
		adresaStanTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				adresaStanovanja = adresaStanTF.getText();
				String adresaStanRegex = "[a-zA-Z\s]+\\d+\\,[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(adresaStanovanja, adresaStanRegex, 3));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				adresaStanovanja = adresaStanTF.getText();
				String adresaStanRegex = "[a-zA-Z\s]+\\d+\\,[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(adresaStanovanja, adresaStanRegex, 3));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				adresaStanovanja = adresaStanTF.getText();
				String adresaStanRegex = "[a-zA-Z\s]+\\d+\\,[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(adresaStanovanja, adresaStanRegex, 3));
			}
		});
		
		telefonTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				kontaktTelefon = telefonTF.getText();
				String telefonRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				btnPotvrdi.setEnabled(proveraUnosa(kontaktTelefon, telefonRegex, 4));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				kontaktTelefon = telefonTF.getText();
				String telefonRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				btnPotvrdi.setEnabled(proveraUnosa(kontaktTelefon, telefonRegex, 4));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				kontaktTelefon = telefonTF.getText();
				String telefonRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				btnPotvrdi.setEnabled(proveraUnosa(kontaktTelefon, telefonRegex, 4));
			}
		});
		
		emailTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				emailAdresa = emailTF.getText();
				String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
				btnPotvrdi.setEnabled(proveraUnosa(emailAdresa, emailRegex, 5));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				emailAdresa = emailTF.getText();
				String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
				btnPotvrdi.setEnabled(proveraUnosa(emailAdresa, emailRegex, 5));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				emailAdresa = emailTF.getText();
				String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
				btnPotvrdi.setEnabled(proveraUnosa(emailAdresa, emailRegex, 5));
			}
		});
		
		adresaKancTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				adresaKancelarije = adresaKancTF.getText();
				String adresaKancRegex = "[a-zA-Z\s]+\\d+\\,[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(adresaKancelarije, adresaKancRegex, 6));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				adresaKancelarije = adresaKancTF.getText();
				String adresaKancRegex = "[a-zA-Z\s]+\\d+\\,[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(adresaKancelarije, adresaKancRegex, 6));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				adresaKancelarije = adresaKancTF.getText();
				String adresaKancRegex = "[a-zA-Z\s]+\\d+\\,[a-zA-Z\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(adresaKancelarije, adresaKancRegex, 6));
			}
		});
		
		brLicneKarteTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				brojLicneKarte = brLicneKarteTF.getText();
				String brLicneKarteRegex = "\\d{9}";
				btnPotvrdi.setEnabled(proveraUnosa(brojLicneKarte, brLicneKarteRegex, 7));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				brojLicneKarte = brLicneKarteTF.getText();
				String brLicneKarteRegex = "\\d{9}";
				btnPotvrdi.setEnabled(proveraUnosa(brojLicneKarte, brLicneKarteRegex, 7));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				brojLicneKarte = brLicneKarteTF.getText();
				String brLicneKarteRegex = "\\d{9}";
				btnPotvrdi.setEnabled(proveraUnosa(brojLicneKarte, brLicneKarteRegex, 7));
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Titula titula = Titula.values()[titulaComboBox.getSelectedIndex()];
				Zvanje zvanje = Zvanje.values()[zvanjeComboBox.getSelectedIndex()];
				
				for(Profesor p: ProfesoriController.getInstance().getProfesori()) {
					if((p.getBrojLicneKarte().equals(brojLicneKarte)) && (p != ProfesoriController.getInstance().getProfesori().get(selectedIndex))) {
						JOptionPane.showMessageDialog(null,
								"Profesor sa datim brojem licne karte vec postoji u sistemu",
								"Greska pri unosu profesora", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				try {
					datumRodjenja = new SimpleDateFormat("dd-MM-yyyy").parse(datumRodjenjaString);
					Profesor profesor = new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, adresaKancelarije, brojLicneKarte, titula, zvanje);
					ProfesoriController.getInstance().izmeniProfesora(selectedIndex, profesor);
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
		
		JPanel btnPredmetiPanel = new JPanel();
		BoxLayout btnPredmetiLayout = new BoxLayout(btnPredmetiPanel, BoxLayout.X_AXIS);
		btnPredmetiPanel.setLayout(btnPredmetiLayout);
		
		JButton btnDodajPredmet = new JButton("Dodaj predmet");
		btnDodajPredmet.setPreferredSize(new Dimension(150, 30));
		JButton btnUkloniPredmet = new JButton("Ukloni predmet");
		btnUkloniPredmet.setPreferredSize(new Dimension(150, 30));
		
		btnPredmetiPanel.add(Box.createHorizontalStrut(25));
		btnPredmetiPanel.add(btnDodajPredmet);
		btnPredmetiPanel.add(Box.createHorizontalStrut(50));
		btnPredmetiPanel.add(btnUkloniPredmet);
		btnPredmetiPanel.add(Box.createHorizontalGlue());
		
		panelPredmeti.add(btnPredmetiPanel, BorderLayout.NORTH);
		
		profesor.initPredmete();
		
		PredmetiPoProfesoruJTable predmetiProfesora = new PredmetiPoProfesoruJTable(profesor);
		JScrollPane predmetiScrollPane = new JScrollPane(predmetiProfesora);
		predmetiScrollPane.setPreferredSize(new Dimension(300, 300));
		panelPredmeti.add(predmetiScrollPane, BorderLayout.CENTER);
		
		btnDodajPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogDodajPredmetProfesoru ddpp = new DialogDodajPredmetProfesoru(profesor, predmetiProfesora);
				ddpp.setVisible(true);
			}
			
		});
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
