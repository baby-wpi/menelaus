package menelaus.view;

import menelaus.model.Bullpen;
import menelaus.model.basic.Coordinate;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import menelaus.model.board.Tile;

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
     * Given a set of KabaSuji pieces, draw them in this panel.
     */
    public BullpenView(Bullpen bullpen) {
        this.bullpen = bullpen;
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
        for (Piece p : bullpen.getPieces()) {
            // TODO: 4/20/16 Calculate placement scheme for bullpen
            PieceDrawer.drawPiece(g, p, 30);
        }
    }

    public Piece findPiece(int x, int y) {
        // TODO: 4/22/16 I'll need some mathemagic to solve this
        Piece p1 = new Piece(new Point(x, y), new Coordinate(0.5f, 0.5f));
        p1.addTile(new Tile(1, 0));
        p1.addTile(new Tile(0, 1));
        p1.addTile(new Tile(1, 1));
//        Piece p1 = bullpen.getPieces().get(0);

        return p1;
    }

    public void refresh() {

    }
}
