package menelaus.model;

import java.io.Serializable;
import java.util.UUID;

import menelaus.model.basic.LevelType;
import menelaus.model.board.Board;

public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	
	UUID uuid;
	String name;
	LevelType type;
	int moveLimit;
	int timeLimit;
	Board board;
	Bullpen bullpen;
	
	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LevelType getType() {
		return type;
	}
	
	public int getMoveLimit() {
		return moveLimit;
	}
	
	public void setMoveLimit(int moveLimit) {
		this.moveLimit = moveLimit;
	}
	
	public int getTimeLimit() {
		return timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Bullpen getBullpen() {
		return bullpen;
	}
	
	public void setBullpen(Bullpen bullpen) {
		this.bullpen = bullpen;
	}
	
	public Level(LevelType type, int boardHeight, int boardWidth) {
		super();
		this.moveLimit = 0;
		this.timeLimit = 0;
		this.type = type;
		this.uuid = UUID.randomUUID();
		this.bullpen = new Bullpen();
		this.board = new Board(boardHeight, boardWidth);
	}
}
