package menelaus.model;


import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import menelaus.util.PieceBank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * The bullpen holds a collection of pieces that can be played and placed on the board.
 * @author vouldjeff
 */
public class Bullpen implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * A private collection with all pieces in Bullpen.
     */
    private ArrayList<Piece> pieces;

    /**
     * Returns all pieces.
     * @return Pieces stored in the bullpen
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Creates an empty bullpen.
     */
    public Bullpen() {
        super();
        this.pieces = new ArrayList<>();
    }

    /**
     * Adds a new piece to the bullpen.
     * @param piece The new piece.
     */
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    /**
     * Removed a piece from the bullpen.
     * @param piece The object to be removed.
     */
    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }

    /**
     * Finds a piece on board given x and y.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return The Piece found or a null if nothing.
     */
    public Piece findPiece(int x, int y) {
        Point loc = new Point(x, y);
        return findPiece(loc);
    }

    /**
     * Finds a piece on board given a Point.
     * @param point The point of interest.
     * @return The Piece found or a null if nothing.
     */
    public Piece findPiece(Point point) {
        for (Piece p : pieces) {
            if (point.equals(p.getPosition()))
                return p;
        }
        return null;
    }

    /**
     * Randomly fills the Bullpen with pieces.
     */
    public void randomFill() {
        int max = 6; //can change depending on how many pieces are meant to be put in the board
        Random random = new Random();
        for (int i = 0; i < max; i++) {
            int index = random.nextInt() % 35;
            this.addPiece(PieceBank.getPiece(index + 1));
        }
    }

    /**
     * Adds a random piece to the bullpen.
     */
    public void addRandomPiece() {
        Random random = new Random();
        int index = (Math.abs(random.nextInt()) % 35) + 1;
        this.addPiece(PieceBank.getPiece(index));
    }
}
