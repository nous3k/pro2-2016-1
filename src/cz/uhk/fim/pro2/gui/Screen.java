package cz.uhk.fim.pro2.gui;

import javax.swing.JPanel;

public abstract class Screen extends JPanel {

	protected MainFrame mainFrame;
	
	public Screen(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		
	}
}
