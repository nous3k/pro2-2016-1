package cz.uhk.fim.pro2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {

	public HomeScreen(MainFrame mainFrame){
		super(mainFrame);
	
		
		JButton jButtonPlay = new JButton("PLAY");
		JButton jButtonScore = new JButton("SCORE");
		JButton jButtonSound = new JButton("SOUND");
		
		JLabel JLabelTitle = new JLabel("FIM BIRD");
		
		jButtonPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
				
			}
		});
		
		jButtonScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
				
			}
		});
			
		JLabelTitle.setFont(new Font("Arial", Font.BOLD, 40));
		JLabelTitle.setLocation(100, 100);
		
		//nastavim velikost a pozici
		
		jButtonPlay.setBounds(100, 400, 280, 50);
		jButtonScore.setBounds(100, 460, 280, 50);
		jButtonSound.setBounds(100, 520, 280, 50);
		
		add(jButtonPlay);
		add(jButtonScore);
		add(jButtonSound);
		add(JLabelTitle);
	}
	
}
