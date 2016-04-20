package menelaus.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author vouldjeff
 *
 */
public class SavedGames implements Serializable {
	private static final long serialVersionUID = 1L;
	
	ArrayList<LevelStars> stars;

	public ArrayList<LevelStars> getStars() {
		return stars;
	}

	public void setStars(ArrayList<LevelStars> stars) {
		this.stars = stars;
	}

	public SavedGames(ArrayList<LevelStars> stars) {
		super();
		this.stars = stars;
	}
	
	public void addLevelStars(LevelStars levelStars) {
		stars.add(levelStars);
	}
}
