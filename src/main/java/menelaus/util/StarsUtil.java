package menelaus.util;

import java.util.Hashtable;

import menelaus.model.GameManager;
import menelaus.model.LevelStars;
import menelaus.model.basic.Color;
import menelaus.model.board.Board;
import menelaus.model.board.BoardTileInfo;
import menelaus.model.board.ColoredSetItem;

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
	
	static LevelStars gradePuzzle(GameManager gameManager) {
		int stars = 0;
		
		int piecesLeft = gameManager.getLevel().getBullpen().getPieces().size();
		if (piecesLeft <= 2) {
			stars = 3 - piecesLeft;
		}
		
		return new LevelStars(stars, gameManager.getLevel().getUuid());
	}
	
	static LevelStars gradeRelease(GameManager gameManager) {
		int completeSets = 0;
		for (Color color : Color.values()) {
			if (isSetComplete(color, gameManager.getLevel().getBoard())) {
				completeSets++;
			}
		}
		
		if (completeSets > 3) {
			completeSets = 3;
		}
		
		return new LevelStars(completeSets, gameManager.getLevel().getUuid());
	}
	
	static boolean isSetComplete(Color color, Board board) {
		Hashtable<Integer, Boolean> filledIn = new Hashtable<Integer, Boolean>();
		
		for (BoardTileInfo info : board.getTileInfo().values()) {
			ColoredSetItem item = info.getColoredSetItem();
			if (item == null || item.getColor() != color || info.getPiecePlaced() == null) {
				continue;
			}
			
			filledIn.put(item.getNumber(), true);
		}
		
		for (int i = 1; i <= 6; i++) {
			if (!filledIn.containsKey(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	static LevelStars gradeLightning(GameManager gameManager) {
		int emptyTiles = gameManager.getLevel().getBoard().getNumberOfEmptyTiles();
		int stars = 0;
		
		if (emptyTiles == 0) {
			stars = 3;
		} else if (emptyTiles <= 6) {
			stars = 2;
		} else if (emptyTiles <= 12) {
			stars = 1;
		}
		
		return new LevelStars(stars, gameManager.getLevel().getUuid());
	}
}
