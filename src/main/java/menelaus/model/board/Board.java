package menelaus.model.board;

import menelaus.model.basic.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

/**
 * 
 * @author vouldjeff
 * @author sanjay
 */
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

    public void addHintPiece(HintPiece hint) {
    	hints.add(hint);
    }
    
    public void addColoredSetItem(ColoredSetItem item, Point point) {
        BoardTileInfo info = tileInfo.get(point);
        if (info == null) {
            info = new BoardTileInfo(false);
            tileInfo.put(point, info);
        }

        info.setColoredSetItem(item);
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
        if (!isPlacementValid(piece)) {
            throw new InvalidPiecePlacementException();
        }

        pieces.add(piece);

        Iterator<Tile> iterator = piece.getTiles().iterator();
        while (iterator.hasNext()) {
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
    
    public boolean isPlacementValid(Piece piece) {
    	try {
			return isPointWithinBoundary(piece.getPosition()) && isBoardFreeForPiece(piece);
		} catch (InvalidPiecePlacementException e) {
			return false;
		}
    }

    public void removePiece(Piece piece) {
        if (!pieces.remove(piece)) {
            return;
        }

        Iterator<Tile> iterator = piece.getTiles().iterator();
        while (iterator.hasNext()) {
            Tile tile = iterator.next();
            Point point = piece.getPosition().add(tile.getRelativePosition());

            BoardTileInfo info = tileInfo.get(point);
            info.setPiecePlaced(null);
        }
    }

    private boolean isBoardFreeForPiece(Piece piece) throws InvalidPiecePlacementException {
        Iterator<Tile> iterator = piece.getTiles().iterator();
        while (iterator.hasNext()) {
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

    public boolean isPointWithinBoundary(Point point) {
        return point.getX() < width && point.getY() < height;
    }
    
    public boolean isFull() {
    	for (int i = 0; i < width; i++) {
    		for (int j = 0; j < height; j++) {
    			if (tileInfo.get(new Point(i, j)) == null) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    /**
     * Places a given piece at an X,Y location. Undoes the move if invalid.
     * @param p The piece to place.
     * @param x The x coordinate to place at.
     * @param y The y coordinate to place at.
     * @return Whether the placing was successful.
     */
    public boolean placePieceAtRowAndColumn(Piece p, int x, int y) {
    	Point newLocation = new Point(x, y);
    	Point oldLocation = new Point(p.getPosition().getX(), p.getPosition().getX());
    	
    	p.setPosition(newLocation);
    	if (isPlacementValid(p)) {
    		try {
				placePiece(p);
				return true;
			} catch (InvalidPiecePlacementException e) {
				p.setPosition(oldLocation);
				e.printStackTrace();
				return false;
			}
    	}
    	else {
    		//go back
    		p.setPosition(oldLocation);
    		return false;
    	}
    	
    	//newLocation;
    	
    }
}
