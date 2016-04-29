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

	//BullpenView panelAllBullpenView;
	//JPanel panelBullpenView;
	//JPanel panelBoardView;
	
	BuilderManager manager = new BuilderManager();
	BoardView panelBoardView;
	

	BullpenView panelBullpenView;

	JPanel panelAllBullpenView;

	JButton btnMakePiece;
	JButton btnComplete;
	JLabel lblMaxMoves;
	
	void initializeControllers() {
		this.panelBoardView.addMouseListener(new BoardBuilderMakeLevelController(this.manager, this.panelBoardView));
		this.btnMakePiece.addActionListener(new MakePieceButtonBuilderMakeLevelController(this.manager,this.panelBoardView,this.panelBullpenView));
		this.txtMaxMoves.addActionListener(new TextNumRestrictionsBuilderMakeLevelController(this.manager,this.txtMaxMoves));
		this.btnComplete.addActionListener(new SaveLevelButtonBuilderMakeLevelController(manager));
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
		
		JButton btnUndo = new JButton("Undo");
		
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
		panelBoardView.setBorder(BorderFactory.createLineBorder(Color.black));
		//panelBoardView = new JPanel();
		
		//panelAllBullpenView = new BullpenView(manager.getLevel().getBullpen());
		//panelBullpenView = new JPanel();
		panelAllBullpenView = new JPanel();
		
		panelBullpenView = new BullpenView(this.manager.getLevel().getBullpen());
		panelBullpenView.setBorder(BorderFactory.createLineBorder(Color.black));
		panelAllBullpenView.setBorder(BorderFactory.createLineBorder(Color.black));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelAllBullpenView, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelBullpenView, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelBoardView, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnExit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)
							.addGap(401)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtInsertName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxMoves)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtMaxMoves, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnComplete)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnUndo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMakePiece)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMakeHint)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMaxMoves)
								.addComponent(txtMaxMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInsertName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMakePiece)
								.addComponent(btnMakeHint)
								.addComponent(btnComplete)
								.addComponent(btnUndo)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExit)
								.addComponent(btnReset))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panelBullpenView, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
							.addComponent(panelAllBullpenView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panelBoardView, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
		);
		setLayout(groupLayout);
		initializeControllers();
		refreshComponentsByGame();
	}
}
