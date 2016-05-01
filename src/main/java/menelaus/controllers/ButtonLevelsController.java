package menelaus.controllers;


import menelaus.model.LevelsPackage;
import menelaus.model.SavedGames;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelSelectorScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonLevelsController implements ActionListener {
	LevelsPackage levelsPackage = null;
	
	public ButtonLevelsController(LevelsPackage lp){
		this.levelsPackage = lp;
	}
	
	public ButtonLevelsController() {
		if (GameWindowFrame.getInstance() == null) {
			return;
		}
		
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
