package ir.mrezaghariblu.sudokobackend.repository;

import ir.mrezaghariblu.sudokobackend.model.DailyPuzzle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DailyPuzzleRepository extends JpaRepository<DailyPuzzle, LocalDate> {
    Optional<DailyPuzzle> findByDate(LocalDate date);
}
