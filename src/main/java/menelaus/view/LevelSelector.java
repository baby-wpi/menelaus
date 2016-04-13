package menelaus.view;

import menelaus.controllers.LevelSelectButtonController;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLevel = new JButton("Level 1");
		btnLevel.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_1 = new JButton("Level 3");
		btnLevel_1.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_2 = new JButton("Level 4");
		btnLevel_2.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_3 = new JButton("Level 6");
		btnLevel_3.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_4 = new JButton("Level 7");
		btnLevel_4.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_5 = new JButton("Level 9");
		btnLevel_5.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_6 = new JButton("Level 10");
		btnLevel_6.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_7 = new JButton("Level 12");
		btnLevel_7.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_8 = new JButton("Level 13");
		btnLevel_8.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_9 = new JButton("Level 15");
		btnLevel_9.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_10 = new JButton("Level 2");
		btnLevel_10.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_11 = new JButton("Level 5");
		btnLevel_11.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_12 = new JButton("Level 8");
		btnLevel_12.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_13 = new JButton("Level 11");
		btnLevel_13.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnLevel_14 = new JButton("Level 14");
		btnLevel_14.addActionListener(new LevelSelectButtonController(this, null));
		
		JButton btnMainMenu = new JButton("Main Menu");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel)
								.addComponent(btnLevel_2)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnLevel_8, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(btnLevel_6, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(btnLevel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnLevel_14, 0, 0, Short.MAX_VALUE)
										.addComponent(btnLevel_13, 0, 0, Short.MAX_VALUE)
										.addComponent(btnLevel_12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnLevel_9, 0, 0, Short.MAX_VALUE)
										.addComponent(btnLevel_7, 0, 0, Short.MAX_VALUE)
										.addComponent(btnLevel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLevel_11)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnLevel_3))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnLevel_10)
									.addGap(81)
									.addComponent(btnLevel_1)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnMainMenu)
							.addGap(163))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel)
						.addComponent(btnLevel_1)
						.addComponent(btnLevel_10))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_2)
						.addComponent(btnLevel_3)
						.addComponent(btnLevel_11))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_4)
						.addComponent(btnLevel_5)
						.addComponent(btnLevel_12))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_6)
						.addComponent(btnLevel_7)
						.addComponent(btnLevel_13))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_8)
						.addComponent(btnLevel_9)
						.addComponent(btnLevel_14))
					.addGap(18)
					.addComponent(btnMainMenu)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
