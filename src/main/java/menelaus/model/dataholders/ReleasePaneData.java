package menelaus.model.dataholders;

import menelaus.model.basic.Color;
import menelaus.model.board.ColoredSetItem;

public class ReleasePaneData {

	Color color;
	int number;
	public final int MAX_POSSIBLE = 6;
	public final int MIN_POSSIBLE = 1;
	
	public ReleasePaneData() {
		this.color = Color.BLUE;
		this.number = this.MIN_POSSIBLE;
	}
	
	public void incrementNumber() {
		this.number += 1;
		if(this.number > this.MAX_POSSIBLE) {
			this.number = this.MIN_POSSIBLE;
		}
	}
	
	public void changeColor() {
		switch (this.color) {
		case BLUE:
			this.color = Color.GREEN;
			break;

		case GREEN:
			this.color = Color.RED;
			break;
			
		case RED:
			this.color = Color.BLUE;
			break;
			
		default:
			break;
		}
	}
	
	public ColoredSetItem generateSetItem() {
		return new ColoredSetItem(this.color, this.number);
	}

}
