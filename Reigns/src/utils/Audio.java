import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.w3c.dom.events.MouseEvent;

public class Audio {

    private AudioInputStream audioInputStream;
    private Clip audioClip;

    public Audio(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File(filePath);
        audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioInputStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        audioClip = (Clip) AudioSystem.getLine(info);

        // Carica l'audio nel buffer
        audioClip.open(audioInputStream);
    }

    public void play() {
        if (audioClip != null) {
            audioClip.start();
            System.out.println("Audio started");
        }
    }

    public void close() {
        if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
            System.out.println("Audio closed");
        }
    }

}

