package menelaus.controllers;

import menelaus.view.ExtraScreen;
import menelaus.view.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeExtraButtonController implements ActionListener {

	// The home screen JFrame that contains the levels button:
	HomeScreen home;
	
	public HomeExtraButtonController(HomeScreen home) {
		this.home = home;
	}
	
	public void actionPerformed(ActionEvent e) {
		ExtraScreen.main(null);
	}
}
