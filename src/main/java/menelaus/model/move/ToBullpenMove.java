package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public class ToBullpenMove extends Move {
	public ToBullpenMove(Piece piece) {
		super(piece);
	}

	@Override
	public boolean perform(Level level) {
		level.getBullpen().addPiece(piece);
		level.getBoard().removePiece(piece);
		return true;
	}
}
