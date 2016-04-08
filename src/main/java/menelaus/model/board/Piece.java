package menelaus.model.board;

import java.util.ArrayList;
import java.util.Iterator;

import menelaus.model.basic.Point;

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
	
	public void rotate() {
		Iterator<Tile> iterator = tiles.iterator();
		
		while (iterator.hasNext()) {
			Tile tile = (Tile) iterator.next();
			Point newLocation = new Point(tile.getRelativePosition().getY(), 
					-tile.getRelativePosition().getX());
			
			tile.setRelativePosition(newLocation);
		}
	}
	
	public void flip() {
		Iterator<Tile> iterator = tiles.iterator();
		int maxX = 0;
		
		while (iterator.hasNext()) {
			Tile tile = (Tile) iterator.next();
			
			if (maxX < tile.getRelativePosition().getX()) {
				maxX = tile.getRelativePosition().getX();
			}
		}
		
		iterator = tiles.iterator();
		while (iterator.hasNext()) {
			Tile tile = (Tile) iterator.next();
			Point newLocation = new Point(maxX - tile.getRelativePosition().getX(), 
					tile.getRelativePosition().getY());
			
			tile.setRelativePosition(newLocation);
		}
	}
	
	public void addTile(Tile tile) {
		tiles.add(tile);
	}
	
	public Piece(Point position) {
		super();
		this.position = position;
		this.tiles = new ArrayList<Tile>();
		tiles.add(new Tile(new Point(0,0)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((tiles == null) ? 0 : tiles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (tiles == null) {
			if (other.tiles != null)
				return false;
		} else if (!tiles.equals(other.tiles))
			return false;
		return true;
	}
}
