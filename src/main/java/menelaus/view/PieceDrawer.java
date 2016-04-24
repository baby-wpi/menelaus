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
    static final String TILE_COLOR = "#3399ff";

    /**
     * Draws the piece.
     * <p/>
     * Draw a bunch of rectangles and hope to it works.
     *
     * @param graphics The graphics object we're drawing to.
     * @param piece    The piece we want drawn
     */
    public static void drawPiece(Graphics graphics, Piece piece, int tileSize) {
        graphics.setColor(Color.decode(TILE_COLOR));

        for (Tile t : piece.getTiles()) {
            graphics.fillRect(
                    piece.getPosition().getX() + (tileSize * t.getRelativePosition().getX()),
                    piece.getPosition().getY() + (tileSize * t.getRelativePosition().getY()),
                    tileSize,
                    tileSize);
        }
    }

    /**
     * Draws the piece.
     * <p/>
     * Draw a bunch of rectangles and hope to it works.
     *
     * @param graphics The graphics object we're drawing to.
     * @param piece    The piece we want drawn
     */
    public static void drawPieceToGrid(Graphics graphics, Piece piece, int tileSize) {
        graphics.setColor(Color.decode(TILE_COLOR));

        for (Tile t : piece.getTiles()) {
            graphics.fillRect(
                    (piece.getPosition().getX() * tileSize) + (tileSize * t.getRelativePosition().getX()),
                    (piece.getPosition().getY() * tileSize) + (tileSize * t.getRelativePosition().getY()),
                    tileSize,
                    tileSize);
        }
    }
}
