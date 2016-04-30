package menelaus.view.game;

import menelaus.controllers.PieceController;
import menelaus.controllers.PieceSelectionController;
import menelaus.controllers.RestartController;
import menelaus.controllers.ToWinScreenController;
import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.basic.LevelType;
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
 * @author Obatola Seward-Evans
 */
public class LevelPlayScreen extends KabasujiPanel {

	GameManager gameManager;
	BoardView boardView;
	BullpenView bullpenView;
	Level level = new Level(LevelType.PUZZLE, 700, 700);

	JLabel labelCountDown;

	private void gameEnded(GameEndReason reason) {
		SavedGamesUtil savedGamesUtil = GameWindowFrame.getInstance().getSavedGamesUtil();
		try {
			savedGamesUtil.addLevelStars(gameManager.getLevelStars());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Cannot write your progress to disk.");
		}

		JOptionPane.showMessageDialog(null, "Game ended. Reason: " + reason.toString());
		
		
		ToWinScreenController controller = new ToWinScreenController(gameManager.getLevelStars(), reason, level);
		controller.actionPerformed(null);
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
	 * @throws Exception 
	 */
	public LevelPlayScreen(Level inputLevel) throws Exception {
		
		if (inputLevel != null) {
			level = inputLevel;
		} else {
			throw new Exception("cannot pass null manager into LevelPlayScreen constructor");
		}
		
		initGameManager(level);

		setBounds(100, 100, GameViewConfigurations.panelWidth, GameViewConfigurations.panelHeight);

		JScrollPane scrollPane = new JScrollPane();

		JLabel labelLevelName = new JLabel(level.getType().toString() + " LEVEL: " + level.getName());
		labelLevelName.setMaximumSize(new Dimension(248, 16));
		
		labelCountDown = new JLabel("Time passed: 0");

        /* BUTTONS */
		
		/** Restart Button. */
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new RestartController(level));
		
		/** Exit Button. */
		JButton btnExitButton = new JButton("EXIT");
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameManager.userEndsGame();

//				ButtonLevelsController controller = new ButtonLevelsController();
				
				// TODO: find way to add reason.
				ToWinScreenController controller = new ToWinScreenController(gameManager.getLevelStars(), null, level);
				controller.actionPerformed(e);
			}
		});

		/** Create Board View */
		boardView = new BoardView(gameManager.getLevel().getBoard(), level);

		/** Create BullpenView */
		bullpenView = new BullpenView(gameManager.getLevel().getBullpen());

		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelCountDown)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnExitButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRestart))
								.addComponent(labelLevelName, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
							.addGap(7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(725, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(labelLevelName)
							.addGap(18)
							.addComponent(labelCountDown)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRestart)
								.addComponent(btnExitButton))
							.addGap(18)
							.addComponent(scrollPane)))
					.addContainerGap())
		);

		scrollPane.setViewportView(bullpenView);
		this.setLayout(gl_contentPane);

		PieceController pc = new PieceController(this, gameManager);
		boardView.addMouseListener(pc);
		boardView.addMouseMotionListener(pc);
		boardView.addMouseWheelListener(pc);

		PieceSelectionController psc = new PieceSelectionController(bullpenView, gameManager);
		bullpenView.addMouseListener(psc);

		gameManager.startGame();
	}
}