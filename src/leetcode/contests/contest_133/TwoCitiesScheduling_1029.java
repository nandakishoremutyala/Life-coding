package leetcode.contests.contest_133;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

public class TwoCitiesScheduling_1029 {
    TwoCitiesScheduling_1029 twoCitiesScheduling;

    @BeforeEach
    public void init() {
        twoCitiesScheduling = new TwoCitiesScheduling_1029();
    }

    public int twoCitySchedCost(int[][] costs) {
        Set<Integer> cityA=new HashSet<>();
        Set<Integer> cityB=new HashSet<>();

        for (int i = 0; i <costs.length ; i++) {
            int[] c=costs[i];
            if(c[0]<c[1])
                cityA.add(i);
            else if(c[0]>c[1])
                cityB.add(i);
            else{
                if (cityA.size() < cityB.size())
                    cityA.add(i);
                else
                    cityB.add(i);
            }
            if(cityA.size()==cityB.size()){
                calcPrize(cityA,cityB,costs);
            }

        }
        return 0;
    }

    private void calcPrize(Set<Integer> cityA, Set<Integer> cityB, int[][] costs) {

    }
}
