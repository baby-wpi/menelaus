package menelaus.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

import org.junit.Before;
import org.junit.Test;

public class TestBullpen {
	
	Bullpen bp;
	Piece p1;
	Point pt1;
	Piece p2;
	Point pt2;
	Piece p3;
	Point pt3;
	Piece p4;
	Point pt4;
	ArrayList<Piece> pieces;
	
	@Before
	public void setUp(){
		bp = new Bullpen();
		pt1 = new Point(0,0);
		p1 = new Piece(pt1);
		pt2 = new Point(1,1);
		p2 = new Piece(pt2);
		pt3 = new Point(2,5);
		p3 = new Piece(pt3);
		pt4 = new Point(10,10);
		p4 = new Piece(pt4);
		pieces = new ArrayList<Piece>();
		pieces.add(p1);
		pieces.add(p2);
		pieces.add(p3);
	}
	@Test
	public void testGettersAndSetters(){
		bp.setPieces(pieces);
		assertEquals(bp.getPieces(), pieces);
	}
	@Test
	public void testRemoveAndAddPiece(){
		bp.removePiece(p1);
		bp.removePiece(p2);
		bp.removePiece(p3);
		bp.addPiece(p4);
		bp.removePiece(p4);
		
		assertEquals(bp.getPieces(), new ArrayList<Piece>());
	}
	
}




