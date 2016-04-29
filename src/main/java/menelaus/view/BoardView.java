package menelaus.view;

import menelaus.model.Level;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Here is where the pieces are to be played (in 700x700 size).
 *
 * @author Obatola Seward-Evans
 */
public class BoardView extends JPanel {

    /**
     * height of a grid square.
     */
    int gridSquareHeight = 0;

    /**
     * width of a grid square.
     */
    int gridSquareWidth = 0;

    /**
     * size of the board.
     */
    int drawingSize = 0;

    /**
     * width/height of grid by grid squares.
     */
    int subdivisions = 0;

    /**
     * Board tile info map for release level.
     */
    Hashtable<Point, BoardTileInfo> boardTileInfoMap;

    /**
     * Board tile info for each point.
     */
    BoardTileInfo boardTileInfo;

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
     * Whether or not board tiles can be selected.
     */
    boolean hasSelection; 

    /**
     * Only applicable in builder, which tiles are selected.
     */
    ArrayList<Point> selection = new ArrayList<Point>();
    
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
        this.hasSelection = false;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    
    public BoardView(Board board, Level level, boolean hasSelection) {
    	this.board = board;
        this.level = level;
        this.hasSelection = hasSelection;
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
        Piece active = level.getActive();
        if (active != null) {
            PieceDrawer.drawPieceToGrid(g, active, calculateGridUnitSize());
        }
        
        if(this.hasSelection) {
        	if(this.selection != null) {
        		PieceDrawer.drawSelection(g, selection, calculateGridUnitSize());
        	}
        }

        drawGrid(g);
        drawUnavailableTiles(g);
        if (level.getType() == LevelType.RELEASE) {
        	drawReleaseColorSets(g);
		}
    }

    /**
     * Draw hint piece on board.
     *
     * @param g
     * @author Obatola Seward-Evans
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
        // get tile info.
    	boardTileInfoMap = board.getTileInfo();

    	// iterate through hashmap of point, boardTileInfo
    	if (boardTileInfoMap.keySet() != null) {
        	for (Point point : boardTileInfoMap.keySet()) {
        		ColoredSetItem tileInfo = boardTileInfoMap.get(point).getColoredSetItem();
        		String number = tileInfo.getNumber() + "";

        		int x = point.getX() + gridSquareHeight/2;
        		int y = point.getY() + gridSquareWidth/2;

        		g.setColor(tileInfo.getJavaColor());
        		g.drawString(number, x, y);
    		}
		}
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
                g.fillRect(point.getX() * calculateGridUnitSize(), point.getY() * calculateGridUnitSize(), gridSquareHeight, gridSquareWidth);
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
        int gridX = x / calculateGridUnitSize();
        int gridY = y / calculateGridUnitSize();

        for (Piece p: board.getPieces()) {
            if (board.getTileInfo().get(new Point(gridX, gridY)).isPiecePlaced()) {
                return p;
            }
        }

        return null;
    }

    public Point pointUnder(int x, int y) {
    	int gridX = x / calculateGridUnitSize();
    	int gridY = y / calculateGridUnitSize();
    	return new Point(gridX, gridY);
    }

    public void setSelection(ArrayList<Point> newSel) {
        this.selection = newSel;
    }

}
