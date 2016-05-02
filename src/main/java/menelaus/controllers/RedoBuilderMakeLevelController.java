package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;

public class RedoBuilderMakeLevelController implements ActionListener {

	BuilderManager manager;
	BoardView boardView;
	BullpenView bullpenView;
	
	public RedoBuilderMakeLevelController(BuilderManager manager, BoardView boardView, BullpenView bullpenView) {
		this.manager = manager;
		this.boardView = boardView;
		this.bullpenView = bullpenView;
	}
	
	
	void doRedo() {
		manager.redo();
		boardView.repaint();
		bullpenView.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
		doRedo();
	}

}
