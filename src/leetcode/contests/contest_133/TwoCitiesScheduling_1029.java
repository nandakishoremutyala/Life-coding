package leetcode.contests.contest_133;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TwoCitiesScheduling_1029 {
    TwoCitiesScheduling_1029 twoCitiesScheduling;
    @BeforeEach
    public void init() {
        twoCitiesScheduling = new TwoCitiesScheduling_1029();
    }

    @Test
    public void firstTest() {
        int[][] in = new int[][]{{259, 770}, {926, 667}, {577, 469}, {448, 54}, {184, 139}, {840, 118}};
        int res = twoCitiesScheduling.twoCitySchedCost(in);
        Assertions.assertEquals(1859,res);
    }

    public int twoCitySchedCost(int[][] costs) {
        Comparator<int[]> comparator = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
        Arrays.sort(costs, comparator);
        int N = costs.length / 2,
                c1 = 0,// counter for the station A
                c2 = 0,// counter for the station B
                ans = 0,
                i = 0;
        while (i < 2 * N) {
            if ((costs[i][0] <= costs[i][1] && c1 < N) || c2 == N) {
                ans += costs[i++][0];
                c1++;
            } else {
                ans += costs[i++][1];
                c2++;
            }
        }
        return ans;
    }
}
