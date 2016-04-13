package menelaus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LevelSelector extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelector frame = new LevelSelector();
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
	public LevelSelector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLevel = new JButton("Level 1");
		
		JButton btnLevel_1 = new JButton("Level 3");
		
		JButton btnLevel_2 = new JButton("Level 4");
		
		JButton btnLevel_3 = new JButton("Level 6");
		
		JButton btnLevel_4 = new JButton("Level 7");
		
		JButton btnLevel_5 = new JButton("Level 9");
		
		JButton btnLevel_6 = new JButton("Level 10");
		
		JButton btnLevel_7 = new JButton("Level 12");
		
		JButton btnLevel_8 = new JButton("Level 13");
		
		JButton btnLevel_9 = new JButton("Level 15");
		
		JButton btnLevel_10 = new JButton("Level 2");
		
		JButton btnLevel_11 = new JButton("Level 5");
		
		JButton btnLevel_12 = new JButton("Level 8");
		
		JButton btnLevel_13 = new JButton("Level 11");
		
		JButton btnLevel_14 = new JButton("Level 14");
		
		JButton btnMainMenu = new JButton("Main Menu");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
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
		contentPane.setLayout(gl_contentPane);
	}
}
