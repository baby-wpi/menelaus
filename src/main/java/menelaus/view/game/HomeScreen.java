package menelaus.view.game;

import menelaus.controllers.HomeContinueButtonController;
import menelaus.controllers.HomeExitButtonController;
import menelaus.controllers.HomeExtraButtonController;
import menelaus.controllers.LevelsButtonController;
import menelaus.model.Level;
import menelaus.model.basic.LevelType;
import menelaus.view.KabaSujiJPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;

public class HomeScreen extends KabaSujiJPanel {

	/**
	 * Create the frame.
	 */
	public HomeScreen() {

		JButton btnContinue = new JButton("Continue");

		JButton btnLevels = new JButton("Levels");

		JButton btnExtra = new JButton("Extra");

		JButton btnExit = new JButton("Exit");


		/* CONNECT BUTTON TO CONTROLLERS */

		//		// TODO: 4/13/16 Add level from disk? 
		btnContinue.addActionListener(new HomeContinueButtonController(new Level(LevelType.LIGHTNING, 8, 8)));
		btnLevels.addActionListener(new LevelsButtonController()); // Levels.
		btnExit.addActionListener(new HomeExitButtonController(this)); // Exit.      
		btnExtra.addActionListener(new HomeExtraButtonController()); // Extra.

		JLabel lblKabasuji = new JLabel("KabaSuji");
		lblKabasuji.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(438, Short.MAX_VALUE)
					.addComponent(lblKabasuji)
					.addGap(436))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnContinue, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(448))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnLevels, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(448))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(btnExtra, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
					.addGap(448))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(303, Short.MAX_VALUE)
					.addComponent(lblKabasuji)
					.addGap(12)
					.addComponent(btnContinue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLevels)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExtra)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit)
					.addGap(265))
		);
		this.setLayout(gl_contentPane);
	}
}
