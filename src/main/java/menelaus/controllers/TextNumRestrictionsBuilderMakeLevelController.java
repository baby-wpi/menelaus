package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import menelaus.model.BuilderManager;

public class TextNumRestrictionsBuilderMakeLevelController implements ActionListener{
	BuilderManager manager;
	JTextField view;
	
	public TextNumRestrictionsBuilderMakeLevelController(BuilderManager manager, JTextField view) {
		this.manager = manager;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		handleTextChanged(view.getText());
	}
	
	void handleTextChanged(String newText) {
		
		int newNumRestrictions;
		System.out.println();
		try {
			newNumRestrictions = Integer.parseInt(newText);
		} catch (NumberFormatException e) {
			System.err.println("Number of restrictions is Not a Number");
			return;
		}
		if (newNumRestrictions > 0) {
			switch(manager.getType()) {
			case LIGHTNING:
				//Set the max time
				manager.getLevel().setTimeLimit(newNumRestrictions);
				break;
			case PUZZLE:
				manager.getLevel().setMoveLimit(newNumRestrictions);
				break;
			case RELEASE:
				manager.getLevel().setMoveLimit(newNumRestrictions);
				break;
			}
		}
		else {
			System.err.println("Restriction should be above 0");
		}
		
	}
}
