package menelaus.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.HomeScreen;
import menelaus.view.game.LevelSelectorScreen;

public class LevelsButtonController implements ActionListener{

	// The home screen JFrame that contains the levels button:
	
	public LevelsButtonController(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen());
	}

}
