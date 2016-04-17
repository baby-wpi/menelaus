package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.InvalidPiecePlacementException;
import menelaus.model.board.Piece;

public class ToBoardMove extends Move {
	Point location;
	
	public ToBoardMove(Piece piece, Point location) {
		super(piece);
		this.location = location;
		this.alterMoveCount = true;
	}

	@Override
	public boolean doMove(Level level) {
		try {
			level.getBoard().placePiece(piece);
			level.getBullpen().removePiece(piece);
			return true;
		} catch (InvalidPiecePlacementException e) {
			return false;
		}
	}

	@Override
	public boolean valid(Level level) {
		return false;
	}
}
