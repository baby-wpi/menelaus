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
 *
 */
public class Bullpen implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Piece> pieces;
    
   private Random random; //for random generation

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
    /**
     * Randomly fills the Bullpen with pieces.
     */
    public void randomFill(){
    	int max = 6; //can change depending on how many pieces are meant to be put in the board
    	Random random  = new Random();
    	random.setSeed(123456789);
    	for(int i = 0; i < max; i++){
    		int index = random.nextInt() % 35;
    		this.addPiece(PieceBank.getPiece(index + 1));
    		
    	}
    }
    public void addRandomPiece(){
    	Random random = new Random();
    	random.setSeed(987654321);
    	int index = random.nextInt() % 35;
    	this.addPiece(PieceBank.getPiece(index));
    }
}
