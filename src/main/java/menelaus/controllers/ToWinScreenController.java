package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.LevelStars;
import menelaus.model.events.GameEndReason;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.WinScreen;

/**
 * Brings player to win screen.
 * @author Obatola Seward-Evans
 */
public class ToWinScreenController implements ActionListener{

	LevelStars stars;
	GameEndReason reason;
	
	
	/**
	 * Constructor for ToWinScreenController.
	 * @param previousLevel
	 * @param gameManager
	 */
	public ToWinScreenController(LevelStars stars, GameEndReason reason){
		this.stars = stars;
		this.reason = reason;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame frame = GameWindowFrame.getInstance();
		frame.swapPanel(new WinScreen(stars, reason));
	}

}
