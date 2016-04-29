package menelaus.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import menelaus.model.basic.*;
import menelaus.model.board.Board;

/**
 * 
 * @author mtmccarthy
 *
 */

public class TestLevel {
	
	Bullpen bp;
	LevelType puzzle;
	LevelType lightning;
	LevelType release;
	Level l1;
	Level l2;
	Board board;
	
	
	@Before
	public void setUp() {
		puzzle = LevelType.PUZZLE;
		lightning = LevelType.LIGHTNING;
		release = LevelType.RELEASE;
		
		bp = new Bullpen();
		l1 = new Level(puzzle, 100, 100);
		board = new Board(50, 50);
		
	}
	@Test
	public void testGettersAndSetters(){
		l1.setBullpen(bp);
		l1.setBoard(board);
		int tl = 100;
		l1.setTimeLimit(tl);
		int ml = 5;
		l1.setMoveLimit(ml);
		String name = "Level 1";
		l1.setName(name);
		
		
		assertEquals(l1.getBullpen(), bp);
		assertEquals(l1.getBoard(), board);
		assertEquals(l1.getTimeLimit(), tl);
		assertEquals(l1.getMoveLimit(), ml);
		assertEquals(l1.getType(), puzzle);
		assertEquals(l1.getName(), name);
		
	}
}
