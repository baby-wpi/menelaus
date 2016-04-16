package menelaus.model.board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

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
		BoardTileInfo info = tileInfo.get(point);
		if (info == null) {
			info = new BoardTileInfo(true);
			tileInfo.put(point, info);
		} else {
			info.setTileChopped(true);
		}
	}
	
	public void placePiece(Piece piece) throws InvalidPiecePlacementException {
		if (!isPointWithinBoundary(piece.getPosition()) || !isBoardFreeForPiece(piece)) {
			throw new InvalidPiecePlacementException();
		}
		
		pieces.add(piece);
		
		Iterator<Tile> iterator = piece.getTiles().iterator();
		while(iterator.hasNext()) {
			Tile tile = iterator.next();
			Point point = piece.getPosition().add(tile.getRelativePosition());
			
			BoardTileInfo info = tileInfo.get(point);
			if (info == null) {
				info = new BoardTileInfo(false);
				tileInfo.put(point, info);
			}
			
			info.setPiecePlaced(piece);
		}
	}
	
	public void removePiece(Piece piece) {
		if (!pieces.remove(piece)) {
			return;
		}
		
		Iterator<Tile> iterator = piece.getTiles().iterator();
		while(iterator.hasNext()) {
			Tile tile = iterator.next();
			Point point = piece.getPosition().add(tile.getRelativePosition());
			
			BoardTileInfo info = tileInfo.get(point);
			info.setPiecePlaced(null);
		}
	}
	
	private boolean isBoardFreeForPiece(Piece piece) throws InvalidPiecePlacementException {
		Iterator<Tile> iterator = piece.getTiles().iterator();
		while(iterator.hasNext()) {
			Tile tile = iterator.next();
			Point point = piece.getPosition().add(tile.getRelativePosition());
			
			if (!isPointWithinBoundary(point)) {
				throw new InvalidPiecePlacementException();
			}
			
			BoardTileInfo info = tileInfo.get(point);
			if (info == null) {
				continue;
			}
			
			if (info.isTileChopped() || ((info.getPiecePlaced() != null) && (!info.getPiecePlaced().equals(piece)))) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isPointWithinBoundary(Point point) {
		return point.getX() < width && point.getY() < height;
	}
}
