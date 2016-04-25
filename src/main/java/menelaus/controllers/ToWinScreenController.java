package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.WinScreen;

/**
 * Brings player to win screen.
 * @author Obatola Seward-Evans
 */
public class ToWinScreenController implements ActionListener{
	/** Level just completed */
	Level previousLevel;
	
	/** Game manager to get level stars. */
	GameManager gameManager;
	
	
	/**
	 * Constructor for ToWinScreenController.
	 * @param previousLevel
	 * @param gameManager
	 */
	public ToWinScreenController(Level previousLevel, GameManager gameManager){
		this.previousLevel = previousLevel;
		this.gameManager = gameManager;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame frame = GameWindowFrame.getInstance();
		frame.swapPanel(new WinScreen(previousLevel, gameManager));
	}

}
