package menelaus.model.board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.OperationNotSupportedException;

import menelaus.model.basic.Point;

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int height;
	int width;
	Hashtable<Point, BoardTileInfo> tileInfo;
	ArrayList<HintPiece> hints;
	ArrayList<Piece> pieces;
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Hashtable<Point, BoardTileInfo> getTileInfo() {
		return tileInfo;
	}
	
	public void setTileInfo(Hashtable<Point, BoardTileInfo> tileInfo) {
		this.tileInfo = tileInfo;
	}
	
	public ArrayList<HintPiece> getHints() {
		return hints;
	}
	
	public void setHints(ArrayList<HintPiece> hints) {
		this.hints = hints;
	}
	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	public Board(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		this.pieces = new ArrayList<Piece>();
		this.hints = new ArrayList<HintPiece>();
		this.tileInfo = new Hashtable<Point, BoardTileInfo>();
	}
	
	public void chopTileOut(Point point) {
		throw new UnsupportedOperationException();
	}
	
	public void placePiece(Piece piece) {
		throw new UnsupportedOperationException();
	}
	
	public void removePiece(Piece piece) {
		throw new UnsupportedOperationException();
	}
}
