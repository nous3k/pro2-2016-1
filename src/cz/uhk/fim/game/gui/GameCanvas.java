package cz.uhk.fim.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {
	private World world;
	public static final int BOUND_UP = 100;
	public static final int BOUND_DOWN = 50;
	
	public GameCanvas(World world) {
		this.world=world;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
		Bird bird = world.getBird();
		
		bird.paint(g);
		
		List<Heart> hearts = world.getHearts();		
		for(Heart heart : hearts){
			heart.paint(g);
		}	
		
		List<Tube> tubes = world.getTubes();
		for (Tube tube : tubes){
			tube.paint(g);
		}
			
		g.setColor(Color.yellow);
		g.fillRect(0, 0, MainFrame.WIDTH, BOUND_UP);
		
		g.setColor(Color.black);
		g.fillRect(0, MainFrame.HEIGHT - BOUND_DOWN, MainFrame.WIDTH, BOUND_DOWN);
	}
}
