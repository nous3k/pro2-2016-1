package cz.uhk.fim.pro2.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public static final int WIDTH = 480;
	public static final int  HEIGHT = 800;
	
	public MainFrame() {
		setSize(480, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Flappy Bird");
		setResizable(false);
	}

}
