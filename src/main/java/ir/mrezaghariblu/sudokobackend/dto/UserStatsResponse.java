package ir.mrezaghariblu.sudokobackend.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserStatsResponse {
    private String username;
    private int easyBestTime;
    private int mediumBestTime;
    private int hardBestTime;
    private int easyWins;
    private int mediumWins;
    private int hardWins;
    private int totalGames;
}
