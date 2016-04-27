package menelaus.controllers;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;

import menelaus.model.BuilderManager;

public class NameTextBuilderMakeBoardController implements ActionListener{

	BuilderManager manager;
	TextField nameTextView;
	
	public NameTextBuilderMakeBoardController(BuilderManager manager, TextField nameTextView) {
		this.manager = manager;
		this.nameTextView = nameTextView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		handleChangedText(nameTextView.getText());
	}
	
	
	void handleChangedText(String newText) {
		this.manager.setLevelName(newText);
	}

}
