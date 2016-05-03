package menelaus.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import menelaus.model.BuilderManager;
import menelaus.model.dataholders.ReleasePaneData;
import menelaus.util.SoundManager;
import menelaus.util.SoundType;
import menelaus.view.builder.BuilderReleasePane;

/**
 * 
 * @author Sanjay.
 *
 */
public class ReleasePaneBuilderMakeLevelController implements MouseListener {

	
	BuilderReleasePane pane;
	ReleasePaneData data;
	BuilderManager manager;
	
	/**
	 * constructor.
	 * @param manager
	 * @param data
	 * @param pane
	 */
	public ReleasePaneBuilderMakeLevelController(BuilderManager manager, ReleasePaneData data, BuilderReleasePane pane){
		this.manager = manager;
		this.data = data;
		this.pane = pane;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SoundManager.getInstance().playSound(SoundType.BUTTONSOUND);
		if(SwingUtilities.isLeftMouseButton(e)) {
			handleIncrementNumber();
		}
		else if(SwingUtilities.isRightMouseButton(e)){
			handleChangeColor();
		}
		refreshView();
	}
	
	public void handleIncrementNumber() {
		this.data.incrementNumber();
	}
	
	public void handleChangeColor() {
		this.data.changeColor();
	}
	
	public void refreshView() {
		manager.setReleaseItem(this.data.generateSetItem());
		this.pane.setItem(this.data.generateSetItem());
		this.pane.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Do Nothing
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Do Nothing
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Do Nothing
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Do Nothing
		
	}
	
	
	

}
