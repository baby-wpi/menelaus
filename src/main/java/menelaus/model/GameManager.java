package menelaus.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import javax.swing.Timer;

import menelaus.model.events.GameEndListener;
import menelaus.model.events.GameEndReason;
import menelaus.model.events.GameTickListener;
import menelaus.model.move.Move;
import menelaus.util.GameUtil;

public class GameManager {
	Timer timer;
	Level level;
	Deque<Move> moves;
	int movesMade;
	int timePassed;
	
	private static final int TICK_TIME = 1000;
	private ArrayList<GameTickListener> tickListeners = new ArrayList<GameTickListener>();
	private ArrayList<GameEndListener> endListeners = new ArrayList<GameEndListener>();
	private boolean isRunning;
	
	public Level getLevel() {
		return level;
	}
	
	public int getMovesMade() {
		return movesMade;
	}

	public GameManager(Level level) {
		super();
		this.level = level;
		this.isRunning = false;
	}
	
	public void addGameEndListener(GameEndListener listener) {
        endListeners.add(listener);
    }
	
	public void addGameTickListener(GameTickListener listener) {
        tickListeners.add(listener);
    }
	
	public void performNewMove(Move move) {
		if (!isRunning) {
			throw new IllegalStateException("game is not running");
		}
		
		moves.add(move);
		move.perform(this.level);
		if (move.shouldAlterMoveCount()) {
			movesMade++;
		}
		
		if (GameUtil.hasGameEnded(this)) {
			stopGame();
			notifyEndListeners(GameEndReason.WON);
		}
		
		if (level.moveLimit > 0 && movesMade >= level.moveLimit) {
			stopGame();
			notifyEndListeners(GameEndReason.NO_MOVES);
		}
	}
	
	public void startGame() {
		this.movesMade = 0;
		this.timePassed = 0;
		this.moves = new ArrayDeque<Move>();
		this.isRunning = true;
		
		timer.setDelay(TICK_TIME);
		timer.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				timePassed++;
				if (level.timeLimit > 0 && timePassed >= level.timeLimit) {
					stopGame();
					notifyEndListeners(GameEndReason.NO_TIME);
				} else {
					notifyTickListeners();
				}
			}
		});
		timer.start();
	}
	
	public void UserGameEnd() {
		stopGame();
		notifyEndListeners(GameEndReason.USER);
	}
	
	private void notifyTickListeners() {
		for (GameTickListener listener : tickListeners) {
			listener.tick();
		}
	}
	
	private void notifyEndListeners(GameEndReason reason) {
		for (GameEndListener listener : endListeners) {
			listener.end(reason);
		}
	}
	
	private void stopGame() {
		this.isRunning = false;
		timer.stop();
	}
}
