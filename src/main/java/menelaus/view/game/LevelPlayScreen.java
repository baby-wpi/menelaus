package menelaus.view.game;

import menelaus.controllers.ButtonLevelsController;
import menelaus.controllers.PieceController;
import menelaus.controllers.PieceSelectionController;
import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.events.GameEndListener;
import menelaus.model.events.GameEndReason;
import menelaus.model.events.GameTickListener;
import menelaus.util.SavedGamesUtil;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author fegan
 * @author vouldjeff
 */
public class LevelPlayScreen extends KabasujiPanel {
	
	GameManager gameManager;
    BoardView boardView;
    BullpenView bullpenView;
    
    JLabel labelCountDown;
    
    private void gameEnded(GameEndReason reason) {
    	SavedGamesUtil savedGamesUtil = GameWindowFrame.getInstance().getSavedGamesUtil();
    	try {
			savedGamesUtil.addLevelStars(gameManager.getLevelStars());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Cannot write your progress to disk.");
		}
    	
    	JOptionPane.showMessageDialog(null, "Game eneded. Reason: " + reason.toString());
    }
    
    private void initGameManager(Level level) {
    	gameManager = new GameManager(level);
    	gameManager.addGameEndListener(new GameEndListener() {
			public void end(GameEndReason reason) {
				gameEnded(reason);
			}
		});
    	
    	gameManager.addGameTickListener(new GameTickListener() {
			public void tick() {
				labelCountDown.setText("Time passed: " + gameManager.getTimePassed());
			}
		});
    }

    public BullpenView getBullpenView(){
        return bullpenView;
    }

    public BoardView getBoardView(){
        return boardView;
    }
	
    /**
     * Create the panel.
     */
    public LevelPlayScreen(Level level) {
    	initGameManager(level);
    	
    	setBounds(100, 100, GameViewConfigurations.panelWidth, GameViewConfigurations.panelHeight);

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel = new JLabel(level.getType().toString() + " LEVEL: " + level.getName());
        labelCountDown = new JLabel("Time passed: 0");

        /* BUTTONS */
        JButton btnRestart = new JButton("RESTART");
        JButton btnExitButton = new JButton("EXIT");

        btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameManager.userEndsGame();
				
				ButtonLevelsController controller = new ButtonLevelsController();
				controller.actionPerformed(e);
			}
		});
        
        /** Create Board View */
        boardView = new BoardView(gameManager.getLevel().getBoard(), level);
        boardView.setBackground(Color.WHITE);
        boardView.setBorder(BorderFactory.createLineBorder(Color.black));
        
        /** Create BullpenView */
        bullpenView = new BullpenView(gameManager.getLevel().getBullpen());
        
        GroupLayout gl_contentPane = new GroupLayout(this);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnExitButton)
        					.addGap(18)
        					.addComponent(btnRestart))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel)
        					.addGap(29)

        					.addComponent(labelCountDown)))
        			.addGap(16)
        			.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(16, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(34, Short.MAX_VALUE)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(labelCountDown)
        						.addComponent(lblNewLabel))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnRestart)
        						.addComponent(btnExitButton))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        
        scrollPane.setViewportView(bullpenView);
        this.setLayout(gl_contentPane);

        PieceController pc = new PieceController(this, level);
        boardView.addMouseListener(pc);
        boardView.addMouseMotionListener(pc);
        boardView.addMouseWheelListener(pc);

        PieceSelectionController psc = new PieceSelectionController(bullpenView, level);
        bullpenView.addMouseListener(psc);
        
        gameManager.startGame();
    }
}