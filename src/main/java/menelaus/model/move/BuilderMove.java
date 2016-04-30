package menelaus.model.move;

import menelaus.model.BuilderManager;
import menelaus.model.Level;

public abstract class BuilderMove {
	BuilderManager manager;
	
	public BuilderMove(BuilderManager manager) {
		this.manager = manager;
	}
	
	public abstract boolean valid(Level level);
	
	public abstract boolean doMove(Level level);
	
	public abstract boolean undo(Level level);

}
