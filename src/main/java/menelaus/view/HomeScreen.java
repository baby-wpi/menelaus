package menelaus.view;

import menelaus.controllers.HomeContinueButtonController;
import menelaus.model.Level;
import menelaus.model.basic.LevelType;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnContinue = new JButton("Continue");
        // TODO: 4/13/16 Add level form disk? 
        btnContinue.addActionListener(new HomeContinueButtonController(this, new Level(LevelType.LIGHTNING, 8, 8)));
		
		JButton btnLevels = new JButton("Levels");
		
		JButton btnExtra = new JButton("Extra");
		
		JButton btnExit = new JButton("Exit");
		
		JLabel lblKabasuji = new JLabel("KabaSuji");
		lblKabasuji.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(159)
					.addComponent(lblKabasuji)
					.addContainerGap(174, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(162)
					.addComponent(btnContinue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(177))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(162)
					.addComponent(btnLevels, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(177))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(162)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnExtra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(177))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblKabasuji)
					.addGap(12)
					.addComponent(btnContinue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLevels)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExtra)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
