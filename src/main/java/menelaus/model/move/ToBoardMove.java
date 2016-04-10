package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

public class ToBoardMove extends Move {
	Point location;
	
	public ToBoardMove(Piece piece, Point location) {
		super(piece);
		this.location = location;
	}

	@Override
	public void perform(Level level) {
		throw new UnsupportedOperationException();
	}
}
