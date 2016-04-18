package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

public class ToBoardCoverMove extends Move {
	Point location;
	
	public ToBoardCoverMove(Piece piece, Point location) {
		super(piece);
		this.location = location;
		this.alterMoveCount = true;
	}

	@Override
	public boolean doMove(Level level) {
		if(level.getType() != LevelType.LIGHTNING)
		    throw new UnsupportedOperationException();
        else return true;
	}

	@Override
	public boolean valid(Level level) {
		return true;
	}
}
