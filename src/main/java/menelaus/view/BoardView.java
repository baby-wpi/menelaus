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
	
	public Dimension getPreferredSize() {
		return new Dimension(700, 700);
	};
	
    /**
     * Core board.
     */
    Board board;

    /**
     * Only here so we can safely open within WindowBuilder.
     */
    public BoardView() { }

    /**
     * Given a set of KabaSuji pieces, draw them in this panel.
     */
    public BoardView(Board board) {
        this.board = board;
    }

    /**
     * Draw background puzzle and all active pieces.
     */
    protected void paintComponent(Graphics g) {    	
    	
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
    	
        super.paintComponent(g);
    	
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
    
        // Draw Pieces:
        for (Piece p : board.getPieces()) {
            PieceDrawer.drawPiece(g, p, calculateGridUnitSize());
        }
    }

    /**
     * Calculates
     * @return The size of a grid unit in pixels
     */
    public int calculateGridUnitSize(){
        if(board.getHeight() > board.getWidth())
            return this.getHeight() / board.getHeight();
        else
            return this.getWidth() / board.getWidth();
    }

}
