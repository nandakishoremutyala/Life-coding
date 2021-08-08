package effort_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxProfitJobScheduling {
    int[] memo = new int[50001];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        Arrays.fill(memo, -1);

        int len = startTime.length;

        for (int i = 0; i < len; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(startTime[i]);
            curr.add(endTime[i]);
            curr.add(profit[i]);
            jobs.add(curr);
        }
        Collections.sort(jobs, (a, b) -> a.get(0) - b.get(0));
        for (int i = 0; i < len; i++) {
            startTime[i] = jobs.get(i).get(0);
        }

        return maxProfit(jobs, startTime, len, 0);
    }

    private int maxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position) {
        if (position == n) return 0;
        if (memo[position] != -1)
            return memo[position];
        int nextIndex = findNextJob(startTime, jobs.get(position).get(1));
        int maxProfit= Math.max(maxProfit(jobs,startTime,n,position+1),
                jobs.get(position).get(2)+maxProfit(jobs,startTime,n,nextIndex));

        return memo[position]=maxProfit;
    }

    private int findNextJob(int[] startTime, Integer lastEndingTime) {
        int start = 0;
        int end = startTime.length - 1;
        int nexIndex = startTime.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nexIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nexIndex;
    }
}
