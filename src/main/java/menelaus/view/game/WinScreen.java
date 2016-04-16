package menelaus.view.game;

import menelaus.view.KabaSujiJPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;

public class WinScreen extends JFrame {

	private KabaSujiJPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinScreen frame = new WinScreen();
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
	public WinScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(KabaSujiJPanel.START_X, KabaSujiJPanel.START_Y, KabaSujiJPanel.WIDTH, KabaSujiJPanel.HEIGHT);
		contentPane = new KabaSujiJPanel();
		setContentPane(contentPane);
		
		JLabel label = new JLabel("You Won!!!");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		
		JButton btnContinue = new JButton("Continue");
		
		JButton btnRestart = new JButton("Restart");
		
		JButton btnExit = new JButton("Exit");
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
