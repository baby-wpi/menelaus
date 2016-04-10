package menelaus.model;

import java.util.ArrayList;

import menelaus.model.board.Piece;

public class Bullpen {
	ArrayList<Piece> pieces;

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	public Bullpen() {
		super();
		this.pieces = new ArrayList<Piece>();
	}
	
	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		pieces.remove(piece);
	}
}
