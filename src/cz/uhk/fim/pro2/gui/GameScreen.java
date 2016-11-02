package cz.uhk.fim.pro2.gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
		
	}

}
