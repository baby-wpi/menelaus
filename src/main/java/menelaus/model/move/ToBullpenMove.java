package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.board.Piece;

public class ToBullpenMove extends Move {

    public ToBullpenMove(Piece piece) {
        super(piece);
    }

    @Override
    public boolean doMove(Level level) {

        level.getBullpen().addPiece(piece);
        level.getBoard().removePiece(piece);
        return true;
    }

    @Override
    public boolean valid(Level level) {
        return false;
    }
}
