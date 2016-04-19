package menelaus.view.game;

import menelaus.view.KabasujiPanel;

import javax.swing.*;
import java.awt.*;

public class GameWindowFrame extends JFrame {

	private KabasujiPanel contentPane;
	private static GameWindowFrame instance = new GameWindowFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindowFrame frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	public static GameWindowFrame getInstance(){
		return instance;
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
