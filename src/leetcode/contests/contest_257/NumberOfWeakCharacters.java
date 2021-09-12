package leetcode.contests.contest_257;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWeakCharacters {
    public static void main(String[] args) {

        int res = numberOfWeakCharacters(new int[][]{
                {7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}
        });
        System.out.println(res);

    }

    public static int numberOfWeakCharacters(int[][] props) {
        int count = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] > b[0] && a[1] > b[1]) return 1;
            else if (a[0] < b[0] || a[1] < b[1]) return -1;
            else return 0;
        });

        pq.addAll(Arrays.asList(props));
        // int[] first = pq.poll();
        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            /*while (!pq.isEmpty() && (first[0] >= data[0] || first[1] >= data[1])) {
                data = pq.poll();
            }
            if (!pq.isEmpty())
                count++;

            if (!pq.isEmpty()) {
                first = pq.poll();
            }*/
            System.out.println(data[0]+"-"+data[1]);
        }
        return count;
    }
}
