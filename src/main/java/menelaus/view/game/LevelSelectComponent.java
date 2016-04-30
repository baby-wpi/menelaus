package menelaus.view.game;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import menelaus.controllers.ButtonLevelSelectController;
import menelaus.model.Level;
import menelaus.model.LevelStars;

/**
 * The level view for the level select view.
 * @author Obatola Seward-Evans
 *
 */
public class LevelSelectComponent extends JPanel {
	/** the level for this component. */
	private Level level;
	
	/** the level stars for this level */
	private LevelStars stars;
	
	/** count of all stars for this level */
	int starCount;
	
	boolean playable;
	
	@Override
	public Dimension getPreferredSize() {
//		return new Dimension(80, 100);
		return new Dimension(180, 180);
	}
	
	/**
	 * Create the panel and mouse listener.
	 */
	public LevelSelectComponent(Level levelParam, LevelStars stars, boolean playableParam) {
		this.level = levelParam;
		this.stars = stars;
		this.playable = playableParam;
		
		// Set star count
		if ( stars == null ){
			starCount = 0;
		} else {
			starCount = this.stars.getStarsCount();	
		}
		
		addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// decides if the level component can be clicked on or not.
				if (starCount > 0 || playable) {
					ButtonLevelSelectController controller = new ButtonLevelSelectController(level);	
					controller.actionPerformed(null);
				}
			}
		});
		
		// Show level name
		JLabel lblLevelName = new JLabel(level.getName());
		
		// Show level type
		JLabel lblLevelType = new JLabel(level.getType().toString().toLowerCase());
		
		// Show number of stars
		JLabel lblLevelScore;
		if ( stars == null ){
			lblLevelScore = new JLabel( String.valueOf( 0 ) );
		} else {
			lblLevelScore = new JLabel( String.valueOf( stars.getStarsCount() ) );	
		}
		
		// StarPolygon stars = new StarPolygon(int x, int y, int r, int innerR, int vertexCount);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLevelName)
						.addComponent(lblLevelType)
						.addComponent(lblLevelScore))
					.addContainerGap(6, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLevelName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLevelType)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLevelScore)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
