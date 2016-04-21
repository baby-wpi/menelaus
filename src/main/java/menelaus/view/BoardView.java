package menelaus.view;

import menelaus.model.board.Board;
import menelaus.model.board.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * Here is where the pieces are to be played (in 700x700 size).
 *
 * @author Obatola Seward-Evans
 */
public class BoardView extends JPanel {
	

    /**
     * Core board.
     */
    Board board;

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
    public BoardView(Board board) {
        this.board = board;
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
    protected void paintComponent(Graphics g) {    	
    	
        super.paintComponent(g);
        
        drawGrid(g);
    	
        // Draw Pieces:
        for (Piece p : board.getPieces()) {
            PieceDrawer.drawPiece(g, p, calculateGridUnitSize());
        }
    }

    /**
     * Calculates.
     * @return The size of a grid unit in pixels
     */
    public int calculateGridUnitSize(){
        if(board.getHeight() > board.getWidth())
            return this.getHeight() / board.getHeight();
        else
            return this.getWidth() / board.getWidth();
    }
    
    /**
     * Draws a grid on the board.
     * @param g Graphics
     * @author Obatola Seward-Evans
     */
    public void drawGrid(Graphics g) {
    	/* Information for Grid */
    	int drawingSize = 700;
    	int subdivisions = 0;
    	
    	// if get board height is the largest:
    	if (board.getHeight() > board.getWidth()){
    		// set the amount of subdivisions to be board height:
    		subdivisions = board.getHeight();
    	} else {
    		// if not, set amount of subdivisions to be board width:
    		subdivisions = board.getWidth();
    	}
    	
    	int subdivisionSize = drawingSize / subdivisions;
    	
        // Draw Grid:
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.GRAY);
        for (int i = 1; i < subdivisions; i++) {
           int x = i * subdivisionSize;
           g2.drawLine(x, 0, x, getSize().height);
        }
        for (int i = 1; i < subdivisions; i++) {
           int y = i * subdivisionSize;
           g2.drawLine(0, y, getSize().width, y);
        }
    }

}
