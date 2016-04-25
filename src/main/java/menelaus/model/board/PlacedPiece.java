package menelaus.model.board;

import java.awt.*;

/**
 * Created by @author frankegan on 4/24/16.
 */
public class PlacedPiece {
    Piece piece;
    Rectangle rect;

    public PlacedPiece (Piece tp, Rectangle rect) {
        this.piece = tp;
        this.rect = rect;
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
    public void setRect(Rectangle r) {
        rect = r;
    }
}
