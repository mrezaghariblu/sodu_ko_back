package ir.mrezaghariblu.sudokobackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)

    private String password; // رمز هش شده

    // آمار بازی‌های تمام شده
    private int easyBestTimeSeconds;   // بهترین زمان (ثانیه)
    private int mediumBestTimeSeconds;
    private int hardBestTimeSeconds;

    private int easyGamesWon;
    private int mediumGamesWon;
    private int hardGamesWon;

    // کل بازی‌های انجام شده (برای آمار کلی)
    private int totalGamesPlayed;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return true; }

    // Hint & Currency
    private int hintBalance = 1;  // شروع با 1 hint رایگان
    private int coins = 0;        // سکه برای خرید

    // Streak & Daily
    private int currentStreak = 0;
    private LocalDate lastPlayedDaily;

    // Achievements
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAchievement> achievements = new ArrayList<>();

    // Settings
    private boolean autoCheckEnabled = true;
    private boolean notesEnabled = true;

}
