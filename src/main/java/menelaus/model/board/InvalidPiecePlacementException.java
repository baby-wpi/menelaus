package menelaus.model.board;

/**
 * Thrown whenever a piece is placed outside of the board.
 * @author vouldjeff
 *
 */
public class InvalidPiecePlacementException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPiecePlacementException() {
		super();
	}
}
