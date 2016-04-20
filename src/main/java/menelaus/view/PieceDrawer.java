package menelaus.view;

import menelaus.model.board.Piece;
import menelaus.model.board.Tile;

import java.awt.*;

/**
 * Created by @author frankegan on 4/19/16.
 */
public class PieceDrawer {
    public static final int SELECTED = 2;
    public static final int NORMAL = 1;
    int mode = NORMAL;
    static final int TILE_SIZE = 30;
    static final String TILE_COLOR = "#3399ff";

    /**
     * Draws the piece.
     * <p/>
     * Draw a bunch of rectangles and hope to it works.
     *
     * @param graphics The graphics object we're drawing to.
     * @param piece    The piece we want drawn
     */
    public static Graphics drawPiece(Graphics graphics, Piece piece) {
        graphics.setColor(Color.decode(TILE_COLOR));

        for (Tile t: piece.getTiles()) {
            graphics.fillRect(piece.getPosition().getX() + (TILE_SIZE * t.getRelativePosition().getX()),
                    piece.getPosition().getY() + (TILE_SIZE * t.getRelativePosition().getY()),
                    TILE_SIZE,
                    TILE_SIZE);
        }

        return graphics;
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
