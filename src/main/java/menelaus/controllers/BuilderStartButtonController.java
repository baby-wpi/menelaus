package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.builder.BuilderLevelBuilderScreen;
import menelaus.view.builder.BuilderWindowFrame;

public class BuilderStartButtonController implements ActionListener {

	public BuilderStartButtonController() {
	}

	public void actionPerformed(ActionEvent e) {
		BuilderWindowFrame.getInstance().swapPanel(new BuilderLevelBuilderScreen());
	}
}