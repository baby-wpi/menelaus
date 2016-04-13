package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.builder.BuilderWindowFrame;
import menelaus.view.builder.HomeScreen;

public class BuilderMainMenuButtonController implements ActionListener {

	public BuilderMainMenuButtonController() {
	}

	public void actionPerformed(ActionEvent e) {
		BuilderWindowFrame.getInstance().swapPanel(new HomeScreen());
	}
}
