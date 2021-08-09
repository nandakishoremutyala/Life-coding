package effort_2021;

import java.util.*;

public class MaxProfitJobSchedulingWithPriorityQueue {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

        // storing job's details into one list
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);

            jobs.add(currJob);
        }
        Collections.sort(jobs, Comparator.comparingInt(job -> job.get(0)));
        return findMaxProfit(jobs);
    }

    private int findMaxProfit(List<List<Integer>> jobs) {
        int n=jobs.size(),maxProfit=0;
        PriorityQueue<ArrayList<Integer>> pq=new PriorityQueue<>((job1,job2)->job1.get(2)-job2.get(2));

        for (int i = 0; i <n ; i++) {
            int start=jobs.get(i).get(0);
            int end=jobs.get(i).get(1);
            int profit=jobs.get(i).get(2);

            while (!pq.isEmpty() && start>pq.peek().get(0)){
                maxProfit= Math.max(maxProfit,pq.peek().get(1));
                pq.remove();
            }

            ArrayList<Integer> combinedJob = new ArrayList<>();
            combinedJob.add(end);
            combinedJob.add(profit+maxProfit);
            pq.add(combinedJob);

        }
        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.peek().get(1));
            pq.remove();
        }

        return maxProfit;
    }
}
