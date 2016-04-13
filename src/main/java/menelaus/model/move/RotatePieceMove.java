package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public class RotatePieceMove extends Move {
	public RotatePieceMove(Piece piece) {
		super(piece);
	}

	@Override
	public void perform(Level level) {
		piece.rotate();
	}
}