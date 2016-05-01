package views;

import static org.junit.Assert.*;

import java.awt.GraphicsEnvironment;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;

import menelaus.model.BuilderManager;
import menelaus.model.LevelStars;
import menelaus.model.basic.LevelType;
import menelaus.model.events.GameEndReason;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.view.BoardView;
import menelaus.view.builder.BuilderLevelBuilderScreen;
import menelaus.view.builder.BuilderSelectScreen;
import menelaus.view.builder.BuilderWindowFrame;
import menelaus.view.builder.HomeScreen;
import menelaus.view.game.ExtraScreen;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.LevelPlayScreen;
import menelaus.view.game.LevelSelectorScreen;
import menelaus.view.game.WinScreen;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class TestView {

	GameWindowFrame frame;
	HomeScreen homeScreen;
	WinScreen winScreen;
	LevelStars stars;
	menelaus.view.game.SplashScreen splashScreen;
	menelaus.view.builder.SplashScreen splashScreen2;
	ExtraScreen extraScreen;
	LevelSelectorScreen levelSelectorScreen;
	LevelPlayScreen playScreen;
	menelaus.model.Level level;
	BuilderWindowFrame builderFrame;
	BuilderSelectScreen bSelectScreen;
	BuilderLevelBuilderScreen blevelScreen;
	BuilderManager bManager;
	
	//Game Simple Views
	BoardView boardView;
	
	@Before
	public void setUp() throws Exception {
		if (GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadless()) {
			return;
		}
		
		frame = GameWindowFrame.getInstance();
		builderFrame = BuilderWindowFrame.getInstance();
		homeScreen = new HomeScreen();
		stars = new LevelStars(0, UUID.randomUUID());
		winScreen = new WinScreen(stars, GameEndReason.WON, frame.getLevelsPackage().getLevels().get(0));
		splashScreen = new menelaus.view.game.SplashScreen();
		splashScreen2 = new menelaus.view.builder.SplashScreen();
		extraScreen = new ExtraScreen();
		levelSelectorScreen = new LevelSelectorScreen(frame.getLevelsPackage(), frame.getSavedGamesUtil().getSavedGames());
		level = new menelaus.model.Level(LevelType.PUZZLE, 6, 6);
		playScreen = new LevelPlayScreen(level);
		bManager = new BuilderManager();
		blevelScreen = new BuilderLevelBuilderScreen();
		bSelectScreen = new BuilderSelectScreen();
	}

	@Test
	public void testFrameLevelPackage() {
		if (GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadless()) {
			return;
		}
		
		try {
			assertEquals(frame.getLevelsPackage().getLevels().iterator().hasNext(), LevelsPackagePersistenceUtil.fromFile(new File("default-levels.boba")).getLevels().iterator().hasNext());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void testHomeScreen(){
		
	}

}
