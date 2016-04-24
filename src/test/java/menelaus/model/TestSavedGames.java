package menelaus.model;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author mtmccarthy
 *
 */
public class TestSavedGames {

	LevelStars star1;
	LevelStars star2;
	LevelStars star3;
	
	
	
	SavedGames sgs;
	Hashtable<UUID, LevelStars> stars;
	
	
	@Before
	public void setUp() throws Exception {
		star1 = new LevelStars(2, UUID.randomUUID());
		star2 = new LevelStars(1, UUID.randomUUID());
		star3 = new LevelStars(3, UUID.randomUUID());
		
		
		stars = new Hashtable<UUID, LevelStars>();
		stars.put(star1.getLevelId(), star1);
		sgs = new SavedGames(stars);
	}

	@Test
	public void testGettersAndSetters() {
		stars.put(star2.getLevelId(), star2);
		sgs.setStars(stars);
		
		assertEquals(sgs.getStars(), stars);
	}
	
	@Test
	public void testAddLevelStars(){
		sgs.addLevelStars(star3);
		stars.put(star3.getLevelId(), star3);
		
		assertEquals(sgs.getStars(), stars);
	}
}
