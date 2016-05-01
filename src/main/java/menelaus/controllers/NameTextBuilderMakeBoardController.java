package menelaus.controllers;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import menelaus.model.BuilderManager;

public class NameTextBuilderMakeBoardController implements DocumentListener{

	BuilderManager manager;
	JTextField nameTextView;
	
	public NameTextBuilderMakeBoardController(BuilderManager manager, JTextField nameTextView) {
		this.manager = manager;
		this.nameTextView = nameTextView;
	}
	
	private void handleChangedText() {
		String newText = nameTextView.getText();
		this.manager.setLevelName(newText);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		handleChangedText();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		handleChangedText();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		handleChangedText();
	}

}
