package leetcode.contests.contest_133;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TwoCitiesScheduling_1029 {
    TwoCitiesScheduling_1029 twoCitiesScheduling;

    private static class DistanceInterval {
        int cityA;
        int cityB;

        public DistanceInterval(int cityA, int cityB) {
            this.cityA = cityA;
            this.cityB = cityB;
        }
    }

    @BeforeEach
    public void init() {
        twoCitiesScheduling = new TwoCitiesScheduling_1029();
    }

    @Test
    public void firstTest() {
        int[][] in = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int res= twoCitiesScheduling.twoCitySchedCost(in);
        System.out.println(res);
    }

    public int twoCitySchedCost(int[][] costs) {
        List<DistanceInterval> data = new ArrayList<>();
        int n = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            data.add(new DistanceInterval(costs[i][0], costs[i][1]));
        }
        data.sort(Comparator.comparingInt(d -> d.cityA));
        int total=0;
        for (int i = 0; i <n ; i++) {
            total+=data.get(i).cityA;
        }

        List<DistanceInterval> newdata= data.subList(n,data.size());
        for (int i = 0; i <newdata.size() ; i++) {
            total+=newdata.get(i).cityB;
        }
        return total;
    }
}
