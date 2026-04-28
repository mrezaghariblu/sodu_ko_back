package ir.mrezaghariblu.sudokobackend.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_daily_progress")
class UserDailyProgress {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private LocalDate puzzleDate;

    private boolean completed;
    private int timeSeconds;
    private int mistakesCount;

    private LocalDateTime completedAt;

    @ManyToOne
    private GameSession session;  // لینک به session
}
