package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.InvalidPiecePlacementException;
import menelaus.model.board.Piece;

// TODO: 4/17/16 What does this class do?

/**
 * A class used to move a piece form one part of the board to another.
 */
public class AroundBoardMove extends Move {
	Point newLocation;
	
	public AroundBoardMove(Piece piece, Point newLocation) {
		super(piece);
		this.newLocation = newLocation;
	}

	@Override
	public boolean doMove(Level level) {
		Point oldPosition = piece.getPosition();
		level.getBoard().removePiece(piece);
		
		piece.setPosition(newLocation);
		try {
            // TODO: 4/17/16 We should not be throwing an exception every other time we try to place a piece
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

	@Override
	public boolean valid(Level level) {
        try {
            return level.getBoard().placePiece(piece);
        } catch (InvalidPiecePlacementException e) {
            e.printStackTrace();
            return false;
        }
    }
}
