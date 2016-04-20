package menelaus.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import menelaus.model.Bullpen;

/**
 * Here is where the pieces will be stored to be placed on the board (in 250-height size).
 * @author ObaSewardEvans 
 */
public class BullpenView extends JPanel {
	
	/** Core bullpen */
	Bullpen bullpen;
	
	/** Base width of bullpen. */
	public final int N = 250;
	
	/** Given a set of KabaSuji pieces, draw them in this panel. */
	public BullpenView(Bullpen bullpen){
		this.bullpen = bullpen;
	}
	
	/** Only here so we can safely open within WindowBuilder. */
	public BullpenView() {
	}
	
	/**
	 * Draw background puzzle and all active pieces.
	 */
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawRect(20,20,10,10);
    	g.setColor(Color.RED);
    	g.fillRect(20, 20, 10, 10);
    }
}
