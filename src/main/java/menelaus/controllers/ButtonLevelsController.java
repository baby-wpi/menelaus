package menelaus.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.Level;
import menelaus.model.LevelsPackage;
import menelaus.model.basic.LevelType;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.HomeScreen;
import menelaus.view.game.LevelSelectorScreen;

public class ButtonLevelsController implements ActionListener{

	// The home screen JFrame that contains the levels button:
	
	public ButtonLevelsController(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Level level1 = new Level(LevelType.PUZZLE, 12, 12);
		Level level2 = new Level(LevelType.RELEASE, 8, 9);
		LevelsPackage levelsPackage = new LevelsPackage();
		levelsPackage.addLevel(level1);
		levelsPackage.addLevel(level2);
		
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen(levelsPackage));
	}

}
