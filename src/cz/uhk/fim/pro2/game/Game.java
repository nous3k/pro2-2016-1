package cz.uhk.fim.pro2.game;

import cz.uhk.fim.game.gui.HomeScreen;
import cz.uhk.fim.game.gui.MainFrame;
import cz.uhk.fim.game.gui.ScoreScreen;


public class Game {

	public static void main(String[] args) {

		MainFrame mainFrame = new MainFrame();
		
		HomeScreen homeScreen= new HomeScreen(mainFrame);
		mainFrame.setScreen(homeScreen);
				
	}

}
