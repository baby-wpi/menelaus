package menelaus.model.basic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import menelaus.model.basic.Point;

/**
 * 
 * @author vouldjeff
 *
 */
public class PointTest {
	Point point;
	
	
	@Before
	public void setUp() throws Exception {
		point = new Point(1,3);
	}

	@Test
	public void testGetters() {
		assertEquals(1, point.getX());
		assertEquals(3, point.getY());
	}

	@Test
	public void testSetY() {
		point.setX(5);
		point.setY(10);
		assertEquals(5, point.getX());
		assertEquals(10, point.getY());
	}
	
	@Test
	public void testAdd() {
		Point offset = new Point(2, -2);
		
		assertEquals(new Point(3, 1), point.add(offset));
	}
}
