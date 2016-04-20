package menelaus.view.game;

import menelaus.controllers.ButtonLevelSelectController;
import menelaus.controllers.ButtonMainMenuController;
import menelaus.model.Level;
import menelaus.model.LevelsPackage;
import menelaus.view.KabasujiPanel;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LevelSelectorScreen extends KabasujiPanel {
	/**
	 * Create the panel.
	 */
	public LevelSelectorScreen(LevelsPackage levelsPackage) {
		int count = 1;
		int numLevels = levelsPackage.getLevels().size();
		
		GroupLayout layout = new GroupLayout(this);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		SequentialGroup group = null;
		SequentialGroup groupVertical = layout.createSequentialGroup();
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ButtonMainMenuController());
		
		Dimension size;
		
		// For each level
		for (Level l : levelsPackage.getLevels()) {
			/* group = layout.createSequentialGroup() // in the beginning of every 4th time
			 * 
			 * group.addComponent()
			 * layout.setHorizontalGroup(group) // in the end of every 4th time
			 *   
			 * 
			 */
			JButton btnLevelX = new JButton(l.getName());
			btnLevelX.addActionListener(new ButtonLevelSelectController(this, null));	
			
			if (count == 1 || count == 5 || count == 9 || count == 13){

			}
			
			Insets insets = this.getInsets();
			this.add(btnLevelX);
			
			size = btnLevelX.getPreferredSize();
			btnLevelX.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
			
			if (count == 4 || count == 8 || count == 12 || count == 16 || count == numLevels){
			}
			
			count++;
		}
	}
}

//
//		GroupLayout gl_contentPane = new GroupLayout(this);
//		gl_contentPane.setHorizontalGroup(
//				gl_contentPane.createParallelGroup(Alignment.TRAILING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//								.addContainerGap()
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//										.addComponent(btnLevel)
//										.addComponent(btnLevel_2)
//										.addComponent(btnLevel_4)
//										.addComponent(btnLevel_6, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
//										.addComponent(btnLevel_8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
//								.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//										.addGroup(gl_contentPane.createSequentialGroup()
//												.addGap(10)
//												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//														.addComponent(btnLevel_10)
//														.addComponent(btnLevel_11)
//														.addComponent(btnLevel_12)
//														.addComponent(btnLevel_13, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
//														.addComponent(btnLevel_14, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
//												.addGap(14))
//										.addComponent(btnMainMenu, Alignment.TRAILING))
//								.addGap(340)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//										.addComponent(btnLevel_1)
//										.addComponent(btnLevel_3)
//										.addComponent(btnLevel_5)
//										.addComponent(btnLevel_7, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
//										.addComponent(btnLevel_9, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
//								.addContainerGap())
//		);
//		gl_contentPane.setVerticalGroup(
//				gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//								.addGap(41)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//										.addComponent(btnLevel_10)
//										.addComponent(btnLevel)
//										.addComponent(btnLevel_1))
//								.addGap(18)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//										.addComponent(btnLevel_11)
//										.addComponent(btnLevel_2)
//										.addComponent(btnLevel_3))
//								.addGap(18)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//										.addComponent(btnLevel_12)
//										.addComponent(btnLevel_4)
//										.addComponent(btnLevel_5))
//								.addGap(18)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//										.addComponent(btnLevel_13)
//										.addComponent(btnLevel_7)
//										.addComponent(btnLevel_6))
//								.addGap(18)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//										.addComponent(btnLevel_14)
//										.addComponent(btnLevel_9)
//										.addComponent(btnLevel_8))
//								.addGap(232)
//								.addComponent(btnMainMenu)
//								.addContainerGap(199, Short.MAX_VALUE))
//		);
//		this.setLayout(gl_contentPane);
//	}
