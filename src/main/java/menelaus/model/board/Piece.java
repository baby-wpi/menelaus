package menelaus.model.board;

import java.util.ArrayList;

public class Piece {
	Point position;
	ArrayList<Tile> tiles;
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}

	public Piece(Point position) {
		super();
		this.position = position;
		this.tiles = new ArrayList<Tile>();
		tiles.add(new Tile(new Point(0,0)));
	}
	
	void rotate() {
		throw new UnsupportedOperationException();
	}
	
	void flip() {
		throw new UnsupportedOperationException();
	}
	
	void addTile(Tile tile) {
		tiles.add(tile);
	}
}
