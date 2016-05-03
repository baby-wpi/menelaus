package menelaus.controllers;

import menelaus.model.BuilderManager;
import menelaus.model.basic.Point;
import menelaus.model.board.Board;
import menelaus.model.move.DeselectSquareBuilderMove;
import menelaus.model.move.PlaceReleaseNumberBuilderMove;
import menelaus.model.move.SelectSquareMove;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.BoardView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Controller that handles making a level for the builder.
 * @author sanjay
 *
 */
public class BoardBuilderMakeLevelController implements MouseListener{
	BuilderManager manager;
	BoardView view;
	
	/**
	 * constructor.
	 * @param manager
	 * @param view
	 */
	public BoardBuilderMakeLevelController(BuilderManager manager, BoardView view) {
		this.manager = manager;
		this.view = view;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(manager.getIsReleaseMode()) {
			handleMouseClickReleaseMode(view.pointUnder(e.getX(), e.getY()));
		}
		else {
			handleMouseClickBoardMode(view.pointUnder(e.getX(), e.getY()));	
		}
	}

	private void handleMouseClickReleaseMode(Point pointOnBoard) {
		PlaceReleaseNumberBuilderMove mv = new PlaceReleaseNumberBuilderMove(this.manager, pointOnBoard.getX(), pointOnBoard.getY(), this.manager.getReleaseItem());
		if(manager.makeMove(mv)) {
			System.out.println("Move made successfully");
			SoundManager.getInstance().playSound(SoundType.PRESSPIECE); //CHANGE THE SOUND
		}
		else {
			System.out.println("Move failed!");
			SoundManager.getInstance().playSound(SoundType.PRESSTILE);
		}
		refreshBoard();
		
	}

	/**
	 * handle the mouse click on the board.
	 * @param pointOnBoard
	 */
	public void handleMouseClickBoardMode(Point pointOnBoard) {
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
