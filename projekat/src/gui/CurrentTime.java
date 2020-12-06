package gui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

public class CurrentTime extends Thread {

	private JLabel vreme;
	private JLabel datum;
	
	public CurrentTime(JLabel l1, JLabel l2) {
		vreme = l1;
		datum = l2;
	}
	
	public void run() {
		
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		while(true) {
		vreme.setText(LocalTime.now().format(timeFormat));
		datum.setText(LocalDate.now().format(dateFormat));
		}
	}
}
