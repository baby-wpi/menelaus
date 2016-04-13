package menelaus.view;

import menelaus.controllers.HomeContinueButtonController;
import menelaus.controllers.HomeExitButtonController;
import menelaus.controllers.HomeExtraButtonController;
import menelaus.controllers.HomeLevelsButtonController;
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
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnContinue = new JButton("Continue");
        
		JButton btnLevels = new JButton("Levels");
		
		JButton btnExtra = new JButton("Extra");
		
		JButton btnExit = new JButton("Exit");
		
		
		/* CONNECT BUTTON TO CONTROLLERS */
		
		// TODO: 4/13/16 Add level from disk? 
        btnContinue.addActionListener(new HomeContinueButtonController(this, new Level(LevelType.LIGHTNING, 8, 8)));
		
        btnLevels.addActionListener(new HomeLevelsButtonController(this));
        
        btnExit.addActionListener(new HomeExitButtonController(this));
        
        btnExtra.addActionListener(new HomeExtraButtonController(this));
        
        
		JLabel lblKabasuji = new JLabel("KabaSuji");
		lblKabasuji.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(447, Short.MAX_VALUE)
					.addComponent(lblKabasuji)
					.addGap(436))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnContinue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(448))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnLevels, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(448))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnExtra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(448))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(448, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(275, Short.MAX_VALUE)
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
		contentPane.setLayout(gl_contentPane);
	}
}
