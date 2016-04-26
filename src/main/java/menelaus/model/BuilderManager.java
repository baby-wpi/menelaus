package menelaus.model;

import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.html.HTMLIsIndexElement;

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
	Stack<BuilderMove> redoMoves; 
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
	
	public boolean makeMove(BuilderMove m) {
		if (m.valid(currentProject)) {
			m.doMove(currentProject);
			moves.push(m);
			return true;
		}
		return false;
	}
	
	public boolean makeMoveAndClear(BuilderMove m) {
		if (makeMove(m)) {
			redoMoves.clear(); 
			//Just made a move, changing the board. So, any former redos are invalid.
			return true;
		}
		return false;
	}
	
	public boolean undo() {
		BuilderMove move = moves.pop();
		if (move.undo(currentProject)) {
			return true; //Just pass on the return if the undo works.
		}
		else {
			moves.push(move); //Push it back onto the stack because it was unsuccessful.
			return false;
		}
	}
	
	
	public boolean redo() {
		if (!redoMoves.empty()) {
			BuilderMove move = redoMoves.pop();
			if ( makeMove(move)) {
				return true;
			}
			else {
				redoMoves.push(move);
			}
		}
		return false;
	}
	
	public boolean selectPoint(Point x) {
		return this.selectedPoints.add(x);
	}
	
	public boolean deselectPoint(Point x) {
		return this.selectedPoints.remove(x);
	}
	
	public boolean deselectPointByIndex(int index) {
		if (index < this.selectedPoints.size()) {
			this.selectedPoints.remove(index);
			return true;
		}
		return false;
	}
	
	public int getNumSelectedPoints() {
		return this.selectedPoints.size();
	}
	
	public ArrayList<Point> getSelectedPoints() {
		return this.selectedPoints;
	}
}
