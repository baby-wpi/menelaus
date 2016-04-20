package menelaus.model;


import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author vouldjeff
 *
 */
public class Bullpen implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public Piece findPiece(int x, int y) {
        Point loc = new Point(x, y);
        for (Piece p : pieces) {
            if (loc.equals(p.getPosition()))
                return p;
        }
        return null;
    }

    public Piece findPiece(Point point) {
        for (Piece p : pieces) {
            if (point.equals(p.getPosition()))
                return p;
        }
        return null;
    }
}
