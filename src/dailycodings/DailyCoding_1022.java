package dailycodings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement:
 * This problem was asked by Google.
 * <p>
 * Given an array of integers where every integer occurs three times except for one integer,
 * which only occurs once, find and return the non-duplicated integer.
 * <p>
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
 * <p>
 * Do this in O(N) time and O(1) space.
 */
public class DailyCoding_1022 {
    public static void main(String[] args) {
        int arr[] = {13, 19, 13, 13};
        int res = findMissingNumberNaive(arr);
        System.out.println(res);
        System.out.println(findMissingNumberOptimal(arr));
    }

    private static int findMissingNumberOptimal(int[] arr) {
        /**
         * 1 1 1 2
         *
         * 0 0 1
         * 0 0 1
         * 0 0 1
         * 0 1 0
         * ------
         * 0 1 0
         *
         * SC: O(32)-> O(1) constant space
         * O(N)
         * */

        int[] bitCount = new int[31];

        for (int num : arr) {
            int temp = 1 << 31;
            int binaryNumber = temp | num;
            String binaryString = Integer.toBinaryString(binaryNumber).substring(1);
            int pos = 0;
            for (char c : binaryString.toCharArray()) {
                if (c == '1') {
                    bitCount[pos++] += 1;// bitcount: 1 1 1
                } else {
                    bitCount[pos++] += 0;
                }
            }
        }
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            resultString.append(bitCount[i] % 3);
        }

        System.out.println(resultString);
        return Integer.parseInt(resultString.toString(), 2);
    }

    private static int findMissingNumberNaive(int[] arr) {
        /**
         * 6: 3
         * 3: 3
         * 1: 1
         *
         *
         * TC: O(N)
         * SC: O(N)
         * */
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : arr) {
            counter.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}
