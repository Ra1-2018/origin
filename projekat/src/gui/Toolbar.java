package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
//import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
//import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;

public class Toolbar extends JToolBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		
		addSeparator();
		
		JButton btnNew = new JButton();
		btnNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 0) {
					System.out.println("Pritisnuto toolbar dugme za dodavanje novog studenta.");
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					DialogDodajProfesora ddp = new DialogDodajProfesora();
					ddp.setVisible(true);
					System.out.println("Pritisnuto toolbar dugme za dodavanje novog profesora.");
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {

				}
			}

		});
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("images/new.png"));	
		add(btnNew);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("images/edit.png"));
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		
		JTextField textfield = new JTextField(20);
		textfield.setMaximumSize(new Dimension(100, 30));
		add(textfield);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/search.png"));
		add(btnSearch);
		
		addSeparator();
		
		setFloatable(false);
	}
}
