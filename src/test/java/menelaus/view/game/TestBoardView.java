package menelaus.view.game;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import menelaus.model.Level;
import menelaus.model.basic.Color;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.Board;
import menelaus.model.board.BoardTileInfo;
import menelaus.model.board.ColoredSetItem;
import menelaus.view.BoardView;

import org.junit.Before;
import org.junit.Test;

public class TestBoardView {
	BoardView bv;
	BufferedImage bi;
	Graphics g;
	BoardTileInfo boardTileInfo;
	Board board;
	Level level;
	

	@Before
	public void setUp() throws Exception {
		board = new Board(6, 8);
		Hashtable<Point, BoardTileInfo>tileInfo = new Hashtable<Point, BoardTileInfo>();
		BoardTileInfo btInfo = new BoardTileInfo(false);
		btInfo.setColoredSetItem(new ColoredSetItem(Color.BLUE, 1));
		tileInfo.put(new Point(0, 0), btInfo );
		board.setTileInfo(tileInfo);
		level = new Level(LevelType.PUZZLE, board.getWidth(), board.getHeight());
		bv = new BoardView(board, level);
		bi = ImageIO.read(this.getClass().getResource("/assets/secondary_back.png"));
		g = bi.createGraphics();
	
		
	}


	@Test
	public void testGetMinimumSize() {
		assertEquals(1464, bv.getMinimumSize().getWidth(), 1);
		assertEquals(1464, bv.getMinimumSize().getHeight(), 1);
	}
	@Test
	public void testPainting(){
		bv.paintComponent(g);
		bv.drawUnavailableTiles(g);
		bv.drawReleaseColorSets(g);
		bv.drawGrid(g);
		
		assertEquals(bv.calculateGridUnitSize(), 0);
		
	}

}
