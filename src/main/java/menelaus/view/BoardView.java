package menelaus.view;

import java.awt.*;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import menelaus.model.board.Board;
import menelaus.model.board.Piece;

/**
 * Here is where the pieces are to be played (in 700x700 size).
 * @author ObaSewardEvans 
 */
public class BoardView extends JPanel {
	
	/** Core board. */
	Board board;
	
	/** around edges. */
	int offset = 32;
	
	/** Base size of board. */
	public final int N = 700;
	
	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	/** Only here so we can safely open within WindowBuilder. */
	public BoardView() {
		
	}
	
	/** Given a set of KabaSuji pieces, draw them in this panel. */
	public BoardView(Board board) {
		this.board = board;
	}
	
	/** 
	 * Swing thing. We must be large enough to draw all KabaSuji pieces. 
	 */
	public Dimension getMinimumSize() {
		int width = 2*N + 2*offset;
		int height = 2*N + 2*offset;

		return new Dimension (width, height);
	}
	
	/**
	 * Draw background puzzle and all active pieces.
	 */
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawRect(20,20,10,10);
    	g.setColor(Color.RED);
    	g.fillRect(20, 20, 10, 10);
    }
 
}
