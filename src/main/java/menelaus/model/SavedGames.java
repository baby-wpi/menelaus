package menelaus.model;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.UUID;

/**
 * 
 * @author vouldjeff
 *
 */
public class SavedGames implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Hashtable<UUID, LevelStars> stars;

	public Hashtable<UUID, LevelStars> getStars() {
		return stars;
	}

	public void setStars(Hashtable<UUID, LevelStars> stars) {
		this.stars = stars;
	}

	public SavedGames(Hashtable<UUID, LevelStars> stars) {
		super();
		this.stars = stars;
	}
	
	public SavedGames() {
		super();
		this.stars = new Hashtable<UUID, LevelStars>();
	}
	
	public void addLevelStars(LevelStars levelStars) {
		stars.put(levelStars.getLevelId(), levelStars);
	}
	
	public LevelStars getStarsForLevel(Level level) {
		return stars.get(level.getUuid());
	}
}
