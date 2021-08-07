package effort_2021;

import java.util.stream.IntStream;

public class MinNumberOfOperations {
    public static void main(String[] args) {
        int res = minNumberOperations(new int[]{1, 2, 3, 2, 1});
        System.out.println(res);
    }

    public static int minNumberOperations(int[] target) {
        int forceToApply = target[0];
        int totalForce = target[0];
        for (int i = 1; i < target.length; i++) {
            // if current chain strength is small, that means previous strength will break it
            if (forceToApply >= target[i]) {
                forceToApply = target[i];
            } else {
                // we have less force but diff has to be added
                totalForce+=target[i]-forceToApply;
                forceToApply= target[i];
            }
        }
        return totalForce;
    }
}
