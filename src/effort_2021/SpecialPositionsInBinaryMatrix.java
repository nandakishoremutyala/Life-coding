package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SpecialPositionsInBinaryMatrix {
    SpecialPositionsInBinaryMatrix specialPositionsInBinaryMatrix;

    @BeforeEach
    public void init() {
        specialPositionsInBinaryMatrix = new SpecialPositionsInBinaryMatrix();
    }

    @Test
    public void firstTest() {
        specialPositionsInBinaryMatrix.numSpecial(new int[][]{
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        });
    }

    public int numSpecial(int[][] mat) {
        List<int[]> targetLoc = new ArrayList<>();

        int row = mat.length;
        int col = mat[0].length;

        int[] rowCount = new int[row];
        int[] colCount = new int[col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (mat[r][c] == 1) {
                    rowCount[r] += 1;
                    targetLoc.add(new int[]{r, c});
                }
            }
        }

        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                if (mat[r][c] == 1) {
                    colCount[c] += 1;
                }
            }
        }

        int total = 0;
        for (int[] loc : targetLoc) {
            if (rowCount[loc[0]] == 1 && colCount[loc[1]] == 1)
                total++;
        }
        return total;
    }
}
