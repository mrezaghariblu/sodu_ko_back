package ir.mrezaghariblu.sudokobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PuzzleResponse {
    private int[][] puzzle;
    private int[][] solution;
    private String difficulty;
}
