package menelaus.controllers;

import menelaus.model.Level;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelPlayScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author fegan
 * @author vouldjeff
 */
public class ButtonContinueController implements ActionListener{

    public ButtonContinueController() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
		GameWindowFrame frame = GameWindowFrame.getInstance();
		Level nextLevel;
		nextLevel = frame.getSavedGamesUtil().getNextPlayableLevelInPackage(frame.getLevelsPackage());
		
    	
    	if (nextLevel == null) {
    		JOptionPane.showMessageDialog(null, "You've played all levels!");
    		return;
    	}
    	
        try {
			GameWindowFrame.getInstance().swapPanel(new LevelPlayScreen(nextLevel));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
