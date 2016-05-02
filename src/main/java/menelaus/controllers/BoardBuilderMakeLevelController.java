package menelaus.controllers;

import menelaus.model.BuilderManager;
import menelaus.model.basic.Point;
import menelaus.model.move.DeselectSquareBuilderMove;
import menelaus.model.move.SelectSquareMove;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.BoardView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 
 * @author sanjay
 *
 */
public class BoardBuilderMakeLevelController implements MouseListener{
	BuilderManager manager;
	BoardView view;
	
	public BoardBuilderMakeLevelController(BuilderManager manager, BoardView view) {
		this.manager = manager;
		this.view = view;
	}
	
	public void mouseClicked(MouseEvent e) {
		handleMouseClick(view.pointUnder(e.getX(), e.getY()));
	}

	public void handleMouseClick(Point pointOnBoard) {
		if(manager.getSelectedPoints().contains(pointOnBoard)) {
			DeselectSquareBuilderMove mv = new DeselectSquareBuilderMove(this.manager, pointOnBoard.getX(), pointOnBoard.getY());
			if(manager.makeMove(mv)) {
				System.out.println("Move made successfully");
				SoundManager.getInstance().playSound(SoundType.PRESSPIECE);
			}
			else {
				System.out.println("Move failed!");
				SoundManager.getInstance().playSound(SoundType.PRESSTILE);
			}
		}
			
		else {
			SelectSquareMove mv = new SelectSquareMove(this.manager, pointOnBoard.getX(), pointOnBoard.getY());
			if(manager.makeMove(mv)) {
				System.out.println("Move successful.");
				SoundManager.getInstance().playSound(SoundType.PRESSPIECE);
			}
			else {
				System.out.println("Move failed!");
				SoundManager.getInstance().playSound(SoundType.PRESSTILE);
			}
			
		}
		refreshBoard();
	}
	
	
	public void mousePressed(MouseEvent e) {
		
	}

	
	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	void refreshBoard() {
		view.repaint();
	}

}
