package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.ExtraScreen;
import menelaus.view.GameWindowFrame;
import menelaus.view.HomeScreen;

public class MainMenuButtonController implements ActionListener {

	// The home screen JFrame that contains the levels button:


	public MainMenuButtonController() {
	}

	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new HomeScreen());
	}
}
