package game;
public enum DifficultyType {
    EASY,
    MEDIUM,
    HARD;

    @Override
    public String toString() {
        String name = name().toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}