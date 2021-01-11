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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

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
	BorderLayout polozeniLayout = new BorderLayout();
	panelPolozeni.setLayout(polozeniLayout);
	tabbedPane.addTab("Polozeni", panelPolozeni);

	JPanel panelNepolozeni = new JPanel();
	BorderLayout nepolozeniLayout = new BorderLayout();
	panelNepolozeni.setLayout(nepolozeniLayout);
	tabbedPane.addTab("Nepolozeni", panelNepolozeni);
	
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
	
	
	Student student = StudentiController.getInstance().getListaSvihStudenata().get(selectedIndex);
	ime = student.getIme();
	prezime = student.getPrezime();
	DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	datumRodjenja = date.format(student.getDatumRodjenja());
	brojTelefona = student.getKontaktTelefon();
	adresa = student.getAdresaStanovanja();
	brIndeksa = student.getBrojIndeksa();
	email = student.getEmailAdresa();
	prosecnaOcena = Double.toString(student.getProsecnaOcena());
	godinaUpisa = student.getGodinaUpisa();
    
	
	
	JTextField imeText = new JTextField(student.getIme());
	imeText.setToolTipText("Format: slova i razmaci");
	JTextField prezimeText = new JTextField(student.getPrezime());
	prezimeText.setToolTipText("Format: slova i razmaci");
	JTextField datumRodjenjaText = new JTextField(date.format(student.getDatumRodjenja()));
	datumRodjenjaText.setToolTipText("Format: dd-MM-yyyy");
	JTextField adresaText = new JTextField(student.getAdresaStanovanja());
	adresaText.setToolTipText("Format: slova i razmaci + broj + zapeta + slova i razmaci");
	JTextField kontaktText = new JTextField(student.getKontaktTelefon());
	JTextField emailText = new JTextField(student.getEmailAdresa());
	JTextField brIndeksaText = new JTextField(student.getBrojIndeksa());
	brIndeksaText.setToolTipText("Format: AAxxx-yyyy");
	JTextField godinaUpisaText = new JTextField(student.getGodinaUpisa());
	godinaUpisaText.setToolTipText("Format: yyyy");
	JTextField prosecnaOcenaText = new JTextField(Double.toString(student.getProsecnaOcena()));
	prosecnaOcenaText.setToolTipText("Format: cifra + tacka + dve cifre ili 10.00");
	String[] godineStudija = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
	JComboBox<String> godineStudijaComboBox = new JComboBox<String>(godineStudija);	
	String[] budzet_samofinansiranje = { "Budzet", "Samofinansiranje" };
	JComboBox<String> budzet_samofinansiranjeComboBox = new JComboBox<String>(budzet_samofinansiranje);
	
	godineStudijaComboBox.setSelectedItem(student.getTrenutnaGodinaStudija());
    budzet_samofinansiranjeComboBox.setSelectedIndex(student.getStatus().ordinal());	
	
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
	
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnDodaj);
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnObrisi);
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnPolaganje);
	buttonPanel.add(Box.createHorizontalGlue());
	btnNpPan.setPreferredSize(new Dimension(750, 50));
	panelNepolozeni.add(btnNpPan, BorderLayout.NORTH);
	
	NepolozeniPredmetiJTable nepolozeniPredmeti = new NepolozeniPredmetiJTable(student);
	JScrollPane nepolozeniScrollPane = new JScrollPane(nepolozeniPredmeti);
	nepolozeniScrollPane.setPreferredSize(new Dimension(300, 300));
	panelNepolozeni.add(nepolozeniScrollPane, BorderLayout.CENTER);
	
	JPanel westPanel = new JPanel();
	westPanel.setPreferredSize(new Dimension(25, 750));
	panelNepolozeni.add(westPanel, BorderLayout.WEST);
	
	JPanel eastPanel = new JPanel();
	eastPanel.setPreferredSize(new Dimension(25, 750));
	panelNepolozeni.add(eastPanel, BorderLayout.EAST);
	
	JPanel southPanel = new JPanel();
	southPanel.setPreferredSize(new Dimension(750, 50));
	panelNepolozeni.add(southPanel, BorderLayout.SOUTH);
	
	btnDodaj.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DialogDodajPredmetStudentu ddps = new DialogDodajPredmetStudentu(student, nepolozeniPredmeti);
			ddps.setVisible(true);
		}
		
	});
	
	btnObrisi.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(nepolozeniPredmeti.getSelectedRow() > -1) {
				DialogObrisiPredmetStudentu dops = new DialogObrisiPredmetStudentu(nepolozeniPredmeti, student);
				dops.setVisible(true);
			}
		}
	});
	
	
	JPanel btnPolozeniPanel = new JPanel();
	BoxLayout btnPolozeniLayout = new BoxLayout(btnPolozeniPanel, BoxLayout.X_AXIS);
	btnPolozeniPanel.setLayout(btnPolozeniLayout);
	
	JButton btnPonistiOcenu = new JButton("Ponisti ocenu");
	btnPonistiOcenu.setPreferredSize(new Dimension(150, 30));
	
	btnPolozeniPanel.add(Box.createHorizontalStrut(25));
	btnPolozeniPanel.add(btnPonistiOcenu);
	btnPolozeniPanel.add(Box.createHorizontalGlue());
	btnPolozeniPanel.setPreferredSize(new Dimension(750, 50));
	panelPolozeni.add(btnPolozeniPanel, BorderLayout.NORTH);
	
	
	PolozeniIspitiJTable polozeniPredmeti = new PolozeniIspitiJTable(student);
	JScrollPane polozeniScrollPane = new JScrollPane(polozeniPredmeti);
	polozeniScrollPane.setPreferredSize(new Dimension(300, 300));
	panelPolozeni.add(polozeniScrollPane, BorderLayout.CENTER);
	
	JPanel leviPanel = new JPanel();
	leviPanel.setPreferredSize(new Dimension(25, 750));
	panelPolozeni.add(leviPanel, BorderLayout.WEST);
	
	JPanel desniPanel = new JPanel();
	desniPanel.setPreferredSize(new Dimension(25, 750));
	panelPolozeni.add(desniPanel, BorderLayout.EAST);
	
	JPanel donjiPanel = new JPanel();
	BoxLayout donjiLayout = new BoxLayout(donjiPanel, BoxLayout.Y_AXIS);
	donjiPanel.setLayout(donjiLayout);
	panelPolozeni.add(donjiPanel, BorderLayout.SOUTH);
	
	JPanel panelOcene = new JPanel();
	BoxLayout desniLayout = new BoxLayout(panelOcene, BoxLayout.X_AXIS);
	panelOcene.setLayout(desniLayout);
	
	JPanel panelBodovi = new JPanel();
	BoxLayout desni1Layout = new BoxLayout(panelBodovi, BoxLayout.X_AXIS);
	panelBodovi.setLayout(desni1Layout);
	
	JLabel srednjaOcena = new JLabel("Prosecna ocena:  " + student.getProsecnaOcena());
	panelOcene.add(Box.createHorizontalGlue());
	panelOcene.add(srednjaOcena);
	panelOcene.add(Box.createHorizontalStrut(10));
	
	JLabel ukupniBodovi = new JLabel("Ukupno ESPB:  " + student.ukupnoBodova());
	panelBodovi.add(Box.createHorizontalGlue());
	panelBodovi.add(ukupniBodovi);
	panelBodovi.add(Box.createHorizontalStrut(10));
	
	donjiPanel.add(Box.createVerticalStrut(10));
	donjiPanel.add(panelOcene);
	donjiPanel.add(Box.createVerticalStrut(10));
	donjiPanel.add(panelBodovi);
	donjiPanel.add(Box.createVerticalStrut(10));

	polozeniPredmeti.getModel().addTableModelListener(new TableModelListener() {

		@Override
		public void tableChanged(TableModelEvent arg0) {
			// TODO Auto-generated method stub
			
			srednjaOcena.setText("Prosecna ocena:  " + student.prosecnaOcena());
			ukupniBodovi.setText("Ukupno ESPB:  " + student.ukupnoBodova());
			
		}
		
	});
	
	
	btnPolaganje.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(nepolozeniPredmeti.getSelectedRow() > -1) {
				DialogUpisiOcenu duo = new DialogUpisiOcenu(nepolozeniPredmeti, polozeniPredmeti, student);
				duo.setVisible(true);
			}
		}
		
	});
	
	
	btnPonistiOcenu.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(polozeniPredmeti.getSelectedRow() > -1) {
				DialogObrisiOcenu doo = new DialogObrisiOcenu(polozeniPredmeti, nepolozeniPredmeti, student);
				doo.setVisible(true);
			}
		}
	});
	
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
