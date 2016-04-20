package menelaus.view.game;

import menelaus.controllers.ButtonLevelsController;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Created by frankegan on 4/10/16.
 */
public class LevelPlayScreen extends KabasujiPanel {

    /**
     * Create the panel.
     */
    public LevelPlayScreen() {
    	setBounds(100, 100, GameViewConfigurations.panelWidth, GameViewConfigurations.panelHeight);


        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel = new JLabel("PUZZLE LEVEL 2");
        JLabel lblMovesLeft = new JLabel("MOVES LEFT 3");

        /* BUTTONS */
        JButton btnRestart = new JButton("RESTART");
        JButton btnExitButton = new JButton("EXIT");
        
        /* CONNECT BUTTONS TO CONTROLLERS */
        btnExitButton.addActionListener(new ButtonLevelsController());
        
        JPanel BoardView = new JPanel();
        
        GroupLayout gl_contentPane = new GroupLayout(this);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel)
        					.addGap(29)
        					.addComponent(lblMovesLeft))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnExitButton)
        					.addGap(18)
        					.addComponent(btnRestart))
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(BoardView, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(BoardView, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(97)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblMovesLeft)
        						.addComponent(lblNewLabel))
        					.addGap(18)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnRestart)
        						.addComponent(btnExitButton))
        					.addGap(18)
        					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        this.setLayout(gl_contentPane);
    }
}