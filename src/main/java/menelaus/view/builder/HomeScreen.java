package menelaus.view.builder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menelaus.controllers.ButtonBuilderExitController;
import menelaus.controllers.ButtonBuilderLevelSelectController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;

public class HomeScreen extends JPanel {
	/**
	 * Create the panel.
	 */
	public HomeScreen() {
		setBounds(100, 100, 1000, 750);

		JLabel lblKabasujiBuilder = new JLabel("KabaSuji Builder");
		lblKabasujiBuilder.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("Create Level");
		btnNewButton.addActionListener(new ButtonBuilderLevelSelectController());
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonBuilderExitController());
		
		
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
