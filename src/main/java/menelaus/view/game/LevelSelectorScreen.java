package menelaus.view.game;

import menelaus.controllers.ButtonLevelSelectController;
import menelaus.controllers.ButtonMainMenuController;
import menelaus.model.Level;
import menelaus.model.LevelsPackage;
import menelaus.model.SavedGames;
import menelaus.view.KabasujiPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

public class LevelSelectorScreen extends KabasujiPanel {
	/**
	 * Create the panel.
	 */
	public LevelSelectorScreen(LevelsPackage levelsPackage) {
		int count = 1;
		int numLevels = levelsPackage.getLevels().size();
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		SavedGames savedGames = new SavedGames();
		
		GroupLayout layout = new GroupLayout(this);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		SequentialGroup group = null;
		SequentialGroup groupVertical = layout.createSequentialGroup();
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ButtonMainMenuController());
		
		Dimension size;
		
		// For each level
		for (Level l : levelsPackage.getLevels()) {

			LevelSelectComponent btnLevelX = new LevelSelectComponent(l, savedGames.getStarsForLevel(l));
			btnLevelX.setBackground(Color.white);
			btnLevelX.setBorder(raisedbevel);
			
			if (count == 1 || count == 5 || count == 9 || count == 13){
				// TODO: create new row
			}
			
			Insets insets = this.getInsets();
			this.add(btnLevelX);
			
			size = btnLevelX.getPreferredSize();
			btnLevelX.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
			
			if (count == 4 || count == 8 || count == 12 || count == 16 || count == numLevels){
				// TODO: create new row
			}
			
			count++;
		}
		
		this.add(btnMainMenu);
	}
}
