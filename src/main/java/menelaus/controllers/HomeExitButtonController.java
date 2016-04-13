package menelaus.controllers;

import menelaus.view.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeExitButtonController implements ActionListener {
	
	// The home screen JFrame that contains the levels button:
	HomeScreen home;
	
	public HomeExitButtonController(HomeScreen home) {
		this.home = home;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
