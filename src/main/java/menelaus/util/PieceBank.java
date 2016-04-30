package menelaus.util;

import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import menelaus.model.board.Tile;

/**
 * Created by @author frankegan on 4/30/16.
 */
public class PieceBank {
    Piece p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
            p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24,
            p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35;

    public static final Piece[] pieces = {

    };

    public PieceBank() {
        p1 = new Piece(new Point(0, 0));
        p1.addTile(new Tile(0, 0));
        p1.addTile(new Tile(0, 1));
        p1.addTile(new Tile(0, 2));
        p1.addTile(new Tile(0, 3));
        p1.addTile(new Tile(0, 4));
        p1.addTile(new Tile(0, 5));

        p2 = new Piece(new Point(0, 0));
        p2.addTile(new Tile(0, 0));
        p2.addTile(new Tile(0, 1));
        p2.addTile(new Tile(0, 2));
        p2.addTile(new Tile(0, 3));
        p2.addTile(new Tile(0, 4));
        p2.addTile(new Tile(1, 0));

        p3 = new Piece(new Point(0, 0));
        p3.addTile(new Tile(0, 0));
        p3.addTile(new Tile(0, 1));
        p3.addTile(new Tile(0, 2));
        p3.addTile(new Tile(0, 3));
        p3.addTile(new Tile(0, 4));
        p3.addTile(new Tile(1, 1));

        p4 = new Piece(new Point(0, 0));
        p4.addTile(new Tile(0, 0));
        p4.addTile(new Tile(0, 1));
        p4.addTile(new Tile(0, 2));
        p4.addTile(new Tile(0, 3));
        p4.addTile(new Tile(0, 4));
        p4.addTile(new Tile(1, 2));

        p5 = new Piece(new Point(0, 0));
        p5.addTile(new Tile(0, 1));
        p5.addTile(new Tile(0, 2));
        p5.addTile(new Tile(0, 3));
        p5.addTile(new Tile(0, 4));
        p5.addTile(new Tile(1, 0));
        p5.addTile(new Tile(1, 1));

        p6 = new Piece(new Point(0, 0));
        p6.addTile(new Tile(0, 0));
        p6.addTile(new Tile(0, 1));
        p6.addTile(new Tile(0, 2));
        p6.addTile(new Tile(0, 3));
        p6.addTile(new Tile(1, 0));
        p6.addTile(new Tile(1, 1));

        p7 = new Piece(new Point(0, 0));
        p7.addTile(new Tile(0, 0));
        p7.addTile(new Tile(0, 1));
        p7.addTile(new Tile(0, 2));
        p7.addTile(new Tile(0, 3));
        p7.addTile(new Tile(1, 0));
        p7.addTile(new Tile(1, 2));

        p8 = new Piece(new Point(0, 0));
        p8.addTile(new Tile(0, 0));
        p8.addTile(new Tile(0, 1));
        p8.addTile(new Tile(0, 2));
        p8.addTile(new Tile(0, 3));
        p8.addTile(new Tile(1, 0));
        p8.addTile(new Tile(1, 3));

        p9 = new Piece(new Point(0, 0));
        p9.addTile(new Tile(0, 0));
        p9.addTile(new Tile(0, 1));
        p9.addTile(new Tile(0, 2));
        p9.addTile(new Tile(0, 3));
        p9.addTile(new Tile(1, 1));
        p9.addTile(new Tile(1, 2));

        p10 = new Piece(new Point(0, 0));
        p10.addTile(new Tile(0, 0));
        p10.addTile(new Tile(0, 1));
        p10.addTile(new Tile(0, 2));
        p10.addTile(new Tile(0, 3));
        p10.addTile(new Tile(1, 0));
        p10.addTile(new Tile(2, 0));

        p11 = new Piece(new Point(0, 0));
        p11.addTile(new Tile(0, 0));
        p11.addTile(new Tile(0, 1));
        p11.addTile(new Tile(0, 2));
        p11.addTile(new Tile(0, 3));
        p11.addTile(new Tile(1, 1));
        p11.addTile(new Tile(2, 1));

        p12 = new Piece(new Point(0, 0));
        p12.addTile(new Tile(0, 0));
        p12.addTile(new Tile(1, 0));
        p12.addTile(new Tile(1, 1));
        p12.addTile(new Tile(1, 2));
        p12.addTile(new Tile(1, 3));
        p12.addTile(new Tile(2, 0));

        p13 = new Piece(new Point(0, 0));
        p13.addTile(new Tile(0, 1));
        p13.addTile(new Tile(1, 0));
        p13.addTile(new Tile(1, 1));
        p13.addTile(new Tile(1, 2));
        p13.addTile(new Tile(1, 3));
        p13.addTile(new Tile(2, 0));

        p14 = new Piece(new Point(0, 0));
        p14.addTile(new Tile(0, 2));
        p14.addTile(new Tile(1, 0));
        p14.addTile(new Tile(1, 1));
        p14.addTile(new Tile(1, 2));
        p14.addTile(new Tile(1, 3));
        p14.addTile(new Tile(2, 0));

        p15 = new Piece(new Point(0, 0));
        p15.addTile(new Tile(0, 3));
        p15.addTile(new Tile(1, 0));
        p15.addTile(new Tile(1, 1));
        p15.addTile(new Tile(1, 2));
        p15.addTile(new Tile(1, 3));
        p15.addTile(new Tile(2, 0));

        p16 = new Piece(new Point(0, 0));
        p16.addTile(new Tile(0, 2));
        p16.addTile(new Tile(1, 0));
        p16.addTile(new Tile(1, 1));
        p16.addTile(new Tile(1, 2));
        p16.addTile(new Tile(1, 3));
        p16.addTile(new Tile(2, 1));

        p17 = new Piece(new Point(0, 0));
        p17.addTile(new Tile(0, 1));
        p17.addTile(new Tile(1, 0));
        p17.addTile(new Tile(1, 1));
        p17.addTile(new Tile(1, 2));
        p17.addTile(new Tile(1, 3));
        p17.addTile(new Tile(2, 1));

        p18 = new Piece(new Point(0, 0));
        p18.addTile(new Tile(0, 1));
        p18.addTile(new Tile(0, 2));
        p18.addTile(new Tile(0, 3));
        p18.addTile(new Tile(1, 0));
        p18.addTile(new Tile(1, 1));
        p18.addTile(new Tile(1, 3));
    }

}
