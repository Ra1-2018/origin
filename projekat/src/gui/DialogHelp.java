package gui;

//import java.awt.Color;
//import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
//import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DialogHelp extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4561836943292265193L;

	
	public DialogHelp() {
		
		JDialog dialog = new JDialog();
		
		dialog.setSize(700,500);
	
		dialog.setTitle("Help");
		
		JTextArea instrukcije = new JTextArea(30,100);
		instrukcije.setAutoscrolls(true);
		
		
         instrukcije.setLineWrap(true);
         instrukcije.setEditable(false);
         JScrollPane txtAreaScroll = new JScrollPane (instrukcije, 
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         
         txtAreaScroll.setViewportView(instrukcije);
         txtAreaScroll.setAutoscrolls(true);
		
		String text = 
				"Uputstva za koriscenje aplikacije:\n\r"+
				"DODAVANJE\n"+
			    "1. Dodavanje studenta - pritiskom prvog dugmeta u ToolBar-u/izborom stavke menija New\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda\n\r"+
				"2. Dodavanje profesora - pritiskom prvog dugmeta u ToolBar-u/izborom stavke menija New\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda\n\r"+
				"3. Dodavanje predmeta - pritiskom prvog dugmeta u ToolBar-u/izborom stavke menija New\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda\n\r"+
				"\n\r"+
				"IZMENE\n"+
				"4. Izmena informacija o studentu - pritiskom drugog dugmeta u ToolBar-u/izborom stavke menija Edit\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda, takodje potrebno je da označi odgovarajući red tabele.\n\r"+
				"\s 4.1 Ako se predmet nalazi u tabeli sa položenim predmetima, njemu je dodeljena odgovarajuća ocena i moguće je poništiti.\n\s Da bi se ocena poništila, potrebno je označiti predmet i kliknuti na dugme Poništi ocenu.\n\r"+
				"\s 4.2 Da bi se dodao novi student na predmet, potrebno je pozicionirati se na tab Nepoloženi i kliknuti dugme Dodaj.\n\r"+
				"\s U okviru taba Nepoloženi moguće je ukloniti predmete, koje označeni student sluša, tako sto se označi odgovarajući predmet i klikne na dugme Ukloni.\n\r"+
				"\s Da bi se polozio predmet iz liste nepolozenih neophodno je označiti neki od predmeta iz tabele nepoločenih predmeta, nakon čega se odabirom dugmeta Polaganje moguce izvrsiti upis ocene\n\r"+
				"5. Izmena informacija o profesoru - pritiskom drugog dugmeta u ToolBar-u/izborom stavke menija Edit\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda, takodje potrebno je da označi odgovarajući red tabele.\n\r"+
				"\s 5.1 Da bi se dodao novi predmet profesoru potrebno je izabrati tab Predemti u okviru dijaloga za izmenu profesora, a zatim dugme Dodaj predmet.\n\r"+
				"\s Da bi se izbrisao predmet profesoru potrebno je izabrati tab Predmeti u okviru dijaloga za izmenu profesora i selektovati predmet koji se uklanja, a zatim pritisnuti dugme Ukloni predmet\n\r"+
				"6. Izmena informacija o predmetu - pritiskom drugog dugmeta u ToolBar-u/izborom stavke menija Edit\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda, takodje potrebno je da označi odgovarajući red tabele.\n\r"+
				"\n\r"+
				"BRISANJE\n"+
				"7. Brisanje studenta - pritiskom treceg dugmeta u ToolBar-u/izborom stavke menija Delete\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda, takodje potrebno je da označi odgovarajući red tabele.\n\r"+
				"8. Brisanje profesora - pritiskom treceg dugmeta u ToolBar-u/izborom stavke menija Delete\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda, takodje potrebno je da označi odgovarajući red tabele.\n\r"+
				"9. Brisanje predmeta - pritiskom treceg dugmeta u ToolBar-u/izborom stavke menija Delete\n\r"+
				"NAPOMENA: Neophodno je da selektovani tab odgovara tipu entiteta koji referent namerava da doda, takodje potrebno je da označi odgovarajući red tabele.\n\r"+
				"SORTIRANJE\n"+
				"10. Sortiranje je moguce izvrsiti odabirom odgovarajuceg taba, a zatim klikom na zaglavlje kolone na osnovu koje ce  se elementi tabele sortirati."+
				"\n\r"+
				"PRETRAGA\n"+
				"11. Pretraga studenta\n\r"+
				"Prilikom pretrage studenata, u polje za pretragu unose se upiti koji se mogu sastojati od jedne, dve ili tri reči. Prva reč je obavezna i odnosi se na deo prezimena studenta.\n Druga, odnosno treća reč su opcione i odnose se na deo imena, odnosno broja indeksa studenta.\n\r"+
				"12. Pretraga profesora\n\r"+
				"Prilikom pretrage profesora, u polje za pretragu unose se upiti koji se mogu sastojati od jedne ili dve reči. Prva reč je obavezna i odnosi se na deo prezimena profesora.\n Druga reč je opciona i odnosi se na deo imena profesora.\n\r"+
				"11. Pretraga predmeta\n\r"+
				"Prilikom pretrage predmeta, u polje za pretragu unose se upiti koji se mogu sastojati od jedne reči koja se odnosi na deo naziva predmeta.\n\r"+
				"NAPOMENA: Nakon unosa upita potrebno je pritisnuti dugme za pretragu (lupa ikonica)\n\r"+
				"\n\r"+
				"Mnemonici:\n\r"+
				"ALT + F - File\n\r"+
				"\s\s\s ALT + N - New\n\r" +
				"\s\s\s ALT + C - Close\n\r"+
				"ALT + E - Edit\n\r"+
				"\s\s\s ALT + E - Edit\n\r"+
				"\s\s\s ALT + D - Delete\n\r"+
				"ALT + H - Help\n\r"+
				"\s\s\s ALT + H - Help\n\r"+
				"\s\s\s ALT + A - About\n\r"+
				"\n\r"+
				"Akceleratori\n\r:"+
				"   ALT + N - omogucava dodavanje novog entiteta u sistem u zavisnosti od selektovanog taba\n\r"+
				"   ALT + C - omogucava izlazak iz aplikacije\n\r" +
				"   CTRL + ALT + E - omogucava izmenu entiteta u zavisnosti od selektovanog taba pod uslovom da je selektovan entitet iz tabele\n\r"+
				"   ALT + D - omogucava brisanje entiteta u zavisnosti od selektovanog taba pod uslovom da je selektovan entitet iz tabele\n\r"+
				"   CTRL + ALT + H - help dijalog\n\r"+
				"   ALT + A - about dijalog\n\r";
		
		
		
		instrukcije.setText(text);
		
		dialog.add(txtAreaScroll);
		
		dialog.pack();
		
		dialog.setLocationRelativeTo(this.getParent());
		dialog.setVisible(true);
	
	}
}
