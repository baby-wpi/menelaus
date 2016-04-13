package menelaus.controllers;


import menelaus.view.HomeScreen;
import menelaus.view.LevelSelector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeLevelsButtonController implements ActionListener{

	// The home screen JFrame that contains the levels button:
	HomeScreen home;
	
	public HomeLevelsButtonController(HomeScreen home){
		this.home = home;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		LevelSelector.main(null);
	}

}
