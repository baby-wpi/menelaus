package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.InvalidPiecePlacementException;
import menelaus.model.board.Piece;

public class AroundBoardMove extends Move {
	Point newLocation;
	
	public AroundBoardMove(Piece piece, Point newLocation) {
		super(piece);
		this.newLocation = newLocation;
	}

	@Override
	public boolean perform(Level level) {
		Point oldPosition = piece.getPosition();
		level.getBoard().removePiece(piece);
		
		piece.setPosition(newLocation);
		try {
			level.getBoard().placePiece(piece);
			return true;
		} catch (InvalidPiecePlacementException e) {
			piece.setPosition(oldPosition);
			
			try {
				level.getBoard().placePiece(piece);
				return false;
			} catch (InvalidPiecePlacementException e1) {
				e1.printStackTrace();
				return false;
			}
		}
	}
}
