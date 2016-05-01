package menelaus.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Sound Manager handles all game sounds.
 * @author Obatola Seward-Evans
 */
public class SoundManager {
    private AudioClip click;
    private boolean isMute = false;
	
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
		if (isMute) { return; } 
		
		switch (type) {
			case BUTTONSOUND:
				getSound("/assets/click.wav");
				break;
			case WINSOUND:
				getSound("/assets/win2.wav");
				break;
			case LOSESOUND:
				getSound("/assets/lose.wav");
				break;
			case COMPLETESOUND:
				getSound("/assets/complete.wav");
				break;
		default:
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
	
	/**
	 * set sound to be mute or not.
	 * @param isMute
	 */
	public void changeMute() {
		if (isMute) {
			isMute = false;
		} else {
			isMute = true;
		}
	}
	
	public boolean isMute(){
		return isMute;
	}

}
