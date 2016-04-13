package menelaus.view;

import com.sun.istack.internal.Nullable;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by frankegan on 4/10/16.
 */
public class LevelPlayScreen extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(@Nullable String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LevelPlayScreen frame = new LevelPlayScreen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LevelPlayScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 669, 439);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        table = new JTable();

        JLabel lblNewLabel = new JLabel("PUZZLE LEVEL 2");

        JLabel lblMovesLeft = new JLabel("MOVES LEFT 3");

        JButton btnRestart = new JButton("RESTART");

        JButton btnNewButton = new JButton("EXIT");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
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
                                                .addComponent(btnNewButton)
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
                                                        .addComponent(btnNewButton))
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}