package classloader;

/**
 * Created by Jay on 5/4/17.
 */
public class MusicPlayer2 {

    public void start() {
        System.out.printf("start Play Music");
    }

    public void end() {
        System.out.printf("end play music");
    }

    private MusicPlayer2 instance;
    public void setMusicPlayer2(Object musicPlayer2) {
        this.instance = (MusicPlayer2) musicPlayer2;
    }

}
