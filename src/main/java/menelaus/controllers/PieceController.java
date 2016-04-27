package menelaus.controllers;

import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.basic.Coordinate;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import menelaus.model.board.PlacedPiece;
import menelaus.model.move.ToBoardMove;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.game.LevelPlayScreen;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.util.Iterator;

/**
 * Created by @author frankegan on 4/21/16.
 */
public class PieceController extends MouseAdapter {
    BoardView boardView;
    BullpenView bullpenView;
    GameManager gameManager;
    Level level;

    PlacedPiece draggingPiece;
    Point draggingAnchor;

    // while mouse controller is in play, remember rotation (hey, just for fun).
    int rotation = 0;

    public PieceController(LevelPlayScreen app, GameManager gameManager) {
        this.boardView = app.getBoardView();
        this.bullpenView = app.getBullpenView();
        this.gameManager = gameManager;
        this.level = gameManager.getLevel();
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


        Rectangle r = computeActiveRect(new Point(me.getX(), me.getY()), level.getSelected());
        PlacedPiece pp = new PlacedPiece(level.getSelected(), r);
        pp.getPiece().setPosition(new Point(gridX, gridY));
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

//        gameManager.performNewMove(new AroundBoardMove(draggingPiece.getPiece(), new Point(gridX, gridY)));
        draggingPiece.getPiece().setPosition(new Point(gridX, gridY));
        boardView.redraw();
        boardView.repaint();
    }

    /**
     * Determine which piece was selected in the PiecesView.
     */
    @Override
    public void mousePressed(MouseEvent me) {
        PlacedPiece pp = level.getActive();
        int gridX = me.getX() / boardView.calculateGridUnitSize();
        int gridY = me.getY() / boardView.calculateGridUnitSize();

        if (pp == null) {
            draggingAnchor = new Point(me.getX(), me.getY());

            // perhaps we are pressing inside one of the existing pieces?
            Piece found = boardView.findPiece(draggingAnchor.getX(), draggingAnchor.getY());
            PlacedPiece exist = new PlacedPiece(found, computeActiveRect(new Point(me.getX(), me.getY()), found));
            if (exist != null) {
                draggingPiece = exist;
            }
            return;
        }

        level.setActive(null);    // no longer being dragged around
        level.setSelected(null);

        gameManager.performNewMove(new ToBoardMove(pp.getPiece(), new Point(gridX, gridY)));

        boardView.redraw();   // has changed state

        boardView.repaint();
        bullpenView.repaint();   // has also changed state since piece no longer selected.
    }

    public Rectangle computeActiveRect(Point pt, Piece selected) {
        if (selected == null) {
            return null;
        }
        java.awt.Point offset = getOffsetFromAnchor(selected);
        Rectangle rect = boardView.computeRect(pt.getX() - offset.x, pt.getY() - offset.y, selected);

        int centerx = (int) (pt.getX() + boardView.N * selected.getCenter().x - offset.x);
        int centery = (int) (pt.getY() + boardView.N * selected.getCenter().y - offset.y);

        return rect;//rotateRect(rect, selected, rotation, centerx, centery);
    }

    // could be in the model. Subtract from coordinates when translating.
    java.awt.Point getOffsetFromAnchor(Piece piece) {
        Iterator<Coordinate> it = piece.iterator();
        Coordinate anchor = it.next();

        return new java.awt.Point((int) (boardView.N * anchor.x), (int) (boardView.N * anchor.y));
    }

    /**
     * Given the piece associated with specific Polygon, rotate based on (centerx, centery) and
     * rotation angle.
     */
    Rectangle rotateRect(Rectangle rectangle, Piece piece, int angle, int centerx, int centery) {
        // The following came from a google search for rotating a polygon. Nifty.
        // note we use center of piece as rotation point, computed from the coordinate

        PathIterator pi = rectangle.getPathIterator(AffineTransform.getRotateInstance(Math.toRadians(angle * 3), centerx, centery));

        float coords[] = new float[6];
        int xpoints[] = new int[6];
        int ypoints[] = new int[6];

        int idx = 0;
        while (!pi.isDone()) {
            int type = pi.currentSegment(coords);
            if (type == PathIterator.SEG_MOVETO || type == PathIterator.SEG_LINETO) {
                xpoints[idx] = (int) coords[0];
                ypoints[idx] = (int) coords[1];
                idx++;
            }
            pi.next();
        }

        return new Rectangle(xpoints[0],
                ypoints[0],
                Math.abs(xpoints[0] - xpoints[1]),
                Math.abs(ypoints[0] - ypoints[3]));
    }

}
