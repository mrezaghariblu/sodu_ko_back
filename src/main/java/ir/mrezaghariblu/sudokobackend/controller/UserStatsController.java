package ir.mrezaghariblu.sudokobackend.controller;

import ir.mrezaghariblu.sudokobackend.dto.StatsUpdateRequest;
import ir.mrezaghariblu.sudokobackend.dto.UserStatsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ir.mrezaghariblu.sudokobackend.service.StatsService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "*")
public class UserStatsController {

    @Autowired
    private StatsService statsService;

    // دریافت آمار کاربر جاری
    @GetMapping("/me")
    public ResponseEntity<UserStatsResponse> getMyStats(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return ResponseEntity.ok(statsService.getUserStats(username));
    }

    // به‌روزرسانی آمار بعد از اتمام بازی

    @PostMapping("/update")
    public ResponseEntity<String> updateStats(@AuthenticationPrincipal UserDetails userDetails,
                                              @Valid @RequestBody StatsUpdateRequest request) {
        statsService.updateStats(userDetails.getUsername(), request);
        return ResponseEntity.ok("Stats updated successfully");
    }
}
