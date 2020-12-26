package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private ProfesoriTableTab profTab;
	private StudentiTableTab studTab;
	
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
		addStudentiTabToTabbedPane("Studenti");
		addProfesoriTabToTabbedPane("Profesori");
		//addPredmetiTabToTabbedPane("Predmeti");
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
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int code = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da zatvorite aplikaciju?",
						"Zatvaranje aplikacije?", JOptionPane.YES_NO_OPTION);
				if (code != JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} else {
					setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
	}
	
	
	private void createStatusBar() {
		this.statusBar = new JPanel();
		this.add(this.statusBar, BorderLayout.SOUTH);
		
		BoxLayout box = new BoxLayout(this.statusBar, BoxLayout.X_AXIS);
		this.statusBar.setLayout(box);
		this.statusBar.setBackground(Color.WHITE);
		this.statusBar.setPreferredSize(new Dimension(100, 30));
		
		this.statusLabel = new JLabel("Studentska služba");
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
	private void addStudentiTabToTabbedPane(String tableName) {
		this.studTab = new StudentiTableTab(tableName);
		
		tabbedPane.addTab(tableName, this.studTab);
		
	}
	
	private void addProfesoriTabToTabbedPane(String tableName) {
		this.profTab = new ProfesoriTableTab(tableName);

		tabbedPane.addTab(tableName, this.profTab);
	}
	

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public StudentiTableTab getStudTab() {
		return studTab;
	}
	
	public void setStudTab(StudentiTableTab studTab) {
		this.studTab = studTab;
	}
	
	public ProfesoriTableTab getProfTab() {
		return profTab;
	}

	public void setProfTab(ProfesoriTableTab profTab) {
		this.profTab = profTab;
	}
	
}
