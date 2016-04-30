package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import menelaus.model.Bullpen;
import menelaus.model.Level;
import menelaus.model.LevelsPackage;
import menelaus.model.board.Piece;
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
//    	Level restartLevel = new Level(previousLevel.getType(), previousLevel.getBoard().getHeight(), previousLevel.getBoard().getWidth());
//    	Bullpen bp = new Bullpen();
//    	bp.setPieces(previousLevel.getBullpen().getPieces());
//    	for(Piece p : previousLevel.getBoard().getPieces()){
//    		bp.addPiece(p);
//    	}
//    	restartLevel.setBullpen(bp);
		
		
		try {
			GameWindowFrame.getInstance().swapPanel(new LevelPlayScreen(previousLevel));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	}

}
