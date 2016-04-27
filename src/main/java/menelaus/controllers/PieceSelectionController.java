package menelaus.controllers;

import menelaus.model.Level;
import menelaus.model.board.Piece;
import menelaus.view.BullpenView;

import javax.swing.*;
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
        //get the piece that was clicked
        Piece selected = bullpenView.findPiece(me.getX(), me.getY());

        //select, rotate, or flip based on mouse event
        if(me.getClickCount() == 1 && SwingUtilities.isLeftMouseButton(me)){
            level.setSelected(selected);
        }
        else if (me.getClickCount() == 2){
            selected.rotate();
            bullpenView.repaint();
            level.setSelected(selected);
        }
        else if (SwingUtilities.isRightMouseButton(me) || me.getButton() == MouseEvent.BUTTON3){
            selected.flip();
            bullpenView.repaint();
            level.setSelected(selected);
        }
    }
}
