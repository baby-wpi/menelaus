package menelaus.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.html.HTMLIsIndexElement;

import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.move.BuilderMove;
import menelaus.util.LevelsPackagePersistenceUtil;

/** 
 * Manages a level builder.
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
		this.selectedPoints = new ArrayList<Point>();
		this.moves = new Stack<BuilderMove>();
		this.redoMoves = new Stack<BuilderMove>();
	}
	
	public String getName() {
		return this.currentProject.getName();
	}
	
	public Level getLevel() {
		return this.currentProject;
	}
	
	public LevelType getType() {
		return this.currentProject.getType();
	}
	
	public int getWidth() {
		return this.currentProject.getBoard().getWidth();
	}
	
	public int getHeight() {
		return this.currentProject.getBoard().getHeight();
	}
	
	public void setLevelName(String name) {
		currentProject.setName(name);
	}
	
	public void setLevelType(LevelType type) {
		// TODO: you can't just set the LevelType midway because the level might behave differently based on its type.
		// You should probably create a new Level
	}
	
	
	public void createLevel(String name, LevelType type, int w, int h) {
		currentProject = new Level(type, h, w);
		setLevelName(name);
	}
	
	
	public void setSize(int w, int h) {
		this.currentProject.getBoard().setWidth(w);
		this.currentProject.getBoard().setHeight(h);
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
	
	public boolean saveLevel() {
		///this.currentProject.
		LevelsPackage pack = new LevelsPackage();
		pack.addLevel(this.currentProject);
		String outputFileName = this.getName() + ".lvlpkg";
		File outputFile = new File(outputFileName);
		try {
			LevelsPackagePersistenceUtil.toFile(pack, outputFile);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
