package menelaus.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menelaus.model.BuilderManager;
import menelaus.model.basic.Point;
import menelaus.view.BoardView;

public class BoardControllerBuilderMakeBoard implements MouseListener{

	BuilderManager manager;
	BoardView view;
	
	public BoardControllerBuilderMakeBoard(BuilderManager manager, BoardView view) {
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
		if(manager.getLevel().getBoard().isChoppedOut(pointOnBoard))
			manager.getLevel().getBoard().unchopTile(pointOnBoard);
		else
			manager.getLevel().getBoard().chopTileOut(pointOnBoard);
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
