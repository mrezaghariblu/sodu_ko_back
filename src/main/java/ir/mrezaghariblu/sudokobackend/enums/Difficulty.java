package ir.mrezaghariblu.sudokobackend.enums;

public enum Difficulty {
    VERY_EASY(30),
    EASY(40),
    MEDIUM(50),
    HARD(55),
    EXPERT(60);

    private final int emptyCells;

    Difficulty(int emptyCells) {
        this.emptyCells = emptyCells;
    }

    public int getEmptyCells() {
        return emptyCells;
    }
}
