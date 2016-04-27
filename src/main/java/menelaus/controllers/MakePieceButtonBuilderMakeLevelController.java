package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.model.move.MakePieceBuilderMove;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;



public class MakePieceButtonBuilderMakeLevelController implements ActionListener{

	BuilderManager manager;
	BoardView boardView;
	BullpenView bullpenView;
	
	public MakePieceButtonBuilderMakeLevelController(BuilderManager manager, BoardView view, BullpenView penView) {
		this.manager = manager;
		this.boardView = view;
		this.bullpenView = penView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		handleButtonClicked();
	}
	
	public void handleButtonClicked() {
		MakePieceBuilderMove move = new MakePieceBuilderMove(manager);
		if(move.valid(manager.getLevel())) {
			manager.makeMove(move);
			System.out.println("Move successful!");
			boardView.repaint();
			bullpenView.repaint();
		}
		else {
			System.out.println("Move failed!");
		}
	}
	
}
