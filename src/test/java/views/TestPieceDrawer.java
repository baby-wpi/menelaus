package views;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import menelaus.model.basic.Point;
import menelaus.model.board.Piece;
import menelaus.view.BoardView;
import menelaus.view.PieceDrawer;

import org.junit.Before;
import org.junit.Test;

import sun.awt.Graphics2Delegate;


public class TestPieceDrawer {
	Graphics g;
	Piece piece;
	Point targetPoint;
	int tileSize;
	BufferedImage bi;
	PieceDrawer pd;
	ArrayList<Point> points;
	
	@Before
	public void setUp() throws Exception {
		targetPoint = new Point(0, 0);
		tileSize = 1;
		piece = new Piece(targetPoint);
		bi = ImageIO.read(this.getClass().getResource("/assets/secondary_back.png"));
		g = bi.createGraphics();
		PieceDrawer.drawPiece(g, piece, targetPoint, tileSize);
		PieceDrawer.drawPieceToGrid(g, piece, tileSize);
		PieceDrawer.drawHintToGrid(g, piece, tileSize);
		points = new ArrayList<Point>();
		points.add(targetPoint);
		PieceDrawer.drawSelection(g, points, tileSize);
		
	}

	@Test
	public void testDrawPiece() {
		assertEquals(piece.getPosition(), targetPoint);
	}

}
