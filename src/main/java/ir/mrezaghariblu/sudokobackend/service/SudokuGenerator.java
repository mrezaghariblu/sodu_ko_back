package ir.mrezaghariblu.sudokobackend.service;

import ir.mrezaghariblu.sudokobackend.enums.Difficulty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SudokuGenerator {

    private final SudokuSolver solver;

    public int[][] generateSolution(Long seed) {
        int[][] board = new int[9][9];
        Random random = seed != null ? new Random(seed) : new Random();

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums, random);

        for (int i = 0; i < 9; i++) {
            board[0][i] = nums.get(i);
        }

        solver.solve(board);
        return board;
    }

    public int[][] createPuzzle(int[][] solution, Difficulty difficulty) {
        int[][] puzzle = solver.deepCopy(solution);
        Random random = new Random();
        int cellsToRemove = difficulty.getEmptyCells();

        while (cellsToRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (puzzle[row][col] != 0) {
                puzzle[row][col] = 0;
                cellsToRemove--;
            }
        }
        return puzzle;
    }
}