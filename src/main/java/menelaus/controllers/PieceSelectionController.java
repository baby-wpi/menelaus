package menelaus.controllers;

import menelaus.model.Level;
import menelaus.model.board.Piece;
import menelaus.view.BullpenView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by @author frankegan on 4/21/16.
 */
public class PieceSelectionController extends MouseAdapter {

    BullpenView bullpenView;
    Level level;

    public PieceSelectionController(BullpenView bullpenView, Level level) {
        this.bullpenView = bullpenView;
        this.level = level;
    }

    /**
     * Determine which piece was selected in the PiecesView.
     */
    public void mousePressed(MouseEvent me) {
        // there is 1-to-1 relationship based on index, between polygons and pieces
        Piece selected = bullpenView.findPiece(me.getX(), me.getY());
        level.setSelected(selected);
        level.getBullpen().removePiece(selected);
    }
}
