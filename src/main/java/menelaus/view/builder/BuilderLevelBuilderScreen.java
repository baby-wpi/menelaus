package menelaus.view.builder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import menelaus.controllers.BoardBuilderMakeLevelController;
import menelaus.controllers.ButtonBuilderMainMenuController;
import menelaus.controllers.MakePieceButtonBuilderMakeLevelController;
import menelaus.controllers.SaveLevelButtonBuilderMakeLevelController;
import menelaus.controllers.TextNumRestrictionsBuilderMakeLevelController;
import menelaus.model.BuilderManager;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.KabasujiPanel;

/**
 * 
 * @author sanjay
 *
 */
public class BuilderLevelBuilderScreen extends KabasujiPanel {
	/**
	 * Keep eclipse happy with Cereal (Serial).
	 */
	private static final long serialVersionUID = -5145620117800309808L;
	private JTextField txtMaxMoves;
	private JTextField txtInsertName;

	BuilderManager manager;
	BoardView panelBoardView;
	//BullpenView panelAllBullpenView;
	BullpenView panelBullpenView;
	//JPanel panelBoardView;
	JPanel panelAllBullpenView;
	//JPanel panelBullpenView;
	JButton btnMakePiece;
	JButton btnComplete;
	
	void initializeControllers() {
		this.panelBoardView.addMouseListener(new BoardBuilderMakeLevelController(this.manager, this.panelBoardView));
		this.btnMakePiece.addActionListener(new MakePieceButtonBuilderMakeLevelController(this.manager,this.panelBoardView,this.panelBullpenView));
		this.txtMaxMoves.addActionListener(new TextNumRestrictionsBuilderMakeLevelController(this.manager,this.txtMaxMoves));
		this.btnComplete.addActionListener(new SaveLevelButtonBuilderMakeLevelController(manager));
	}
	
	/**
	 * Create the panel.
	 */
	public BuilderLevelBuilderScreen(BuilderManager manager) {
		this.manager = manager;
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonBuilderMainMenuController());
		
		JButton btnReset = new JButton("Reset");
		
		btnComplete = new JButton("Complete");
		
		JButton btnUndo = new JButton("Undo");
		
		btnMakePiece = new JButton("Make Piece");
		
		JButton btnMakeHint = new JButton("Make Hint");
		
		txtMaxMoves = new JTextField();
		txtMaxMoves.setText("Max Moves");
		txtMaxMoves.setColumns(10);
		
		txtInsertName = new JTextField();
		txtInsertName.setText("Insert Name");
		txtInsertName.setColumns(10);
		
		JLabel lblMaxMoves = new JLabel("Max Moves:");
		panelBoardView = new BoardView(manager.getLevel().getBoard(),manager.getLevel(),true);
		panelBoardView.setSelection(this.manager.getSelectedPoints());
		//panelBoardView = new JPanel();
		
		//panelAllBullpenView = new BullpenView(manager.getLevel().getBullpen());
		panelAllBullpenView = new JPanel();
		
		panelBullpenView = new BullpenView(manager.getLevel().getBullpen());
		//panelBullpenView = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
									.addComponent(btnComplete)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnUndo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMakePiece)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMakeHint))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelAllBullpenView, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelBullpenView, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelBoardView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelBoardView, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelBullpenView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelAllBullpenView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		setLayout(groupLayout);
		initializeControllers();
	}
}
