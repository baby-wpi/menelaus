package menelaus.model;

import menelaus.model.board.Piece;
import menelaus.util.PieceBank;

import java.util.ArrayList;

/**
 * @author vouldjeff
 */
public class AllPieceBullpen extends Bullpen {
    private final int NUM_PIECES = 35;

    @Override
    public ArrayList<Piece> getPieces() {
        ArrayList<Piece> pieces = new ArrayList<>(NUM_PIECES);
        for (int i = 1; i <= NUM_PIECES; i++){
            pieces.add(PieceBank.getPiece(i));
        }

        return pieces;
    }
}
