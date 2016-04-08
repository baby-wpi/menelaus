package menelaus.model.board;

public class Tile {
	Point relativePosition;

	public Point getRelativePosition() {
		return relativePosition;
	}

	public void setRelativePosition(Point relativePosition) {
		this.relativePosition = relativePosition;
	}

	public Tile(Point relativePosition) {
		super();
		this.relativePosition = relativePosition;
	}
	
	public Tile(int x, int y) {
		super();
		this.relativePosition = new Point(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((relativePosition == null) ? 0 : relativePosition.hashCode());
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
		Tile other = (Tile) obj;
		if (relativePosition == null) {
			if (other.relativePosition != null)
				return false;
		} else if (!relativePosition.equals(other.relativePosition))
			return false;
		return true;
	}
}
