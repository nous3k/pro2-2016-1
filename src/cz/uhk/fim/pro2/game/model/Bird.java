package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.game.gui.MainFrame;


public class Bird {
	
	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_LIVES = 3;
	public static final int JUMP = 650;

	private static final int GRAVITY = 400;

	
	private String name;
	private float positionX, positionY;
	//tato promená øíká jak rychle bude stoupat
	private float speed;
	private int lives;
	private int score;

	public Bird(String name, float positonX, float positionY) {
		super();
		this.name=name;
		this.positionX=positonX;
		this.positionY=positionY;		
		speed = JUMP / 2;
		lives = DEFAULT_LIVES;
		score = DEFAULT_SCORE;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);		
		Rectangle rectangle = getRectangle();
		
		g.fillRect(
				(int)rectangle.getX(),
				(int)rectangle.getY(),
				(int)rectangle.getWidth(),
				(int)rectangle.getHeight());
	}
	
	//vraáti souøadnice ke kolizím	
	public Rectangle getRectangle() {
		return new Rectangle(
				(int)(getPositionX()-25),
				(int)getPositionY()-25,
				50,
				50);
	}
	
	//metoda rozpohybovájící ftáka
	public void update(float deltaTime){
		positionY -= speed *deltaTime;
		//positionX += World.SPEED * deltaTime;
		positionY +=  GRAVITY*deltaTime;
		//øeší skok
		speed -= speed * deltaTime;
	}
	
	//kolize s trubou
	public Boolean collideWith(Tube tube){
		Rectangle rectangle = getRectangle();
		//intersect za nás poèítá, jestli se nám ty ètverce nepøekrývají!
		return rectangle.intersects(tube.getBottomRectangle()) || rectangle.intersects(tube.getTopRectangle());
	}
	
	//kolize se srdce
	public Boolean collideWith(Heart heart){
		return getRectangle().intersects(heart.getRectangle());
	}
	
	//kolize se zemí
	public Boolean isOutOf() {
		Rectangle rectangle = getRectangle();
		
		//porovnani min hodnot
		if (rectangle.getMinX()<0 || rectangle.getMinY() <0){
			return true;
		}
		
		if (rectangle.getMaxX()> MainFrame.WIDTH || rectangle.getMaxY() > MainFrame.HEIGHT){
			return true;
		}else{
			return false;
		}
		
			
	}
	
	
	public void goUp(){
		speed = JUMP;
	}
	
	public String getName(){
		return name;
	}
	
		public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}


	public void catchHeart(){
		lives++;	
	}
	
	public void die(){
		
	}
	
	public void addLive(){
		
	}
	
	public void removeLive(){
		lives --;
	}
	
	public void addPoint(){
		score++;
	}
	
	public boolean isAlive(){
		return lives >0;
	}

	public int getScore() {
		return score;
	}
	
	
}
