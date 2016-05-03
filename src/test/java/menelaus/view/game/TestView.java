package menelaus.view.game;

import menelaus.controllers.ButtonBuilderLevelSelectController;
import menelaus.controllers.ButtonLevelSelectController;
import menelaus.controllers.ButtonLevelsController;
import menelaus.controllers.ToWinScreenController;
import menelaus.model.Level;
import menelaus.model.LevelStars;
import menelaus.model.basic.LevelType;
import menelaus.model.events.GameEndReason;
import menelaus.view.BoardView;
import menelaus.view.builder.BuilderWindowFrame;
import menelaus.view.builder.HomeScreen;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class TestView {

	GameWindowFrame frame;
	HomeScreen homeScreen;
	menelaus.view.game.SplashScreen splashScreen;
	menelaus.view.builder.SplashScreen splashScreen2;
	ExtraScreen extraScreen;
	BuilderWindowFrame builderFrame;
	
	//Game Simple Views
	BoardView boardView;
	
	@Before
	public void setUp() throws Exception {
		if (_stopTest()) { return; }
		
		frame = GameWindowFrame.getInstance();
		builderFrame = BuilderWindowFrame.getInstance();
		homeScreen = new HomeScreen();
		splashScreen = new menelaus.view.game.SplashScreen();
		splashScreen2 = new menelaus.view.builder.SplashScreen();
		extraScreen = new ExtraScreen();
	}

	@Test
	public void testWinScreen() {
		if (_stopTest()) { return; }
		
		Level level = new Level(LevelType.PUZZLE, 12, 12);
		LevelStars stars = new LevelStars(3, level.getUuid());
		
		ToWinScreenController controller = new ToWinScreenController(stars, GameEndReason.WON, level);
		controller.actionPerformed(null);
	}
	
	@Test
	public void testPlayScreen() {
		if (_stopTest()) { return; }
		
		ButtonLevelSelectController controller = new ButtonLevelSelectController(frame.getLevelsPackage().getLevels().get(0));
		controller.actionPerformed(null);
		LevelPlayScreen screen = (LevelPlayScreen) frame.getContentPane().getComponent(0);
		screen.btnRestart.doClick();
		screen.btnExitButton.doClick();
	}
	
	@Test
	public void testLevelSelect() {
		if (_stopTest()) { return; }
		
		ButtonLevelsController controller = new ButtonLevelsController();
		controller.actionPerformed(null);
	}
	
	@Test
	public void testStartLevel() {
		if (_stopTest()) { return; }
		
		ButtonBuilderLevelSelectController controller = new ButtonBuilderLevelSelectController();
		controller.actionPerformed(null);
	}
	
	private boolean _stopTest() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadless();
	}

}
