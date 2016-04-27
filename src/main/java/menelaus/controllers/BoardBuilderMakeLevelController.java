package menelaus.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menelaus.model.BuilderManager;
import menelaus.model.basic.Point;
import menelaus.model.move.DeselectSquareBuilderMove;
import menelaus.model.move.SelectSquareMove;
import menelaus.view.BoardView;

public class BoardBuilderMakeLevelController implements MouseListener{
	BuilderManager manager;
	BoardView view;
	
	public BoardBuilderMakeLevelController(BuilderManager manager, BoardView view) {
		this.manager = manager;
		this.view = view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//manager.getLevel().getBoard().chopTileOut(new Point(0, 0));
		//System.out.println("Clicked! x: " + e.getX() + " y: " + e.getY());
		handleMouseClick(view.pointUnder(e.getX(), e.getY()));
	}

	public void handleMouseClick(Point pointOnBoard) {
		//System.out.println("Click.. x: " + pointOnBoard.getX() + " y: " + pointOnBoard.getY());
		if(manager.getSelectedPoints().contains(pointOnBoard)) {
			DeselectSquareBuilderMove mv = new DeselectSquareBuilderMove(this.manager, pointOnBoard.getX(), pointOnBoard.getY());
			if(manager.makeMove(mv)) {
				System.out.println("Move made successfully");
			}
			else {
				System.out.println("Move failed!");
			}
		}
			
		else {
			SelectSquareMove mv = new SelectSquareMove(this.manager, pointOnBoard.getX(), pointOnBoard.getY());
			if(manager.makeMove(mv)) {
				System.out.println("Move successful.");
			}
			else {
				System.out.println("Move failed!");
			}
			
		}
		refreshBoard();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	void refreshBoard() {
		view.repaint();
	}

}
