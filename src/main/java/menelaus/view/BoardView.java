package menelaus.view;

import menelaus.model.Level;
import menelaus.model.basic.Coordinate;
import menelaus.model.basic.Point;
import menelaus.model.board.*;

import javax.swing.*;
import java.awt.*;

/**
 * Here is where the pieces are to be played (in 700x700 size).
 *
 * @author Obatola Seward-Evans
 */
public class BoardView extends JPanel {
    /**
     * height of a grid square
     */
    int gridSquareHeight = 0;
    /**
     * width of a grid square
     */
    int gridSquareWidth = 0;
    /**
     * size of the board
     */
    int drawingSize = 0;
    /**
     * width/height of grid by grid squares
     */
    int subdivisions = 0;

    /**
     * Core board.
     */
    Board board;
    Level level;

    /**
     * around edges.
     */
    int offset = 32;

    /**
     * Base size of board.
     */
    public final int N = 700;

    /**
     * Off-screen image for drawing (and Graphics object).
     */
    Image offScreenImage = null;
    Graphics offScreenGraphics = null;

    /**
     * Only here so we can safely open within WindowBuilder.
     */
    public BoardView() {

    }

    /**
     * Given a set of KabaSuji pieces, draw them in this panel.
     */
    public BoardView(Board board, Level level) {
        this.board = board;
        this.level = level;
    }

    /**
     * Swing thing. We must be large enough to draw all KabaSuji pieces.
     */
    public Dimension getMinimumSize() {
        int width = 2 * N + 2 * offset;
        int height = 2 * N + 2 * offset;

        return new Dimension(width, height);
    }

    /**
     * Draw background puzzle and all active pieces.
     */
    @Override
    protected void paintComponent(Graphics g) {
        initDemensions();

        super.paintComponent(g);
        drawHints(g);

        // Draw Pieces:
        for (Piece p : board.getPieces()) {
            PieceDrawer.drawPieceToGrid(g, p, calculateGridUnitSize());
        }

        // draw active piece.
        PlacedPiece active = level.getActive();
        if (active != null) {
            PieceDrawer.drawPieceToGrid(g, active.getPiece(), calculateGridUnitSize());
        }

        drawGrid(g);
        drawUnavailableTiles(g);

        drawReleaseColorSets(g);
    }
    
    /**
     * Draw hint piece on board.
     * @author Obatola Seward-Evans
     * @param g
     */
    private void drawHints(Graphics g) {
    	for (HintPiece hintPiece : board.getHints()) {
			PieceDrawer.drawHintToGrid(g, hintPiece, calculateGridUnitSize());
		}
    }

    private void initDemensions() {
        drawingSize = this.getWidth();

        // if get board height is the largest:
        if (board.getHeight() > board.getWidth()) {
            // set the amount of subdivisions to be board height:
            subdivisions = board.getHeight();
        } else {
            // if not, set amount of subdivisions to be board width:
            subdivisions = board.getWidth();
        }

        gridSquareHeight = drawingSize / subdivisions;

        gridSquareWidth = drawingSize / subdivisions;

    }

    /**
     * Calculates.
     *
     * @return The size of a grid unit in pixels
     */
    public int calculateGridUnitSize() {
        if (board.getHeight() > board.getWidth())
            return this.getHeight() / board.getHeight();
        else
            return this.getWidth() / board.getWidth();
    }

    /**
     * Draws all the color set numbers on the board.
     *
     * @param g
     */
    public void drawReleaseColorSets(Graphics g) {
        // TODO: get tile info


        // TODO: for each tile where there is a number
        // TODO: draw a colored j label on that spot
    }

    /**
     * Draws all unavailable tiles on the board.
     *
     * @param g
     * @author Obatola Seward-Evans
     */
    public void drawUnavailableTiles(Graphics g) {

        for (menelaus.model.basic.Point point : board.getTileInfo().keySet()) {
            if (board.getTileInfo().get(point).isTileChopped()) { // This tile should not be on the board.
                g.setColor(Color.LIGHT_GRAY);

                // TODO: make sure rectangle point is correct.
                g.fillRect(point.getX(), point.getY(), gridSquareHeight, gridSquareWidth);
            }
        }
    }

    /**
     * Draws a grid on the board.
     *
     * @param g Graphics
     * @author Obatola Seward-Evans
     */
    public void drawGrid(Graphics g) {
        int subdivisionSize = drawingSize / subdivisions;

        // Draw Grid:
        Graphics2D grid = (Graphics2D) g;
        grid.setPaint(Color.GRAY);
        for (int i = 1; i < subdivisions; i++) {
            int x = i * subdivisionSize;
            grid.drawLine(x, 0, x, getSize().height);
        }
        for (int i = 1; i < subdivisions; i++) {
            int y = i * subdivisionSize;
            grid.drawLine(0, y, getSize().width, y);
        }
    }

    public Piece findPiece(int x, int y) {
        // TODO: 4/22/16 do some mathemagic to solve this
        Piece p1 = new Piece(new Point(x, y), new Coordinate(0.5f, 0.5f));
        p1.addTile(new Tile(1, 0));
        p1.addTile(new Tile(0, 1));
        p1.addTile(new Tile(1, 1));

        return p1;
    }

    /**
     * Helper method to return polygon for KabaSuji piece anchored at (x,y).
     * <p/>
     * Appropriate that this method be in View since it is responsible for
     * mapping abstract pieces into pixel locations.
     */
    public Rectangle computeRect(int x, int y, Piece p) {
        int[] xpoints = new int[4];
        int[] ypoints = new int[4];

        // convert coordinate sequence into (x,y) points.
//        int idx = 0;
//        for (Coordinate c : p) {
//            xpoints[idx] = (int) (x + N * c.x);
//            ypoints[idx] = (int) (y + N * c.y);
//            idx++;
//        }


        return new Rectangle(x, y, x + calculateGridUnitSize(), y + calculateGridUnitSize());
    }

    /**
     * Draw background and then all pieces on top of it.
     */
    public void redraw() {
        // Once created, draw each, with buffer.
    }
}
