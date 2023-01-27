import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Musicloader {

    public static File sound;



    public static float value;
    public String pathname;

    //private float mute = -100f;

    Clip clip;

    public Musicloader() {
        value = -10f; //Hier wird die Lautstärke eingestellt
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
        clip.loop(100);
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
    }

    public void loadSelectSound() { //SELECTSOUND
        sound = new File("sounds\\Select Sound\\Select 11k.wav");
    }

    public void loadStartSound() { //STARTSOUND
        sound = new File("sounds\\Start Sound\\Start 11k.wav");
        play(sound);
    }

    public void loadCreditMusic() { //CREDITMUSIC
        sound = new File(randomizer());
        play(sound);
        clip.loop(2);
    }

    public void stopWAV() { //STOPWAV
        clip.stop();
    }

    public String randomizer() {

        Random random = ThreadLocalRandom.current();
        int number = 1 + random.nextInt(6);
        switch (number) {
            case 1:
                return "sounds\\CreditsMusic\\keyboard.wav";
            case 2:
                return "sounds\\CreditsMusic\\trololo.wav";
            case 3:
                return "sounds\\CreditsMusic\\horse.wav";
            case 4:
                return "sounds\\CreditsMusic\\peanut.wav";
            case 5:
                return "sounds\\CreditsMusic\\frolic.wav";
            case 6:
                return "sounds\\CreditsMusic\\rick.wav";
        }
        return null;
    }


    //Methode die den jeweiligen Pfad zurückgibt
    public String pathFinder(String path) {
        pathname = path;
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

    public void setValue(float value) {
        Musicloader.value = value;
    }

}
