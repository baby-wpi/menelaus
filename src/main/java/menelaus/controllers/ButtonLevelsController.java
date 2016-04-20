package menelaus.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.Level;
import menelaus.model.LevelsPackage;
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
		
		if (pack == null) {
			pack = GameWindowFrame.getInstance().getLevelsPackage();
		}
		GameWindowFrame.getInstance().swapPanel(new LevelSelectorScreen(pack));
	}

}
