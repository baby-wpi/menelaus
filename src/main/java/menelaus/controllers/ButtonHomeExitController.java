package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.HomeScreen;

public class ButtonHomeExitController implements ActionListener {
	
	// The home screen JFrame that contains the levels button:
	HomeScreen home;
	
	public ButtonHomeExitController(HomeScreen home) {
		this.home = home;
	}
	
	public ButtonHomeExitController() {
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().close();
	}

}
