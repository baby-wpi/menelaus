package menelaus.model.board;

import menelaus.model.basic.Point;
import menelaus.view.PieceDrawer;

import java.util.ArrayList;
import java.util.Iterator;

public class Piece {
	Point position;
	ArrayList<Tile> tiles;
	PieceDrawer pieceDrawer;
	
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
	
	public Piece(Point position, PieceDrawer pieceDrawer) {
		super();
		this.position = position;
		this.tiles = new ArrayList<Tile>();
		tiles.add(new Tile(new Point(0,0)));
		this.pieceDrawer = pieceDrawer;
	}

    public int getHeight(){
        // TODO: 4/19/16 Run through tiles to find height
        return 3;
    }

    public int getWidth(){
        // TODO: 4/19/16 Run through tiles to find width
        return 2;
    }

    /**
     * A method for accessing this pieces drawer.
     *
     * Every piece should be able to draw itself.
     * @return the drawer we're using to draw the piece.
     */
    public PieceDrawer getDrawer(){
        return pieceDrawer;
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
