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
        value = -25f; //Hier wird die Lautstärke eingestellt
    }



    //METHODEN FÜR DAS LADEN DER JEWEILIGEN SOUNDS
    public void loadMenuMusic() { //MENUMUSIC
        sound = new File("sounds\\Menu Songs\\MenuSong - classic.wav");
        play(sound);
        clip.loop(2);
    }
    public void loadGameMusic() { //INGAMEMUSIC
        sound = new File("sounds\\Game Songs\\GameSongfinalfinal.wav");
        play(sound);
    }
    public void loadEatSound() { //EATSOUND
        sound = new File("sounds\\Eat Sound\\Eat2 44k.wav");
        play(sound);
    }
    public void loadExitSound() { //EXITSOUND
        sound = new File("sounds\\Exit Sounds\\Exit 11k.wav");
        play(sound);
    }
    public void loadGameOverSound() { //GAME-OVERSOUND
        sound = new File("sounds\\Game Over Sounds\\explosion 11k.wav");
        play(sound);
        clip.loop(100);
    }
    public void loadSelectSound() { //SELECTSOUND
        sound = new File("sounds\\Select Sound\\Select 11k.wav");
    }
    public void loadStartSound() { //STARTSOUND
        sound = new File("sounds\\Start Sound\\Start 11k.wav");
        play(sound);
    }
    public void stopWAV() { //STOPWAV
        clip.stop();
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
