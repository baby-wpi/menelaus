import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import menelaus.view.builder.BuilderWindowFrame;

/** Used to launch the KabaSuji Builder Application. */
public class MainBuilder {
	public static void main (String[] args){
		//Model m = new Model();

		
		// if using 'app' within the anonymous class generated below, must be marked final.
		final BuilderWindowFrame app = BuilderWindowFrame.getInstance();

		// state how to deal with leaving
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
}
