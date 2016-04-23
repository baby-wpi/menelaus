package menelaus.view.game;

import menelaus.controllers.ButtonContinueController;
import menelaus.controllers.ButtonHomeExitController;
import menelaus.controllers.ButtonLevelsController;
import menelaus.controllers.ButtonMainMenuController;
import menelaus.controllers.RestartController;
import menelaus.controllers.ToWinScreenController;
import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WinScreen extends KabasujiPanel  {
	/** the level that brought player to winscreen */
	Level currentLevel;
	
	private KabasujiPanel contentPane;

	/**
	 * Create the frame.
	 */
	public WinScreen(Level currentLevel) {
		this.currentLevel = currentLevel;
		
		setBounds(KabasujiPanel.START_X, KabasujiPanel.START_Y, KabasujiPanel.WIDTH, KabasujiPanel.HEIGHT);
		contentPane = this;
		
		
		JLabel lblCongratulations = new JLabel("Congratulations!!!\n");
		lblCongratulations.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ButtonContinueController());
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new RestartController(currentLevel));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonLevelsController());
		
		JLabel lblScore = new JLabel("Score: ");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(356, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblCongratulations)
							.addGap(345))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
							.addGap(409))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(474)
					.addComponent(lblScore)
					.addContainerGap(474, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(259)
					.addComponent(lblCongratulations)
					.addGap(18)
					.addComponent(lblScore)
					.addGap(42)
					.addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(169, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
