package menelaus.controllers;

import static org.junit.Assert.*;
import java.awt.event.MouseEvent;

import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.basic.LevelType;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.game.LevelPlayScreen;

import org.junit.Before;
import org.junit.Test;

public class TestPieceController {
	GameManager gameManager;
	BullpenView bullpenView;
	BoardView boardView;
	Level level;
	PieceController pieceController;

	@Before
	public void setUp() throws Exception {
	level = new Level(LevelType.PUZZLE, 6, 8);
	boardView = new BoardView();
	gameManager = new GameManager(level);
	pieceController = new PieceController(new LevelPlayScreen(level), gameManager);
	
	}

	@Test
	public void testPieceController() {
		pieceController.mouseClicked(null);
		pieceController.mouseDragged(null);
		pieceController.mouseEntered(null);
		pieceController.mouseExited(null);
		//pieceController.mouseMoved(null);
		//pieceController.mousePressed(null);
		pieceController.mouseReleased(null);
		pieceController.mouseWheelMoved(null);
	}

}
