package menelaus.view.builder;

import menelaus.model.LevelsPackage;
import menelaus.view.KabasujiPanel;

import javax.swing.*;

public class BuilderWindowFrame extends JFrame {

	private KabasujiPanel contentPane;
	private static BuilderWindowFrame instance = new BuilderWindowFrame();
	
	private LevelsPackage currentPackage;

	/**
	 * Create the frame.
	 */
	private BuilderWindowFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(KabasujiPanel.START_X, KabasujiPanel.START_Y, KabasujiPanel.WIDTH, KabasujiPanel.HEIGHT);
		
		// Run the splash screen for 2 seconds then swap to main menu:
		contentPane = new SplashScreen();
		this.add(contentPane);
		setVisible(true);
		setResizable(false);
		setName("KabaSuji Builder");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		contentPane = new HomeScreen();
		this.swapPanel(contentPane);

	}

	/**
	 * Gives access to the gameWindow
	 * @return instance  the game window
	 */
	public static BuilderWindowFrame getInstance(){
		return instance;
	}

	/**
	 * Swaps panel in BuilderWindow
	 *  to the given panel
	 * @param panel  the panel you want to switch to.
	 * @return void
	 */
	public void swapPanel(KabasujiPanel panel) {
        contentPane = panel;
		this.getContentPane().removeAll();
		this.getContentPane().add( panel );

		validate();
	}
	
	/**
	 * Close game
	 */
	public void close(){
		System.exit(0);
	}

	/**
	 * Get panel in BuilderWindow
	 * @return the current panel
	 */
	public KabasujiPanel getPanel() {
		return contentPane;
	}
	
	public LevelsPackage getCurrentPackage() {
		return this.currentPackage;
	}
	
	public void setCurrentPackage(LevelsPackage newPackage) {
		this.currentPackage = newPackage;
	}
}
