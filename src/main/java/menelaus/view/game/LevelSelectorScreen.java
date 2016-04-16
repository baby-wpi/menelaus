package menelaus.view.game;

import menelaus.controllers.LevelSelectButtonController;
import menelaus.controllers.MainMenuButtonController;
import menelaus.view.KabaSujiJPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LevelSelectorScreen extends KabaSujiJPanel {
	/**
	 * Create the panel.
	 */
	public LevelSelectorScreen() {
		
		JButton btnLevel = new JButton("Level 1");
		btnLevel.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_1 = new JButton("Level 3");
		btnLevel_1.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_2 = new JButton("Level 4");
		btnLevel_2.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_3 = new JButton("Level 6");
		btnLevel_3.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_4 = new JButton("Level 7");
		btnLevel_4.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_5 = new JButton("Level 9");
		btnLevel_5.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_6 = new JButton("Level 10");
		btnLevel_6.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_7 = new JButton("Level 12");
		btnLevel_7.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_8 = new JButton("Level 13");
		btnLevel_8.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_9 = new JButton("Level 15");
		btnLevel_9.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_10 = new JButton("Level 2");
		btnLevel_10.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_11 = new JButton("Level 5");
		btnLevel_11.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_12 = new JButton("Level 8");
		btnLevel_12.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_13 = new JButton("Level 11");
		btnLevel_13.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_14 = new JButton("Level 14");
		btnLevel_14.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new MainMenuButtonController());
		
		
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLevel)
						.addComponent(btnLevel_2)
						.addComponent(btnLevel_4)
						.addComponent(btnLevel_6, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_10)
								.addComponent(btnLevel_11)
								.addComponent(btnLevel_12)
								.addComponent(btnLevel_13, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_14, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(14))
						.addComponent(btnMainMenu, Alignment.TRAILING))
					.addGap(340)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLevel_1)
						.addComponent(btnLevel_3)
						.addComponent(btnLevel_5)
						.addComponent(btnLevel_7, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_9, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_10)
						.addComponent(btnLevel)
						.addComponent(btnLevel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_11)
						.addComponent(btnLevel_2)
						.addComponent(btnLevel_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_12)
						.addComponent(btnLevel_4)
						.addComponent(btnLevel_5))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_13)
						.addComponent(btnLevel_7)
						.addComponent(btnLevel_6))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_14)
						.addComponent(btnLevel_9)
						.addComponent(btnLevel_8))
					.addGap(232)
					.addComponent(btnMainMenu)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		this.setLayout(gl_contentPane);
	}
}
