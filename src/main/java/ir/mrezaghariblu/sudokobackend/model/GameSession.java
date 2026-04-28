package ir.mrezaghariblu.sudokobackend.model;

import ir.mrezaghariblu.sudokobackend.enums.Difficulty;
import ir.mrezaghariblu.sudokobackend.enums.GameStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "game_sessions")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String puzzle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String solution;

    @Column(columnDefinition = "TEXT")
    private String currentState;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(columnDefinition = "TEXT")
    private String moveHistory;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(nullable = false)
    private boolean isDailyPuzzle = false;

    private LocalDate dailyPuzzleDate;

    @Column(nullable = false)
    private int mistakesCount = 0;

    @Column(nullable = false)
    private int maxMistakes = 3;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    private LocalDateTime pausedAt;

    @Column(nullable = false)
    private int elapsedSeconds = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameStatus status = GameStatus.ACTIVE;

    private LocalDateTime completedAt;

    // Constructors
    public GameSession() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getPuzzle() { return puzzle; }
    public void setPuzzle(String puzzle) { this.puzzle = puzzle; }

    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }

    public String getCurrentState() { return currentState; }
    public void setCurrentState(String currentState) { this.currentState = currentState; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getMoveHistory() { return moveHistory; }
    public void setMoveHistory(String moveHistory) { this.moveHistory = moveHistory; }

    public Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public boolean isDailyPuzzle() { return isDailyPuzzle; }
    public void setDailyPuzzle(boolean dailyPuzzle) { isDailyPuzzle = dailyPuzzle; }

    public LocalDate getDailyPuzzleDate() { return dailyPuzzleDate; }
    public void setDailyPuzzleDate(LocalDate dailyPuzzleDate) { this.dailyPuzzleDate = dailyPuzzleDate; }

    public int getMistakesCount() { return mistakesCount; }
    public void setMistakesCount(int mistakesCount) { this.mistakesCount = mistakesCount; }

    public int getMaxMistakes() { return maxMistakes; }
    public void setMaxMistakes(int maxMistakes) { this.maxMistakes = maxMistakes; }

    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }

    public LocalDateTime getPausedAt() { return pausedAt; }
    public void setPausedAt(LocalDateTime pausedAt) { this.pausedAt = pausedAt; }

    public int getElapsedSeconds() { return elapsedSeconds; }
    public void setElapsedSeconds(int elapsedSeconds) { this.elapsedSeconds = elapsedSeconds; }

    public GameStatus getStatus() { return status; }
    public void setStatus(GameStatus status) { this.status = status; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
}
