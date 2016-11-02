package cz.uhk.fim.pro2.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import czk.uhk.fim.pro2.model.Bird;
import czk.uhk.fim.pro2.model.Heart;
import czk.uhk.fim.pro2.model.Tube;
import czk.uhk.fim.pro2.model.World;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
	 
		
	
		
		add(jButtonBack);
		add(jButtonPause);
		
		jButtonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
				
			}
		});
		
		
	//nastaveni pozice a velikosti tlacitek
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonBack.setFont(new Font("Arial", Font.PLAIN, 8));
		
		jButtonPause.setBounds(90, 20, 60, 60);
		jButtonPause.setFont(new Font("Arial", Font.PLAIN, 8));
		
	//WORLD
	Bird bird = new Bird("Ales",240,400);
	World world = new World(bird);
	
	world.addTube(new Tube(400, 400, Color.GREEN));
	world.addTube(new Tube(600, 300, Color.GREEN));
	world.addTube(new Tube(800, 500, Color.GREEN));
	
	world.addHeart(new Heart(500,450));
	world.addHeart(new Heart(700,600));
	
	GameCanvas gameCanvas = new GameCanvas(world);
	gameCanvas.setBounds(0, 0, MainFrame.WIDTH, mainFrame.getHeight());
	add(gameCanvas);
		
		
	}

}
