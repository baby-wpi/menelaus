package menelaus.model.board;

import menelaus.model.basic.Point;
import menelaus.view.PieceDrawer;

public class HintPiece extends Piece {

	public HintPiece(Point position) {
		super(position, new PieceDrawer());
	}

}
