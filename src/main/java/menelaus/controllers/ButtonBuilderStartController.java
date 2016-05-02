package menelaus.controllers;

import menelaus.model.BuilderManager;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.builder.BuilderLevelBuilderScreen;
import menelaus.view.builder.BuilderWindowFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBuilderStartController implements ActionListener {

    BuilderManager manager;

    public ButtonBuilderStartController(BuilderManager manager) {
        this.manager = manager;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
		
		try {
			BuilderWindowFrame.getInstance().swapPanel(new BuilderLevelBuilderScreen(manager));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}