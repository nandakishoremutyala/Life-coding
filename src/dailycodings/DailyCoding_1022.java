package dailycodings;

import java.util.Arrays;
/**
 * Problem statement:
 *
 *
 * */
public class DailyCoding_1022 {
    public static void main(String[] args) {
        int arr[] = {6, 1, 3, 3, 3, 6, 6};
        int res = findMissingNumber(arr);
        System.out.println(res);
        System.out.println(findMissingNumber(new int[]{13, 19, 13, 13}));
        System.out.println(findMissingNumber(new int[]{11, 5, 5, 5, 6, 11, 11}));
    }

    private static int findMissingNumber(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int i = 0;
        while (i + 2 < len) {
            int begin = arr[i];
            int last = arr[i + 2];
            int result = arr[i] ^ arr[i + 1] ^ arr[i + 2];
            if (result != last) return begin;
            i += 3;
        }
        return arr[i];
    }
}
