package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.model.basic.LevelType;

public class LevelTypeButtonBuilderMakeBoardController implements ActionListener{

	BuilderManager manager;
	LevelType type;
	
	public LevelTypeButtonBuilderMakeBoardController(BuilderManager manager, LevelType type) {
		this.manager = manager;
		this.type = type;
	}
	
	public void actionPerformed(ActionEvent e) {
		handleClick();
	}
	
	void handleClick() {
		manager.setLevelType(this.type);
		System.out.println(manager.getLevel().getType().name());
	}

}
