package menelaus.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * 
 * @author vouldjeff
 *
 */
public class LevelStars implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int starsCount;
	UUID levelId;
	
	public int getStarsCount() {
		return starsCount;
	}
	
	public void setStarsCount(int starsCount) {
		if (starsCount < 0 || starsCount > 3) {
			throw new IllegalArgumentException();
		}
		
		this.starsCount = starsCount;
	}
	
	public UUID getLevelId() {
		return levelId;
	}
	
	public void setLevelId(UUID levelId) {
		this.levelId = levelId;
	}

	public LevelStars(int starsCount, UUID levelId) {
		super();
		this.starsCount = starsCount;
		this.levelId = levelId;
	}
}
