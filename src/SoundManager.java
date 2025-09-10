import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SoundManager {
    private Clip[] hitSounds;
    private Clip scoreSound;
    private Random random;
    private float volume = 2.0f;
    
    public SoundManager() {
        random = new Random();
        loadSounds();
    }
    
    private void loadSounds() {
        try {
            hitSounds = new Clip[3];
            for (int i = 0; i < hitSounds.length; i++) {
                File soundFile = new File("../sfx/hit" + i + ".wav");
                if (soundFile.exists()) {
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    hitSounds[i] = AudioSystem.getClip();
                    hitSounds[i].open(audioIn);
                    System.out.println("Loaded sound: " + soundFile.getAbsolutePath());
                } else {
                    System.err.println("Sound file not found: " + soundFile.getAbsolutePath());
                }
            }
            
            File scoreFile = new File("../sfx/score.wav");
            if (scoreFile.exists()) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(scoreFile);
                scoreSound = AudioSystem.getClip();
                scoreSound.open(audioIn);
                System.out.println("Loaded sound: " + scoreFile.getAbsolutePath());
            } else {
                System.err.println("Score sound file not found: " + scoreFile.getAbsolutePath());
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error loading sounds: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void playHitSound() {
        if (hitSounds == null || hitSounds.length == 0) return;
        
        if (random.nextFloat() < 0.05f && hitSounds[0] != null) {
            playSound(hitSounds[0]);
        } else {
            int randomIndex = 1 + random.nextInt(hitSounds.length - 1);
            if (hitSounds[randomIndex] != null) {
                playSound(hitSounds[randomIndex]);
            }
        }
    }
    
    public void playScoreSound() {
        if (scoreSound != null) {
            playSound(scoreSound);
        }
    }
    
    private void playSound(Clip clip) {
        if (clip == null) return;
        
        if (clip.isRunning()) {
            clip.stop();
        }
        clip.setFramePosition(0);
        
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = gainControl.getMaximum() - gainControl.getMinimum();
            float gain = (range * volume) + gainControl.getMinimum();
            gainControl.setValue(gain);
        }
        
        clip.start();
    }
    
    public void setVolume(float volume) {
        this.volume = Math.max(0.0f, Math.min(1.0f, volume));
    }
    
    public float getVolume() {
        return volume;
    }
    
    public void stopAllSounds() {
        if (hitSounds != null) {
            for (Clip clip : hitSounds) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                }
            }
        }
        
        if (scoreSound != null && scoreSound.isRunning()) {
            scoreSound.stop();
        }
    }
    
    public void close() {
        stopAllSounds();
        
        if (hitSounds != null) {
            for (Clip clip : hitSounds) {
                if (clip != null) {
                    clip.close();
                }
            }
        }
        
        if (scoreSound != null) {
            scoreSound.close();
        }
    }
}