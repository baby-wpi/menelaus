package menelaus.model.basic;

import java.io.Serializable;

/**
 * 
 * @author vouldjeff
 *
 */
public class Point implements Serializable {
	int x;
	int y;
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point add(Point otherPoint) {
		return new Point(this.x + otherPoint.getX(), this.y + otherPoint.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "X = " + x + ", Y = " + y;
	}
	
	public boolean adjacentTo(Point other) {
		//The other one is adjacent if one of the coordinates is 1 block away, and the other is zero. That is...
		//Both are within 1 block.
		//Exactly 1 is 0 blocks away.
		return (
				(Math.abs(other.x-this.x) <= 1 && Math.abs(other.y-this.y) <= 1)
				&&
				(Math.abs(other.x-this.x) == 0 ^ Math.abs(other.y-this.y) == 0)
				);
	}
	
}
