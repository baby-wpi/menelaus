package menelaus.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.html.HTMLIsIndexElement;

import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.Board;
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
	
	public void clearSelectedPoints() {
		this.selectedPoints.clear();
	}
	
	public void setSelectedPoints(ArrayList<Point> backup) {
		clearSelectedPoints();
		for(int i = 0; i < backup.size(); i++) {
			this.selectedPoints.add(new Point(backup.get(i).getX(), backup.get(i).getY()));
		}
	}
	
	/**
	 * Clean the level up before saving it to make it playable.
	 * @return Whether the clean up is successful.
	 */
	boolean cleanUpLevel() {
		Board theBoard = this.currentProject.getBoard();
		while(theBoard.getPieces().size() > 0) {
			theBoard.removePiece(theBoard.getPieces().get(0)); //Remove all the pieces from the board. 
			// They're still in the bullpen.
		}
		return true;
	}
	
	public LevelsPackage loadLevel() {
		try {
			LevelsPackage pack = LevelsPackagePersistenceUtil.fromFile(new File("customLevels.boba"));
			return pack;
		}
		catch (IOException e) {
			return new LevelsPackage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new LevelsPackage();
		}
	}
	
	
	public boolean saveLevel() {
		///this.currentProject.
		//LevelsPackage pack = new LevelsPackage();
		LevelsPackage pack = loadLevel();
		cleanUpLevel();
		pack.addLevel(this.currentProject);
		//String outputFileName = this.getName() + ".lvlpkg";
		String outputFileName = "customLevels.boba";
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
