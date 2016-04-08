package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public class ToBullpenMove extends Move {
	public ToBullpenMove(Piece piece) {
		super(piece);
	}

	@Override
	public void perform(Level level) {
		throw new UnsupportedOperationException();
	}
}
