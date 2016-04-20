package menelaus.view.game;

import menelaus.controllers.ButtonHomeContinueController;
import menelaus.controllers.ButtonHomeExitController;
import menelaus.controllers.ButtonMainMenuController;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;

public class WinScreen extends JPanel {

	private KabasujiPanel contentPane;

	/**
	 * Create the frame.
	 */
	public WinScreen() {
		
		setBounds(KabasujiPanel.START_X, KabasujiPanel.START_Y, KabasujiPanel.WIDTH, KabasujiPanel.HEIGHT);
		contentPane = new KabasujiPanel();
		
		
		JLabel label = new JLabel("You Won!!!");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		
		JButton btnContinue = new JButton("Continue");
		//btnContinue.addActionListener(new ButtonHomeContinueController());
		
		JButton btnRestart = new JButton("Restart");
		//btnRestart.addActionListener(new Button);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonMainMenuController());
		
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
							.addGap(439))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(226, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(115)
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
