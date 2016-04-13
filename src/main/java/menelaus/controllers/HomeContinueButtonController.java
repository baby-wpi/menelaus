package menelaus.controllers;

import menelaus.model.Level;
import menelaus.view.GameWindowFrame;
import menelaus.view.LevelPlayScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by frankegan on 4/13/16.
 */
public class HomeContinueButtonController implements ActionListener{

    /**
     * The level model that we will be continuing from.
     */
    Level level;

    public HomeContinueButtonController(Level level) {
        this.level = level;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        GameWindowFrame.getInstance().swapPanel(new LevelPlayScreen());
    }
}
