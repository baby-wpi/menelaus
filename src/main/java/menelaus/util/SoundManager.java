package menelaus.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Sound Manager handles all game sounds.
 * @author Obatola Seward-Evans
 */
public class SoundManager {
    AudioClip click;
	
	private static SoundManager instance = new SoundManager();
	
	private SoundManager(){
		
	}
	
	/**
	 * get SoundManager instance.
	 * @return
	 */
	public static SoundManager getInstance() {
		return instance;
	}
	
	/**
	 * play sound from given given sound type.
	 * @param type
	 */
	public void playSound(SoundType type){
		switch (type) {
			case BUTTONSOUND:
				getSound("click.wav");
				break;
			case WINSOUND:
				getSound("win2.wav");
				break;
			case LOSESOUND:
				getSound("lose.wav");
				break;
		}
	}
	
	/**
	 * get sound from file and play.
	 * @param file_name
	 */
	private void getSound(String file_name) {
        URL urlClick = SoundManager.class.getResource(file_name);
		if(urlClick != null) {
			click = Applet.newAudioClip(urlClick);
			click.play();
		}
	}

}
