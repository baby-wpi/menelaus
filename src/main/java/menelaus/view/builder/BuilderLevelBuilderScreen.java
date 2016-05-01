package menelaus.view.builder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import static javax.swing.ScrollPaneConstants.*;

import menelaus.controllers.BoardBuilderMakeLevelController;
import menelaus.controllers.ButtonBuilderMainMenuController;
import menelaus.controllers.MakePieceButtonBuilderMakeLevelController;
import menelaus.controllers.NameTextBuilderMakeBoardController;
import menelaus.controllers.RedoBuilderMakeLevelController;
import menelaus.controllers.SaveLevelButtonBuilderMakeLevelController;
import menelaus.controllers.TextNumRestrictionsBuilderMakeLevelController;
import menelaus.controllers.UndoBuilderMakeLevelController;
import menelaus.controllers.*;
import menelaus.model.AllPieceBullpen;
import menelaus.model.BuilderManager;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	
	BuilderManager manager = new BuilderManager();
	BoardView panelBoardView;
	//the view for the corresponding bullpen
	BullpenView panelBullpenView;
	//the AllPieceBullpen
	BullpenView panelAllBullpenView;

	JButton btnMakePiece;
	JButton btnComplete;
	JButton btnUndo;
	JLabel lblMaxMoves;
	JButton btnRedo;

	void initializeControllers() {
		this.panelBoardView.addMouseListener(new BoardBuilderMakeLevelController(this.manager, this.panelBoardView));
		this.btnMakePiece.addActionListener(new MakePieceButtonBuilderMakeLevelController(this.manager,this.panelBoardView,this.panelBullpenView));
		this.txtMaxMoves.getDocument().addDocumentListener(new TextNumRestrictionsBuilderMakeLevelController(this.manager,this.txtMaxMoves));
		this.btnComplete.addActionListener(new SaveLevelButtonBuilderMakeLevelController(manager));
		this.btnUndo.addActionListener(new UndoBuilderMakeLevelController(this.manager, this.panelBoardView, this.panelBullpenView));
		this.btnRedo.addActionListener(new RedoBuilderMakeLevelController(this.manager, this.panelBoardView, this.panelBullpenView));
		txtInsertName.getDocument().addDocumentListener(new NameTextBuilderMakeBoardController(manager, txtInsertName));
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
	public BuilderLevelBuilderScreen() {
		this.manager = new BuilderManager();
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonBuilderMainMenuController());
		
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

		btnRedo = new JButton("Redo");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnExit)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnUndo)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnRedo)
								.addGap(18)
								.addComponent(lblMaxMoves)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtMaxMoves, 0, 0, Short.MAX_VALUE))
							.addComponent(panelBoardView, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnMakePiece)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnMakeHint)
								.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
								.addComponent(btnComplete)))
						.addComponent(txtInsertName, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(87, Short.MAX_VALUE)
					.addComponent(txtInsertName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnUndo)
						.addComponent(btnRedo)
						.addComponent(lblMaxMoves)
						.addComponent(txtMaxMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMakePiece)
						.addComponent(btnMakeHint)
						.addComponent(btnComplete))
					.addGap(18)
					.addComponent(panelBoardView, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addGap(77))
		);
		
		panelBullpenView = new BullpenView(this.manager.getLevel().getBullpen());
		panelBullpenView.setPreferredSize(new Dimension(240, 2200));
		scrollPane_1.setViewportView(panelBullpenView);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane_1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		panelAllBullpenView = new BullpenView(new AllPieceBullpen());
		panelAllBullpenView.setPreferredSize(new Dimension(240, 2200));
		scrollPane.setViewportView(panelAllBullpenView);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		setLayout(groupLayout);
		initializeControllers();
		refreshComponentsByGame();
	}
}
