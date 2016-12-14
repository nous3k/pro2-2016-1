package cz.uhk.fim.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen {
	
	JLabel scoreLabel;
	JButton jButtonPlay = new JButton("PLAY");	
	JButton jButtonScore = new JButton("SCORE");

	public FinishScreen(MainFrame mainFrame, World world) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
		
		scoreLabel = new JLabel(world.getBird().getScore() + "!");
		scoreLabel.setFont(new Font("Arial",Font.BOLD, 40));
		scoreLabel.setBounds(240, 100, 280, 50);
		
		ScoreManager.putScore(world.getBird().getScore());
		
		jButtonPlay.setBounds(100, 400, 280, 50);
		jButtonScore.setBounds(100, 450, 280, 50);
		
		jButtonScore.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
			}
		});
		
		
		
		add(scoreLabel);
		add(jButtonPlay);
		add(jButtonScore);
	}

}
