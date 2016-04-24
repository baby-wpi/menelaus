package menelaus.model;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author mtmccarthy
 *
 */

public class TestLevelStars {

	LevelStars ls1;
	LevelStars ls2;
	
	@Before
	public void setUp() {
		ls1 = new LevelStars(2, UUID.randomUUID());
		ls2 = new LevelStars(1, UUID.randomUUID());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testStarsCount1(){
		ls1.setStarsCount(-1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testStarsCount2(){
		ls1.setStarsCount(5);
	}
	@Test
	public void testGetterAndSetters(){
		ls1.setStarsCount(3);
		UUID ranUUID = UUID.randomUUID();
		ls2.setLevelId(ranUUID);
		assertEquals(ls1.getStarsCount(), 3);
		assertEquals(ls2.getLevelId(), ranUUID);
	}
}
