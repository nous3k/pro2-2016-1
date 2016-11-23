package cz.uhk.fim.game.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public static final int WIDTH = 480; 
	public static final int HEIGHT = 800; 
	
	//rikame ze vzdycky tu bude nejaka screena
	protected Screen actualScreen;
	
	public MainFrame(){
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Flappy bird");
		setResizable(false);
	}
	
	//metoda nám nastavuje aktuální screenu, bere ji z paramatru, jakou
	public void setScreen(Screen screen){
		if (actualScreen != null){
			remove(actualScreen);
		}
		add(screen);
		actualScreen = screen;
		revalidate();
		
	}
	
}
