package menelaus.model.board;

import menelaus.model.basic.Coordinate;
import menelaus.model.basic.Point;

/**
 * 
 * @author vouldjeff
 *
 */
public class HintPiece extends Piece {

	public HintPiece(Point position) {
		super(position, new Coordinate(0.5f, 0.5f));
	}

}
