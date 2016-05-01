package menelaus.view.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import menelaus.controllers.ButtonLevelSelectController;
import menelaus.model.Level;
import menelaus.model.LevelStars;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class LevelSelectComponent1 extends JPanel {
	/** the level for this component. */
	private Level level;
	
	/** the level stars for this level */
	private LevelStars stars;
	
	/** count of all stars for this level */
	int starCount;
	
	BufferedImage starIMG;
	BufferedImage emptyStarIMG;
	ImageIcon starIcon;
	ImageIcon emptyStarIcon;
	
	JLabel lblStar1;
	JLabel lblStar2;
	JLabel lblStar3;
	
	String starString = "str";
	
	boolean playable;
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(138, 180);
	}

	/**
	 * Create the panel.
	 */
	public LevelSelectComponent1(Level levelParam, LevelStars stars, boolean playableParam) {
		setBounds(0, 0, 138, 180);
		starIcon = null;
		emptyStarIcon = null;
		
		this.level = levelParam;
		this.stars = stars;
		this.playable = playableParam;
		int starDemension = 35;
		
		try {
			starIMG = ImageIO.read(new File("star.png"));
			emptyStarIMG = ImageIO.read(new File("empty_star.png"));
			starIcon = new ImageIcon(starIMG.getScaledInstance(starDemension, starDemension, Image.SCALE_DEFAULT));
			emptyStarIcon = new ImageIcon(emptyStarIMG.getScaledInstance(starDemension, starDemension, Image.SCALE_DEFAULT));
			starString = null;
		} catch (IOException e) {
			System.out.println("fuck the image isn't read");
		}
		
		// Set star count
		if ( stars == null ){
			starCount = 0;
		} else {
			starCount = this.stars.getStarsCount();	
		}
		
		lblStar1 = new JLabel(starString);
		lblStar2 = new JLabel(starString);
		lblStar3 = new JLabel(starString);
		
		setStarIcons();
		
		JLabel lblLevelName = new JLabel(level.getName());
		lblLevelName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelName.setMaximumSize(new Dimension(120, 16));
		
		JLabel lblLevelType = new JLabel(level.getType().toString().toLowerCase());
		lblLevelType.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelType.setMaximumSize(new Dimension(120, 16));
		
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
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLevelName, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(lblLevelType, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblStar1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblStar2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblStar3)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblLevelName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblLevelType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStar2)
						.addComponent(lblStar3)
						.addComponent(lblStar1))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		this.setBackground(Color.white);
	}
	
	private void setStarIcons() {
		
		switch (starCount) {
		case 1:
			lblStar1.setIcon(starIcon);
			lblStar2.setIcon(emptyStarIcon);
			lblStar3.setIcon(emptyStarIcon);
			break;
			
		case 2:
			lblStar1.setIcon(starIcon);
			lblStar2.setIcon(starIcon);
			lblStar3.setIcon(emptyStarIcon);
			break;
			
		case 3:
			lblStar1.setIcon(starIcon);
			lblStar2.setIcon(starIcon);
			lblStar3.setIcon(starIcon);
			break;
			
		default: // case 0
			lblStar1.setIcon(emptyStarIcon);
			lblStar2.setIcon(emptyStarIcon);
			lblStar3.setIcon(emptyStarIcon);
			break;
		}

		
	}

}
