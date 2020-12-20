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

import controller.StudentiController;
import model.Student;
import model.Student.Status;
public class DialogDodajStudenta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4020750263214713978L;
	
	
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
	JTextField prezimeText = new JTextField();
	JTextField datumRodjenjaText = new JTextField();
	JTextField adresaText = new JTextField();
	JTextField kontaktText = new JTextField();
	JTextField emailText = new JTextField();
	JTextField brIndeksaText = new JTextField();
	JTextField godinaUpisaText = new JTextField();
	JTextField prosecnaOcenaText = new JTextField();
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
	
	potvrda.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			String ime = imeText.getText();
			String prezime = prezimeText.getText();
			String datumRodjenja = datumRodjenjaText.getText();
			String adresa = adresaText.getText();
			String brIndeksa = brIndeksaText.getText();
			String brojTelefona = kontaktText.getText();
			String email = emailText.getText();
			String prosecnaOcena = prosecnaOcenaText.getText();
			String godinaUpisa = godinaUpisaText.getText();
			String godinaStudija=  godineStudijaComboBox.getSelectedItem().toString();
		    String nacinFinansiranja = budzet_samofinansiranjeComboBox.getSelectedItem().toString();
		    
		    double ocena = Double.parseDouble(prosecnaOcena);
		    	    
		    Status finansiranje;
		    
			if(nacinFinansiranja=="Budzet")
				finansiranje = Status.B;
			else
				finansiranje = Status.S;
			
			
			if(!ime.matches("\\s*[a-zA-Z]+\\s*")) {
				JOptionPane.showMessageDialog(null, "Unos ne odgovara ocekivanom formatu", "Greska pri unosu imena", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(!prezime.matches("\\s*[a-zA-Z]+\\s*")) {
				JOptionPane.showMessageDialog(null, "Unos ne odgovara ocekivanom formatu", "Greska pri unosu prezimena", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(!datumRodjenja.matches("\\d{1,2}-\\d{1,2}-\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Unos ne odgovara ocekivanom formatu", "Greska pri unosu datuma rodjenja ", JOptionPane.ERROR_MESSAGE);
				return;
				
			}
			
			if(!adresa.matches("[[a-zA-Z]+\s]+\\d+\\,[[a-zA-Z]+\s]+")) {
				JOptionPane.showMessageDialog(null, "Unos ne odgovara ocekivanom formatu", "Greska pri unosu adrese stanovanja ", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		    Student student = new Student(brIndeksa, ime, prezime, godinaStudija, finansiranje, ocena, datumRodjenja, adresa, brojTelefona, email, godinaUpisa);
			StudentiController.getInstance().dodajStudenta(student);
		
		}
		});
	
	odustanak.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			dispose();

		}

	});
	
	}
}
