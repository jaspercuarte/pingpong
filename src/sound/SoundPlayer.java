package sound;

import javax.sound.sampled.*;

class SoundPlayer {
    private float volume = 1.0f;

    void play(Clip clip) {
        if (clip == null) return;
        if (clip.isRunning()) clip.stop();
        clip.setFramePosition(0);
        applyVolume(clip);
        clip.start();
    } 

    void loop(Clip clip) {
        if (clip == null) return;
        if (clip.isRunning()) clip.stop();
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        applyVolume(clip);
        clip.start();
    }

    void stop(Clip clip) {
        if (clip!=null && clip.isRunning()) clip.stop();
    }

    void setVolume(float volume) {
        this.volume = Math.max(0.0f, Math.min(1.0f, volume));
    }

    float getVolume() {
        return this.volume;
    }

    private void applyVolume(Clip clip) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = gainControl.getMaximum() - gainControl.getMinimum();
            float gain = (range*volume) + gainControl.getMinimum();
            gainControl.setValue(gain); 
        }
    }
}
