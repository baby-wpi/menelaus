package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.builder.BuilderWindowFrame;

public class BuilderExitButtonController implements ActionListener {

	public BuilderExitButtonController(){}
	
	public void actionPerformed(ActionEvent e) {
		BuilderWindowFrame.getInstance().close();		
	}

}
