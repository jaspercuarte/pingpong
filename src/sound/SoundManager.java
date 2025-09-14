package sound;

import javax.sound.sampled.*;
import java.util.*;

public class SoundManager {
    private final Map<Sound, Clip> clips = new EnumMap<>(Sound.class);
    private final SoundLoader loader = new SoundLoader();
    private final SoundPlayer player = new SoundPlayer();
    private final Random random = new Random();

    public SoundManager() {
        loadAll();
    }

    private void loadAll() {
        for (Sound sound: Sound.values()) {
            clips.put(sound, loader.load(sound));
        }
    }

    public void playMenuMusic() { 
        player.loop(clips.get(Sound.MENU)); 
    }
    public void stopMenuMusic() { 
        player.stop(clips.get(Sound.MENU)); 
    }

    public void playScoreSound() { 
        player.play(clips.get(Sound.SCORE)); 
    }

    public boolean playHitSound() {
        int i = (random.nextFloat() < 0.05f) ? 0 : 1 + random.nextInt(2);
        Sound chosen = Sound.values()[i];
        player.play(clips.get(chosen));
        return chosen == Sound.HIT0;
    }

    public void stopAllSounds() {
        clips.values().forEach(player::stop);
    }

    public void setVolume(float volume) { 
        player.setVolume(volume); 
    }
    
    public float getVolume() { 
        return player.getVolume(); 
    }

    public void close() {
        stopAllSounds();
        clips.values().forEach(clip -> { 
            if (clip != null) clip.close(); 
        });
        clips.clear();
    }
}