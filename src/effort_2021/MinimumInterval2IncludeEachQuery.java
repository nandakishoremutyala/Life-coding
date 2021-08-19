package effort_2021;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumInterval2IncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int numQuery = queries.length;

        int[][] queryWithIndex = new int[numQuery][2];
        for (int i = 0; i < numQuery; i++) {
            queryWithIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);
        //sort interval in increasing order of size
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> ((a[1] - a[0]) - (b[1] - b[0])));

        int[] result = new int[numQuery];

        int j = 0;

        for (int i = 0; i < numQuery; i++) {
            int queryVal = queryWithIndex[i][0];
            int queryIndex = queryWithIndex[i][1];

            while (j < intervals.length && intervals[j][0] <= queryVal) {
                minHeap.add(intervals[j]);
                j++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryVal) {
                minHeap.remove();
            }
            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1);
        }
        return result;
    }
}
