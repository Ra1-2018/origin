package gui;

import javax.swing.Icon;
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
				
		Icon icon = new ImageIcon("new.png");
		JMenuItem m_new = new JMenuItem("New", icon);
			
		icon = new ImageIcon("close.png");
		JMenuItem m_close = new JMenuItem("Close", icon);
		
		file.add(m_new);
		file.addSeparator();
		file.add(m_close);
		
		icon = new ImageIcon("edit.png");
		JMenuItem m_edit = new JMenuItem("Edit");
		
		icon = new ImageIcon("delete.png");
		JMenuItem m_delete = new JMenuItem("Delete");
		
		file.add(m_edit);
		file.addSeparator();
		file.add(m_delete);
		
		icon = new ImageIcon("help.png");
		JMenuItem m_help= new JMenuItem("Help");
		
		icon = new ImageIcon("about.png");
		JMenuItem m_about = new JMenuItem("About");
		
		file.add(m_help);
		file.addSeparator();
		file.add(m_about);
		
		add(file);
		add(edit);
		add(help);
	}
}