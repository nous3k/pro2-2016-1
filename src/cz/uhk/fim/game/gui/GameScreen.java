package cz.uhk.fim.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;
import interfaces.WorldListener;

public class GameScreen extends Screen  implements WorldListener{
	
	private long lastTimeMillis;
	private Timer timer;
	private Bird bird;
	private JLabel jLabelScore;
	private JLabel jLabelLives;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		jButtonPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning() == true){
					timer.stop();
				}else{
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
				}
			}
		});
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonBack.setFont(new Font("Arial",Font.PLAIN, 8));
		jButtonPause.setBounds(400, 20, 60, 60);
		jButtonPause.setFont(new Font("Arial",Font.PLAIN, 8));
		
		add(jButtonPause);
		add(jButtonBack);
		
		jLabelLives = new JLabel("Lives: " + Bird.DEFAULT_LIVES);
		jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		
		jLabelLives.setBounds(260, 20, 12, 60);
		jLabelScore.setBounds(100, 20, 120, 60);
		
		add(jLabelLives);
		add(jLabelScore);

		
		//WORLD	
		bird = new Bird("Pavel", 150, 400);
		
		World world = new World(bird, this);
		world.generateRandom();
		//world.addTube(new Tube(400, 400, Color.green));
		//world.addTube(new Tube(600, 300, Color.green));
		//world.addTube(new Tube(800, 500, Color.green));
		
		//world.addHeart(new Heart(500, 450));
		//world.addHeart(new Heart(700, 600));
		
		GameCanvas gamecanvas = new GameCanvas(world);
		gamecanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		
		gamecanvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				bird.goUp();
			}
		});
		
		add(gamecanvas);


		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				
				float delta = (currentTimeMillis - lastTimeMillis) / 1000f;				
				world.update(delta);
				
				jLabelLives.setText("Lives: " + bird.getLives());
				jLabelScore.setText("Score: " + bird.getScore());
				
				if(!bird.isAlive()){
					timer.stop();
				}
				
				
				gamecanvas.repaint();
				
				lastTimeMillis = currentTimeMillis;
			}
		});
		
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}

	@Override
	public void crashTube(Tube tube) {
		bird.removeLive();
		bird.setPositionY(tube.getCenterY());
		System.out.println("naboural do tuby");
		
	}

	@Override
	public void catchHeart(Heart heart) {
		System.out.println("Catched heart");
		heart.setPositionY(-100);
		bird.catchHeart();
		
	}

	@Override
	public void outOf() {
		System.out.println("je mimo");
		bird.setPositionY(MainFrame.HEIGHT);
		bird.setSpeed(Bird.JUMP / 2);
		
		bird.removeLive();
		
		
	}
}

