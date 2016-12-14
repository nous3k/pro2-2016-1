package cz.uhk.fim.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {
	private World world;
	
	
	private BufferedImage imageBird;
	private BufferedImage imageHeart;
	private BufferedImage imageTube;
	private BufferedImage imageTop;
	private BufferedImage imageBottom;
	private BufferedImage imageBackground;
	
	
	
	public static final int BOUND_UP = 100;
	public static final int BOUND_DOWN = 50;
	
	public GameCanvas(World world) {
		this.world=world;
		
		try {
			imageBird = ImageIO.read(new File("assets/bird.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			imageHeart = ImageIO.read(new File("assets/heart.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			imageTube = ImageIO.read(new File("assets/tube.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			imageTop = ImageIO.read(new File("assets/top.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			imageBottom = ImageIO.read(new File("assets/bottom.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			imageBackground = ImageIO.read(new File("assets/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
				
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(imageBackground, 0, BOUND_UP, MainFrame.WIDTH, MainFrame.HEIGHT - BOUND_DOWN - BOUND_UP, null);
		
		Bird bird = world.getBird();
		
		bird.paint(g, imageBird);
		
		List<Heart> hearts = world.getHearts();		
		for(Heart heart : hearts){
			heart.paint(g, imageHeart);
		}	
		
		List<Tube> tubes = world.getTubes();
		for (Tube tube : tubes){
			tube.paint(g, imageTube);
		}
			
		g.setColor(Color.yellow);
		g.drawImage(imageTop,0,0, MainFrame.WIDTH, BOUND_UP, null);
		
		g.setColor(Color.black);
		g.drawImage(imageBottom,0, MainFrame.HEIGHT - BOUND_DOWN, MainFrame.WIDTH, BOUND_DOWN, null);
	}
}
