import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Musicloader {

    public static File sound;
    public static float value;

    Clip clip;

    public Musicloader() {
        value = -30f; //Hier wird die Lautstärke eingestellt
    }

    public void load() {
        //Hier insert File
        sound = new File("Sounds\\Menu Songs\\MenuSong2 - Dreamland.wav");

    }

    public void play(File sound) {

        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); //Lautstärke anpassen
            gainControl.setValue(value);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
