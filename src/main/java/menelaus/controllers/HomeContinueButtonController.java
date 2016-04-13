package menelaus.controllers;

import menelaus.model.Level;
import menelaus.view.HomeScreen;
import menelaus.view.LevelPlayScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by frankegan on 4/13/16.
 */
public class HomeContinueButtonController implements ActionListener{
    /**
     * The home screen JFrame that contains the continue button.
     */
    HomeScreen home;
    /**
     * The level model that we will be continuing from.
     */
    Level level;

    public HomeContinueButtonController(HomeScreen home, Level level) {
        this.home = home;
        this.level = level;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        LevelPlayScreen.main(null);
    }
}
