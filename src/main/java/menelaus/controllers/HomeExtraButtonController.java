package menelaus.controllers;

import menelaus.view.ExtraScreen;
import menelaus.view.GameWindowFrame;
import menelaus.view.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeExtraButtonController implements ActionListener {

	// The home screen JFrame that contains the levels button:


	public HomeExtraButtonController() {
	}

	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new ExtraScreen());
	}
}
