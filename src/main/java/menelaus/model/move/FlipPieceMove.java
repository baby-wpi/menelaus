package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public class FlipPieceMove extends Move {
	public FlipPieceMove(Piece piece) {
		super(piece);
	}

	@Override
	public void perform(Level level) {
		piece.flip();
	}
}
