package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JLabel;

public class Frame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3821033433179171038L;

	private Toolbar toolbar;
	private MenuBar menu;
	private JPanel statusBar;
	private JLabel statusLabel;
	private JLabel trenutni_datum;
	private JLabel time;
	private CurrentTime sat;
	
	private static Frame instance = null;

	
	
	private Frame() {
		this.initPosition();
		this.createStatusbar();
		
		this.menu = new MenuBar();
		this.setJMenuBar(this.menu);
		
		this.toolbar = new Toolbar();
		this.add(this.toolbar, BorderLayout.NORTH);
	
		//JPanel panel = new JPanel();
		//panel.setBackground(Color.GRAY);
		//this.add(panel);
		//JLabel todolabel = new JLabel("TODO: prikaz entiteta sistema", JLabel.CENTER);
		//todolabel.setForeground(Color.WHITE);
		//panel.add(todolabel);
	}
		
	public static Frame getInstance() {
		if (instance == null) {
			instance = new Frame();
		}
		return instance;
	}
	
	private void initPosition() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		this.setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		this.setTitle("Studentska služba");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	private void createStatusbar() {
		this.statusBar = new JPanel();
		this.add(this.statusBar, BorderLayout.SOUTH);
		
		BoxLayout box = new BoxLayout(statusBar, BoxLayout.X_AXIS);
		this.statusBar.setLayout(box);
		this.statusBar.setBackground(Color.WHITE);
		this.statusBar.setPreferredSize(new Dimension(100, 30));
		
		this.statusLabel = new JLabel("Studentska služba");
		this.statusBar.add(Box.createHorizontalStrut(15));
		this.statusBar.add(statusLabel);
		this.statusBar.add(Box.createHorizontalGlue());

		
		this.trenutni_datum = new JLabel();
		this.time = new JLabel();
		
		this.sat = new CurrentTime(this.time, this.trenutni_datum);
		this.sat.start();
		
		this.statusBar.add(this.time);
		this.statusBar.add(Box.createHorizontalStrut(5)); 
		this.statusBar.add(this.trenutni_datum);
		this.statusBar.add(Box.createHorizontalStrut(15));
	}
}
