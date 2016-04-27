package menelaus.model;


import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The bullpen holds a collection of pieces that can be played and placed on the board.
 * @author vouldjeff
 *
 */
public class Bullpen implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Piece> pieces;

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

    public Piece findPiece(int x, int y) {
        Point loc = new Point(x, y);
        return findPiece(loc);
    }

    public Piece findPiece(Point point) {
        for (Piece p : pieces) {
            if (point.equals(p.getPosition()))
                return p;
        }
        return null;
    }
}
