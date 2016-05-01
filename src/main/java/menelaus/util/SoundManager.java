package menelaus.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Sound Manager handles all game sounds.
 * @author Obatola Seward-Evans
 */
public class SoundManager {
    private AudioClip click;
    
    private boolean isMute = false;
    
    /** HashTable for memoization. */
    private Map<SoundType, AudioClip> clipTable = new HashMap<SoundType, AudioClip>();
    String filePath;
	
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
	
	
	/*
	 * check in hashtable
	 * if not 
	 * 		put in hash table
	 * if so
	 * 		play sound with that sound clip
	 */
	
	/**
	 * play sound from given given sound type.
	 * @param type
	 * @author Obatola Seward-Evans
	 */
	public void playSound(SoundType type){
		if (isMute) { return; } 
		
		switch (type) {
			case BUTTONSOUND:
				getPlaySound("/assets/click.wav", type);
				break;
			case WINSOUND:
				getPlaySound("/assets/win2.wav", type);
				break;
			case LOSESOUND:
				getPlaySound("/assets/lose.wav", type);
				break;
			case COMPLETESOUND:
				getPlaySound("/assets/complete.wav", type);
				break;
			case EXITSOUND:
				getPlaySound("/assets/close_app.wav", type);
				break;
			case PRESSPIECE:
				getPlaySound("/assets/place_piece.wav", type);
				break;
			case PRESSTILE:
				getPlaySound("/assets/click_tile.wav", type);
				break;
			case RESTARTSOUND:
				getPlaySound("/assets/restart.wav", type);
				break;
			default:
				break;
		}
	}
	
	/**
	 * check if the audio clip is in hashtable, if so play, if not put clip in.
	 * @author Obatola Seward-Evans
	 * @param file_path
	 * @param soundType
	 */
	public void getPlaySound(String filePath, SoundType soundType) {
		if (clipTable.containsKey(soundType)) {
			clipTable.get(soundType).play();
		} else {
			clipTable.put(soundType, getSoundFile(filePath));
		}
	}
	
	/**
	 * get sound from file and play.
	 * @param file_name
	 * @return 
	 */
	private AudioClip getSoundFile(String file_name) {
        URL urlClick = SoundManager.class.getResource(file_name);
		if(urlClick != null) {
			click = Applet.newAudioClip(urlClick);
			click.play();
		}		
		return click;
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
