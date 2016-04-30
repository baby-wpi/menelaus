package menelaus.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundManager {
    AudioClip click;
	
	private static SoundManager instance = new SoundManager();
	
	private SoundManager(){
		
	}
	
	public static SoundManager getInstance() {
		return instance;
	}
	
	public void playSound(SoundType type){
		switch (type) {
			case BUTTONSOUND:
				getSound("click.wav");
				break;
			case WINSOUND:
				getSound("win.wav");
				break;
			case LOSESOUND:
				getSound("lose.wav");
				break;
		}
	}
	
	private void getSound(String file_name) {
        URL urlClick = SoundManager.class.getResource(file_name);
		if(urlClick != null) {
			click = Applet.newAudioClip(urlClick);
			click.play();
		}
	}

}
