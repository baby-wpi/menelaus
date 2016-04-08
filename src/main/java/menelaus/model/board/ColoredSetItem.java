package menelaus.model.board;

import menelaus.model.basic.Color;

public class ColoredSetItem {
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
}
