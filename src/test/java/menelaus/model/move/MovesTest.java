package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.Coordinate;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import org.junit.Before;

/**
 * Created by frankegan on 4/18/16.
 */
public class MovesTest {
    Piece piece;
    Level lightning;

    @Before
    public void setUp() {
        piece = new Piece(new Point(1, 1), new Coordinate(0.5f, 0.5f));
        lightning = new Level(LevelType.LIGHTNING, 8, 6);
    }

//    @Test
//    public void testAroundBoardMove() {
//        Move abm = new AroundBoardMove(piece, new Point(3, 3));
//        assertTrue(abm.valid(lightning));
//        assertTrue(abm.doMove(lightning));
//    }
//
//    @Test
//    public void testFlipPieceMove() {
//        Move flip = new FlipPieceMove(piece);
//        assertTrue(flip.valid(lightning));
//        assertTrue(flip.doMove(lightning));
//    }
//
//    @Test
//    public void testRotatePieceMove() {
//        Move rot = new RotatePieceMove(piece);
//        assertTrue(rot.valid(lightning));
//        assertTrue(rot.doMove(lightning));
//    }
//
//    @Test
//    public void testToBoardCoverMove() {
//        Move cov = new ToBoardCoverMove(piece, new Point(3, 3));
//        assertTrue(cov.valid(lightning));
//        assertTrue(cov.doMove(lightning));
//    }
//
//    @Test
//    public void testToBoardMove() {
//        Move tbm = new RotatePieceMove(piece);
//        assertTrue(tbm.valid(lightning));
//        assertTrue(tbm.doMove(lightning));
//    }
//
//    @Test
//    public void testBullpenMove() {
//        Move tbp = new RotatePieceMove(piece);
//        assertTrue(tbp.valid(lightning));
//        assertTrue(tbp.doMove(lightning));
//    }
}
