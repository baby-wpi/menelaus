package menelaus.view.builder;

import java.awt.Color;

import javax.swing.BorderFactory;
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
import menelaus.controllers.NameTextBuilderMakeBoardController;
import menelaus.controllers.RedoBuilderMakeLevelController;
import menelaus.controllers.SaveLevelButtonBuilderMakeLevelController;
import menelaus.controllers.TextNumRestrictionsBuilderMakeLevelController;
import menelaus.controllers.UndoBuilderMakeLevelController;
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

	//BullpenView panelAllBullpenView;
	//JPanel panelBullpenView;
	//JPanel panelBoardView;
	
	BuilderManager manager = new BuilderManager();
	BoardView panelBoardView;
	

	BullpenView panelBullpenView;

	// TODO: change panelAllBullpenView to bullpenView if necessary
	JPanel panelAllBullpenView;

	JButton btnMakePiece;
	JButton btnComplete;
	JButton btnUndo;
	JLabel lblMaxMoves;
	JButton btnRedo;
	
	void initializeControllers() {
		this.panelBoardView.addMouseListener(new BoardBuilderMakeLevelController(this.manager, this.panelBoardView));
		this.btnMakePiece.addActionListener(new MakePieceButtonBuilderMakeLevelController(this.manager,this.panelBoardView,this.panelBullpenView));
		this.txtMaxMoves.addActionListener(new TextNumRestrictionsBuilderMakeLevelController(this.manager,this.txtMaxMoves));
		this.btnComplete.addActionListener(new SaveLevelButtonBuilderMakeLevelController(manager));
		this.btnUndo.addActionListener(new UndoBuilderMakeLevelController(this.manager, this.panelBoardView, this.panelBullpenView));
		this.btnRedo.addActionListener(new RedoBuilderMakeLevelController(this.manager, this.panelBoardView, this.panelBullpenView));
		txtInsertName.addActionListener(new NameTextBuilderMakeBoardController(manager, txtInsertName));
	}
	
	void refreshComponentsByGame() {
		switch (this.manager.getType()) {
		case LIGHTNING:
			this.lblMaxMoves.setText("Max Time:");
			this.txtMaxMoves.setText(this.manager.getLevel().getTimeLimit() + "");
			break;
		default:
			this.lblMaxMoves.setText("Max Moves:");
			this.txtMaxMoves.setText(this.manager.getLevel().getMoveLimit() + "");
			break;
		}
		this.txtInsertName.setText(this.manager.getName());
		this.repaint();
	}
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public BuilderLevelBuilderScreen(BuilderManager manager) throws Exception {
		if (manager != null) {
			this.manager = manager;
		} else {
			throw new Exception("cannot pass null manager into BuilderLevelBuilderScreen constructor");
		}
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonBuilderMainMenuController());
		
		JButton btnReset = new JButton("Reset");
		
		btnComplete = new JButton("Complete");
		
		btnUndo = new JButton("Undo");
		
		btnMakePiece = new JButton("Make Piece");
		
		JButton btnMakeHint = new JButton("Make Hint");
		
		txtMaxMoves = new JTextField();
		txtMaxMoves.setText("Max Moves");
		txtMaxMoves.setColumns(10);
		
		txtInsertName = new JTextField();
		txtInsertName.setText("Insert Name");
		txtInsertName.setColumns(10);
		
		lblMaxMoves = new JLabel("Max Moves:");
		panelBoardView = new BoardView(this.manager.getLevel().getBoard(), this.manager.getLevel(),true);
		panelBoardView.setSelection(this.manager.getSelectedPoints());
		//panelBoardView = new JPanel();
		
		//panelAllBullpenView = new BullpenView(manager.getLevel().getBullpen());
		//panelBullpenView = new JPanel();
		panelAllBullpenView = new JPanel();
		
		/* TODO: change panelAllBullpenView to bullpenView if necessary
		 * if this is done remove the later two lines.
		 */
		panelAllBullpenView.setBorder(BorderFactory.createLineBorder(Color.black));
		panelAllBullpenView.setBackground(Color.white);
		
		panelBullpenView = new BullpenView(this.manager.getLevel().getBullpen());
		
		btnRedo = new JButton("Redo");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(294, Short.MAX_VALUE)
					.addComponent(panelAllBullpenView, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelBullpenView, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnExit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset))
						.addComponent(panelBoardView, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnComplete)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnUndo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRedo)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnMakePiece))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(txtInsertName, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMaxMoves)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtMaxMoves, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMakeHint)))))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelAllBullpenView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
						.addComponent(panelBullpenView, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnExit)
								.addComponent(btnReset))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtInsertName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaxMoves)
								.addComponent(txtMaxMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnComplete)
								.addComponent(btnUndo)
								.addComponent(btnMakeHint)
								.addComponent(btnMakePiece)
								.addComponent(btnRedo))
							.addGap(21)
							.addComponent(panelBoardView, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)))
					.addGap(21))
		);
		setLayout(groupLayout);
		initializeControllers();
		refreshComponentsByGame();
	}
}
