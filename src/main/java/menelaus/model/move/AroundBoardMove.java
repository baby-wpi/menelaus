package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

public class AroundBoardMove extends Move {
	Point newLocation;
	
	public AroundBoardMove(Piece piece, Point newLocation) {
		super(piece);
		this.newLocation = newLocation;
	}

	@Override
	public void perform(Level level) {
		throw new UnsupportedOperationException();
	}
}
