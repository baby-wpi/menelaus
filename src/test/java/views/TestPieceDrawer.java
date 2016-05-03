package views;

import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TestPieceDrawer {
	Graphics g;
	Piece piece;
	Point targetPoint;
	int tileSize;
	ArrayList<Point> points;
	
	@Before
	public void setUp() throws Exception {
		targetPoint = new Point(0, 0);
		tileSize = 1;
		piece = new Piece(targetPoint);
//		PieceDrawer.drawPiece(g, piece, targetPoint, tileSize);
//		PieceDrawer.drawPieceToGrid(g, piece, tileSize);
//		PieceDrawer.drawHintToGrid(g, piece, tileSize);
		points = new ArrayList<>();
		points.add(targetPoint);
//		PieceDrawer.drawSelection(g, points, tileSize);
		
	}

	@Test
	public void testDrawPiece() {
		assertEquals(piece.getPosition(), targetPoint);
	}

}
