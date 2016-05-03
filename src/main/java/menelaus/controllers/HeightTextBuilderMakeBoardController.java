package menelaus.controllers;

import menelaus.model.BuilderManager;
import menelaus.view.BoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Sanjay.
 *
 */
public class HeightTextBuilderMakeBoardController implements ActionListener {
    BoardView boardView;
    BuilderManager manager;
    JTextField heightField;

    /**
     * constructor.
     * @param boardView
     * @param manager
     * @param heightField
     */
    public HeightTextBuilderMakeBoardController(BoardView boardView, BuilderManager manager, JTextField heightField) {
        this.boardView = boardView;
        this.manager = manager;
        this.heightField = heightField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleTextChanged(this.heightField.getText());
    }

    /**
     * Resizes the board dimensions to math the input number. Chops out any pieces that aren't in the specified dimensions.
     * @param newText The new dimension
     */
    void handleTextChanged(String newText) {
        int newHeight;
        try {
            newHeight = Integer.parseInt(newText);

        } catch (NumberFormatException e) {
            this.heightField.setText(this.manager.getHeight() + "");
            return;
        }
        this.manager.setSize(this.manager.getWidth(), newHeight);
//        //auto chop out pieces not available
//        if(newMajorSide(newHeight)) {
//            for (int x = manager.getWidth(); x < newHeight; x++) {
//                for (int y = 0; y < newHeight; y++) {
//                    manager.getLevel().getBoard().chopTileOut(new Point(x, y));
//                }
//            }
//        }
        this.boardView.repaint();
        this.heightField.repaint();
    }

    /**
     * This method is used to determine if the new dimension we're setting makes this dimension the longest.
     * @param newSideLen the new side length.
     * @return Is this now the longest side?
     */
    private boolean newMajorSide(int newSideLen) {
        return newSideLen > manager.getWidth();
    }
}
