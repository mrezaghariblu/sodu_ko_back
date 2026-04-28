package ir.mrezaghariblu.sudokobackend.repository;

import ir.mrezaghariblu.sudokobackend.enums.GameStatus;
import ir.mrezaghariblu.sudokobackend.model.GameSession;
import ir.mrezaghariblu.sudokobackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    List<GameSession> findByUserAndStatus(User user, GameStatus status);

    Optional<GameSession> findByUserAndIsDailyPuzzleAndDailyPuzzleDate(
            User user, boolean isDailyPuzzle, LocalDate date);

    List<GameSession> findByUserOrderByStartedAtDesc(User user);
}
