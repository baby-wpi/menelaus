package menelaus.view.game;

import menelaus.controllers.ButtonMainMenuController;
import menelaus.model.Level;
import menelaus.model.LevelStars;
import menelaus.model.LevelsPackage;
import menelaus.model.SavedGames;
import menelaus.view.KabasujiPanel;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

public class LevelSelectorScreen extends KabasujiPanel {
	/**
	 * Create the panel.
	 */
	public LevelSelectorScreen(LevelsPackage levelsPackage) {
		int count = 1;
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		// TEST
		SavedGames savedGames = new SavedGames();
		savedGames.addLevelStars(new LevelStars(3, levelsPackage.getLevels().get(0).getUuid()));
		savedGames.addLevelStars(new LevelStars(1, levelsPackage.getLevels().get(1).getUuid()));
		savedGames.addLevelStars(new LevelStars(2, levelsPackage.getLevels().get(2).getUuid()));
		
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ButtonMainMenuController());
		
		// For each level
		for (Level l : levelsPackage.getLevels()) {
			LevelSelectComponent btnLevelX = new LevelSelectComponent(l, savedGames.getStarsForLevel(l));
			btnLevelX.setBackground(Color.white);
			btnLevelX.setBorder(raisedbevel);
			
			this.setLocation(count * this.getWidth(), 200);
			this.add(btnLevelX);
			count++;
		}
		
		this.add(btnMainMenu);
	}
}
