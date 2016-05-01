package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.builder.BuilderWindowFrame;

public class ButtonBuilderExitController implements ActionListener {

	public ButtonBuilderExitController(){}
	
	public void actionPerformed(ActionEvent e) {
		SoundManager.getInstance().playSound(SoundType.EXITSOUND);
		BuilderWindowFrame.getInstance().close();		
	}

}
