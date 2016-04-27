package menelaus.controllers;

import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.model.move.MakePieceBuilderMove;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;

public class MakePieceBuilderMakeLevelController implements ActionListener{

	BullpenView bullpenView;
	BoardView boardView;
	BuilderManager manager;
	
	public MakePieceBuilderMakeLevelController(BullpenView bullpenView, BoardView boardView, BuilderManager manager) {
		this.bullpenView = bullpenView;
		this.boardView = boardView;
		this.manager = manager;
	}
	
	public void actionPerformed(java.awt.event.ActionEvent e) {
		
	};
	
	void handleClick() {
		MakePieceBuilderMove move = new MakePieceBuilderMove(manager);
		if(move.valid(manager.getLevel())) {
			this.manager.makeMove(move);
			bullpenView.repaint();
			boardView.repaint();
			System.out.println("Make Piece Move Successful!");
		}
		else {
			System.out.println("Make Piece Move Failed!");
		}
	}
	
}
