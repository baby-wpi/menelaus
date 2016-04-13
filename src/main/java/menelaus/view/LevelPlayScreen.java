package menelaus.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import menelaus.controllers.HomeLevelsButtonController;

import java.awt.*;

/**
 * Created by frankegan on 4/10/16.
 */
public class LevelPlayScreen extends JPanel {

    private JTable table;

    /**
     * Create the panel.
     */
    public LevelPlayScreen() {
        setBounds(100, 100, 1000, 750);


        JScrollPane scrollPane = new JScrollPane();

        table = new JTable();

        JLabel lblNewLabel = new JLabel("PUZZLE LEVEL 2");
        JLabel lblMovesLeft = new JLabel("MOVES LEFT 3");

        /* BUTTONS */
        JButton btnRestart = new JButton("RESTART");
        JButton btnExitButton = new JButton("EXIT");
        
        /* CONNECT BUTTONS TO CONTROLLERS */
        btnExitButton.addActionListener(new HomeLevelsButtonController());
        
        GroupLayout gl_contentPane = new GroupLayout(this);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblMovesLeft))
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnExitButton)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnRestart)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(table, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(table, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(lblMovesLeft))
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnRestart)
                                                        .addComponent(btnExitButton))
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        this.setLayout(gl_contentPane);
    }
}