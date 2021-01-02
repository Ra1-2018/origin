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

import model.BazaProfesora;
import model.Profesor;

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
	private PredmetiTableTab predTab;
	
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
		JPanel bigPanel = new JPanel(new BorderLayout());
		
		JPanel panNorth = new JPanel();
		panNorth.setPreferredSize(new Dimension(1000, 10));
		bigPanel.add(panNorth, BorderLayout.NORTH);
		
		JPanel panSouth = new JPanel();
		panSouth.setPreferredSize(new Dimension(1000, 10));
		bigPanel.add(panSouth, BorderLayout.SOUTH);
		
		JPanel panWest = new JPanel();
		panWest.setPreferredSize(new Dimension(25, 1000));
		bigPanel.add(panWest, BorderLayout.WEST);
		
		JPanel panEast = new JPanel();
		panEast.setPreferredSize(new Dimension(25, 1000));
		bigPanel.add(panEast, BorderLayout.EAST);
		
		this.tabbedPane = new JTabbedPane();
		bigPanel.add(this.tabbedPane, BorderLayout.CENTER);
		
		this.add(bigPanel, BorderLayout.CENTER);
		
		addStudentiTabToTabbedPane("Studenti");
		addProfesoriTabToTabbedPane("Profesori");
		addPredmetiTabToTabbedPane("Predmeti");
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			p.initNePredaje();
		}
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
				String[] options = new String[2];
				options[0] = new String("Da");
				options[1] = new String("Ne");
				int code = JOptionPane.showOptionDialog(Frame.getInstance().getContentPane(),"Da li ste sigurni da zelite da zatvorite aplikaciju?","Zatvaranje aplikacije?", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
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
	
	private void addPredmetiTabToTabbedPane(String tableName) {
		this.predTab = new PredmetiTableTab(tableName);
		
		tabbedPane.addTab(tableName, this.predTab);
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

	public PredmetiTableTab getPredTab() {
		return predTab;
	}

	public void setPredTab(PredmetiTableTab predTab) {
		this.predTab = predTab;
	}
}
