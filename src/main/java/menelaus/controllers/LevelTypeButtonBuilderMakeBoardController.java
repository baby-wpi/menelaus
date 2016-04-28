package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.model.basic.LevelType;
import menelaus.view.builder.BuilderSelectScreen;

public class LevelTypeButtonBuilderMakeBoardController implements ActionListener{

	BuilderManager manager;
	LevelType type;
	BuilderSelectScreen screen;
	
	public LevelTypeButtonBuilderMakeBoardController(BuilderManager manager, LevelType type, BuilderSelectScreen screen) {
		this.manager = manager;
		this.type = type;
		this.screen = screen;
	}
	
	public void actionPerformed(ActionEvent e) {
		handleClick();
	}
	
	void handleClick() {
		manager.setLevelType(this.type);
		System.out.println(manager.getLevel().getType().name());
	}

}
