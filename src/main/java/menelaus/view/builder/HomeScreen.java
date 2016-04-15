package menelaus.view.builder;

import menelaus.controllers.BuilderExitButtonController;
import menelaus.controllers.BuilderLevelSelectController;
import menelaus.view.KabaSujiJPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;

public class HomeScreen extends KabaSujiJPanel {
	/**
	 * Create the panel.
	 */
	public HomeScreen() {

		JLabel lblKabasujiBuilder = new JLabel("KabaSuji Builder");
		lblKabasujiBuilder.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("Create Level");
		btnNewButton.addActionListener(new BuilderLevelSelectController());
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new BuilderExitButtonController());
		
		
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(406)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(lblKabasujiBuilder)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addGap(396))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(268, Short.MAX_VALUE)
					.addComponent(lblKabasujiBuilder)
					.addGap(24)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(258))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {lblKabasujiBuilder, btnNewButton, btnExit});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblKabasujiBuilder, btnNewButton, btnExit});
		this.setLayout(gl_contentPane);
	}
}
