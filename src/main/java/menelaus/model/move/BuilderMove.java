package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public abstract class BuilderMove extends Move {

	public BuilderMove(Piece piece) {
		super(piece);
		
	}
	
	public abstract boolean undo(Level level);

}
