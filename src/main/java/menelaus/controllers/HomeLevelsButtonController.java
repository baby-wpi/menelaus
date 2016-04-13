package menelaus.controllers;


import menelaus.view.GameWindowFrame;
import menelaus.view.HomeScreen;
import menelaus.view.LevelSelector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeLevelsButtonController implements ActionListener{

	// The home screen JFrame that contains the levels button:
	
	public HomeLevelsButtonController(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new LevelSelector());
	}

}
