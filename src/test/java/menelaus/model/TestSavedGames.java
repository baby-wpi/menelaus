package menelaus.model;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;


public class TestSavedGames {

	LevelStars star1;
	LevelStars star2;
	LevelStars star3;
	
	ArrayList<LevelStars> stars;
	
	SavedGames sgs;
	
	
	
	@Before
	public void setUp() throws Exception {
		star1 = new LevelStars(2, UUID.randomUUID());
		star2 = new LevelStars(1, UUID.randomUUID());
		star3 = new LevelStars(3, UUID.randomUUID());
		
		stars = new ArrayList<LevelStars>();
		stars.add(star1);
		
		
		
		sgs = new SavedGames(stars);
	}

	@Test
	public void testGettersAndSetters() {
		stars.add(star2);
		sgs.setStars(stars);
		
		assertEquals(sgs.getStars(), stars);
	}
	
	@Test
	public void testAddLevelStars(){
		sgs.addLevelStars(star3);
		stars.add(star3);
		
		assertEquals(sgs.getStars(), stars);
	}
}
