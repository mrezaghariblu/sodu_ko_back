package ir.mrezaghariblu.sudokobackend.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_achievements")
class UserAchievement {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Achievement achievement;

    private int progress;  // مثلاً 7/10
    private boolean unlocked;
    private LocalDateTime unlockedAt;
}
