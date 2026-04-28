package ir.mrezaghariblu.sudokobackend.service;

import ir.mrezaghariblu.sudokobackend.dto.StatsUpdateRequest;
import ir.mrezaghariblu.sudokobackend.dto.UserStatsResponse;
import ir.mrezaghariblu.sudokobackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ir.mrezaghariblu.sudokobackend.repository.UserRepository;

@Service
public class StatsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void updateStats(String username, StatsUpdateRequest stats) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String diff = stats.getDifficulty();
        int time = stats.getTimeSeconds();
        boolean won = stats.isWon();

        // اگر بازی برنده شده باشد
        if (won) {
            switch (diff) {
                case "easy":
                    user.setEasyGamesWon(user.getEasyGamesWon() + 1);
                    if (user.getEasyBestTimeSeconds() == 0 || time < user.getEasyBestTimeSeconds()) {
                        user.setEasyBestTimeSeconds(time);
                    }

                    break;
                case "medium":
                    user.setMediumGamesWon(user.getMediumGamesWon() + 1);
                    if (user.getMediumBestTimeSeconds() == 0 || time < user.getMediumBestTimeSeconds()) {
                        user.setMediumBestTimeSeconds(time);
                    }
                    break;
                case "hard":
                    user.setHardGamesWon(user.getHardGamesWon() + 1);
                    if (user.getHardBestTimeSeconds() == 0 || time < user.getHardBestTimeSeconds()) {
                        user.setHardBestTimeSeconds(time);
                    }
                    break;
            }
        }
        user.setTotalGamesPlayed(user.getTotalGamesPlayed() + 1);
        userRepository.save(user);
    }

    public UserStatsResponse getUserStats(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserStatsResponse.builder()
                .username(user.getUsername())
                .easyBestTime(user.getEasyBestTimeSeconds())
                .mediumBestTime(user.getMediumBestTimeSeconds())
                .hardBestTime(user.getHardBestTimeSeconds())
                .easyWins(user.getEasyGamesWon())
                .mediumWins(user.getMediumGamesWon())
                .hardWins(user.getHardGamesWon())
                .totalGames(user.getTotalGamesPlayed())
                .build();
    }

}
