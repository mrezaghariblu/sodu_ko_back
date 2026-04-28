package ir.mrezaghariblu.sudokobackend.model;

import ir.mrezaghariblu.sudokobackend.enums.Difficulty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_puzzles")
public class DailyPuzzle {
    @Id
    private LocalDate date;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String puzzle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String solution;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    // Constructors
    public DailyPuzzle() {}

    public DailyPuzzle(LocalDate date, String puzzle, String solution, Difficulty difficulty) {
        this.date = date;
        this.puzzle = puzzle;
        this.solution = solution;
        this.difficulty = difficulty;
    }

    // Getters & Setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getPuzzle() { return puzzle; }
    public void setPuzzle(String puzzle) { this.puzzle = puzzle; }

    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }

    public Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
}
