package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public abstract class Move {
	Piece piece;
	boolean alterMoveCount;
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public boolean shouldAlterMoveCount() {
		return alterMoveCount;
	}
	
	public void setAlterMoveCount(boolean alterMoves) {
		this.alterMoveCount = alterMoves;
	}
	
	public abstract boolean perform(Level level);
	public Move(Piece piece) {
		this.piece = piece;
		this.alterMoveCount = false;
	}
}
