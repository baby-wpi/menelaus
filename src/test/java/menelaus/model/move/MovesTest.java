package menelaus.model.move;

import menelaus.model.Level;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import menelaus.view.PieceDrawer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by frankegan on 4/18/16.
 */
public class MovesTest {
    Piece piece;
    Level lightning;
    Level puzzle; 

    @Before
    public void setUp() {
        piece = new Piece(new Point(1, 1));
        lightning = new Level(LevelType.LIGHTNING, 8, 6);
        lightning.getBullpen().addPiece(piece);
        puzzle = new Level(LevelType.PUZZLE, 8, 6);
        puzzle.getBullpen().addPiece(piece);
    }

    @Test
    public void testAroundBoardMove() {
        Move abm = new AroundBoardMove(piece, new Point(3, 3));
        assertTrue(!abm.valid(lightning)); //cannot move around in lighting level
        assertTrue(abm.valid(puzzle));
        assertTrue(abm.doMove(puzzle));
    }

    @Test
    public void testFlipPieceMove() {
        Move flip = new FlipPieceMove(piece);
        assertTrue(flip.valid(lightning));
        assertTrue(flip.doMove(lightning));
    }

    @Test
    public void testRotatePieceMove() {
        Move rot = new RotatePieceMove(piece);
        assertTrue(rot.valid(lightning));
        assertTrue(rot.doMove(lightning));
    }

    @Test
    public void testToBoardCoverMove() {
        Move cov = new ToBoardCoverMove(piece, new Point(3, 3));
        assertTrue(cov.valid(lightning));
        assertTrue(cov.doMove(lightning));
    }

    @Test
    public void testToBoardMove() {
        Move tbm = new RotatePieceMove(piece);
        assertTrue(tbm.valid(lightning));
        assertTrue(tbm.doMove(lightning));
    }

    @Test
    public void testBullpenMove() {
        Move tbp = new RotatePieceMove(piece);
        assertTrue(tbp.valid(lightning));
        assertTrue(tbp.doMove(lightning));
    }
}
