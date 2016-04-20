package menelaus.controllers;

import menelaus.model.Level;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelPlayScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by frankegan on 4/13/16.
 */
public class ButtonHomeContinueController implements ActionListener{

    /**
     * The level level that we will be continuing from.
     */
    Level level;

    public ButtonHomeContinueController(Level level) {
        this.level = level;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        GameWindowFrame.getInstance().swapPanel(new LevelPlayScreen());
    }
}
