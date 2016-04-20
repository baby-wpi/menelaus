package menelaus.model.board;

import java.io.Serializable;

import menelaus.model.basic.Color;

/**
 * 
 * @author vouldjeff
 *
 */
public class ColoredSetItem implements Serializable {
	Color color;
	int number;
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public ColoredSetItem(Color color, int number) {
		super();
		this.color = color;
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + number;
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
		ColoredSetItem other = (ColoredSetItem) obj;
		if (color != other.color)
			return false;
		if (number != other.number)
			return false;
		return true;
	}
}
