package menelaus.view.builder;

import menelaus.controllers.ButtonBuilderMainMenuController;
import menelaus.controllers.ButtonBuilderStartController;
import menelaus.model.BuilderManager;
import menelaus.view.BoardView;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BuilderSelectScreen extends KabasujiPanel {
	private JTextField txtInstertName;
	private JTextField txtWidth;
	private JTextField txtHeight;

	BuilderManager manager;
	
	void initializeManager() {
		manager = new BuilderManager();
		
	}
	
	/**
	 * Create the panel.
	 */
	public BuilderSelectScreen() {
		initializeManager();
		
		JButton btnPuzzle = new JButton("Puzzle");
		
		JButton btnLightning = new JButton("Lightning");
		
		JButton btnRelease = new JButton("Release");
		
		txtInstertName = new JTextField();
		txtInstertName.setText("Insert Name");
		txtInstertName.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ButtonBuilderStartController());
		
		txtWidth = new JTextField();
		txtWidth.setText("Width");
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setText("Height");
		txtHeight.setColumns(10);
		
		JLabel lblX = new JLabel("x");

		JLabel lblBoardSize = new JLabel("Board Size");

		JPanel boardPanel = new BoardView(manager.getLevel().getBoard(),manager.getLevel());
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ButtonBuilderMainMenuController());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMainMenu)
								.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBoardSize)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblX)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtInstertName, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStart))
						.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtInstertName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnStart)
								.addComponent(btnMainMenu))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblX)
								.addComponent(lblBoardSize))
							.addGap(18)
							.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(267)
							.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		GroupLayout gl_boardPanel = new GroupLayout(boardPanel);
		gl_boardPanel.setHorizontalGroup(
			gl_boardPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 613, Short.MAX_VALUE)
		);
		gl_boardPanel.setVerticalGroup(
			gl_boardPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 598, Short.MAX_VALUE)
		);
		boardPanel.setLayout(gl_boardPanel);
		setLayout(groupLayout);

	}
}
