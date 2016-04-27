package menelaus.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.Level;
import menelaus.model.LevelsPackage;
import menelaus.model.SavedGames;
import menelaus.model.basic.LevelType;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelSelectorScreen;

public class ButtonLevelsController implements ActionListener {
	LevelsPackage levelsPackage;
	
	public ButtonLevelsController(LevelsPackage lp){
		this.levelsPackage = lp;
	}
	
	public ButtonLevelsController() {
	}
	
	public void actionPerformed(ActionEvent e) {
		LevelsPackage pack = levelsPackage;
		SavedGames savedGames = GameWindowFrame.getInstance().getSavedGamesUtil().getSavedGames();
		
		if (pack == null) {
			pack = GameWindowFrame.getInstance().getLevelsPackage();
			
		}
		
		for (int i = 0; i < 4; i++ ){
			pack.addLevel(new Level(LevelType.PUZZLE, 6, 6));
			pack.addLevel(new Level(LevelType.LIGHTNING, 6, 6));
			pack.addLevel(new Level(LevelType.RELEASE, 6, 6));
		}
		
		
		
		
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen(pack, savedGames));
	}

}
