package menelaus.controllers;

import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.InvalidPiecePlacementException;
import menelaus.model.board.Piece;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.game.LevelPlayScreen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by @author frankegan on 4/21/16.
 */
public class PieceController extends MouseAdapter {
    BoardView boardView;
    BullpenView bullpenView;
    Level level;

    Piece draggingPiece;
    Point draggingAnchor;

    // while mouse controller is in play, remember rotation (hey, just for fun).
    int rotation = 0;

    public PieceController(LevelPlayScreen app, Level l) {
        this.boardView = app.getBoardView();
        this.bullpenView = app.getBullpenView();
        this.level = l;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // clear rotation state back to normal
        rotation = 0;
    }

    /**
     * Once released, no more dragging.
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        draggingPiece = null;
        draggingAnchor = null;
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (draggingPiece != null) {

            // piece is no longer on the board, so remove it!
            level.getBoard().getPieces().remove(draggingPiece);
            draggingPiece = null;
            draggingAnchor = null;
        }

        // clear the view of partial drawings once mouse exits region
        level.setActive(null);

        bullpenView.refresh();   // Only necessary if one draws available pieces differently.
        bullpenView.repaint();

        boardView.redraw();     // fix board as well
        boardView.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Piece selected = level.getSelected();
        int gridX = me.getX() / boardView.calculateGridUnitSize();
        int gridY = me.getY() / boardView.calculateGridUnitSize();
        if (selected == null) { return; }


        level.getActive().setPosition(new Point(me.getX(), me.getY()));
        boardView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        // if nothing being dragged, leave
        if (draggingPiece == null) {
            return;
        }

        int diffX = me.getPoint().x - draggingAnchor.getX();
        int diffY = me.getPoint().y - draggingAnchor.getY();
        draggingAnchor = new Point(me.getX(), me.getY());

        //this is supposed to be translate(x:int, y:int)
        Point old = draggingPiece.getPosition();
        draggingPiece.setPosition(new Point(old.getX() + diffX, old.getY() + diffY));
        boardView.redraw();
        boardView.repaint();
    }

    /**
     * Determine which piece was selected in the PiecesView.
     */
    public void mousePressed(MouseEvent me) {
        Piece pp = level.getActive();
        if (pp == null) {
            draggingAnchor = new Point(me.getX(), me.getY());

            // perhaps we are pressing inside one of the existing pieces? Take LAST piece that
            // intersects, since that will ensure we grab topmost one.
            Piece exist = boardView.findPiece(draggingAnchor.getX(), draggingAnchor.getY());
            if (exist != null) {
                draggingPiece = exist;
            }
            return;
        }

        level.setActive(null);    // no longer being dragged around
        level.setSelected(null);

        try {
            level.getBoard().placePiece(pp);
        } catch (InvalidPiecePlacementException e) {
            e.printStackTrace();
        }

        boardView.redraw();   // has changed state
        bullpenView.refresh();  // has changed state

        boardView.repaint();
        bullpenView.repaint();   // has also changed state since piece no longer selected.
    }
}
