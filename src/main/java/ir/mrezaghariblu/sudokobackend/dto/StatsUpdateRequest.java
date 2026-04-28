package ir.mrezaghariblu.sudokobackend.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class StatsUpdateRequest {
    @NotBlank(message = "Difficulty is required")
    private String difficulty; // "easy", "medium", "hard"

    @Positive(message = "Time must be positive")
    private int timeSeconds;   // زمان پشت سر گذاشته شده (ثانیه)

    private boolean won;       // آیا بازیکن برنده شده؟
}
