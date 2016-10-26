package cz.uhk.fim.pro2.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen {

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		
		add(jButtonBack);
		
		jButtonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
				
			}
		});
	}

}
