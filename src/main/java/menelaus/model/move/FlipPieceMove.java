package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public class FlipPieceMove extends Move {
	public FlipPieceMove(Piece piece) {
		super(piece);
	}

	@Override
	public boolean doMove(Level level) {
		piece.flip();
		return true;
	}

	@Override
	public boolean valid(Level level) {
		return piece != null;
	}
}
