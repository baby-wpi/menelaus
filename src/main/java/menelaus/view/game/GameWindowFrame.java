package menelaus.view.game;

import javax.swing.*;
import java.awt.*;

public class GameWindowFrame extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 1000, 750);
		
		// Run the splash screen for 2 seconds then swap to main menu:
		this.add(new SplashScreen());
		setVisible(true);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.swapPanel(new HomeScreen());
		
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
	public void swapPanel(JPanel panel) {
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

}
