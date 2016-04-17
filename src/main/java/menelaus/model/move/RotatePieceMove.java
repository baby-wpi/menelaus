package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public class RotatePieceMove extends Move {
	public RotatePieceMove(Piece piece) {
		super(piece);
	}

	@Override
	public boolean doMove(Level level) {
		piece.rotate();
		return true;
	}

	@Override
	public boolean valid(Level level) {
		return false;
	}
}
