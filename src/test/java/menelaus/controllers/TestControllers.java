package menelaus.controllers;

import static org.junit.Assert.*;

import java.util.Hashtable;

import menelaus.model.BuilderManager;
import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.basic.Color;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.Board;
import menelaus.model.board.BoardTileInfo;
import menelaus.model.board.ColoredSetItem;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.game.GameWindowFrame;

import org.junit.Before;
import org.junit.Test;

public class TestControllers {
	PieceDragController pdc;
	BoardBuilderMakeLevelController bbmlc;
	PieceSelectionController psc;
	ButtonBuilderStartController bbsc;
	
	
	Level level;
	GameWindowFrame gwFrame;
	BuilderManager bManager;
	BoardView bv;
	Board board;
	BullpenView bpView;
	GameManager gameManager;

	@Before
	public void setUp() throws Exception {
		bManager = new BuilderManager();
		board = new Board(6, 8);
		Hashtable<Point, BoardTileInfo>tileInfo = new Hashtable<Point, BoardTileInfo>();
		BoardTileInfo btInfo = new BoardTileInfo(false);
		btInfo.setColoredSetItem(new ColoredSetItem(Color.BLUE, 1));
		tileInfo.put(new menelaus.model.basic.Point(0, 0), btInfo );
		level = new Level(LevelType.PUZZLE, 6, 8);
		board.setTileInfo(tileInfo);
		bv = new BoardView(board, level);
		gwFrame = GameWindowFrame.getInstance();
		bpView = new BullpenView();
		gameManager = new GameManager(level);
		
		pdc = new PieceDragController(level, gwFrame);
		bbmlc = new BoardBuilderMakeLevelController(bManager, bv);
		psc = new PieceSelectionController(bpView, gameManager);
	}

	@Test
	public void testPieceDragController() {
		pdc.mouseClicked(null);
		//pdc.mouseDragged(null);
		pdc.mouseEntered(null);
		pdc.mouseExited(null);
		pdc.mouseMoved(null);
		//pdc.mousePressed(null);
		//pdc.mouseReleased(null);
		pdc.mouseWheelMoved(null);
		assertEquals(1, 1);
	}
	@Test
	public void testBoardBuilderMakeLevelController() {
		//bbmlc.mouseClicked(null);
		bbmlc.mouseEntered(null);
		bbmlc.mouseExited(null);
		bbmlc.mousePressed(null);
		bbmlc.mouseReleased(null);
		assertEquals(1, 1);
	}
	@Test
	public void testPieceSelectionController(){
		psc.mouseClicked(null);
		psc.mouseDragged(null);
		psc.mouseEntered(null);
		psc.mouseExited(null);
		psc.mouseMoved(null);
		//psc.mousePressed(null);
		psc.mouseReleased(null);
		psc.mouseWheelMoved(null);
	}
}
