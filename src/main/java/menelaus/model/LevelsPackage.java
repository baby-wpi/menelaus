package menelaus.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author vouldjeff
 *
 */
public class LevelsPackage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Level> levels;

	public ArrayList<Level> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}

	public LevelsPackage() {
		super();
		this.levels = new ArrayList<Level>();
	}
	
	public void addLevel(Level level) {
		levels.add(level);
	}
}
