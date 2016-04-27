package menelaus.model.board;

import menelaus.model.basic.Coordinate;
import menelaus.model.basic.Point;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.validator.PublicClassValidator;

/**
 * @author vouldjeff
 */
public class Piece implements Serializable, Iterable<Coordinate>{
	private Point position;
	private ArrayList<Tile> tiles;
	private boolean selected;
	private Coordinate center;
    private Rectangle rect;
	
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
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
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
	
	public Piece(Point position, Coordinate center) {
		super();
		this.position = position;
		this.tiles = new ArrayList<Tile>();
        this.center = center;
		tiles.add(new Tile(new Point(0,0)));
	}
	
	public Piece(Point position) {
		this(position, new Coordinate(0.5f, 0.5f));
	}

    public int getHeight() {
        int max = 0, min = 0;
        for (Tile t : tiles) {
            int y = t.getRelativePosition().getY();
            if (y > max)
                max = y;
            else if (y < min)
                min = y;
        }
        return Math.abs(max) + Math.abs(min) + 1;//plus one for 0 indexing
    }

    public int getWidth() {
        int max = 0, min = 0;
        for (Tile t : tiles) {
            int x = t.getRelativePosition().getX();
            if (x > max)
                max = x;
            else if (x < min)
                min = x;
        }
        return Math.abs(max) + Math.abs(min) + 1;//plus one for 0 indexing
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

	public Coordinate getCenter() {
		return center;
	}

    public Rectangle getRect() {
        return rect;
    }

    public Iterator<Coordinate> iterator() {
        ArrayList<Coordinate> points = new ArrayList<Coordinate>(4);
        points.add(new Coordinate(0, 0));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(0, 1));

        return points.iterator();
    }
}
