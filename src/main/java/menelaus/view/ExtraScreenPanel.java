package menelaus.view;

import javax.swing.JPanel;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import menelaus.controllers.MainMenuButtonController;

public class ExtraScreenPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ExtraScreenPanel() {
		setBounds(100, 100, 1000, 750);
		
		/* Buttons */
		JButton btnLoadLevel = new JButton("Load Level");
		JButton btnMainMenu = new JButton("Main Menu");
		
		/* CONNECT BUTTON TO CONTROLLERS */
		btnMainMenu.addActionListener(new MainMenuButtonController());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(444)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMainMenu)
								.addComponent(btnLoadLevel))
						.addContainerGap(444, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(343)
						.addComponent(btnLoadLevel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnMainMenu)
						.addContainerGap(343, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}

}
