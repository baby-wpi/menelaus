package Main;
import menelaus.view.builder.BuilderWindowFrame;

/** Used to launch the KabaSuji Builder Application. */
public class MainBuilder {
	public static void main (String[] args){
		//Model m = new Model();

		
		// if using 'app' within the anonymous class generated below, must be marked final.
		final BuilderWindowFrame app = BuilderWindowFrame.getInstance();

		app.setVisible(true);
	}
}
