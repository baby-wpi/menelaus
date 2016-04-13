package menelaus.view.builder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BuilderWindowFrame extends JFrame {

	private JPanel contentPane;
	private static BuilderWindowFrame instance = new BuilderWindowFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderWindowFrame frame = getInstance();
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
	private BuilderWindowFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		this.add(new HomeScreen());
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
