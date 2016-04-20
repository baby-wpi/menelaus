package menelaus.util;

import menelaus.model.GameManager;
import menelaus.model.LevelStars;

/**
 * 
 * @author vouldjeff
 *
 */
public class StarsUtil {
	public static LevelStars getStars(GameManager gameManager) {
		switch (gameManager.getLevel().getType()) {
		case LIGHTNING:
			return gradeLightning(gameManager);
		case RELEASE:
			return gradeRelease(gameManager);
		default:
			return gradePuzzle(gameManager);
		}
	}
	
	private static LevelStars gradePuzzle(GameManager gameManager) {
		// TODO
		return new LevelStars(3, gameManager.getLevel().getUuid());
	}
	
	private static LevelStars gradeRelease(GameManager gameManager) {
		// TODO
		return new LevelStars(3, gameManager.getLevel().getUuid());
	}
	
	private static LevelStars gradeLightning(GameManager gameManager) {
		// TODO
		return new LevelStars(3, gameManager.getLevel().getUuid());
	}
}
