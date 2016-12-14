package cz.uhk.fim.pro2.game;

import java.io.File;
import java.io.IOException;

import cz.uhk.fim.game.gui.HomeScreen;
import cz.uhk.fim.game.gui.MainFrame;
import cz.uhk.fim.game.gui.ScoreScreen;


public class Game {
	
	public static final String SCORE_FILE = "scores.csv";

	public static void main(String[] args) {
		
		File file = new File(SCORE_FILE);
		
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Nejde vytvoøit soubor!");
			}
		}

		MainFrame mainFrame = new MainFrame();
		
		HomeScreen homeScreen= new HomeScreen(mainFrame);
		mainFrame.setScreen(homeScreen);
				
	}

}
