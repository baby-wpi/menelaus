package views;

import static org.junit.Assert.*;
import menelaus.model.BuilderManager;
import menelaus.view.builder.BuilderLevelBuilderScreen;

import org.junit.Before;
import org.junit.Test;

public class TestBuilderLevelBuilderScreen {

	 BuilderManager bManager;
	 BuilderLevelBuilderScreen screen;
	
	@Before
	public void setUp() throws Exception {
		bManager = new BuilderManager();
		screen = new BuilderLevelBuilderScreen(bManager);
	}

	@Test
	public void testRandom() {
		assertEquals(1, 1);
	}

}
