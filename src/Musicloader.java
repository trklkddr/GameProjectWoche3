import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Musicloader {

    public static File sound;
    public static float value;
    public String pathname;


    Clip clip;

    public Musicloader() {
        value = -35f; //Hier wird die Lautstärke eingestellt
    }



    //METHODEN FÜR DAS LADEN DER JEWEILIGEN SOUNDS
    public void loadMenuMusic() { //MENUMUSIC
        sound = new File("sounds\\Menu Songs\\MenuSongTestSilence.wav");
        play(sound);
    }
    public void loadGameMusic() { //INGAMEMUSIC
        sound = new File("sounds\\Menu Songs\\GameSongTestSilence.wav");
        play(sound);
    }
    public void loadEatSound() { //EATSOUND
        sound = new File("sounds\\Eat Sound\\Eat2 44k.wav");
        play(sound);
    }
    public void loadExitSound() { //EXITSOUND
        sound = new File("sounds\\Exit Sounds\\Exit 11k.wav");
    }
    public void loadGameOverSound() { //GAME-OVERSOUND
        sound = new File("sounds\\Game Over Sounds\\explosion 11k.wav");
        play(sound);
    }
    public void loadSelectSound() { //SELECTSOUND
        sound = new File("sounds\\Select Sound\\Select 11k.wav");
    }
    public void loadStartSound() { //STARTSOUND
        sound = new File("sounds\\Start Sound\\Start 11k.wav");
    }


    //Methode die den jeweiligen Pfad zurückgibt
    public String pathFinder(String path){
        pathname=path;
        return pathname;
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
