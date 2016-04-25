package menelaus.model.board;

import java.awt.*;

/**
 * Created by @author frankegan on 4/24/16.
 */
public class PlacedPiece {
    Piece piece;
    Rectangle rect;

    public PlacedPiece (Piece tp, Rectangle p) {
        this.piece = tp;
        this.rect = p;
    }

    public boolean contains (Point p) {
        return rect.contains(p);
    }

    public Rectangle getRect() {
        return rect;
    }

    public Piece getPiece() {
        return piece;
    }

    /** Used when rotating piece. */
    public void setRect(Rectangle poly) {
        rect = poly;
    }
}
