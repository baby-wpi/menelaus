package Main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import menelaus.view.game.GameWindowFrame;

/** Used to launch the KabaSuji Application. */
public class MainGame {
	public static void main (String[] args){
		//Model m = new Model();

		
		// if using 'app' within the anonymous class generated below, must be marked final.
		final GameWindowFrame app = GameWindowFrame.getInstance();

		// state how to deal with leaving
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
