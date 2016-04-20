package menelaus.model.board;

import java.io.Serializable;

/**
 * 
 * @author vouldjeff
 *
 */
public class BoardTileInfo implements Serializable {
	ColoredSetItem coloredSetItem;
	boolean isTileChopped;
	Piece piecePlaced;
	
	public ColoredSetItem getColoredSetItem() {
		return coloredSetItem;
	}
	
	public void setColoredSetItem(ColoredSetItem coloredSetItem) {
		this.coloredSetItem = coloredSetItem;
	}
	
	public boolean isTileChopped() {
		return isTileChopped;
	}
	
	public void setTileChopped(boolean isTileChopped) {
		this.isTileChopped = isTileChopped;
	}
	
	public Piece getPiecePlaced() {
		return piecePlaced;
	}
	
	public void setPiecePlaced(Piece piecePlaced) {
		this.piecePlaced = piecePlaced;
	}

	public BoardTileInfo(boolean isTileChopped) {
		super();
		this.isTileChopped = isTileChopped;
	}
}
