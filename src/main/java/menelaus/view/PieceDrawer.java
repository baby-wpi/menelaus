package menelaus.view;

import menelaus.model.board.Piece;
import menelaus.model.board.Tile;

import java.awt.*;
import java.util.ArrayList;

import org.omg.PortableServer.ServantActivator;

/**
 * Created by @author frankegan on 4/19/16.
 */
public class PieceDrawer {
    public static final int SELECTED = 2;
    public static final int NORMAL = 1;
    int mode = NORMAL;
    static final String TILE_COLOR = "#3399ff";
    static final String HINT_COLOR = "#ff8133";
    static final String SELECT_COLOR = "#408ecf";

    /**
     * Draws the piece.
     * <p/>
     * Draw a bunch of rectangles and hope to it works.
     *
     * @param graphics The graphics object we're drawing to.
     * @param piece    The piece we want drawn
     */
    public static void drawPiece(Graphics graphics, Piece piece, int tileSize) {

        for (Tile t : piece.getTiles()) {
            //draw each tile
            graphics.setColor(Color.decode(TILE_COLOR));
            graphics.fillRect(
                    piece.getPosition().getX() + (tileSize * t.getRelativePosition().getX()),
                    piece.getPosition().getY() + (tileSize * t.getRelativePosition().getY()),
                    tileSize,
                    tileSize);
            //draw border
            graphics.setColor(Color.GRAY);
            graphics.drawRect(piece.getPosition().getX() + (tileSize * t.getRelativePosition().getX()),
                    piece.getPosition().getY() + (tileSize * t.getRelativePosition().getY()),
                    tileSize,
                    tileSize);
        }
    }

    /**
     * Draws the piece.
     * <p/>
     * Draw a bunch of rectangles, here the piece can have a position in terms of teh actual grid units, instead of pixels.
     *
     * @param graphics The graphics object we're drawing to.
     * @param piece    The piece we want drawn
     */
    public static void drawPieceToGrid(Graphics graphics, Piece piece, int tileSize) {

        for (Tile t : piece.getTiles()) {
            //draw tiles
            graphics.setColor(Color.decode(TILE_COLOR));
            graphics.fillRect(
                    (piece.getPosition().getX() * tileSize) + (tileSize * t.getRelativePosition().getX()),
                    (piece.getPosition().getY() * tileSize) + (tileSize * t.getRelativePosition().getY()),
                    tileSize,
                    tileSize);
        }
    }

    /**
     * Draws the hint.
     * <p/>
     * Draw a bunch of rectangles, here the piece can have a position in terms of teh actual grid units, instead of pixels.
     *
     * @param graphics The graphics object we're drawing to.
     * @param piece    The piece we want drawn
     */
    public static void drawHintToGrid(Graphics graphics, Piece piece, int tileSize) {

        for (Tile t : piece.getTiles()) {
            //draw tiles
            graphics.setColor(Color.decode(HINT_COLOR));
            graphics.fillRect(
                    (piece.getPosition().getX() * tileSize) + (tileSize * t.getRelativePosition().getX()),
                    (piece.getPosition().getY() * tileSize) + (tileSize * t.getRelativePosition().getY()),
                    tileSize,
                    tileSize);
        }
    }
    
    public static void drawSelection(Graphics graphics, ArrayList<menelaus.model.basic.Point> selectedPoints, int tileSize) {
    	for (menelaus.model.basic.Point p : selectedPoints) {
            //draw tiles
            graphics.setColor(Color.decode(SELECT_COLOR));
            graphics.fillRect(
                    (p.getX() * tileSize),
                    (p.getY() * tileSize),
                    tileSize,
                    tileSize);
        }
    }
}
