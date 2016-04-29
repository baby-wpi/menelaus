package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.model.BuilderManager;
import menelaus.view.builder.BuilderLevelBuilderScreen;
import menelaus.view.builder.BuilderWindowFrame;

public class EditButtonBuilderHomeScreenController implements ActionListener{

	public EditButtonBuilderHomeScreenController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		BuilderManager manager = new BuilderManager();
		manager.loadLastLevel();
		try {
			BuilderWindowFrame.getInstance().swapPanel(new BuilderLevelBuilderScreen(manager));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
