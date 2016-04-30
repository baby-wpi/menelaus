package menelaus.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.Level;
import menelaus.model.LevelsPackage;
import menelaus.model.SavedGames;
import menelaus.model.basic.LevelType;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelSelectorScreen;

public class ButtonLevelsController implements ActionListener {
	LevelsPackage levelsPackage;
	
	public ButtonLevelsController(LevelsPackage lp){
		this.levelsPackage = lp;
	}
	
	public ButtonLevelsController() {
		this.levelsPackage = GameWindowFrame.getInstance().getRecentlyPLayedLevelsPackage();
	}
	
	public void actionPerformed(ActionEvent e) {
		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
		LevelsPackage pack = levelsPackage;
		SavedGames savedGames = GameWindowFrame.getInstance().getSavedGamesUtil().getSavedGames();
		
		if (pack == null) {
			pack = GameWindowFrame.getInstance().getLevelsPackage();
			
		}
		
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen(pack, savedGames));
	}

}
