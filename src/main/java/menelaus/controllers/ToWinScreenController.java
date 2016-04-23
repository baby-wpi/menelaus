package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.Level;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.WinScreen;

/**
 * Brings player to win screen.
 * @author Obatola Seward-Evans
 *
 */
public class ToWinScreenController implements ActionListener{
	/** Level just completed */
	Level previousLevel;
	
	public ToWinScreenController(Level previousLevel){
		this.previousLevel = previousLevel;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame frame = GameWindowFrame.getInstance();
		frame.swapPanel(new WinScreen(previousLevel));
	}

}
