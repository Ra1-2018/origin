package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

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
					DialogDodajStudenta dds = new DialogDodajStudenta();
					dds.setVisible(true);
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					DialogDodajProfesora ddp = new DialogDodajProfesora();
					ddp.setVisible(true);
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {
					DialogDodajPredmet ddpr = new DialogDodajPredmet();
					ddpr.setVisible(true);
				}
			}

		});
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("images/new.png"));	
		add(btnNew);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 0) {
					if(Frame.getInstance().getStudTab().getTabelaStudenata().getSelectedRow() > -1) {
						DialogIzmeniStudenta dis = new DialogIzmeniStudenta(Frame.getInstance().getStudTab().getTabelaStudenata().getSelectedRow());
						dis.setVisible(true);
					}
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					if(Frame.getInstance().getProfTab().getTabelaProfesora().getSelectedRow() > -1) {
						DialogIzmeniProfesora dip = new DialogIzmeniProfesora(Frame.getInstance().getProfTab().getTabelaProfesora().getSelectedRow());
						dip.setVisible(true);
					}
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {
					//TODO Poziv dijaloga za izmenu predmeta
				}
			}
		});
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("images/edit.png"));
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 0) {
					//TODO Poziv dijaloga za brisanje studenta
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					//TODO Poziv dijaloga za brisanje profesora
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {
					if(Frame.getInstance().getPredTab().getTabelaPredmeta().getSelectedRow() > -1) {
						DialogObrisiPredmet dop = new DialogObrisiPredmet(Frame.getInstance().getPredTab().getTabelaPredmeta().getSelectedRow());
						dop.setVisible(true);
					}
				}
			}
		});
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		
		JTextField textfield = new JTextField(20);
		textfield.setMaximumSize(new Dimension(100, 30));
		add(textfield);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 0) {
					//TODO
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 1) {
					
					/*String[] reci = textfield.getText().split(" ");
					for(int i=0; i< reci.length; i++) {
						ProfesoriJTable.newFilter(reci[i], i);
					}*/
					String test = textfield.getText();
					ProfesoriJTable.newFilter(test);
				}
				if (Frame.getInstance().getTabbedPane().getSelectedIndex() == 2) {
					//TODO
				}
			}
		});
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/search.png"));
		add(btnSearch);
		
		addSeparator();
		
		setFloatable(false);
	}
}
