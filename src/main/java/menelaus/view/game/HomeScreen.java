package menelaus.view.game;

import menelaus.controllers.ButtonContinueController;
import menelaus.controllers.ButtonHomeExitController;
import menelaus.controllers.ButtonHomeExtraController;
import menelaus.controllers.ButtonLevelSelectController;
import menelaus.controllers.ButtonLevelsController;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.KabasujiPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author vouldjeff
 * @author fegan
 */
public class HomeScreen extends KabasujiPanel {
	JLabel lblMute;
	BufferedImage backgroundIMG;
	BufferedImage starIMG;
	ClassLoader classLoader;
	
	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		try {
			backgroundIMG = ImageIO.read(new File("back.jpg"));
			starIMG = ImageIO.read(new File("star.png"));
		} catch (IOException e) {
			System.out.println("fuck the image isn't read");
		}
		
		

		JButton btnContinue = new JButton("Continue");

		JButton btnLevels = new JButton("Levels");

		JButton btnExtra = new JButton("Extra");

		JButton btnExit = new JButton("Exit");

		btnContinue.addActionListener(new ButtonContinueController());
		try {
			btnLevels.addActionListener(new ButtonLevelsController(LevelsPackagePersistenceUtil.fromFile(new File("default-levels.boba"))));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // Levels.
		btnExit.addActionListener(new ButtonHomeExitController(this)); // Exit.      
		btnExtra.addActionListener(new ButtonHomeExtraController()); // Extra.

		JLabel lblKabasuji = new JLabel("KabaSuji");
		lblKabasuji.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		/** mute button. */
		lblMute = new JLabel("");
		lblMute.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				updateMute();
			}
		});
		
		lblMute.setIcon(new ImageIcon(HomeScreen.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMute.png")));
		
		if (SoundManager.getInstance().isMute()) {
			lblMute.setIcon(new ImageIcon(HomeScreen.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaUnmute.png")));
		} else {
			lblMute.setIcon(new ImageIcon(HomeScreen.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMute.png")));
		}
		
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(428, Short.MAX_VALUE)
					.addComponent(lblKabasuji)
					.addGap(436))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnContinue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(448))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnLevels, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addGap(448))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnExtra, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
					.addGap(448))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMute)
					.addContainerGap(964, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(289, Short.MAX_VALUE)
					.addComponent(lblKabasuji)
					.addGap(12)
					.addComponent(btnContinue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLevels)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExtra)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit)
					.addGap(243)
					.addComponent(lblMute)
					.addContainerGap())
		);
		this.setLayout(gl_contentPane);
	}
	
	private void updateMute(){
		SoundManager.getInstance().changeMute();
		if (SoundManager.getInstance().isMute()) {
			lblMute.setIcon(new ImageIcon(HomeScreen.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaUnmute.png")));
		} else {
			lblMute.setIcon(new ImageIcon(HomeScreen.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMute.png")));
		}
		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//g.drawRect(100, 100, 100, 100);
		g.drawImage(backgroundIMG.getScaledInstance(1000, 750, Image.SCALE_DEFAULT), 0, 0, null);
		g.drawImage(starIMG, 0, 0, null);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 20, 20);
	}
}
