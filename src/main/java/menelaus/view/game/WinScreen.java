package menelaus.view.game;

import menelaus.controllers.ButtonContinueController;
import menelaus.controllers.ButtonLevelsController;
import menelaus.controllers.RestartController;
import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.LevelStars;
import menelaus.model.events.GameEndReason;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;

public class WinScreen extends KabasujiPanel  {
	LevelStars stars;
	GameEndReason reason;
	
	/** the string in which the lblScore presents. */
	String scoreLabel;
	
	/** the string in which the lblCongratulations presents. */
	String congratsLabel;

	
	/** the count of stars for the current level. */
	int starCount;
	
	private KabasujiPanel contentPane;

	/**
	 * Create the frame.
	 * @param Level
	 * @param gameManager 
	 * @author Obatola Seward-Evans
	 */
	public WinScreen(LevelStars starsParams, GameEndReason reason, Level inputLevel) {
		this.stars = starsParams;
		this.reason = reason;
		contentPane = this;
		starCount = stars.getStarsCount();
		
		Level restartLevel = inputLevel;
//		Level restartLevel = null;
//		for (Level level : GameWindowFrame.getInstance().getLevelsPackage().getLevels()) {
//			if (level.getUuid() == stars.getLevelId()) {
//				restartLevel = level;
//			}
//		}
//		
		if ( starCount < 1 ) {
			congratsLabel = "You Lose!\n";
		} else if (starCount == 1) {
			congratsLabel = "Almost there!\n";
		} else {
			congratsLabel = "Congratulations!!!\n";
		}
		
		// Create the string in which the lblScore presents.
		scoreLabel = new StringBuilder().append("Score: ")
				.append(String.valueOf( starCount )).toString();
		
		setBounds(KabasujiPanel.START_X, KabasujiPanel.START_Y, KabasujiPanel.WIDTH, KabasujiPanel.HEIGHT);
		
		/** Continue Button. */
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ButtonContinueController());
		
		/** Restart Button. */
		JButton btnRestart = new JButton("Play Again");
		if (restartLevel != null) {
			btnRestart.addActionListener(new RestartController(restartLevel));
		}
		
		/** Exit Button. */
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonLevelsController());
//		try {
//			btnExit.addActionListener(new ButtonLevelsController(LevelsPackagePersistenceUtil.fromFile(new File("default-levels.boba"))));
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/** Score label. */
		JLabel lblScore = new JLabel( scoreLabel );
		
		/** Congratulations label. */
		JLabel lblCongratulations = new JLabel( congratsLabel );
		lblCongratulations.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratulations.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCongratulations, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(120)
							.addComponent(lblScore))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
					.addGap(344))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(219, Short.MAX_VALUE)
					.addComponent(lblCongratulations)
					.addGap(18)
					.addComponent(lblScore)
					.addGap(42)
					.addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(209))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
