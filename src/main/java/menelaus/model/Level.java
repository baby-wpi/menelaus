package menelaus.model;

import menelaus.model.basic.LevelType;
import menelaus.model.board.Board;
import menelaus.model.board.Piece;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a Level that could be later played -- it has a Board, Bullpen and game constraints.
 * However, a game in progress is always managed by the GameManager and that is where the progress state is kept.
 * @author vouldjeff
 *
 */
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UUID uuid;
	private String name;
	private LevelType type;
	private int moveLimit;
	private int timeLimit;
	private Board board;
	private Bullpen bullpen;
	
	private Piece selected;
    private Piece active;
	
    /**
     * Gets the unique LevelID.
     * @return A UUID object
     */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * 
	 * @return
	 */
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
	
	public Level resetLevel(){
		
		for (Piece p : this.board.getPieces()){
			this.bullpen.addPiece(p);
		}
		this.board.setPieces(new ArrayList<Piece>());
		this.board.resetBoard();
		return this;
	}

	public void setSelected(Piece p) {
		selected = p;
	}

	/**
	 * Currently selected piece (or null if none). When a shape is
	 * selected, it is no longer part of the Model.
	 */
	public Piece getSelected() {
		return selected;
	}

    public void setActive(Piece active) {
        this.active = active;
    }

    /**
     * Currently actively dragged piece (or null if none). When a shape is
     * selected, it is no longer part of the Model.
     */
    public Piece getActive() {
        return active;
    }
}
