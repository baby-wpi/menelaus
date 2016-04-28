package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import menelaus.model.BuilderManager;
import menelaus.view.BoardView;

public class WidthTextBuilderMakeBoardController implements ActionListener{
	BoardView boardView;
	BuilderManager manager;
	JTextField widthField;
	public WidthTextBuilderMakeBoardController(BoardView boardView, BuilderManager manager, JTextField widthField) {
		this.boardView = boardView;
		this.manager = manager;
		this.widthField = widthField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		handleTextChanged(this.widthField.getText());
	}
	void handleTextChanged(String newText) {
		int newWidth;
		try {
			newWidth = Integer.parseInt(newText);
			
		} catch (NumberFormatException e) {
			this.widthField.setText(this.manager.getWidth() + "");
			return;
		}
		this.manager.setSize(newWidth, this.manager.getHeight());
		this.boardView.repaint();
		this.widthField.repaint();
		//this.manager.setSize(, h);
	}
	
}
