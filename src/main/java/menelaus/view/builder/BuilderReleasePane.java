package menelaus.view.builder;

import java.awt.Graphics;

import javax.swing.JPanel;

import menelaus.model.board.ColoredSetItem;

public class BuilderReleasePane extends JPanel {

	/**
	 * Cereal to keep Eclipse Happy :)
	 */
	private static final long serialVersionUID = 8728359376463283367L;
	ColoredSetItem item;
	int width;
	int height;
	
	/**
	 * Create the panel.
	 */
	public BuilderReleasePane(ColoredSetItem item, int width, int height) {
		this.item = item;
		this.width = width;
		this.height = height;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.item.getJavaColor());
		g.drawChars((this.item.getNumber() + "").toCharArray(),0,1,(int)(this.width * 0.2),(int)(this.height * 0.8));
	}
	
	public void setItem(ColoredSetItem s) {
		this.item = s;
	}
}
