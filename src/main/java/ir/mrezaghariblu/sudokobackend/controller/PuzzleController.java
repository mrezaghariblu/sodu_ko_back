package ir.mrezaghariblu.sudokobackend.controller;

import ir.mrezaghariblu.sudokobackend.dto.PuzzleResponse;
import ir.mrezaghariblu.sudokobackend.enums.Difficulty;
import ir.mrezaghariblu.sudokobackend.service.SudokuGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puzzle")
@RequiredArgsConstructor
public class PuzzleController {

    private final SudokuGenerator generator;

    @GetMapping("/generate")
    public ResponseEntity<PuzzleResponse> generate(
            @RequestParam(defaultValue = "MEDIUM") String difficulty) {

        Difficulty diff = Difficulty.valueOf(difficulty.toUpperCase());
        int[][] solution = generator.generateSolution(null);
        int[][] puzzle = generator.createPuzzle(solution, diff);

        return ResponseEntity.ok(new PuzzleResponse(puzzle, solution, diff.name()));
    }
}