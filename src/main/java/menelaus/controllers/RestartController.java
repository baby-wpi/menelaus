package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.Level;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelPlayScreen;


/** 
 * handles restarts.
 * @author Obatola Seward-Evans
 *
 */
public class RestartController implements ActionListener {
	/** the level you plan to restart to */
	Level previousLevel;
	
	
	public RestartController(Level previousLevel){
		this.previousLevel = previousLevel;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame frame = GameWindowFrame.getInstance();
		frame.swapPanel(new LevelPlayScreen(previousLevel));
	}

}
