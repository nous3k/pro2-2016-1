package czk.uhk.fim.pro2.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	public World(Bird bird){
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public String toString(){
		return("Jm�no pt�ka: " + bird.getName() + " Po�et trubek: " + tubes.size() + " Po�et srd��ek: " + hearts.size());
	}
	
	public Bird getBird(){
		return bird;
	}
}
