package menelaus.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import menelaus.model.Level;
import menelaus.model.LevelsPackage;
import menelaus.model.basic.LevelType;

public class LevelsPackagePersistenceUtilTest {
	LevelsPackage levelsPackage;
	
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	
	@Before
	public void setUp() throws Exception {
		levelsPackage = new LevelsPackage();
		levelsPackage.addLevel(new Level(LevelType.PUZZLE, 6, 6));
		levelsPackage.addLevel(new Level(LevelType.PUZZLE, 6, 6));
		levelsPackage.addLevel(new Level(LevelType.LIGHTNING, 7, 7));
		levelsPackage.addLevel(new Level(LevelType.RELEASE, 8, 8));
	}

	@Test
	public void testToAndFromFile() throws ClassNotFoundException, IOException {
		LevelsPackage loaded;
		
		File createdFile = folder.newFile("testFile.dat");
		
		LevelsPackagePersistenceUtil.toFile(levelsPackage, createdFile);
		loaded = LevelsPackagePersistenceUtil.fromFile(createdFile);
		
		assertEquals(levelsPackage.getLevels().size(), loaded.getLevels().size());
	}
}
