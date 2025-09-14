package sound;

import javax.sound.sampled.*;
import java.io.*;

class SoundLoader {
    Clip load(Sound sound) {
        try (InputStream stream = getClass().getResourceAsStream(sound.getPath())) {
            if (stream == null) {
                System.out.println("Sound not found: " + sound.getPath());
                return null;
            }
            try (AudioInputStream audioInput = AudioSystem.getAudioInputStream(new BufferedInputStream(stream))) {
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                return clip;
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            return null;
        }
    }
}
