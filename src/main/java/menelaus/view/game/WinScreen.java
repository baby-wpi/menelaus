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
		
		
		JLabel label = new JLabel("You Won!!!");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		
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
					.addContainerGap(417, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(406))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnExit)
							.addGap(452))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnRestart)
							.addGap(446))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnContinue)
							.addGap(439))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblScore)
							.addGap(461))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(248, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(18)
					.addComponent(lblScore)
					.addGap(81)
					.addComponent(btnContinue)
					.addGap(18)
					.addComponent(btnRestart)
					.addGap(18)
					.addComponent(btnExit)
					.addGap(216))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
