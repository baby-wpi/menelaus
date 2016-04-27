package menelaus.view.game;

import menelaus.controllers.ButtonContinueController;
import menelaus.controllers.ButtonHomeExitController;
import menelaus.controllers.ButtonHomeExtraController;
import menelaus.controllers.ButtonLevelsController;
import menelaus.model.Level;
import menelaus.model.basic.LevelType;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author vouldjeff
 * @author fegan
 */
public class HomeScreen extends KabasujiPanel {

	/**
	 * Create the frame.
	 */
	public HomeScreen() {

		JButton btnContinue = new JButton("Continue");

		JButton btnLevels = new JButton("Levels");

		JButton btnExtra = new JButton("Extra");

		JButton btnExit = new JButton("Exit");

		btnContinue.addActionListener(new ButtonContinueController());
		try {
			btnLevels.addActionListener(new ButtonLevelsController(LevelsPackagePersistenceUtil.fromFile(new File("default-levels.boba"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Levels.
		btnExit.addActionListener(new ButtonHomeExitController(this)); // Exit.      
		btnExtra.addActionListener(new ButtonHomeExtraController()); // Extra.

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
