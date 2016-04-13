package menelaus.controllers;

import menelaus.model.Level;
import menelaus.view.LevelPlayScreen;
import menelaus.view.LevelSelector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by frankegan on 4/13/16.
 */
public class LevelSelectButtonController implements ActionListener{
    /**
     * The home screen JFrame that contains the continue button.
     */
    LevelSelector selectScreen;
    /**
     * The level model that we will be continuing from.
     */
    Level level;

    /**
     * A controller fro opening teh proper level from teh level select screen.
     * @param selectScreen Th screen that let's you select each level.
     * @param level The level we're opeing up.
     */
    public LevelSelectButtonController(LevelSelector selectScreen, Level level) {
        this.selectScreen = selectScreen;
        this.level = level;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        LevelPlayScreen.main(null);
    }
}
