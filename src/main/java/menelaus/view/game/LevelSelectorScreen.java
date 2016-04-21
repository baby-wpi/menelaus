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
	public LevelSelectorScreen(LevelsPackage levelsPackage, SavedGames savedGames) {
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ButtonMainMenuController());
		
		// For each level
		for (Level l : levelsPackage.getLevels()) {
			LevelSelectComponent btnLevelX = new LevelSelectComponent(l, savedGames.getStarsForLevel(l));
			btnLevelX.setBackground(Color.white);
			btnLevelX.setBorder(raisedbevel);

			this.add(btnLevelX);
		}
		
		this.add(btnMainMenu);
	}
}
