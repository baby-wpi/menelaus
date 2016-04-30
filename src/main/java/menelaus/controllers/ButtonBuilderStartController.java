package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.builder.BuilderLevelBuilderScreen;
import menelaus.view.builder.BuilderSelectScreen;
import menelaus.view.builder.BuilderWindowFrame;

public class ButtonBuilderStartController implements ActionListener {

	public ButtonBuilderStartController() {
	}

	public void actionPerformed(ActionEvent e) {
		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
		
		try {
			BuilderWindowFrame.getInstance().swapPanel(new BuilderLevelBuilderScreen());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}