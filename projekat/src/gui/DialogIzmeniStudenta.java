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

import controller.StudentiController;
import model.Student;
import model.Student.Status;

public class DialogIzmeniStudenta extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3483057378640442927L;
	private boolean ispravni[] = {true, true, true, true, true, true, true, true, true};
	String ime;
	String prezime;
	String brojTelefona;
	String datumRodjenja;
	String adresa;
	String brIndeksa;
	String email;
	String prosecnaOcena;
	String godinaUpisa;
	
	public DialogIzmeniStudenta(int selectedIndex) {
	super();
	setTitle("Izmeni studenta");
	setSize(750, 750);
	this.setModal(true);
	setLocationRelativeTo(Frame.getInstance());
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel panelInformacije = new JPanel();
	BoxLayout dialogLayout = new BoxLayout(panelInformacije, BoxLayout.Y_AXIS);
	panelInformacije.setLayout(dialogLayout);
	tabbedPane.addTab("Informacije", panelInformacije );
	
	
	JPanel panelPolozeni = new JPanel();
	tabbedPane.addTab("Polo�eni", panelPolozeni);
	
	JPanel panelNepolozeni = new JPanel();
	BoxLayout nepolozeniLayout = new BoxLayout(panelNepolozeni, BoxLayout.Y_AXIS);
	panelNepolozeni.setLayout(nepolozeniLayout);
	tabbedPane.addTab("Nepolo�eni", panelNepolozeni);
	
	add(tabbedPane, BorderLayout.CENTER);
	
	FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
	Dimension dimension = new Dimension(200, 30);
	
	JPanel imePanel = new JPanel(layout);
	JPanel prezimePanel = new JPanel(layout);
	JPanel datumRodjenjaPanel = new JPanel(layout);
	JPanel adresaPanel = new JPanel(layout);
	JPanel kontaktPanel = new JPanel(layout);
	JPanel emailPanel = new JPanel(layout);
	JPanel brIndeksaPanel = new JPanel(layout);
	JPanel godinaUpisaPanel = new JPanel(layout);
	JPanel godinaStudijaPanel = new JPanel(layout);
	JPanel nacinFinansiranjaPanel = new JPanel(layout);
	JPanel prosecnaOcenaPanel = new JPanel(layout);
		
	JLabel imeLabel = new JLabel("Ime*: ");
	JLabel prezimeLabel = new JLabel("Prezime*: ");
	JLabel datumRodjenjaLabel = new JLabel("Datum rodjenja*: ");
	JLabel adresaLabel = new JLabel("Adresa stanovanja*: ");
	JLabel kontaktLabel = new JLabel("Broj telefona*: ");
	JLabel emailLabel = new JLabel("E-mail adresa*: ");
	JLabel brIndeksaLabel = new JLabel("Broj indeksa*: ");
	JLabel godinaUpisaLabel = new JLabel("Godina upisa*: ");
	JLabel godinaStudijaLabel = new JLabel("Trenutna godina studija*: ");
	JLabel prosecnaOcenaLabel = new JLabel("Prosecna ocena*: ");
	JLabel nacinFinansiranjaLabel = new JLabel("Nacin finansiranja*:");
	
	imeLabel.setPreferredSize(dimension);
	prezimeLabel.setPreferredSize(dimension);
	datumRodjenjaLabel.setPreferredSize(dimension);
	adresaLabel.setPreferredSize(dimension);
	kontaktLabel.setPreferredSize(dimension);
	emailLabel.setPreferredSize(dimension);
	brIndeksaLabel.setPreferredSize(dimension);
	godinaUpisaLabel.setPreferredSize(dimension);
	godinaStudijaLabel.setPreferredSize(dimension);
	prosecnaOcenaLabel.setPreferredSize(dimension);
	nacinFinansiranjaLabel.setPreferredSize(dimension);
	
	
	Student stareInformacije = StudentiController.getInstance().getListaSvihStudenata().get(selectedIndex);
	ime = stareInformacije.getIme();
	prezime = stareInformacije.getPrezime();
	DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	datumRodjenja = date.format(stareInformacije.getDatumRodjenja());
	brojTelefona = stareInformacije.getKontaktTelefon();
	adresa = stareInformacije.getAdresaStanovanja();
	brIndeksa = stareInformacije.getBrojIndeksa();
	email = stareInformacije.getEmailAdresa();
	prosecnaOcena = Double.toString(stareInformacije.getProsecnaOcena());
	godinaUpisa = stareInformacije.getGodinaUpisa();
    
	
	
	JTextField imeText = new JTextField(stareInformacije.getIme());
	imeText.setToolTipText("Format: slova i razmaci");
	JTextField prezimeText = new JTextField(stareInformacije.getPrezime());
	prezimeText.setToolTipText("Format: slova i razmaci");
	JTextField datumRodjenjaText = new JTextField(date.format(stareInformacije.getDatumRodjenja()));
	datumRodjenjaText.setToolTipText("Format: dd-MM-yyyy");
	JTextField adresaText = new JTextField(stareInformacije.getAdresaStanovanja());
	adresaText.setToolTipText("Format: slova i razmaci + broj + zapeta + slova i razmaci");
	JTextField kontaktText = new JTextField(stareInformacije.getKontaktTelefon());
	JTextField emailText = new JTextField(stareInformacije.getEmailAdresa());
	JTextField brIndeksaText = new JTextField(stareInformacije.getBrojIndeksa());
	brIndeksaText.setToolTipText("Format: AAxxx-yyyy");
	JTextField godinaUpisaText = new JTextField(stareInformacije.getGodinaUpisa());
	godinaUpisaText.setToolTipText("Format: yyyy");
	JTextField prosecnaOcenaText = new JTextField(Double.toString(stareInformacije.getProsecnaOcena()));
	prosecnaOcenaText.setToolTipText("Format: cifra + tacka + dve cifre ili 10.00");
	String[] godineStudija = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
	JComboBox<String> godineStudijaComboBox = new JComboBox<String>(godineStudija);	
	String[] budzet_samofinansiranje = { "Budzet", "Samofinansiranje" };
	JComboBox<String> budzet_samofinansiranjeComboBox = new JComboBox<String>(budzet_samofinansiranje);
	
	godineStudijaComboBox.setSelectedItem(stareInformacije.getTrenutnaGodinaStudija());
    budzet_samofinansiranjeComboBox.setSelectedIndex(stareInformacije.getStatus().ordinal());	
	
	imeText.setPreferredSize(dimension);
	prezimeText.setPreferredSize(dimension);
	datumRodjenjaText.setPreferredSize(dimension);
	adresaText.setPreferredSize(dimension);
	kontaktText.setPreferredSize(dimension);
	emailText.setPreferredSize(dimension);
	brIndeksaText.setPreferredSize(dimension);
	godinaUpisaText.setPreferredSize(dimension);
	prosecnaOcenaText.setPreferredSize(dimension);
	godineStudijaComboBox.setPreferredSize(dimension);
	budzet_samofinansiranjeComboBox.setPreferredSize(dimension);
			
	
	imePanel.add(imeLabel);
	imePanel.add(imeText);
	prezimePanel.add(prezimeLabel);
	prezimePanel.add(prezimeText);
	datumRodjenjaPanel.add(datumRodjenjaLabel);
	datumRodjenjaPanel.add(datumRodjenjaText);
	adresaPanel.add(adresaLabel);
	adresaPanel.add(adresaText);
	kontaktPanel.add(kontaktLabel);
	kontaktPanel.add(kontaktText);
	emailPanel.add(emailLabel);
	emailPanel.add(emailText);	
	brIndeksaPanel.add(brIndeksaLabel);
	brIndeksaPanel.add(brIndeksaText);	
	godinaUpisaPanel.add(godinaUpisaLabel);
	godinaUpisaPanel.add(godinaUpisaText);
	prosecnaOcenaPanel.add(prosecnaOcenaLabel);
	prosecnaOcenaPanel.add(prosecnaOcenaText);	
	godinaStudijaPanel.add(godinaStudijaLabel);
	godinaStudijaPanel.add(godineStudijaComboBox);
	nacinFinansiranjaPanel.add(nacinFinansiranjaLabel);
	nacinFinansiranjaPanel.add(budzet_samofinansiranjeComboBox);
	
	panelInformacije.add(imePanel);
	panelInformacije.add(prezimePanel);
	panelInformacije.add(datumRodjenjaPanel);
	panelInformacije.add(adresaPanel);
	panelInformacije.add(kontaktPanel);
	panelInformacije.add(emailPanel);
	panelInformacije.add(brIndeksaPanel);
	panelInformacije.add(prosecnaOcenaPanel);
	panelInformacije.add(godinaUpisaPanel);
	panelInformacije.add(godinaStudijaPanel);
	panelInformacije.add(nacinFinansiranjaPanel);
	panelInformacije.add(Box.createVerticalStrut(25));
	
	add(tabbedPane, BorderLayout.CENTER);
	
	JPanel buttonPanel = new JPanel();
	BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
	buttonPanel.setLayout(buttonLayout);
	
	JButton potvrda = new JButton("Potvrdi");
	JButton odustanak = new JButton("Odustani");
	potvrda.setPreferredSize(new Dimension(100, 30));
	odustanak.setPreferredSize(new Dimension(100, 30));
	buttonPanel.add(Box.createGlue());
	buttonPanel.add(potvrda);
	buttonPanel.add(Box.createHorizontalStrut(50));
	buttonPanel.add(odustanak);
	buttonPanel.add(Box.createGlue());
	
	panelInformacije.add(buttonPanel);
	setLocationRelativeTo(Frame.getInstance());
	
	potvrda.setEnabled(true);
	
	
	imeText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			ime = imeText.getText();
			String regex_ime = "[[a-zA-Z]\s]+";
			potvrda.setEnabled(proveraUnosa(ime, regex_ime, 0));		
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			ime = imeText.getText();
			String regex_ime = "[[a-zA-Z]\s]+";
			potvrda.setEnabled(proveraUnosa(ime, regex_ime, 0));	
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			ime = imeText.getText();
			String regex_ime = "[[a-zA-Z]\s]+";
			potvrda.setEnabled(proveraUnosa(ime, regex_ime, 0));	
		}
			
	});
	
	
	prezimeText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prezime = prezimeText.getText();
			String regex_prezime = "[a-zA-Z\s]+";
			potvrda.setEnabled(proveraUnosa(prezime, regex_prezime, 1));		
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prezime = prezimeText.getText();
			String regex_prezime = "[a-zA-Z\s]+";
			potvrda.setEnabled(proveraUnosa(prezime, regex_prezime, 1));		
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prezime = prezimeText.getText();
			String regex_prezime = "[a-zA-Z\s]+";
			potvrda.setEnabled(proveraUnosa(prezime, regex_prezime, 1));	
		}
			
	});
	
	
	datumRodjenjaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			datumRodjenja = datumRodjenjaText.getText();
			String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
			potvrda.setEnabled(proveraUnosa(datumRodjenja, regex_datumRodjenja, 2));
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			datumRodjenja = datumRodjenjaText.getText();
			String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
			potvrda.setEnabled(proveraUnosa(datumRodjenja, regex_datumRodjenja, 2));
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			datumRodjenja = datumRodjenjaText.getText();
			String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
			potvrda.setEnabled(proveraUnosa(datumRodjenja, regex_datumRodjenja, 2));
			
		}
		
	});
	
	
	adresaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			adresa = adresaText.getText();
			String regex_adresa = "[[a-zA-Z]+\s]+\\d+\\,[[a-zA-Z]+\s]+";
			potvrda.setEnabled(proveraUnosa(adresa, regex_adresa, 3));
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			adresa = adresaText.getText();
			String regex_adresa = "[[a-zA-Z]+\s]+\\d+\\,[[a-zA-Z]+\s]+";
			potvrda.setEnabled(proveraUnosa(adresa, regex_adresa, 3));
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			adresa = adresaText.getText();
			String regex_adresa = "[[a-zA-Z]+\s]+\\d+\\,[[a-zA-Z]+\s]+";
			potvrda.setEnabled(proveraUnosa(adresa, regex_adresa, 3));		
		}	
	});
	
	
	brIndeksaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brIndeksa = brIndeksaText.getText();
			String regex_brIndeksa = "[A-Z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
			potvrda.setEnabled(proveraUnosa(brIndeksa, regex_brIndeksa, 4));	
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brIndeksa = brIndeksaText.getText();
			String regex_brIndeksa = "[A-Z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
			potvrda.setEnabled(proveraUnosa(brIndeksa, regex_brIndeksa, 4));	
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brIndeksa = brIndeksaText.getText();
			String regex_brIndeksa = "[A-Z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
			potvrda.setEnabled(proveraUnosa(brIndeksa, regex_brIndeksa, 4));	
		}
		
	});
	
	
	kontaktText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brojTelefona = kontaktText.getText();
			String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
			potvrda.setEnabled(proveraUnosa(brojTelefona, regex_brojTelefona, 5));	
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brojTelefona = kontaktText.getText();
			String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
			potvrda.setEnabled(proveraUnosa(brojTelefona, regex_brojTelefona, 5));			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brojTelefona = kontaktText.getText();
			String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
			potvrda.setEnabled(proveraUnosa(brojTelefona, regex_brojTelefona, 5));	
		}
		
	});
	
	
	emailText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText();
			String regex_email = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			potvrda.setEnabled(proveraUnosa(email, regex_email, 6));		
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText();
			String regex_email = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			potvrda.setEnabled(proveraUnosa(email, regex_email, 6));	
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText();
			String regex_email = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			potvrda.setEnabled(proveraUnosa(email, regex_email, 6));		
		}
		
	});
	
	prosecnaOcenaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}|10\\.00";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}|10\\.00";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}|10\\.00";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
		
		}
		
	});
	
	godinaUpisaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			godinaUpisa = godinaUpisaText.getText();
			String regex_godinaUpisa = "\\d{4}";
			potvrda.setEnabled(proveraUnosa(godinaUpisa, regex_godinaUpisa, 8));
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			godinaUpisa = godinaUpisaText.getText();
			String regex_godinaUpisa = "\\d{4}";
			potvrda.setEnabled(proveraUnosa(godinaUpisa, regex_godinaUpisa, 8));
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			godinaUpisa = godinaUpisaText.getText();
			String regex_godinaUpisa = "\\d{4}";
			potvrda.setEnabled(proveraUnosa(godinaUpisa, regex_godinaUpisa, 8));
			
		}
		
	});
	
	
	potvrda.addActionListener(new ActionListener() {
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String godinaStudija =  godineStudijaComboBox.getSelectedItem().toString();
	    String nacinFinansiranja = budzet_samofinansiranjeComboBox.getSelectedItem().toString();
	    
		double ocena = Double.parseDouble(prosecnaOcena);
	    
	    Status finansiranje;
	    
		if(nacinFinansiranja=="Budzet")
			finansiranje = Status.B;
		else
			finansiranje = Status.S;
		

		for (Student s : StudentiController.getInstance().getListaSvihStudenata()) {
					if ((s!=StudentiController.getInstance().getListaSvihStudenata().get(selectedIndex)) && (s.getBrojIndeksa().equals(brIndeksa))) {
						JOptionPane.showMessageDialog(null, "Student sa datim broj indeksa vec postoji u sistemu", "Greska pri unosu broja indeksa", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			
				try {	
			Date datumRodjenjaDate = new SimpleDateFormat("dd-MM-yyyy").parse(datumRodjenja);
		    Student student = new Student(brIndeksa, ime, prezime, godinaStudija, finansiranje, ocena, datumRodjenjaDate, adresa, brojTelefona, email, godinaUpisa);
			StudentiController.getInstance().izmeniStudenta(selectedIndex, student);
				}
				catch(java.text.ParseException pe) {
					pe.printStackTrace();
				}
	}
	});
	
	odustanak.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			dispose();

		}});
	
	JPanel btnNpPan = new JPanel();
	BoxLayout btnNpLayout = new BoxLayout(btnNpPan, BoxLayout.X_AXIS);
	btnNpPan.setLayout(btnNpLayout);
	
	JButton btnDodaj = new JButton("Dodaj");
	btnDodaj.setPreferredSize(new Dimension(100, 30));
	JButton btnObrisi = new JButton("Obrisi");
	btnObrisi.setPreferredSize(new Dimension(100, 30));
	JButton btnPolaganje = new JButton("Polaganje");
	btnPolaganje.setPreferredSize(new Dimension(100, 30));
	
	btnNpPan.add(btnDodaj);
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnObrisi);
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnPolaganje);
	buttonPanel.add(Box.createHorizontalGlue());
	panelNepolozeni.add(btnNpPan);
	
	NepolozeniPredmetiJTable nepolozeniPredmeti = new NepolozeniPredmetiJTable(stareInformacije);
	JScrollPane nepolozeniScrollPane = new JScrollPane(nepolozeniPredmeti);
	nepolozeniScrollPane.setPreferredSize(new Dimension(300, 300));
	panelNepolozeni.add(nepolozeniScrollPane);
	
	}
	
	public boolean proveraUnosa(String text, String regex, int index) {
		if(!text.matches(regex))
			ispravni[index] = false;
		else
			ispravni[index] = true;
		
		boolean ispravnoSve = true;
		
		for(boolean i : ispravni)
			if(i == false)
				ispravnoSve = false;
		if(ispravnoSve == true)
			return true;
		else
			return false;
	}
	

}