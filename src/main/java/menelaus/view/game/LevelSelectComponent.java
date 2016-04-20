package menelaus.view.game;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.junit.After;

import menelaus.controllers.ButtonLevelSelectController;
import menelaus.model.Level;
import menelaus.model.LevelStars;
import menelaus.model.SavedGames;

public class LevelSelectComponent extends JPanel {
	private Level level;
	
	@Override
	public Dimension getPreferredSize() {
//		return new Dimension(80, 100);
		return new Dimension(180, 180);
	}
	
	/**
	 * Create the panel.
	 */
	public LevelSelectComponent(Level levelParam, LevelStars stars) {
		this.level = levelParam;
		
		setBounds(100, 100, 80, 100);
		
		addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				ButtonLevelSelectController controller = new ButtonLevelSelectController(level);	
				controller.actionPerformed(null);
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
