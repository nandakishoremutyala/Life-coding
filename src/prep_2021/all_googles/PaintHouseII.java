package prep_2021.all_googles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PaintHouseII {

    PaintHouseII paintHouseII;

    @BeforeEach
    public void init() {
        paintHouseII = new PaintHouseII();
    }

    @Test
    public void firstTest() {
        int res = paintHouseII.minCostII(new int[][]{
                {1, 5, 3},
                {2, 9, 4}
        });
        System.out.println(res);
    }

    @Test
    public void secondTest() {
        int res = paintHouseII.minCostII(new int[][]{
                {1, 3},
                {2, 4}
        });
        System.out.println(res);
    }


    private int n;
    private int k;
    private int[][] costs;
    private Map<String, Integer> memo;

    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        this.k = costs[0].length;
        this.n = costs.length;
        this.costs = costs;
        this.memo = new HashMap<>();

        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < k; color++) {
            minCost = Math.min(minCost, memoSolve(0, color));
        }
        return minCost;
    }

    private int memoSolve(int houseNumber, int color) {
        // base case: there no more houses after this house
        if (houseNumber == n - 1)
            return costs[houseNumber][color];

        if (memo.containsKey(getKey(houseNumber, color))) return memo.get(getKey(houseNumber, color));

        int minRemainingCost = Integer.MAX_VALUE;

        for (int nextColor = 0; nextColor < k; nextColor++) {
            if (color == nextColor) continue;
            int currentRemainingCost = memoSolve(houseNumber + 1, nextColor);
            minRemainingCost = Math.min(currentRemainingCost, minRemainingCost);
        }
        int totalCost = costs[houseNumber][color] + minRemainingCost;
        memo.put(getKey(houseNumber, color), totalCost);
        return totalCost;
    }

    private String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }
}
