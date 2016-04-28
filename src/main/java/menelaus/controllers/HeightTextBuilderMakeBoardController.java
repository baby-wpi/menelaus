package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import menelaus.model.BuilderManager;
import menelaus.view.BoardView;

public class HeightTextBuilderMakeBoardController implements ActionListener {
	BoardView boardView;
	BuilderManager manager;
	JTextField heightField;
	public HeightTextBuilderMakeBoardController(BoardView boardView, BuilderManager manager, JTextField heightField) {
		this.boardView = boardView;
		this.manager = manager;
		this.heightField = heightField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		handleTextChanged(this.heightField.getText());
	}
	void handleTextChanged(String newText) {
		int newHeight;
		try {
			newHeight = Integer.parseInt(newText);
			
		} catch (NumberFormatException e) {
			this.heightField.setText(this.manager.getHeight() + "");
			return;
		}
		this.manager.setSize(this.manager.getWidth(),newHeight);
		this.boardView.repaint();
		this.heightField.repaint();
		//this.manager.setSize(, h);
	}
}
