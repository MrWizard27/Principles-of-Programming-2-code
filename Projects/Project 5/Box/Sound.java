import java.io.*;
import javax.sound.sampled.*;

class Sound {

static void playSound(String filename) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("snd/dice1.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch(Exception exc) {
        System.out.println("Error playing sound.");
        exc.printStackTrace();
    }
}

public static void main(String[] args) {
	playSound("snd/reject3.wav");
	playSound("snd/dice1.wav");
	// playSound("garbage");
}

}
