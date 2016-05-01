package menelaus.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.LoadClass;

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
	
	/** constructor loads all files. */
	private SoundManager(){
		LoadFiles();
	}
	
	/**
	 * get SoundManager instance.
	 * @return
	 */
	public static SoundManager getInstance() {
		return instance;
	}
	
	public void playSound(SoundType soundType){
		if (isMute || !clipTable.containsKey(soundType)) { return; }
		clipTable.get(soundType).play();
	}
	
	/** load all sound files. */
	private void LoadFiles() {
		putSoundInMap(SoundType.BUTTONSOUND);
		putSoundInMap(SoundType.CLOSEAPP);
		putSoundInMap(SoundType.COMPLETESOUND);
		putSoundInMap(SoundType.EXITSOUND);
		putSoundInMap(SoundType.LOSESOUND);
		putSoundInMap(SoundType.PRESSPIECE);
		putSoundInMap(SoundType.PRESSTILE);
		putSoundInMap(SoundType.RESTARTSOUND);
		putSoundInMap(SoundType.WINSOUND);	
	}
	
	/**
	 * put sound file in hashTable.
	 * @param type
	 * @author Obatola Seward-Evans
	 */
	private void putSoundInMap(SoundType type){
		switch (type) {
			case BUTTONSOUND:
				clipTable.put(type, getSoundFile("/assets/click.wav"));
				break;
			case WINSOUND:
				clipTable.put(type, getSoundFile("/assets/win2.wav"));
				break;
			case LOSESOUND:
				clipTable.put(type, getSoundFile("/assets/lose.wav"));
				break;
			case COMPLETESOUND:
				clipTable.put(type, getSoundFile("/assets/complete.wav"));
				break;
			case EXITSOUND:
				clipTable.put(type, getSoundFile("/assets/close_app.wav"));
				break;
			case PRESSPIECE:
				clipTable.put(type, getSoundFile("/assets/place_piece.wav"));
				break;
			case PRESSTILE:
				clipTable.put(type, getSoundFile("/assets/click_tile.wav"));
				break;
			case RESTARTSOUND:
				clipTable.put(type, getSoundFile("/assets/restart.wav"));
				break;
			default:
				break;
		}
	}
	
	/**
	 * get sound from file.
	 * @param file_name
	 * @return 
	 */
	private AudioClip getSoundFile(String file_name) {
        URL urlClick = SoundManager.class.getResource(file_name);
		if(urlClick != null) {
			click = Applet.newAudioClip(urlClick);
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
