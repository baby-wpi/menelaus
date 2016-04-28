package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import menelaus.model.BuilderManager;

public class NameTextBuilderMakeBoardController implements ActionListener{

	BuilderManager manager;
	JTextField nameTextView;
	
	public NameTextBuilderMakeBoardController(BuilderManager manager, JTextField nameTextView) {
		this.manager = manager;
		this.nameTextView = nameTextView;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		handleChangedText(nameTextView.getText());
	}
	
	
	void handleChangedText(String newText) {
		this.manager.setLevelName(newText);
	}

}
