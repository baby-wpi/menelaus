package menelaus.controllers;

import menelaus.model.Level;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelPlayScreen;
import menelaus.view.game.LevelSelectorScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by frankegan on 4/13/16.
 */
public class ButtonLevelSelectController implements ActionListener{
    /**
     * The level level that we will be continuing from.
     */
    Level level;

    /**
     * A controller fro opening teh proper level from teh level select screen.
     * @param selectScreen Th screen that let's you select each level.
     * @param level The level we're opeing up.
     */
    public ButtonLevelSelectController(Level level) {
        this.level = level;
    }

    public void actionPerformed(ActionEvent actionEvent) {
    	try {
    		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
			GameWindowFrame.getInstance().swapPanel(new LevelPlayScreen(level));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
