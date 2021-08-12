package effort_2021;

import java.util.Arrays;

public class CarFleet {
    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        /*carFleet.carFleet(12,
                new int[]{10, 8, 0, 5, 3},
                new int[]{2, 4, 1, 1, 3});
*/
       /* carFleet.carFleet(10,
                new int[]{ 3},
                new int[]{3});*/

        carFleet.carFleet(10,
                new int[]{ 6,8},
                new int[]{3,2});
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        int[][] cars = new int[N][2];
        for (int i = 0; i < N; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        int fleet = 1;
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        double timeToReach = Double.MAX_VALUE;
        int i = 0;
        while (i < N) {

            int s = target - cars[i][0];
            int v = cars[i][1];
            double reachingTime = s / (double)v;
            if(i==0)
                timeToReach=reachingTime;

            if (reachingTime <= timeToReach) {
                i++;
                continue;
            } else {
                timeToReach = reachingTime;
                fleet++;
            }
            i++;
        }

        return fleet;
    }
}
