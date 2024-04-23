import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

class BoxSounds {

static final String DICE1 = "dice1";
static final String DICE2 = "dice2";
static final String DICE3 = "dice3";
static final String DICE4 = "dice4";
static final String TILE_FLIP = "tileFlip";
static final String TILE_SLIDE1 = "tileSlide1";
static final String TILE_SLIDE2 = "tileSlide2";
static final String TILE_SLIDE3 = "tileSlide3";
static final String TILE_SLIDE4 = "tileSlide4";
/*
static final String START_OVER1 = "startOver1";
static final String START_OVER2 = "startOver2";
static final String START_OVER3 = "startOver3";
static final String START_OVER4 = "startOver4";
*/
static final String DIDNT_WIN = "didntWin";
static final String WIN = "win";

static void init() {
	SoundManager.addSound(DICE1, "snd/dice1.wav");
	SoundManager.addSound(DICE2, "snd/dice2.wav");
	SoundManager.addSound(DICE3, "snd/dice3.wav");
	SoundManager.addSound(DICE4, "snd/dice4.wav");
    /*
	SoundManager.addSound(START_OVER1, "snd/startOver1.wav");
	SoundManager.addSound(START_OVER2, "snd/startOver2.wav");
	SoundManager.addSound(START_OVER3, "snd/startOver3.wav");
	SoundManager.addSound(START_OVER4, "snd/startOver4.wav");
    */
	SoundManager.addSound(TILE_FLIP, "snd/tileFlip.wav");
	SoundManager.addSound(TILE_SLIDE1, "snd/tileSlide.wav");
	SoundManager.addSound(TILE_SLIDE2, "snd/tileSlide.wav");
	SoundManager.addSound(TILE_SLIDE3, "snd/tileSlide.wav");
	SoundManager.addSound(TILE_SLIDE4, "snd/tileSlide.wav");
	SoundManager.addSound(DIDNT_WIN, "snd/didntWin.wav");
	SoundManager.addSound(WIN, "snd/win.wav");
}

static void dice() {
	switch ((int)(Math.random() * 4.0)) {
		case 0: SoundManager.playSound(DICE1); break;
		case 1: SoundManager.playSound(DICE2); break;
		case 2: SoundManager.playSound(DICE3); break;
		default: SoundManager.playSound(DICE4);
	}
}

/*
static void startOver() {
	switch ((int)(Math.random() * 4.0)) {
		case 0: SoundManager.playSound(START_OVER1); break;
		case 1: SoundManager.playSound(START_OVER2); break;
		case 2: SoundManager.playSound(START_OVER3); break;
		default: SoundManager.playSound(START_OVER4);
	}
}
*/

static void tileFlip() {
	SoundManager.playSound(TILE_FLIP);
}

static int slideRotator = 0;

static void tileSlide() {
	switch (slideRotator) {
		case 0: SoundManager.playSound(TILE_SLIDE1); break;
		case 1: SoundManager.playSound(TILE_SLIDE2); break;
		case 2: SoundManager.playSound(TILE_SLIDE3); break;
		case 3: SoundManager.playSound(TILE_SLIDE4); break;
	}
	slideRotator = (slideRotator + 1)%4;
}

static void didntWin() {
	SoundManager.playSound(DIDNT_WIN);
}

static void win() {
	SoundManager.playSound(WIN);
}


}

class SoundManager {

private static HashMap<String, Clip> clips;

static {
	clips = new HashMap<String, Clip>(20);
}

public static void addSound(String key, String filename) {
    try {
		AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		clips.put(key, clip);
    } catch(Exception ex) {
        System.out.println("Error loading sound <"+key+">.");
        ex.printStackTrace();
    }
}


public static void playSound(String key) {
	if (clips.containsKey(key)) {
		try {
			Clip clip = clips.get(key);
			clip.stop();
			clip.setFramePosition(0);
			clip.start();
		} catch(Exception ex) {
			System.out.println("Error playing sound <"+key+">.");
			ex.printStackTrace();
		}
	}
}

}
