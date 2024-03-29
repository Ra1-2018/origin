package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;




public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;
	
	public MenuBar() {
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");

		
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
		
		JMenuItem m_new = new JMenuItem(" New", new ImageIcon("images/new.png"));
		m_new.setMnemonic(KeyEvent.VK_N);
		m_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		
		
		m_new.addActionListener(new ActionListener()
		 {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 0) {				
					DialogDodajStudenta dialog = new DialogDodajStudenta();
					dialog.setVisible(true);
				
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					DialogDodajProfesora dialog = new DialogDodajProfesora();
					dialog.setVisible(true);
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {
					DialogDodajPredmet dialog = new DialogDodajPredmet();
					dialog.setVisible(true);

				}
			}

		});
	
		JMenuItem m_close = new JMenuItem(" Close", new ImageIcon("images/close.png"));
		m_close.setMnemonic(KeyEvent.VK_C);
		m_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		m_close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = new String[2];
				options[0] = new String ("Da");
				options[1] = new String ("Ne");
				int code = JOptionPane.showOptionDialog(Frame.getInstance().getContentPane(), "Da li ste sigurni da zelite da zatvorite aplikaciju?", "Zatvaranje aplikacije", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
				
				if (code == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			
			}
		});
		
	
		
		file.add(m_new);
		file.addSeparator();
		file.add(m_close);
		
		JMenuItem m_edit = new JMenuItem(" Edit", new ImageIcon("images/edit.png"));
		m_edit.setMnemonic(KeyEvent.VK_E);
		m_edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK));
		
		m_edit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 0) {	
					if(Frame.getInstance().getStudTab().getTabelaStudenata().getSelectedRow()>-1) {
					DialogIzmeniStudenta dialog = new DialogIzmeniStudenta(Frame.getInstance().getStudTab().getTabelaStudenata().getSelectedRow());
					dialog.setVisible(true);
					}
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					if(Frame.getInstance().getProfTab().getTabelaProfesora().getSelectedRow()>-1) {
						DialogIzmeniProfesora dialog = new DialogIzmeniProfesora(Frame.getInstance().getProfTab().getTabelaProfesora().getSelectedRow());
						dialog.setVisible(true);
						}
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {
					if(Frame.getInstance().getPredTab().getTabelaPredmeta().getSelectedRow()>-1) {
						DialogIzmeniPredmet dialog = new DialogIzmeniPredmet(Frame.getInstance().getPredTab().getTabelaPredmeta().getSelectedRow());
						dialog.setVisible(true);
						}
				}
			}		
		});
		
		JMenuItem m_delete = new JMenuItem(" Delete", new ImageIcon("images/delete.png"));
		m_delete.setMnemonic(KeyEvent.VK_D);
		m_delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		
		m_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 0) {
					if(Frame.getInstance().getStudTab().getTabelaStudenata().getSelectedRow()>-1) {
					DialogObrisiStudenta dialog = new DialogObrisiStudenta(Frame.getInstance().getStudTab().getTabelaStudenata().getSelectedRow());
					dialog.setVisible(true);
					}
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					//TODO Poziv dijaloga za brisanje profesora
					if(Frame.getInstance().getProfTab().getTabelaProfesora().getSelectedRow()>-1) {
						DialogObrisiProfesora dialog = new DialogObrisiProfesora(Frame.getInstance().getProfTab().getTabelaProfesora().getSelectedRow());
						dialog.setVisible(true);
					}
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {
					//
					}
				}
			});
		
		edit.add(m_edit);
		edit.addSeparator();
		edit.add(m_delete);
		
		JMenuItem m_help= new JMenuItem(" Help", new ImageIcon("images/help.png"));
		m_help.setMnemonic(KeyEvent.VK_H);
		m_help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK));
		m_help.addActionListener(new ActionListener()
				{
						@Override
							public void actionPerformed(ActionEvent e) {
							@SuppressWarnings("unused")
							DialogHelp help_dialog = new DialogHelp();
						}
				
				});
		
		JMenuItem m_about = new JMenuItem(" About", new ImageIcon("images/about.png"));
		m_about.setMnemonic(KeyEvent.VK_A);
		m_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		
		m_about.addActionListener(new ActionListener()
		{
				@Override
					public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("unused")
					DialogAbout about_dialog = new DialogAbout();
				}
		
		});
		
		help.add(m_help);
		help.addSeparator();
		help.add(m_about);
		
		add(file);
		add(edit);
		add(help);
	}
}