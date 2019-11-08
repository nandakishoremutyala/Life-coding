package leetcode;

import practice.backtracking.SubArrayWithKDifferentIntegers;

import java.util.*;

public class SubArraysWithKDifferentIntegers {
    public static void main(String[] args) {
        SubArraysWithKDifferentIntegers sadi = new SubArraysWithKDifferentIntegers();
        int count = sadi.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3);
        System.out.println(count);
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return exactK(A, K);
    }

    private int exactK(int[] A, int K) {
        int res = 0, count = 0, lo = 0, hi = 0, max = 0, n;
        Map<Integer, Integer> dp = new HashMap<>();
        while (hi < A.length) {
            while (count == K) {
                res += max - hi + 1;
                n = dp.get(A[lo]);
                if (n == 1) {
                    count--;
                    hi++;
                }
                dp.put(A[lo], n - 1);
                lo++;

            }
            while (hi < A.length) {
                n = dp.getOrDefault(A[hi], 0);
                // n==0 means a new character
                if (n == 0) count++;
                dp.put(A[hi], n + 1);

                // if found hi, then define max
                // you have found the first window and keep moving right until you found a new character
                // new character means count will be higher than K
                if (count == K) {
                    //
                    max = hi;
                    while (max + 1 < A.length) {
                        if (dp.getOrDefault(A[max + 1], 0) == 0) break;
                        max++;
                    }
                    break;
                }
                hi++;
            }
        }
        return res;
    }
}
