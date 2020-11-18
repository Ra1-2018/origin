package gui;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;
	
	public MenuBar() {
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");

		JMenuItem m_new = new JMenuItem("New", new ImageIcon("images/new.png"));		
		JMenuItem m_close = new JMenuItem("Close", new ImageIcon("images/close.png"));
		
		file.add(m_new);
		file.addSeparator();
		file.add(m_close);
		
		JMenuItem m_edit = new JMenuItem("Edit", new ImageIcon("images/edit.png"));
		JMenuItem m_delete = new JMenuItem("Delete", new ImageIcon("images/delete.png"));
		
		edit.add(m_edit);
		edit.addSeparator();
		edit.add(m_delete);
		
		JMenuItem m_help= new JMenuItem("Help", new ImageIcon("images/help.png"));
		JMenuItem m_about = new JMenuItem("About", new ImageIcon("images/about.png"));
		
		help.add(m_help);
		help.addSeparator();
		help.add(m_about);
		
		add(file);
		add(edit);
		add(help);
	}
}