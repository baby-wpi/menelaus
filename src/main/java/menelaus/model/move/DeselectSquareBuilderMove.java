package menelaus.model.move;

import java.util.ArrayList;
import java.util.Hashtable;

import menelaus.model.BuilderManager;
import menelaus.model.Level;
import menelaus.model.basic.Point;
import menelaus.model.board.BoardTileInfo;

public class DeselectSquareBuilderMove extends BuilderMove {

	Point selectedPoint;
	public DeselectSquareBuilderMove(BuilderManager manager) {
		super(manager);
		this.manager = manager;
	}
	
	@Override
	public boolean undo(Level level) {
		this.manager.selectPoint(selectedPoint); //deselect the point
		return true;
	}

	@Override
	public boolean doMove(Level level) {
		//Don't do the move if invalid
		if(!valid(level)) return false;
		return this.manager.deselectPoint(selectedPoint); //If it's valid, select the point
	}

	@Override
	public boolean valid(Level level) {
		if(this.manager.getSelectedPoints().contains(selectedPoint)) {
			return true;
		}
		return false;
	}

}
