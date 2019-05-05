package practice;

import java.util.Arrays;

public class SegmentTree_050319 {
    static int[] in;
    static int[] temp;

    public static void main(String[] args) {
        in = new int[]{5, 4, 3, 2, 7, 9, 10};
        int len = in.length;
        temp = new int[len + len];
        for (int i = 0; i < in.length; i++) {
            temp[i + len] = in[i];
        }

        System.out.println(2 << 1);
        System.out.println(3 >> 1);

        for (int i = len - 1; i > 0; --i)
            temp[i] = Math.max(temp[i << 1], temp[i << 1 | 1]);

        Arrays.stream(temp).forEach(value -> System.out.print(value + "-"));
        int res = searchInRange(len + 3, len + 5);
        System.out.println(res);
    }

    public static int searchInRange(int start, int end) {
        if (start == end) return temp[start];
        end = end / 2;
        start = start / 2;
        return searchInRange(start, end);
    }
}
