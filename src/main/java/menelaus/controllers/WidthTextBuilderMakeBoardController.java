package menelaus.controllers;

import menelaus.model.BuilderManager;
import menelaus.view.BoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//		//auto chop out pieces not available
//		if(newMajorSide(newWidth)) {
//			for (int x = 0; x < newWidth; x++) {
//				for (int y = manager.getHeight(); y < newWidth; y++) {
//					manager.getLevel().getBoard().chopTileOut(new Point(x, y));
//				}
//			}
//		}
		this.boardView.repaint();
		this.widthField.repaint();
		//this.manager.setSize(, h);
	}

	/**
	 * This method is used to determine if the new dimension we're setting makes this dimension the longest.
	 * @param newSideLen the new side length.
	 * @return Is this now the longest side?
	 */
	private boolean newMajorSide(int newSideLen) {
		return newSideLen > manager.getHeight();
	}
}
