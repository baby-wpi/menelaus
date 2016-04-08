package menelaus.model.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PieceTest {
	Piece piece;
	Piece piece2;

	@Before
	public void setUp() throws Exception {
		piece = new Piece(new Point(0, 0));
		piece.addTile(new Tile(1, 1));
		piece.addTile(new Tile(2, 1));
		piece.addTile(new Tile(1, 2));
		
		piece2 = new Piece(new Point(0, 0));
		piece2.addTile(new Tile(0, 1));
		piece2.addTile(new Tile(0, 2));
		piece2.addTile(new Tile(0, 3));
		piece2.addTile(new Tile(1, 2));
	}

	@Test
	public void testRotate() {
		fail("Not yet implemented");
		
		piece.rotate();
		piece2.rotate();
		
		assertEquals(piece.getTiles().get(0), new Tile(0, 0));
		assertEquals(piece.getTiles().get(1), new Tile(1, -1));
		assertEquals(piece.getTiles().get(0), new Tile(1, -2));
		assertEquals(piece.getTiles().get(0), new Tile(2, -1));
		
		assertEquals(piece2.getTiles().get(0), new Tile(0, 0));
		assertEquals(piece2.getTiles().get(0), new Tile(1, 0));
		assertEquals(piece2.getTiles().get(1), new Tile(2, 0));
		assertEquals(piece2.getTiles().get(2), new Tile(3, 0));
		assertEquals(piece2.getTiles().get(3), new Tile(2, -1));
	}

	@Test
	public void testFlip() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTile() {
		piece.addTile(new Tile(1, 0));
	
		assertEquals(piece.getTiles().get(0), new Tile(0, 0));
		assertEquals(piece.getTiles().get(1), new Tile(1, 0));
	}

}
