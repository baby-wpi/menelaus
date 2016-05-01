package menelaus.view.game;

import menelaus.model.LevelsPackage;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.util.SavedGamesUtil;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import java.io.File;

/**
 * 
 * @author vouldjeff
 * @author boba
 *
 */
public class GameWindowFrame extends JFrame {
	private final static String DEFAULT_PACKAGE_NAME = "/assets/default-levels.boba";
	private final static String SAVED_GAMES_NAME = "saved-games.boba";
	
	private KabasujiPanel contentPane;
	private static GameWindowFrame instance = new GameWindowFrame();
	
	private LevelsPackage levelsPackage;
	private LevelsPackage recentlyPLayedLevelsPackage;
	private SavedGamesUtil savedGamesUtil;

	/**
	 * Create the frame.
	 */
	private GameWindowFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, GameViewConfigurations.panelWidth, GameViewConfigurations.panelHeight);
		
		// Run the splash screen for 2 seconds then swap to main menu:
        contentPane = new SplashScreen();
		this.add(contentPane);
		setVisible(true);
		setResizable(false);
		setName("KabaSuji");
		
		try {
			levelsPackage = LevelsPackagePersistenceUtil.fromFile(this.getClass().getResourceAsStream(DEFAULT_PACKAGE_NAME));
			savedGamesUtil = new SavedGamesUtil(new File(SAVED_GAMES_NAME));
			recentlyPLayedLevelsPackage = levelsPackage;
			
			contentPane = new HomeScreen();
//			Thread.sleep(2000);
			// TODO: change back
			Thread.sleep(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.swapPanel(contentPane);
	}

	/**
	 * Gives access to the gameWindow
	 * @return instance  the game window
	 */
	public static GameWindowFrame getInstance(){
		return instance;
	}
	
	/**
	 * sets loaded recently played levels package.
	 * @return boolean - true if level was set
	 */
	public LevelsPackage getLevelsPackage() {
		return levelsPackage;
	}
	
	/**
	 * sets recently played levels package.
	 * @return boolean - true if level was set
	 */
	public boolean setRecentlyPLayedLevelsPackage(LevelsPackage inputLevelsPackage){
		recentlyPLayedLevelsPackage = inputLevelsPackage;
		return true;
	}
	
	/**
	 * gets loaded recently played levels package.
	 * @return boolean - true if level was set
	 */
	public LevelsPackage getRecentlyPLayedLevelsPackage() {
		return recentlyPLayedLevelsPackage;
	}
	
	/**
	 * Returns the SavedGamesUtil.
	 * @return
	 */
	public SavedGamesUtil getSavedGamesUtil() {
		return savedGamesUtil;
	}

	/**
	 * Swaps panel in GameWindow to the given panel
	 * @param panel  the panel you want to switch to.
	 */
	public void swapPanel(KabasujiPanel panel) {
        contentPane = panel;
		this.getContentPane().removeAll();
		this.getContentPane().add( panel );
		//setVisible(true);
		validate();
	}
	
	/**
	 * Close game
	 */
	public void close(){
		System.exit(0);
	}

    /**
     * Gets the panel that is being displayed.
     * @return
     */
	public KabasujiPanel getPanel() {
		return contentPane;
	}
}
