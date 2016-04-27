package menelaus.model;

import menelaus.model.events.GameEndListener;
import menelaus.model.events.GameEndReason;
import menelaus.model.events.GameTickListener;
import menelaus.model.move.Move;
import menelaus.util.StarsUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * This class manages a Level which is played. Tracks time, executes moves and notifies
 * whenever a game has ended. Use this class to modify the game environment.
 * @author vouldjeff
 *
 */
public class GameManager {
	Timer timer;
	Level level;
	Deque<Move> moves;
	int movesMade;
	int timePassed;
	LevelStars levelStars;
	
	private static final int TICK_TIME = 1000;
	private ArrayList<GameTickListener> tickListeners = new ArrayList<GameTickListener>();
	private ArrayList<GameEndListener> endListeners = new ArrayList<GameEndListener>();
	private boolean isRunning;
	
	/**
	 * The Level which is played.
	 */
	public Level getLevel() {
		return level;
	}
	
	public int getMovesMade() {
		return movesMade;
	}
	
	public LevelStars getLevelStars() {
		return levelStars;
	}

	public GameManager(Level levelParam) {
		super();
		this.level = levelParam;
		this.isRunning = false;
		this.levelStars = new LevelStars(0, levelParam.getUuid());
		final GameManager _this = this;
		
		timer = new Timer(TICK_TIME, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timePassed++;
				levelStars = StarsUtil.getStars(_this);
				
				if (level.getTimeLimit() > 0 && timePassed >= level.getTimeLimit()) {
					stopGame();
					notifyEndListeners(GameEndReason.NO_TIME);
				} else {
					notifyTickListeners();
				}
			}
		});
	}
	
	public int getTimePassed() {
		return timePassed;
	}
	
	/**
	 * Register a listener for whenever the Game is won/finished.
	 * @param listener
	 */
	public void addGameEndListener(GameEndListener listener) {
        endListeners.add(listener);
    }
	
	/**
	 * Register a listener for the Timer ticking.
	 * @param listener
	 */
	public void addGameTickListener(GameTickListener listener) {
        tickListeners.add(listener);
    }
	
	/**
	 * Always allow GameManager to perform the moves. This method runs the move, checks the progress
	 * on the actual level, generates Stars and notifies if game is won.
	 * @param move The move to be performed.
	 */
	public void performNewMove(Move move) {
		if (!isRunning) {
			throw new IllegalStateException("game is not running");
		}
		
		moves.add(move);
		boolean successfulMove = move.doMove(this.level);
		if (!successfulMove) {
			return;
		}
		
		if (move.shouldAlterMoveCount()) {
			movesMade++;
		}
		
		levelStars = StarsUtil.getStars(this);
		
		if (levelStars.getStarsCount() == 3 || level.getBoard().isFull()) {
			stopGame();
			notifyEndListeners(GameEndReason.WON);
			return;
		}
		
		if (level.getMoveLimit() > 0 && movesMade >= level.getMoveLimit()) {
			stopGame();
			notifyEndListeners(GameEndReason.NO_MOVES);
		}
	}
	
	/**
	 * Call whenever the game starts. Starts timer.
	 */
	public void startGame() {
		this.movesMade = 0;
		this.timePassed = 0;
		this.moves = new ArrayDeque<Move>();
		this.isRunning = true;
	
		timer.start();
	}
	
	/**
	 * Call this method if Player wants to end game earlier. It stops timer.
	 */
	public void userEndsGame() {
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
