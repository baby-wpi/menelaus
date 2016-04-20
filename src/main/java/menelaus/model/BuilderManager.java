package menelaus.model;

import java.util.ArrayList;
import java.util.Stack;

import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.move.BuilderMove;

/** Manages a level builder.
 * 
 * @author sanjay
 *
 */
public class BuilderManager {
	Level currentProject;
	Stack<BuilderMove> moves;
	ArrayList<Point> selectedPoints;
	
	public final LevelType DEFAULT_LEVEL = LevelType.PUZZLE;
	public final int DEFAULT_WIDTH = 6;
	public final int DEFAULT_HEIGHT = 6;
	
	public BuilderManager() {
		this.currentProject = new Level(DEFAULT_LEVEL, DEFAULT_HEIGHT, DEFAULT_WIDTH);
	}
	
	public String getName() {
		return this.currentProject.name;
	}
	
	public Level getLevel() {
		return this.currentProject;
	}
	
	public LevelType getType() {
		return this.currentProject.type;
	}
	
	public int getWidth() {
		return this.currentProject.board.getWidth();
	}
	
	public int getHeight() {
		return this.currentProject.board.getHeight();
	}
	
	public void setLevelName(String name) {
		currentProject.name = name;
	}
	
	public void setLevelType(LevelType type) {
		currentProject.type = type;
	}
	
	
	public void createLevel(String name, LevelType type, int w, int h) {
		currentProject = new Level(type, h, w);
		setLevelName(name);
	}
	
	
	public void setSize(int w, int h) {
		this.currentProject.board.setWidth(w);
		this.currentProject.board.setHeight(h);
	}
	
	public boolean movePiece(BuilderMove m) {
		if (m.valid(currentProject)) {
			m.doMove(currentProject);
			moves.push(m);
			return true;
		}
		return false;
	}
	
}
