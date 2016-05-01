package menelaus.model;

import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.Board;
import menelaus.model.move.BuilderMove;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.view.builder.BuilderLevelBuilderScreen;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

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
		
		/*String name = getName();
		int width = getWidth();
		int height = getHeight();
		this.currentProject = new Level(type, width, height);
		setLevelName(name);*/
		this.currentProject.setType(type);
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
		if(moves.isEmpty()) return false;
		BuilderMove move = moves.pop();
		if (move.undo(currentProject)) {
			redoMoves.push(move);
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
	public void cleanUpLevel() {
		Board theBoard = this.currentProject.getBoard();
		while(theBoard.getPieces().size() > 0) {
			theBoard.removePiece(theBoard.getPieces().get(0)); //Remove all the pieces from the board. 
			// They're still in the bullpen.
		}
		return true;
	}
	
	public LevelsPackage loadLevel() {
		try {
			LevelsPackage pack = LevelsPackagePersistenceUtil.fromFile(new File("default-levels.boba"));
			return pack;
		}
		catch (IOException e) {
			return new LevelsPackage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new LevelsPackage();
		}
	}
	
	public void loadLastLevel() {
		LevelsPackage pack = loadLevel();
		if(pack.levels.size() > 1) {
			this.currentProject = pack.levels.get(pack.levels.size()-1);
		}
	}
	
	public boolean saveLevel() {
		LevelsPackage pack = loadLevel();
		cleanUpLevel();
		pack.addLevel(this.currentProject);
        String customPath  = "";

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File (System.getProperty("user.home")));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        try {
            if (chooser.showOpenDialog(new BuilderLevelBuilderScreen(this)) == JFileChooser.APPROVE_OPTION) {
                customPath = chooser.getSelectedFile().getPath() + File.separator;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String outputFileName = "package-name.boba";
		File outputFile = new File(customPath + outputFileName);
		try {
			LevelsPackagePersistenceUtil.toFile(pack, outputFile);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
