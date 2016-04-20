package menelaus.model;

import java.util.ArrayList;
import java.util.List;

import menelaus.model.basic.Point;
import menelaus.model.board.Board;
import menelaus.model.board.Piece;

public class Model {
	/** Set of KabaSuji pieces. */
	List<Piece> set;
	
	/** Which piece is selected. */
	Piece selected = null;
	
	/** Puzzle being solved. */
	Board board;
	
	/** Placed pieces, with their coordinates. */
	List<Piece> placedPieces = new ArrayList<Piece>();
	
	/** A piece is being actively floated around (but not already on the board). Not yet in placedPieces. */
	Piece activePiece;
	
	/** A piece was on the board and is being dragged around. This piece is in placedPieces. */
	Piece draggingPiece;
	
	public Model () {
		Piece piece1;
		
		// define 1 point used for all pieces.
		Point p0 = new Point(0,    0);
		
		// define several pieces
		piece1 = new Piece(p0);
		
		// add to specific set
		set = new ArrayList<Piece>();
		set.add(piece1);
		
		this.board = new Board(20, 20);
	}
	
	/** Return the pieces in the model. */
	public List<Piece> getPieces() {
		return set;
	}
	
	/** Set which piece is 'selected'. */
	public void setSelected(Piece p) {
		this.selected = p;
	}

	/** Determines the currently selected piece. */
	public Piece getSelected() {
		return selected;
	}

	/** The puzzle being solved. */
	public void setBoard(Board p) {
		this.board = p;
	}

	/** Get puzzle. */
	public Board getBoard() {
		return board;
	}
	
	/** Return placed pieces. */
	public List<Piece> getPlacedPieces() {
		return placedPieces;
	}
	
	/** Get piece which user is 'hovering' over the board. */
	public Piece getActive() {
		return activePiece;
	}
	
	/** Set the piece that will hover over the board. */
	public void setActive(Piece pp) {
		activePiece = pp;
	}

	/** Get piece that is already on the board, but is now under control of user. */
	public Piece getDraggingPiece() {
		return activePiece;
	}
	
	/** Set the piece that is already on the board, and is now under control of user. */
	public void setDraggingPiece(Piece pp) {
		activePiece = pp;
	}
	
	/** Place piece on the board. Perhaps Puzzle should know piece placement? Decide later. */
	public void addPiece(Piece pp) {
		placedPieces.add(pp);
	}
	
}
