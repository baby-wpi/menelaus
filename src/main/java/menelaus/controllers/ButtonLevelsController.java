package menelaus.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.HomeScreen;
import menelaus.view.game.LevelSelectorScreen;

public class ButtonLevelsController implements ActionListener{

	// The home screen JFrame that contains the levels button:
	
	public ButtonLevelsController(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen());
	}

}
