package czk.uhk.fim.pro2.game;

import cz.uhk.fim.pro2.gui.HomeScreen;
import cz.uhk.fim.pro2.gui.MainFrame;
import cz.uhk.fim.pro2.gui.GameScreen;
import cz.uhk.fim.pro2.gui.ScoreScreen;

public class Game {

	public static void main(String[] args) {
		
		MainFrame mainFrame = new MainFrame();
		
		mainFrame.setScreen(new HomeScreen(mainFrame));

	}

}
