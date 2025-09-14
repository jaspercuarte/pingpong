package sound;

public enum Sound {
    HIT0("/sfx/hit0.wav"),
    HIT1("/sfx/hit1.wav"),
    HIT2("/sfx/hit2.wav"),
    SCORE("/sfx/score.wav"),
    MENU("/sfx/menu.wav");

    private final String path;

    Sound(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
