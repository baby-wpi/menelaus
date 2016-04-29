package menelaus.controllers;

import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import menelaus.model.move.AroundBoardMove;
import menelaus.model.move.ToBoardMove;
import menelaus.model.move.ToBullpenMove;
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
    GameManager gameManager;
    Level level;

    /**The piece that is being dragged around after it is placed on the board*/
    private Piece draggingPiece;
    /**The point we are dragging from*/
    private Point draggingAnchor;

    public PieceController(LevelPlayScreen app, GameManager gameManager) {
        this.boardView = app.getBoardView();
        this.bullpenView = app.getBullpenView();
        this.gameManager = gameManager;
        this.level = gameManager.getLevel();
    }

    /**
     * Determine which piece was selected in the PiecesView.
     */
    @Override
    public void mousePressed(MouseEvent me) {
        Piece pp = level.getActive();
        int gridX = me.getX() / boardView.calculateGridUnitSize();
        int gridY = me.getY() / boardView.calculateGridUnitSize();

        if (pp == null) {
            draggingAnchor = new Point(me.getX(), me.getY());

            // perhaps we are pressing inside one of the existing pieces?
            Piece found = boardView.findPiece(draggingAnchor.getX(), draggingAnchor.getY());
            if (found != null) {
                draggingPiece = found;
            }
            return;
        }

        level.setActive(null);    // no longer being dragged around
        level.setSelected(null);

        gameManager.performNewMove(new ToBoardMove(pp, new Point(gridX, gridY)));

        boardView.repaint();
        bullpenView.repaint();   // has also changed state since piece no longer selected.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Piece selected = level.getSelected();
        int gridX = me.getX() / boardView.calculateGridUnitSize();
        int gridY = me.getY() / boardView.calculateGridUnitSize();
        if (selected == null) {
            return;
        }

        Piece pp = level.getSelected();
        pp.setPosition(new Point(gridX, gridY));
        level.setActive(pp);
        boardView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        // if nothing being dragged, leave
        if (draggingPiece == null) {
            return;
        }
        int gridX = me.getX() / boardView.calculateGridUnitSize();
        int gridY = me.getY() / boardView.calculateGridUnitSize();

        gameManager.performNewMove(new AroundBoardMove(draggingPiece, new Point(gridX, gridY)));
        boardView.repaint();
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
            //piece is no longer on the board so move it back to bullpen
            gameManager.performNewMove(new ToBullpenMove(draggingPiece));
            draggingPiece = null;
            draggingAnchor = null;
        }

        // clear the view of partial drawings once mouse exits region
        level.setActive(null);

        bullpenView.repaint();

        boardView.repaint();
    }
}
