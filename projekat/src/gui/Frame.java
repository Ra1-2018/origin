package gui;

import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;
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

	}
}
