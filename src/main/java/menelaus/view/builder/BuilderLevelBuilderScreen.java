package menelaus.view.builder;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import menelaus.controllers.BuilderMainMenuButtonController;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class BuilderLevelBuilderScreen extends JPanel {
	private JTextField txtMaxMoves;
	private JTextField txtInsertName;

	/**
	 * Create the panel.
	 */
	public BuilderLevelBuilderScreen() {
		setBounds(100, 100, 1000, 750);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new BuilderMainMenuButtonController());
		
		JButton btnReset = new JButton("Reset");
		
		JButton btnComplete = new JButton("Complete");
		
		JButton btnUndo = new JButton("Undo");
		
		JButton btnMakePiece = new JButton("Make Piece");
		
		JButton btnMakeHint = new JButton("Make Hint");
		
		txtMaxMoves = new JTextField();
		txtMaxMoves.setText("Max Moves");
		txtMaxMoves.setColumns(10);
		
		txtInsertName = new JTextField();
		txtInsertName.setText("Insert Name");
		txtInsertName.setColumns(10);
		
		JLabel lblMaxMoves = new JLabel("Max Moves:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblBoardGoesHere = new JLabel("Board Goes Here");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(279)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnExit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset))
						.addComponent(txtInsertName))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblMaxMoves)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMaxMoves, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBoardGoesHere)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnComplete)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnUndo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMakePiece)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMakeHint)))
					.addContainerGap(124, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(575, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtInsertName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxMoves)
						.addComponent(txtMaxMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnReset)
						.addComponent(btnComplete)
						.addComponent(btnUndo)
						.addComponent(btnMakePiece)
						.addComponent(btnMakeHint))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
							.addGap(16))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(319)
							.addComponent(lblBoardGoesHere)
							.addContainerGap())))
		);
		
		JLabel lblBullpen = new JLabel("BullPen");
		scrollPane_1.setColumnHeaderView(lblBullpen);
		
		JLabel lblAllPieces = new JLabel("All Pieces");
		scrollPane.setColumnHeaderView(lblAllPieces);
		setLayout(groupLayout);

	}
}
