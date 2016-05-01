package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.builder.BuilderSelectScreen;
import menelaus.view.builder.BuilderWindowFrame;

public class ButtonBuilderLevelSelectController implements ActionListener {
	
	public ButtonBuilderLevelSelectController(){ }

	public void actionPerformed(ActionEvent e) {
		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
		
		BuilderWindowFrame.getInstance().setCurrentPackage(null);
		BuilderWindowFrame.getInstance().swapPanel(new BuilderSelectScreen());
	}

}
