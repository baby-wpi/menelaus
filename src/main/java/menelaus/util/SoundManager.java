package menelaus.util;

import java.awt.Toolkit;

import menelaus.view.game.GameWindowFrame;
import sun.security.action.GetBooleanAction;

public class SoundManager {
	
	private static SoundManager instance = new SoundManager();
	
	private SoundManager(){
		
	}
	
	public static SoundManager getInstance() {
		return instance;
	}
	
	public void playSound(SoundType type){
		switch (type) {
			case BUTTONSOUND:
				Toolkit.getDefaultToolkit().beep();
		}
		
	}

}
