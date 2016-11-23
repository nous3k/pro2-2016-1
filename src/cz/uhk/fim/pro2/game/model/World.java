package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

import interfaces.WorldListener;

public class World {

	//atributy
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	
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
					if(bird.getPositionX() > tube.getMinX() && bird.getPositionX() < tube.getMaxX()){
						if(!tube.isCounted()){
							bird.addPoint();
							System.out.println("Score: " + bird.getScore());
							tube.setCounted(true);
						}
						
					}
				}
		}		
	}
	
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public void addTubet(Tube tube){
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
