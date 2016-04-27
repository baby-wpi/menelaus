package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.builder.BuilderLevelBuilderScreen;
import menelaus.view.builder.BuilderSelectScreen;
import menelaus.view.builder.BuilderWindowFrame;

public class ButtonBuilderStartController implements ActionListener {

	public ButtonBuilderStartController() {
	}

	public void actionPerformed(ActionEvent e) {
		BuilderSelectScreen sender = (BuilderSelectScreen) BuilderWindowFrame.getInstance().getPanel();
		BuilderWindowFrame.getInstance().swapPanel(new BuilderLevelBuilderScreen(sender.getManager()));
	}
}