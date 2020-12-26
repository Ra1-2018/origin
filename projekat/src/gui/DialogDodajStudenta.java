package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.StudentiController;
import model.Student;
import model.Student.Status;
public class DialogDodajStudenta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4020750263214713978L;
	

	private boolean ispravni[] = {false, false, false, false, false, false, false, false, false};
	String ime;
	String prezime;
	String brojTelefona;
	String datumRodjenja;
	String adresa;
	String brIndeksa;
	String email;
	String prosecnaOcena;
	String godinaUpisa;
	
	public DialogDodajStudenta() {
	super();
	
	
	setSize(750, 750);
	this.setModal(true);
	setLocationRelativeTo(Frame.getInstance());
	setTitle("Dodavanje novog studenta");
	
	
	JPanel dialogPanel = new JPanel();
	BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
	dialogPanel.setLayout(dialogLayout);
	
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
	
	JTextField imeText = new JTextField();
	imeText.setToolTipText("Format: slova i razmaci");
	JTextField prezimeText = new JTextField();
	prezimeText.setToolTipText("Format: slova i razmaci");
	JTextField datumRodjenjaText = new JTextField();
	datumRodjenjaText.setToolTipText("Format: dd-MM-yyyy");
	JTextField adresaText = new JTextField();
	adresaText.setToolTipText("Format: slova i razmaci + broj + zapeta + slova i razmaci");
	JTextField kontaktText = new JTextField();
	JTextField emailText = new JTextField();
	JTextField brIndeksaText = new JTextField();
	brIndeksaText.setToolTipText("Format: AAxxx-yyyy");
	JTextField godinaUpisaText = new JTextField();
	godinaUpisaText.setToolTipText("Format: yyyy");
	JTextField prosecnaOcenaText = new JTextField();
	prosecnaOcenaText.setToolTipText("Format: cifra + tacka + dve cifre ili 10.00");
	String[] godineStudija = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
	JComboBox<String> godineStudijaComboBox = new JComboBox<String>(godineStudija);	
	String[] budzet_samofinansiranje = { "Budzet", "Samofinansiranje" };
	JComboBox<String> budzet_samofinansiranjeComboBox = new JComboBox<String>(budzet_samofinansiranje);
	
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
	
	dialogPanel.add(imePanel);
	dialogPanel.add(prezimePanel);
	dialogPanel.add(datumRodjenjaPanel);
	dialogPanel.add(adresaPanel);
	dialogPanel.add(kontaktPanel);
	dialogPanel.add(emailPanel);
	dialogPanel.add(brIndeksaPanel);
	dialogPanel.add(prosecnaOcenaPanel);
	dialogPanel.add(godinaUpisaPanel);
	dialogPanel.add(godinaStudijaPanel);
	dialogPanel.add(nacinFinansiranjaPanel);
	dialogPanel.add(Box.createVerticalStrut(25));
	
	add(dialogPanel, BorderLayout.CENTER);
	
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
	
	add(buttonPanel, BorderLayout.SOUTH);
	setLocationRelativeTo(Frame.getInstance());
	
	potvrda.setEnabled(false);
	
	
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
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, "10.00", 7));
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, "10.00", 7));
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, "10.00", 7));
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
					if (s.getBrojIndeksa().equals(brIndeksa)) {
						JOptionPane.showMessageDialog(null, "Student sa datim broj indeksa vec postoji u sistemu", "Greska pri unosu broja indeksa", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			
				try {	
			Date datumRodjenjaDate = new SimpleDateFormat("dd-MM-yyyy").parse(datumRodjenja);
			System.out.println(datumRodjenjaDate);
		    Student student = new Student(brIndeksa, ime, prezime, godinaStudija, finansiranje, ocena, datumRodjenjaDate, adresa, brojTelefona, email, godinaUpisa);
			StudentiController.getInstance().dodajStudenta(student);
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
