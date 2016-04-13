package menelaus.controllers;


import menelaus.view.GameWindowFrame;
import menelaus.view.HomeScreen;
import menelaus.view.LevelSelectorScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelsButtonController implements ActionListener{

	// The home screen JFrame that contains the levels button:
	
	public LevelsButtonController(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen());
	}

}
