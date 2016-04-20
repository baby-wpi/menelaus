package menelaus.view;

import menelaus.model.board.Piece;

import java.awt.*;

/**
 * Created by @frankegan on 4/19/16.
 */
public class PieceDrawer {
    public static final int SELECTED = 2;
    public static final int NORMAL = 1;
    int mode = NORMAL;

    /**
     * Draws the piece.
     * <p/>
     * Fill in background and draw outline on top. Finally, draw the color.
     * Strategy design pattern being applied here.
     *
     * @param graphics The graphics object we're grading to.
     * @param piece    The piece we want drawn
     */
    public static void drawPiece(Graphics graphics, Piece piece) {
        // TODO: 4/19/16 start drawing pieces
    }

    /**
     * Set the state of the drawer (selected, target, normal).
     */
    public void setState(int mode) {
        if (mode == SELECTED) {
            this.mode = SELECTED;
        }
    }
}
