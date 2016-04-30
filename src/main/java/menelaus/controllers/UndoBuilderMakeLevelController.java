package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;

public class UndoBuilderMakeLevelController implements ActionListener{

	BuilderManager manager;
	BoardView boardView;
	BullpenView bullpenView;
	
	public UndoBuilderMakeLevelController(BuilderManager manager, BoardView boardView, BullpenView bullpenView) {
		this.manager = manager;
		this.boardView = boardView;
		this.bullpenView = bullpenView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		doUndo();
	}
	
	void doUndo() {
		manager.undo();
		boardView.repaint();
		bullpenView.repaint();
	}
	
	
}
