package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.Coordinate;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.InvalidPiecePlacementException;
import menelaus.model.board.Piece;

/**
 * Performs a move of a Piece already placed on the Board to a new location.
 * 
 * @author vouldjeff
 */
public class AroundBoardMove extends Move {
	Point newLocation;
	
	/**
	 * Initialize the move. You should always pass those to a GameManager. 
	 * @param piece The piece to be moved
	 * @param newLocation Its new location
	 */
	public AroundBoardMove(Piece piece, Point newLocation) {
		super(piece);
		this.newLocation = newLocation;
		this.alterMoveCount = true;
	}

	/**
	 * Perform the Move. Always let the GameManager call this method.
	 */
	@Override
	public boolean doMove(Level level) {
		if (!valid(level)) {
			return false;
		}
		
		Point oldPosition = piece.getPosition();
		level.getBoard().removePiece(piece);
		
		piece.setPosition(newLocation, new Coordinate(0.5f, 0.5f));
		try {
            level.getBoard().placePiece(piece);
			return true;
        } catch (InvalidPiecePlacementException e) {
			piece.setPosition(oldPosition, new Coordinate(0.5f, 0.5f));
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
        return piece != null && level.getType() == LevelType.PUZZLE && level.getBoard().isPlacementValid(piece);
    }
}
