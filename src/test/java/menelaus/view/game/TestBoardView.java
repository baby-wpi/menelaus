package menelaus.view.game;

import static org.junit.Assert.*;
import menelaus.view.BoardView;

import org.junit.Before;
import org.junit.Test;

public class TestBoardView {
	BoardView bv;

	@Before
	public void setUp() throws Exception {
		bv = new BoardView();
	}


	@Test
	public void testGetMinimumSize() {
		assertEquals(1464, bv.getMinimumSize().getWidth(), 1);
		assertEquals(1464, bv.getMinimumSize().getHeight(), 1);
	}

}
