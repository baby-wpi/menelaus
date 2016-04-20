package menelaus.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.LevelsPackage;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.HomeScreen;
import menelaus.view.game.LevelSelectorScreen;

public class ButtonLevelsController implements ActionListener{

	LevelsPackage levelsPackage;
	
	// The home screen JFrame that contains the levels button:
	
	public ButtonLevelsController(){
		
	}
	
	public ButtonLevelsController(LevelsPackage lp){
		this.levelsPackage = lp;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen());
	}

}
