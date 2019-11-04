package leetcode;

import java.util.HashSet;

public class HappyNumber {
    HashSet<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        while (set.add(n)) {
            int sum = 0;
            int remain = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n /= 10;
            }
            if (sum == 1) return true;
            else
                n = sum;
        }
        return false;
    }

}
