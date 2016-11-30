package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import interfaces.WorldListener;

public class World {

	//atributy
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	private boolean generated = false;
	
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEARTS = 450;
	
	static final int SPEED = 100;
	
	//konstruktor
	public World(Bird bird, WorldListener worldListener) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener = worldListener;
	}
	
	//metody:
	
	//metoda update - stará se o pohyb, voláme metudu update u ptáka, trubky, srdce
	//for each protože pro každý objekt ji zavoláme
	public void update(float deltaTime){
		bird.update(deltaTime);
		
		if(generated){
			regenerate();
		}
		
		if(bird.isOutOf()){
			worldListener.outOf();
		}
		
		for(Heart heart: hearts){
			heart.update(deltaTime);			
			if(bird.collideWith(heart)){
				worldListener.catchHeart(heart);
			}
		}
		
		for(Tube tube: tubes){
			tube.update(deltaTime);			
			if(bird.collideWith(tube)){
				tube.setCounted(true);
				worldListener.crashTube(tube);
			}
			else{
					if(bird.getPositionX() > tube.getMaxX()){
						if(!tube.isCounted()){
							bird.addPoint();
							System.out.println("Score: " + bird.getScore());
							tube.setCounted(true);
						}
						
					}
				}
		}		
	}
	
	public void generateRandom(){
		for(int i =0; i<3;i++){
			float x = (SPACE_BETWEEN_TUBES + i * SPACE_BETWEEN_TUBES);
			addTube(new Tube(x, Tube.getRandomHeight(), Color.GREEN));
		}
		
		addHeart(new Heart(SPACE_BETWEEN_HEARTS, Heart.getRandomY()));
		
		generated = true;
	}
	
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public void regenerate(){
		for(Tube tube : tubes){
			if (tube.getPositionX() < -100){
				tube.setPositionX(tube.getPositionX() + tubes.size()  * SPACE_BETWEEN_TUBES);
				tube.setHeight(Tube.getRandomHeight());
				tube.setCounted(false);
			}
		}
		
		for(Heart heart : hearts){
			if(heart.getPositionX() < -100){
				heart.setPositionX(heart.getPositionX() + (hearts.size() +1)*SPACE_BETWEEN_HEARTS);
				heart.setPositionY(Heart.getRandomY());
			}
		}
	}
	

	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	
	public Bird getBird() {
		return bird;
	}
	
	
	public List<Tube> getTubes() {
		return tubes;
	}

	public List<Heart> getHearts() {
		return hearts;
	}

}
