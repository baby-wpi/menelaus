package menelaus.view;

import menelaus.model.Bullpen;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * Here is where the pieces will be stored to be placed on the board (in 250-height size).
 *
 * @author Obatola Seward-Evans
 */
public class BullpenView extends JPanel {

    /**
     * Core bullpen
     */
    Bullpen bullpen;

    /**
     * Base width of bullpen.
     */
    public final int N = 250;
    /**
     * The space around pieces
     */
    private final int MARGIN = 50;
    /**
     * The space form one piece to another in the X axis.
     */
    private final int XSTEP = 75;
    /**
     * The space form one piece to another in the Y axis.
     */
    private final int YSTEP = 125;
    /**
     * Unit size of piece
     */
    public static final int UNIT_SIZE = 30;

    /**
     * Given a set of KabaSuji pieces, draw them in this panel.
     */
    public BullpenView(Bullpen bullpen) {
        this.bullpen = bullpen;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.WHITE);
    }

    /**
     * Only here so we can safely open within WindowBuilder.
     */
    public BullpenView() {
    }

    /**
     * Draw background puzzle and all active pieces.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw pieces to board

        int x = MARGIN, y = MARGIN;
        int i = 0;
        for (Piece p : bullpen.getPieces()) {
            // TODO: 4/20/16 Calculate placement scheme for bullpen
            p.setPosition(new Point(x, y));
            if(i % 2 == 0) {
                x += XSTEP;
            }
            else{
                x -= XSTEP;
                y += YSTEP;
            }
            PieceDrawer.drawPiece(g, p, UNIT_SIZE);
            i++;
        }
    }

    public Piece findPiece(int clickX, int clickY) {
        //Each piece is in it's own invisible square this is the length of the square.
        int pieceSpotSize = (this.getWidth() / 2);
        int indexY = clickY / pieceSpotSize;
        int indexX = clickX / pieceSpotSize;
        //calculate which piece spot was clicked
        int pieceIndex = 2 * indexY + indexX;

        return bullpen.getPieces().get(pieceIndex);
    }
}
