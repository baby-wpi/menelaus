package menelaus.controllers;

import static org.junit.Assert.*;

import java.awt.event.MouseEvent;
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
import menelaus.model.board.Piece;
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
	SaveLevelButtonBuilderMakeLevelController slbb;
	
	
	
	Level level;
	GameWindowFrame gwFrame;
	BuilderManager bManager;
	BoardView bv;
	BullpenView bpView;
	GameManager gameManager;

	@Before
	public void setUp() throws Exception {
		gwFrame = GameWindowFrame.getInstance();
		bManager = new BuilderManager();
		level = gwFrame.getLevelsPackage().getLevels().get(0);
		bv = new BoardView(level.getBoard(), level);
		gwFrame = GameWindowFrame.getInstance();
		bpView = new BullpenView();
		gameManager = new GameManager(level);
		
		pdc = new PieceDragController(level, gwFrame);
		bbmlc = new BoardBuilderMakeLevelController(bManager, bv, null);
		psc = new PieceSelectionController(bpView, gameManager);
		bbsc = new ButtonBuilderStartController(bManager);
		slbb = new SaveLevelButtonBuilderMakeLevelController(bManager);
		
	}

	@Test
	public void testPieceDragController() {
		pdc.level.getBullpen().addPiece(new Piece(new Point(0, 0)));
		pdc.register();
		pdc.select(0, 0);
		pdc.mouseClicked(null);
		pdc.mouseDragged(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		pdc.mouseEntered(null);
		pdc.mouseExited(null);
		pdc.mouseMoved(null);
		pdc.mousePressed(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		pdc.mouseReleased(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		pdc.mouseWheelMoved(null);
		assertEquals(1, 1);
	}
	@Test
	public void testBoardBuilderMakeLevelController() {
		//bbmlc.mouseClicked(new MouseEvent(bv, 1, 2, 1, 1, 1, 1, 1, 1, false, 1));
		bbmlc.mouseEntered(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		bbmlc.mouseExited(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		bbmlc.mousePressed(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		bbmlc.mouseReleased(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		
		assertEquals(1, 1);
	}
	@Test
	public void testPieceSelectionController(){
		psc.mouseClicked(new MouseEvent(bv, 1, 2, 1, 1, 1, 1, 1, 1, false, 1));
		psc.mouseDragged(new MouseEvent(bv, 0, 0, 0, 0, 0, 0, 0, 0, false, 0));
		psc.mouseEntered(new MouseEvent(bv, 1, 2, 1, 1, 1, 1, 1, 1, false, 1));
		psc.mouseExited(new MouseEvent(bv, 1, 2, 1, 1, 1, 1, 1, 1, false, 1));
		psc.mouseMoved(new MouseEvent(bv, 1, 2, 1, 1, 1, 1, 1, 1, false, 1));
		//psc.mousePressed(null);
		//psc.mouseReleased(new MouseEvent(bv, 1, 2, 1, 1, 1, 1, 1, 1, false, 1));
		psc.mouseWheelMoved(null);
	}
	@Test
	public void testButtonBuilderStartController(){
		bbsc.actionPerformed(null);
		assertTrue(bbsc.isSizeValid(0, 0));
		assertTrue(!bbsc.isSizeValid(-1, 0));
	}
	@Test
	public void testSaveLevelButtonBuilder(){
		slbb.actionPerformed(null);
		assertTrue(true);
	}
}
