package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.builder.BuilderWindowFrame;

public class ButtonBuilderExitController implements ActionListener {

	public ButtonBuilderExitController(){}
	
	public void actionPerformed(ActionEvent e) {
		BuilderWindowFrame.getInstance().close();		
	}

}
