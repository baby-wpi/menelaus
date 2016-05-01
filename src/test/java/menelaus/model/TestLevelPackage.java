package menelaus.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import menelaus.model.basic.*;

/**
 * 
 * @author mtmccarthy
 *
 */
public class TestLevelPackage {
	
	Level l1;
	Level l2;
	Level l3;
	ArrayList<Level> levels;
	LevelsPackage pack;

	@Before
	public void setUp() throws Exception {
		l1 = new Level(LevelType.PUZZLE, 100, 100);
		l2 = new Level(LevelType.LIGHTNING, 100, 100);
		l3 = new Level(LevelType.RELEASE, 100, 100);
		levels = new ArrayList<Level>();
		levels.add(l1);
		levels.add(l2);
		levels.add(l3);
		pack = new LevelsPackage();
	}

	@Test
	public void testSetLevels() {
		pack.setLevels(levels);
		assertEquals(pack.getLevels(), levels);
	}

}
