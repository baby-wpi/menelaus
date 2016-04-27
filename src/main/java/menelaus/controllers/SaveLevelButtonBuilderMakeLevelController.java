package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.view.builder.BuilderWindowFrame;
import menelaus.view.builder.HomeScreen;

public class SaveLevelButtonBuilderMakeLevelController implements ActionListener{
	BuilderManager manager;
	public SaveLevelButtonBuilderMakeLevelController(BuilderManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		save();
		quit();
	}

	void save() {
		manager.saveLevel();
	}
	
	void quit() {
		BuilderWindowFrame.getInstance().swapPanel(new HomeScreen());
	}
}
