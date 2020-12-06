package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
//import javax.swing.JRadioButton;

public class Frame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4743270606172960944L;

	public Frame() {
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		
		
		JPanel statusBar = new JPanel();
		add(statusBar, BorderLayout.SOUTH);

		BoxLayout box = new BoxLayout(statusBar, BoxLayout.X_AXIS);
		statusBar.setLayout(box);	
		statusBar.setBackground(Color.WHITE);
		statusBar.setPreferredSize(new Dimension(100, 30));
		
		
		JLabel statusLabel = new JLabel("Studentska služba");
		statusBar.add(Box.createHorizontalStrut(15)); 
		statusBar.add(statusLabel);
		statusBar.add(Box.createHorizontalGlue());
		
		
		JLabel trenutni_datum = new JLabel();
		JLabel time = new JLabel();
		
		CurrentTime sat = new CurrentTime(time, trenutni_datum);
		sat.start();
		
		statusBar.add(time);
		statusBar.add(Box.createHorizontalStrut(5)); 
		statusBar.add(trenutni_datum);
		statusBar.add(Box.createHorizontalStrut(15)); 
		

	}
}
