package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
	private JTabbedPane tabbedPane;
	
	
	private static Frame instance = null;

	
	
	private Frame() {
		
		this.createMenuBar();
		this.createToolbar();
		this.createTabbedPane();
		this.initPosition();
		this.createStatusBar();
	}
		
	public static Frame getInstance() {
		if (instance == null) {
			instance = new Frame();
		}
		return instance;
	}
	
	private void createMenuBar() {
		this.menu = new MenuBar();
		this.setJMenuBar(this.menu);
	}
	
	private void createToolbar() {
		this.toolbar = new Toolbar();
		this.add(this.toolbar, BorderLayout.NORTH);
	}
	
	private void createTabbedPane() {
		this.tabbedPane = new JTabbedPane();
		this.add(this.tabbedPane, BorderLayout.CENTER);
		addMyTabToTabbedPane("Studenti");
		addMyTabToTabbedPane("Profesori");
		addMyTabToTabbedPane("Predmeti");
	}
	
	private void initPosition() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		this.setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		this.setTitle("Studentska slu�ba");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	private void createStatusBar() {
		this.statusBar = new JPanel();
		this.add(this.statusBar, BorderLayout.SOUTH);
		
		BoxLayout box = new BoxLayout(this.statusBar, BoxLayout.X_AXIS);
		this.statusBar.setLayout(box);
		this.statusBar.setBackground(Color.WHITE);
		this.statusBar.setPreferredSize(new Dimension(100, 30));
		
		this.statusLabel = new JLabel("Studentska slu�ba");
		this.statusBar.add(Box.createHorizontalStrut(15));
		this.statusBar.add(this.statusLabel);
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
	
	private void addMyTabToTabbedPane(String tableName) {

		//ImageIcon icon = createImageIcon("images/img.png", true, 16, 16);

		TableTab mt = new TableTab(tableName);
		// add tab to tabbed pane
		tabbedPane.addTab(tableName, mt);
	}
}
